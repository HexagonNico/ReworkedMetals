package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.content.block.ReworkedFurnaceBlock;
import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainer;
import hexagonnico.reworkedmetals.content.crafting.ReworkedFurnaceRecipe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class ReworkedFurnaceTileEntity extends LockableLootTileEntity implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {
    
    protected int litTime;
    protected int totalLitTime;
    protected int smeltingProgress;
    protected int smeltingTime;
    protected float storedExp;
    
    protected NonNullList<ItemStack> inventory;
    
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    
    public ReworkedFurnaceTileEntity(TileEntityType<?> blockEntityType) {
        super(blockEntityType);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
    }
    
    @Override
    public void load(BlockState state, CompoundNBT compoundTag) {
        super.load(state, compoundTag);
        this.litTime = compoundTag.getInt("LitTime");
        this.totalLitTime = compoundTag.getInt("TotalLitTime");
        this.smeltingProgress = compoundTag.getInt("SmeltingProgress");
        this.smeltingTime = compoundTag.getInt("SmeltingTime");
        this.storedExp = compoundTag.getFloat("StoredExp");
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compoundTag, this.inventory);
        CompoundNBT recipesUsedTag = compoundTag.getCompound("RecipesUsed");
        recipesUsedTag.getAllKeys().forEach(key -> this.recipesUsed.put(new ResourceLocation(key), recipesUsedTag.getInt(key)));
    }
    
    @Override
    public CompoundNBT save(CompoundNBT compoundTag) {
        super.save(compoundTag);
        compoundTag.putInt("LitTime", this.litTime);
        compoundTag.putInt("TotalLitTime", this.totalLitTime);
        compoundTag.putInt("SmeltingProgress", this.smeltingProgress);
        compoundTag.putInt("SmeltingTime", this.smeltingTime);
        compoundTag.putFloat("StoredExp", this.storedExp);
        ItemStackHelper.saveAllItems(compoundTag, this.inventory);
        CompoundNBT recipesTag = new CompoundNBT();
        this.recipesUsed.forEach((resourceLocation, integer) -> recipesTag.putInt(resourceLocation.toString(), integer));
        compoundTag.put("RecipesUsed", recipesTag);
        return compoundTag;
    }
    
    @Override
    protected Container createMenu(int id, PlayerInventory playerInventory) {
        return new ReworkedFurnaceContainer(id, playerInventory, this, this.getDataAccess());
    }
    
    @Override
    public int getContainerSize() {
        return this.inventory.size();
    }
    
    @Override
    public boolean isEmpty() {
        return this.inventory.stream().allMatch(ItemStack::isEmpty);
    }
    
    @Override
    public ItemStack getItem(int index) {
        return this.inventory.get(index);
    }
    
    @Override
    public ItemStack removeItem(int index, int flags) {
        return ItemStackHelper.removeItem(this.inventory, index, flags);
    }
    
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ItemStackHelper.takeItem(this.inventory, index);
    }
    
    @Override
    public void setItem(int index, ItemStack item) {
        ItemStack itemStack = this.inventory.get(index);
        boolean flag = !item.isEmpty() && item.sameItem(itemStack) && ItemStack.tagMatches(item, itemStack);
        this.inventory.set(index, item);
        if(item.getCount() > this.getMaxStackSize()) {
            item.setCount(this.getMaxStackSize());
        }
        if((index == 0 || index == 1 || index == 2 || index == 3) && !flag) {
            this.smeltingTime = 0;
            this.smeltingProgress = 0;
            this.setChanged();
        }
    }
    
    @Override
    public boolean stillValid(PlayerEntity player) {
        if(this.level != null && this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5, (double) this.worldPosition.getY() + 0.5, (double) this.worldPosition.getZ() + 0.5) <= 64.0;
        }
    }
    
    @Override
    public void clearContent() {
        this.inventory.clear();
    }
    
    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.inventory;
    }
    
    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.inventory = items;
    }
    
    public abstract String stationType();
    
    public void popExperience(@Nullable ServerPlayerEntity player, ServerWorld world, Vector3d position) {
        List<IRecipe<?>> recipes = Lists.newArrayList();
        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            world.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe -> {
                recipes.add(recipe);
                float exp = (float) entry.getIntValue() * ((ReworkedFurnaceRecipe) recipe).getExperience();
                int expInt = MathHelper.floor(exp);
                float random = MathHelper.frac(exp);
                if(random != 0.0f && Math.random() < (double) random)
                    expInt++;
                while(expInt > 0) {
                    int j = ExperienceOrbEntity.getExperienceValue(expInt);
                    expInt -= j;
                    world.addFreshEntity(new ExperienceOrbEntity(world, position.x, position.y, position.z, j));
                }
            }));
        }
        if(player != null) player.awardRecipes(recipes);
        this.recipesUsed.clear();
    }
    
    public void setRecipeUsed(ReworkedFurnaceRecipe recipe) {
        this.recipesUsed.addTo(recipe.getId(), 1);
    }
    
    public void removeIngredient(Ingredient ingredient) {
        for(int i = 0; i < 4; i++) {
            ItemStack itemInSlot = this.getItem(i);
            if(!itemInSlot.isEmpty() && ingredient.test(itemInSlot)) {
                itemInSlot.shrink(1);
                this.setItem(i, itemInSlot.isEmpty() ? ItemStack.EMPTY : itemInSlot);
                break;
            }
        }
    }
    
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.worldPosition, 1, this.getUpdateTag());
    }
    
    @Override
    public CompoundNBT getUpdateTag() {
        return this.save(new CompoundNBT());
    }
    
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.load(this.getBlockState(), pkt.getTag());
    }
    
    private IIntArray getDataAccess() {
        return new IIntArray() {
            @Override
            public int get(int index) {
                switch (index) {
                    case 0: return ReworkedFurnaceTileEntity.this.litTime;
                    case 1: return ReworkedFurnaceTileEntity.this.totalLitTime;
                    case 2: return ReworkedFurnaceTileEntity.this.smeltingProgress;
                    case 3: return ReworkedFurnaceTileEntity.this.smeltingTime;
                    default: return 0;
                }
            }
            
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: ReworkedFurnaceTileEntity.this.litTime = value; break;
                    case 1: ReworkedFurnaceTileEntity.this.totalLitTime = value; break;
                    case 2: ReworkedFurnaceTileEntity.this.smeltingProgress = value; break;
                    case 3: ReworkedFurnaceTileEntity.this.smeltingTime = value; break;
                }
            }
            
            @Override
            public int getCount() {
                return 4;
            }
        };
    }
    
    @Override
    public void tick() {
        boolean flag = this.litTime > 0;
        boolean flag1 = false;
        if(this.litTime > 0) {
            this.litTime--;
        }

        ItemStack fuel = this.inventory.get(4);
        if(this.litTime > 0 || !fuel.isEmpty()) {
            Optional<ReworkedFurnaceRecipe> recipe = this.level.getRecipeManager().getRecipeFor(ReworkedFurnaceRecipe.TYPE, this, level);
            if(recipe.isPresent()) {
                this.smeltingTime = recipe.get().getSmeltingTime();
                if(this.litTime <= 0 && this.canSmelt(recipe.get(), this.level)) {
                    this.litTime = ForgeHooks.getBurnTime(fuel, null);
                    this.totalLitTime = this.litTime;
                    if(this.litTime > 0) {
                        flag1 = true;
                        if(fuel.hasContainerItem()) {
                            this.inventory.set(4, fuel.getContainerItem());
                        } else if(!fuel.isEmpty()) {
                            fuel.shrink(1);
                            if(fuel.isEmpty()) {
                                this.inventory.set(4, fuel.getContainerItem());
                            }
                        }
                    }
                }

                if(this.litTime > 0 && this.canSmelt(recipe.get(), level)) {
                    this.smeltingProgress++;
                    if(this.smeltingProgress == this.smeltingTime) {
                        this.smeltingProgress = 0;
                        if(this.canSmelt(recipe.get(), level)) {
                            recipe.get().getIngredients().forEach(this::removeIngredient);
                            ItemStack outputSlotItem = this.getItem(5);
                            ItemStack result = recipe.get().assemble(this);
                            if(outputSlotItem.isEmpty()) {
                                this.setItem(5, result);
                            } else {
                                outputSlotItem.grow(result.getCount());
                            }
                            this.setRecipeUsed(recipe.get());
                        }
                        flag1 = true;
                    }
                } else {
                    this.smeltingProgress = 0;
                }
            }
        } else if(this.litTime <= 0 && this.smeltingProgress > 0) {
            this.smeltingProgress = MathHelper.clamp(this.smeltingProgress - 2, 0, this.smeltingTime);
        }

        if(flag != (this.litTime > 0)) {
            flag1 = true;
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(ReworkedFurnaceBlock.LIT, this.litTime > 0), 3);
        }
        
        if(flag1) {
            this.setChanged();
        }
    }

    private boolean canSmelt(ReworkedFurnaceRecipe recipe, World level) {
        ItemStack itemInOutputSlot = this.getItem(5);
        ItemStack expectedOutput = recipe.getResultItem();
        return recipe.getStations().contains(this.stationType()) && recipe.matches(this, level) &&
                (itemInOutputSlot.isEmpty() || (itemInOutputSlot.sameItem(expectedOutput) && (itemInOutputSlot.getCount() + expectedOutput.getCount() <= itemInOutputSlot.getMaxStackSize())));
    }
    
    @Override
    public int[] getSlotsForFace(Direction direction) {
        switch(direction) {
            case DOWN: return new int[] {5, 4};
            case UP: return new int[] {0, 1, 2, 3};
            default: return new int[] {4};
        }
    }
    
    @Override
    public boolean canPlaceItemThroughFace(int slot, ItemStack item, @Nullable Direction direction) {
        return this.canPlaceItem(slot, item);
    }
    
    @Override
    public boolean canTakeItemThroughFace(int slot, ItemStack itemStack, Direction direction) {
        if(direction == Direction.DOWN) {
            if(slot == 4) {
                Item item = itemStack.getItem();
                return item == Items.WATER_BUCKET || item == Items.BUCKET;
            }
            return slot == 5;
        }
        return true;
    }
    
    @Override
    public boolean canPlaceItem(int slot, ItemStack item) {
        if(slot == 5) {
            return false;
        } else if(slot == 4) {
            return AbstractFurnaceTileEntity.isFuel(item);
        } else {
            return true;
        }
    }
    
    @Override
    public void fillStackedContents(RecipeItemHelper recipeItemHelper) {
        for(ItemStack itemstack : this.inventory) {
            recipeItemHelper.accountStack(itemstack);
        }
    }
    
    @Override
    public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
        if(recipe != null) {
            ResourceLocation resourcelocation = recipe.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }
    
    @Nullable
    @Override
    public IRecipe<?> getRecipeUsed() {
        return null;
    }
    
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction side) {
        if(!this.remove && side != null && capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if(side == Direction.UP)
                return handlers[0].cast();
            else if(side == Direction.DOWN)
                return handlers[1].cast();
            else
                return handlers[2].cast();
        }
        return super.getCapability(capability, side);
    }
}
