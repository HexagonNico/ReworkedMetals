package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.block.ReworkedFurnaceBlock;
import hexagon.reworkedmetals.container.ReworkedFurnaceMenu;
import hexagon.reworkedmetals.crafting.ReworkedFurnaceRecipe;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeHooks;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public abstract class ReworkedFurnaceBlockEntity extends BaseContainerBlockEntity {
    
    protected int litTime;
    protected int totalLitTime;
    protected int smeltingProgress;
    protected int smeltingTime;
    protected float storedExp; // TODO - Exp
    
    protected NonNullList<ItemStack> inventory;
    protected final ContainerData containerData;
    
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
    
    public ContainerData getData() {
        return this.containerData;
    }
    
    public abstract int tier();
    
    public void popExperience(ServerPlayer player) {
        ExperienceOrb.award(player.getLevel(), player.position(), Mth.floor(this.storedExp));
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
            Optional<ReworkedFurnaceRecipe> recipe = level.getRecipeManager().getRecipeFor(ReworkedFurnaceRecipe.TYPE, blockEntity, level);
            if(recipe.isPresent() && canSmelt(recipe.get(), level, blockEntity)) {
                lightUpIfHasFuel(level, pos, state, blockEntity);
                startSmelting(recipe.get(), blockEntity);
                checkIfStillOn(level, pos, state, blockEntity);
                checkIfDone(recipe.get(), blockEntity);
                progress(blockEntity);
            } else {
                resetProgress(blockEntity);
            }
        }
    
        private static boolean canSmelt(ReworkedFurnaceRecipe recipe, Level level, ReworkedFurnaceBlockEntity blockEntity) {
            ItemStack itemInOutputSlot = blockEntity.getItem(5);
            ItemStack expectedOutput = recipe.getResultItem();
            return recipe.getTier() <= blockEntity.tier() && recipe.matches(blockEntity, level) &&
                    (itemInOutputSlot.isEmpty() || (itemInOutputSlot.sameItem(expectedOutput) && (itemInOutputSlot.getCount() + expectedOutput.getCount() <= itemInOutputSlot.getMaxStackSize())));
        }
    
        private static void startSmelting(ReworkedFurnaceRecipe recipe, ReworkedFurnaceBlockEntity blockEntity) {
            if(blockEntity.litTime > 0 && blockEntity.smeltingProgress == 0) {
                blockEntity.smeltingTime = recipe.getSmeltingTime();
            }
        }
    
        private static void lightUpIfHasFuel(Level level, BlockPos pos, BlockState state, ReworkedFurnaceBlockEntity blockEntity) {
            ItemStack fuel = blockEntity.getItem(4);
            int burnTime = ForgeHooks.getBurnTime(fuel, null);
            if(blockEntity.litTime == 0 && !fuel.isEmpty() && burnTime > 0) {
                blockEntity.totalLitTime = burnTime;
                blockEntity.litTime = burnTime;
                state = state.setValue(ReworkedFurnaceBlock.LIT, true);
                level.setBlock(pos, state, 3);
                fuel.shrink(1);
            }
        }
        
        private static void checkIfStillOn(Level level, BlockPos pos, BlockState state, ReworkedFurnaceBlockEntity blockEntity) {
            if(blockEntity.litTime == 0 && blockEntity.totalLitTime > 0) {
                blockEntity.totalLitTime = 0;
                state = state.setValue(ReworkedFurnaceBlock.LIT, false);
                level.setBlock(pos, state, 3);
            }
        }
        
        private static void checkIfDone(ReworkedFurnaceRecipe recipe, ReworkedFurnaceBlockEntity blockEntity) {
            if(blockEntity.smeltingTime > 0 && blockEntity.smeltingProgress == blockEntity.smeltingTime) {
                blockEntity.getItem(0).shrink(1);
                blockEntity.getItem(1).shrink(1);
                blockEntity.getItem(2).shrink(1);
                blockEntity.getItem(3).shrink(1);
                blockEntity.smeltingProgress = 0;
                blockEntity.smeltingTime = 0;
                ItemStack outputSlotItem = blockEntity.getItem(5);
                ItemStack result = recipe.assemble(blockEntity);
                if(outputSlotItem.isEmpty()) {
                    blockEntity.setItem(5, result);
                } else {
                    outputSlotItem.grow(result.getCount());
                }
                blockEntity.storedExp += recipe.getExperience();
            }
        }
        
        private static void progress(ReworkedFurnaceBlockEntity blockEntity) {
            if(blockEntity.smeltingProgress >= 0 && blockEntity.smeltingProgress < blockEntity.smeltingTime) {
                if(blockEntity.litTime > 0) {
                    blockEntity.smeltingProgress++;
                    blockEntity.litTime--;
                } else {
                    blockEntity.smeltingProgress--;
                }
            }
        }
        
        private static void resetProgress(ReworkedFurnaceBlockEntity blockEntity) {
            if(blockEntity.litTime > 0) {
                blockEntity.litTime--;
            }
            if(blockEntity.smeltingProgress > 0) {
                blockEntity.smeltingProgress = 0;
                blockEntity.smeltingTime = 0;
            }
        }
    }
}
