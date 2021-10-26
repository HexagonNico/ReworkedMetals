package hexagon.reworkedmetals.blockentity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

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
    protected Component getDefaultName() {
        return new TextComponent("container.reworkedmetals.smeltery");
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
    
    public boolean isLit() {
        return this.litTime > 0;
    }
    
    public boolean isSmelting() {
        return this.smeltingProgress > 0;
    }
    
    public void litUp(int time) {
        this.litTime = time;
        this.totalLitTime = time;
    }
    
    public void setSmeltingTime(int progress) {
        this.smeltingTime = progress;
    }
    
    public void smeltingProgress(int value) {
        this.smeltingProgress += value;
    }
    
    public boolean hasFinishedSmelting() {
        return this.smeltingProgress == this.smeltingTime;
    }
    
    public void resetSmeltingProgress() {
        this.smeltingProgress = 0;
    }
    
    public void decreaseLitTime() {
        this.litTime--;
    }
    
    public void resetLitTime() {
        this.totalLitTime = 0;
    }
    
    public void resetSmeltingTime() {
        this.smeltingTime = 0;
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
}
