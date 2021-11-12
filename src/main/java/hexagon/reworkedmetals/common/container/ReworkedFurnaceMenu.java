package hexagon.reworkedmetals.common.container;

import hexagon.reworkedmetals.common.blockentity.ReworkedFurnaceBlockEntity;
import hexagon.reworkedmetals.core.registry.ReworkedMetalsContainers;

import javax.annotation.Nonnull;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

@MethodsReturnNonnullByDefault
public class ReworkedFurnaceMenu extends AbstractContainerMenu {
    
    private final ReworkedFurnaceBlockEntity container;
    private final ContainerData containerData;
    
    public ReworkedFurnaceMenu(int windowId, Inventory playerInventory, ReworkedFurnaceBlockEntity container, ContainerData containerData) {
        super(ReworkedMetalsContainers.FURNACE.get(), windowId);
        this.container = container;
        this.containerData = containerData;
        checkContainerSize(container, 6);
        container.startOpen(playerInventory.player);
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                this.addSlot(new Slot(container, j + i * 2, 38 + j * 18, 17 + i * 18));
            }
        }
        
        this.addSlot(new ReworkedFurnaceFuelSlot(container, 4, 47, 71));
        this.addSlot(new ReworkedFurnaceResultSlot(container, playerInventory.player, 5, 118, 26));
        
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
    
    public ReworkedFurnaceMenu(int windowId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(windowId, playerInventory, (ReworkedFurnaceBlockEntity) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()), new SimpleContainerData(4));
    }
    
    @Override
    public boolean stillValid(@Nonnull Player player) {
        return this.container.stillValid(player);
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
    public ItemStack quickMoveStack(@Nonnull Player player, int slotIndex) {
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
