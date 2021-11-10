package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.common.container.ReworkedFurnaceMenu;
import hexagon.reworkedmetals.common.crafting.ReworkedFurnaceRecipe;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeHooks;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class ReworkedFurnaceBlockEntity extends BaseContainerBlockEntity {
    
    protected int litTime;
    protected int totalLitTime;
    protected int smeltingProgress;
    protected int smeltingTime;
    protected float storedExp;
    
    protected NonNullList<ItemStack> inventory;
    protected final ContainerData containerData;
    
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    
    public ReworkedFurnaceBlockEntity(BlockEntityType<?> blockEntityType, BlockPos pos, BlockState state) {
        super(blockEntityType, pos, state);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
        this.containerData = this.getContainerData();
    }
    
    @Override
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
    
    @Override
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
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new ReworkedFurnaceMenu(id, playerInventory, this, this.containerData);
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
        return ContainerHelper.removeItem(this.inventory, index, flags);
    }
    
    @Override
    public ItemStack removeItemNoUpdate(int index) {
        return ContainerHelper.takeItem(this.inventory, index);
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
    public boolean stillValid(Player player) {
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
    
    public abstract String stationType();
    
    public void popExperience(@Nullable ServerPlayer player, ServerLevel level, Vec3 position) {
        List<Recipe<?>> recipes = Lists.newArrayList();
        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            level.getRecipeManager().byKey(entry.getKey()).ifPresent((recipe -> {
                recipes.add(recipe);
                float exp = (float) entry.getIntValue() * ((ReworkedFurnaceRecipe) recipe).getExperience();
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
    
    private ContainerData getContainerData() {
        return new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ReworkedFurnaceBlockEntity.this.litTime;
                    case 1 -> ReworkedFurnaceBlockEntity.this.totalLitTime;
                    case 2 -> ReworkedFurnaceBlockEntity.this.smeltingProgress;
                    case 3 -> ReworkedFurnaceBlockEntity.this.smeltingTime;
                    default -> 0;
                };
            }
            
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ReworkedFurnaceBlockEntity.this.litTime = value;
                    case 1 -> ReworkedFurnaceBlockEntity.this.totalLitTime = value;
                    case 2 -> ReworkedFurnaceBlockEntity.this.smeltingProgress = value;
                    case 3 -> ReworkedFurnaceBlockEntity.this.smeltingTime = value;
                }
            }
            
            @Override
            public int getCount() {
                return 4;
            }
        };
    }
    
    public static class Logic {
    
        public static void tickFunction(Level level, BlockPos pos, BlockState state, ReworkedFurnaceBlockEntity blockEntity) {
            boolean flag = blockEntity.litTime > 0;
            boolean flag1 = false;
            if(blockEntity.litTime > 0) {
                blockEntity.litTime--;
            }
    
            ItemStack fuel = blockEntity.inventory.get(4);
            if(blockEntity.litTime > 0 || !fuel.isEmpty()) {
                Optional<ReworkedFurnaceRecipe> recipe = level.getRecipeManager().getRecipeFor(ReworkedFurnaceRecipe.TYPE, blockEntity, level);
                if(recipe.isPresent()) {
                    blockEntity.smeltingTime = recipe.get().getSmeltingTime();
                    if(blockEntity.litTime <= 0 && canSmelt(recipe.get(), level, blockEntity)) {
                        blockEntity.litTime = ForgeHooks.getBurnTime(fuel, null);
                        blockEntity.totalLitTime = blockEntity.litTime;
                        if(blockEntity.litTime > 0) {
                            flag1 = true;
                            if(fuel.hasContainerItem()) {
                                blockEntity.inventory.set(4, fuel.getContainerItem());
                            } else if(!fuel.isEmpty()) {
                                fuel.shrink(1);
                                if(fuel.isEmpty()) {
                                    blockEntity.inventory.set(4, fuel.getContainerItem());
                                }
                            }
                        }
                    }
    
                    if(blockEntity.litTime > 0 && canSmelt(recipe.get(), level, blockEntity)) {
                        blockEntity.smeltingProgress++;
                        if(blockEntity.smeltingProgress == blockEntity.smeltingTime) {
                            blockEntity.smeltingProgress = 0;
                            if(canSmelt(recipe.get(), level, blockEntity)) {
                                recipe.get().getIngredients().forEach(blockEntity::removeIngredient);
                                ItemStack outputSlotItem = blockEntity.getItem(5);
                                ItemStack result = recipe.get().assemble(blockEntity);
                                if(outputSlotItem.isEmpty()) {
                                    blockEntity.setItem(5, result);
                                } else {
                                    outputSlotItem.grow(result.getCount());
                                }
                                blockEntity.setRecipeUsed(recipe.get());
                            }
                            flag1 = true;
                        }
                    } else {
                        blockEntity.smeltingProgress = 0;
                    }
                }
            } else if(blockEntity.litTime <= 0 && blockEntity.smeltingProgress > 0) {
                blockEntity.smeltingProgress = Mth.clamp(blockEntity.smeltingProgress - 2, 0, blockEntity.smeltingTime);
            }
    
            if(flag != (blockEntity.litTime > 0)) {
                flag1 = true;
                state = state.setValue(AbstractFurnaceBlock.LIT, blockEntity.litTime > 0);
                level.setBlock(pos, state, 3);
            }
            
            if(flag1) {
                setChanged(level, pos, state);
            }
        }
    
        private static boolean canSmelt(ReworkedFurnaceRecipe recipe, Level level, ReworkedFurnaceBlockEntity blockEntity) {
            ItemStack itemInOutputSlot = blockEntity.getItem(5);
            ItemStack expectedOutput = recipe.getResultItem();
            return recipe.getStations().contains(blockEntity.stationType()) && recipe.matches(blockEntity, level) &&
                    (itemInOutputSlot.isEmpty() || (itemInOutputSlot.sameItem(expectedOutput) && (itemInOutputSlot.getCount() + expectedOutput.getCount() <= itemInOutputSlot.getMaxStackSize())));
        }
    }
}
