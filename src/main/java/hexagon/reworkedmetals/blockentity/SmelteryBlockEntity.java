package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.block.SmelteryBlock;
import hexagon.reworkedmetals.container.SmelteryContainerMenu;
import hexagon.reworkedmetals.crafting.SmelteryRecipe;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.Optional;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class SmelteryBlockEntity extends BaseContainerBlockEntity {
    
    protected int litTime;
    protected int totalLitTime;
    protected int smeltingProgress;
    protected int totalSmeltingProgress;
    protected float storedExp; // TODO - Exp
    
    protected NonNullList<ItemStack> inventory;
    protected final ContainerData containerData;
    
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTERY.get(), pos, state);
        this.inventory = NonNullList.withSize(6, ItemStack.EMPTY);
        this.containerData = this.getContainerData();
    }
    
    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.litTime = compoundTag.getInt("LitTime");
        this.totalLitTime = compoundTag.getInt("TotalLitTime");
        this.smeltingProgress = compoundTag.getInt("SmeltingProgress");
        this.totalSmeltingProgress = compoundTag.getInt("TotalSmeltingProgress");
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
        compoundTag.putInt("TotalSmeltingProgress", this.totalSmeltingProgress);
        compoundTag.putFloat("StoredExp", this.storedExp);
        ContainerHelper.saveAllItems(compoundTag, this.inventory);
        return compoundTag;
    }
    
    @Override
    protected Component getDefaultName() {
        return new TextComponent("container.reworkedmetals.smeltery");
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new SmelteryContainerMenu(id, playerInventory, this, this.containerData);
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
            this.totalSmeltingProgress = 0;
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
                    case 0 -> SmelteryBlockEntity.this.litTime;
                    case 1 -> SmelteryBlockEntity.this.totalLitTime;
                    case 2 -> SmelteryBlockEntity.this.smeltingProgress;
                    case 3 -> SmelteryBlockEntity.this.totalSmeltingProgress;
                    default -> 0;
                };
            }
            
            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> SmelteryBlockEntity.this.litTime = value;
                    case 1 -> SmelteryBlockEntity.this.totalLitTime = value;
                    case 2 -> SmelteryBlockEntity.this.smeltingProgress = value;
                    case 3 -> SmelteryBlockEntity.this.totalSmeltingProgress = value;
                }
            }
            
            @Override
            public int getCount() {
                return 4;
            }
        };
    }
    
    public static void tickFunction(Level level, BlockPos pos, BlockState state, SmelteryBlockEntity smelteryBlockEntity) {
        Optional<SmelteryRecipe> recipe = level.getRecipeManager().getRecipeFor(SmelteryRecipe.TYPE, smelteryBlockEntity, level);
        ItemStack outputSlotItem = smelteryBlockEntity.getItem(5);
        if(recipe.isPresent() && recipe.get().matches(smelteryBlockEntity, level) && (outputSlotItem.isEmpty() || outputSlotItem.sameItem(recipe.get().getResultItem()))) {
            if(smelteryBlockEntity.litTime == 0) {
                ItemStack fuel = smelteryBlockEntity.getItem(4);
                if(!fuel.isEmpty() && fuel.getItem().equals(Items.COAL)) {
                    smelteryBlockEntity.totalLitTime = 200;
                    smelteryBlockEntity.litTime = 200;
                    state = state.setValue(SmelteryBlock.LIT, true);
                    level.setBlock(pos, state, 3);
                    fuel.shrink(1);
                }
            } else {
                smelteryBlockEntity.totalSmeltingProgress = recipe.get().getSmeltingTime();
                smelteryBlockEntity.smeltingProgress++;
                if(smelteryBlockEntity.smeltingProgress == smelteryBlockEntity.totalSmeltingProgress) {
                    smelteryBlockEntity.getItem(0).shrink(1);
                    smelteryBlockEntity.getItem(1).shrink(1);
                    smelteryBlockEntity.getItem(2).shrink(1);
                    smelteryBlockEntity.getItem(3).shrink(1);
                    smelteryBlockEntity.smeltingProgress = 0;
                    if(outputSlotItem.isEmpty()) {
                        smelteryBlockEntity.setItem(5, recipe.get().assemble(smelteryBlockEntity));
                    } else {
                        outputSlotItem.grow(1);
                    }
                    smelteryBlockEntity.storedExp += recipe.get().getExperience();
                }
            }
        }
        if(smelteryBlockEntity.litTime > 0) {
            smelteryBlockEntity.litTime--;
        } else if(smelteryBlockEntity.litTime == 0) {
            smelteryBlockEntity.totalLitTime = 0;
            smelteryBlockEntity.smeltingProgress--;
            if(smelteryBlockEntity.smeltingProgress == 0)
                smelteryBlockEntity.totalSmeltingProgress = 0;
            state = state.setValue(SmelteryBlock.LIT, false);
            level.setBlock(pos, state, 3);
        }
    }
}
