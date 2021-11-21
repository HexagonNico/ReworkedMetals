package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainer;
import hexagonnico.reworkedmetals.content.crafting.ReworkedSmeltingRecipe;

import java.util.ArrayList;
import java.util.List;

import com.mojang.math.Vector3d;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.SidedInvWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * Reworked Furnace Block Entity. All furnaces in ReworkedMetals extend this class.
 * 
 * @author Nico
 */
public abstract class ReworkedFurnaceTileEntity extends BaseContainerBlockEntity implements WorldlyContainer, RecipeHolder, StackedContentsCompatible {
    
    protected int litTime;
    protected int totalLitTime;
    protected int smeltingProgress;
    protected int smeltingTime;
    protected float storedExp;
    
    protected NonNullList<ItemStack> inventory;
    
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    
    /**
     * Create tile entity
     * @param tileEntityType BlockEntityType
     * @param pos BlockPos
     * @param state BlockState
     */
    public ReworkedFurnaceTileEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
        super(blockEntityType, pos, state);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
    }
    
    @Override // Load data from NBT
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.litTime = compoundTag.getInt("LitTime");
        this.totalLitTime = compoundTag.getInt("TotalLitTime");
        this.smeltingProgress = compoundTag.getInt("SmeltingProgress");
        this.smeltingTime = compoundTag.getInt("SmeltingTime");
        this.storedExp = compoundTag.getFloat("StoredExp");
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compoundTag, this.inventory);
        CompoundTag recipesUsedTag = compoundTag.getCompound("RecipesUsed");
        recipesUsedTag.getAllKeys().forEach(key -> this.recipesUsed.put(new ResourceLocation(key), recipesUsedTag.getInt(key)));
    }
    
    @Override // Saves data to NBT
    public CompoundTag save(CompoundTag compoundTag) {
        super.save(compoundTag);
        compoundTag.putInt("LitTime", this.litTime);
        compoundTag.putInt("TotalLitTime", this.totalLitTime);
        compoundTag.putInt("SmeltingProgress", this.smeltingProgress);
        compoundTag.putInt("SmeltingTime", this.smeltingTime);
        compoundTag.putFloat("StoredExp", this.storedExp);
        ContainerHelper.saveAllItems(compoundTag, this.inventory);
        CompoundTag recipesTag = new CompoundTag();
        this.recipesUsed.forEach((resourceLocation, integer) -> recipesTag.putInt(resourceLocation.toString(), integer));
        compoundTag.put("RecipesUsed", recipesTag);
        return compoundTag;
    }
    
    @Override // Create container menu
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new ReworkedFurnaceContainer(id, playerInventory, this, this.getContainerData());
    }
    
    @Override // Inventory size
    public int getContainerSize() {
        return this.inventory.size();
    }
    
    @Override // If inventory is empty
    public boolean isEmpty() {
        return this.inventory.stream().allMatch(ItemStack::isEmpty);
    }
    
    @Override // Get item in inventory
    public ItemStack getItem(int index) {
        return this.inventory.get(index);
    }
    
    @Override // Remove item from inventory
    public ItemStack removeItem(int index, int flags) {
        return ContainerHelper.removeItem(this.inventory, index, flags);
    }
    
    @Override // Remove item from inventory
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
    }
    
    @Override // Set item in inventory
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
    
    @Override // Container is still valid
    public boolean stillValid(Player player) {
        if(this.level != null && this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return player.distanceToSqr((double) this.worldPosition.getX() + 0.5, (double) this.worldPosition.getY() + 0.5, (double) this.worldPosition.getZ() + 0.5) <= 64.0;
        }
    }
    
    @Override // Clears inventory
    public void clearContent() {
        this.inventory.clear();
    }
    
    /**
     * Get station type. Needed by {@link ReworkedSmeltingRecipe}.
     * @return A value among ["smeltery", "furnace", "blast_furnace", "kiln"]
     */
    public abstract String stationType();
    
    /**
     * Adds experience to world when block is broken or output item is taken.
     * @param player ServerPlayer
     * @param level ServerLevel
     * @param position block position
     */
    public void popExperience(ServerPlayer player, ServerLevel level, Vec3 position) {
        List<Recipe<?>> recipes = new ArrayList<>();
        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe -> {
                recipes.add(recipe);
                float exp = (float) entry.getIntValue() * ((ReworkedSmeltingRecipe) recipe).getExperience();
                int expInt = Mth.floor(exp);
                float random = Mth.frac(exp);
                if(random != 0.0f && Math.random() < (double) random)
                    expInt++;
                ExperienceOrb.award(level, position, expInt);
            }));
        }
        if(player != null) player.awardRecipes(recipes);
        this.recipesUsed.clear();
    }
    
    /**
     * Adds a recipe to the stored recipes map
     * @param recipe ReworkedFurnaceRecipe
     */
    public void setRecipeUsed(ReworkedSmeltingRecipe recipe) {
        this.recipesUsed.addTo(recipe.getId(), 1);
    }
    
    /**
     * Remove item according by given ingredient.
     * @param ingredient Ingredient
     */
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
    
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return new ClientboundBlockEntityDataPacket(this.worldPosition, 1, this.getUpdateTag());
    }
    
    @Override
    public CompoundTag getUpdateTag() {
        return this.save(new CompoundTag());
    }
    
    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }
    
    /**
     * Value used to access data from gui
     * @return ContainerData of length 4: [litTime, totalLitTime, smeltingProgress, smeltingTime]
     */
    private ContainerData getContainerData() {
        return new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ReworkedFurnaceTileEntity.this.litTime;
                    case 1 -> ReworkedFurnaceTileEntity.this.totalLitTime;
                    case 2 -> ReworkedFurnaceTileEntity.this.smeltingProgress;
                    case 3 -> ReworkedFurnaceTileEntity.this.smeltingTime;
                    default -> 0;
                };
            }
            
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ReworkedFurnaceTileEntity.this.litTime = value;
                    case 1 -> ReworkedFurnaceTileEntity.this.totalLitTime = value;
                    case 2 -> ReworkedFurnaceTileEntity.this.smeltingProgress = value;
                    case 3 -> ReworkedFurnaceTileEntity.this.smeltingTime = value;
                }
            }
            
            @Override
            public int getCount() {
                return 4;
            }
        };
    }
    
    // @Override // Server tick, furnace logic
    // public void tick() {
    //     boolean wasLitInitially = this.litTime > 0;
    //     boolean changed = false;
    //     this.litTime = this.litTime > 0 ? this.litTime - 1 : this.litTime;

    //     ItemStack fuel = this.inventory.get(4);
    //     if(this.litTime > 0 || !fuel.isEmpty()) {
    //         Optional<ReworkedSmeltingRecipe> recipe = this.level.getRecipeManager().getRecipeFor(ReworkedSmeltingRecipe.TYPE, this, level);
    //         if(recipe.isPresent()) {
    //             this.smeltingTime = recipe.get().getSmeltingTime();
    //             if(this.litTime <= 0 && this.canSmelt(recipe.get(), this.level)) {
    //                 this.litTime = ForgeHooks.getBurnTime(fuel, null);
    //                 this.totalLitTime = this.litTime;
    //                 if(this.litTime > 0) {
    //                     changed = true;
    //                     if(fuel.hasContainerItem()) {
    //                         this.inventory.set(4, fuel.getContainerItem());
    //                     } else if(!fuel.isEmpty()) {
    //                         fuel.shrink(1);
    //                         if(fuel.isEmpty()) {
    //                             this.inventory.set(4, fuel.getContainerItem());
    //                         }
    //                     }
    //                 }
    //             }

    //             if(this.litTime > 0 && this.canSmelt(recipe.get(), level)) {
    //                 this.smeltingProgress++;
    //                 if(this.smeltingProgress == this.smeltingTime) {
    //                     this.smeltingProgress = 0;
    //                     if(this.canSmelt(recipe.get(), level)) {
    //                         recipe.get().getIngredients().forEach(this::removeIngredient);
    //                         ItemStack outputSlotItem = this.getItem(5);
    //                         ItemStack result = recipe.get().assemble(this);
    //                         if(outputSlotItem.isEmpty()) {
    //                             this.setItem(5, result);
    //                         } else {
    //                             outputSlotItem.grow(result.getCount());
    //                         }
    //                         this.setRecipeUsed(recipe.get());
    //                     }
    //                     changed = true;
    //                 }
    //             } else {
    //                 this.smeltingProgress = 0;
    //             }
    //         }
    //     } else if(this.litTime <= 0 && this.smeltingProgress > 0) {
    //         this.smeltingProgress = MathHelper.clamp(this.smeltingProgress - 2, 0, this.smeltingTime);
    //     }

    //     if(wasLitInitially != (this.litTime > 0)) {
    //         changed = true;
    //         this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(ReworkedFurnaceBlock.LIT, this.litTime > 0), 3);
    //     }
        
    //     if(changed) {
    //         this.setChanged();
    //     }
    // }

    // /**
    //  * Checks if furnace has fuel, has a free output slot and the given recipe matches the input.
    //  * @param recipe ReworkedFurnaceRecipe. Need to match input
    //  * @param world World
    //  * @return True if can smelt, false if not
    //  */
    // private boolean canSmelt(ReworkedSmeltingRecipe recipe, World world) {
    //     ItemStack itemInOutputSlot = this.getItem(5);
    //     ItemStack expectedOutput = recipe.getResultItem();
    //     return recipe.getStations().contains(this.stationType()) && recipe.matches(this, world) &&
    //             (itemInOutputSlot.isEmpty() || (itemInOutputSlot.sameItem(expectedOutput) && (itemInOutputSlot.getCount() + expectedOutput.getCount() <= itemInOutputSlot.getMaxStackSize())));
    // }
    
    @Override // Slots for hopper interaction
    public int[] getSlotsForFace(Direction direction) {
        switch(direction) {
            case DOWN: return new int[] {5, 4};
            case UP: return new int[] {0, 1, 2, 3};
            default: return new int[] {4};
        }
    }
    
    @Override // Hopper interaction
    public boolean canPlaceItemThroughFace(int slot, ItemStack item, Direction direction) {
        return this.canPlaceItem(slot, item);
    }
    
    @Override // Hopper interaction
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
    
    @Override // Hopper interaction
    public boolean canPlaceItem(int slot, ItemStack item) {
        if(slot == 5) {
            return false;
        } else if(slot == 4) {
            return AbstractFurnaceBlockEntity.isFuel(item);
        } else {
            return true;
        }
    }
    
    @Override // Recipe stuff
    public void fillStackedContents(StackedContents stackedContents) {
        for(ItemStack itemStack : this.inventory) {
            stackedContents.accountStack(itemStack);
        }
    }
    
    @Override // Recipe stuff
    public void setRecipeUsed(Recipe<?> recipe) {
        if(recipe != null) {
            ResourceLocation resourceLocation = recipe.getId();
            this.recipesUsed.addTo(resourceLocation, 1);
        }
    }
    
    @Override // Recipe stuff
    public Recipe<?> getRecipeUsed() {
        return null;
    }
    
    LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    @Override // Hopper interaction
    public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction side) {
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
