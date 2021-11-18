package hexagonnico.reworkedmetals.content.container;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;
import hexagonnico.reworkedmetals.registry.ContainersRegistry;

import javax.annotation.Nonnull;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

@MethodsReturnNonnullByDefault
public class ReworkedFurnaceContainer extends Container {
    
    private final ReworkedFurnaceTileEntity tileEntity;
    private final IIntArray containerData;
    
    public ReworkedFurnaceContainer(int windowId, PlayerInventory playerInventory, ReworkedFurnaceTileEntity tileEntity, IIntArray containerData) {
        super(ContainersRegistry.FURNACE.get(), windowId);
        this.tileEntity = tileEntity;
        this.containerData = containerData;
        checkContainerSize(tileEntity, 6);
        tileEntity.startOpen(playerInventory.player);
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                this.addSlot(new Slot(tileEntity, j + i * 2, 38 + j * 18, 17 + i * 18));
            }
        }
        
        this.addSlot(new ReworkedFurnaceFuelSlot(tileEntity, 4, 47, 71));
        this.addSlot(new ReworkedFurnaceResultSlot(tileEntity, playerInventory.player, 5, 118, 26));
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 102 + i * 18));
            }
        }
    
        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 160));
        }
        this.addDataSlots(containerData);
    }
    
    public ReworkedFurnaceContainer(int windowId, PlayerInventory playerInventory, PacketBuffer buffer) {
        this(windowId, playerInventory, (ReworkedFurnaceTileEntity) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()), new IntArray(4));
    }
    
    @Override
    public boolean stillValid(@Nonnull PlayerEntity player) {
        return this.tileEntity.stillValid(player);
    }
    
    @OnlyIn(Dist.CLIENT)
    public int litTime() {
        return this.containerData.get(1) == 0 ? 0 : this.containerData.get(0) * 13 / this.containerData.get(1);
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getSmeltingProgress() {
        int i = this.containerData.get(2);
        int j = this.containerData.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }
    
    @Override
    public ItemStack quickMoveStack(@Nonnull PlayerEntity player, int slotIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotIndex);
        if(slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1.copy();
            if(slotIndex == 5) {
                if(!this.moveItemStackTo(itemStack1, 6, 42, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(itemStack1, itemStack);
            } else if(slotIndex > 5) {
                if(ForgeHooks.getBurnTime(itemStack1, null) > 0) {
                    if(!this.moveItemStackTo(itemStack1, 4, 5, false)) {
                        return ItemStack.EMPTY;
                    }
                } else {
                    if(!this.moveItemStackTo(itemStack1, 0, 4, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else {
                if(!this.moveItemStackTo(itemStack1, 6, 42, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if(itemStack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if(itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, itemStack1);
        }
        return itemStack;
    }
}
