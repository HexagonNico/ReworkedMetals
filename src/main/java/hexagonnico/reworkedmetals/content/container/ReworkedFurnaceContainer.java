package hexagonnico.reworkedmetals.content.container;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;
import hexagonnico.reworkedmetals.registry.ContainersRegistry;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import org.antlr.runtime.misc.IntArray;

/**
 * Furnace container. All tile entities that contain items need one of this.
 * 
 * @author Nico
 */
public class ReworkedFurnaceContainer extends AbstractContainerMenu {
    
    private final ReworkedFurnaceTileEntity tileEntity;
    private final ContainerData containerData;
    
    /**
     * Get container data and create slots
     * @param id Window id
     * @param playerInventory player inventory
     * @param tileEntity ReworkedFurnaceTileEntity
     * @param containerData Needed to pass data from block to gui
     */
    public ReworkedFurnaceContainer(int id, Inventory playerInventory, ReworkedFurnaceTileEntity tileEntity, ContainerData containerData) {
        super(ContainersRegistry.FURNACE.get(), id);
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
    
    /**
     * Constructor needed to register container type.
     * @param id Window id
     * @param playerInventory PlayerInventory
     * @param buffer PacketBuffer
     */
    public ReworkedFurnaceContainer(int id, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(id, playerInventory, (ReworkedFurnaceTileEntity) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()), new SimpleContainerData(4));
    }
    
    @Override // Container is accessible
    public boolean stillValid(Player player) {
        return this.tileEntity.stillValid(player);
    }
    
    /**
     * Get proportioned lit time for gui animation.
     * @return Number of pixels for the fire animation in the gui.
     */
    public int litTime() {
        return this.containerData.get(1) == 0 ? 0 : this.containerData.get(0) * 13 / this.containerData.get(1);
    }
    
    /**
     * Get proportioned smelting progress for gui animation.
     * @return Number of pixels for the arrow animation in the gui.
     */
    public int getSmeltingProgress() {
        int i = this.containerData.get(2);
        int j = this.containerData.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }
    
    @Override // Handles shift-click
    public ItemStack quickMoveStack(Player player, int slotIndex) {
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
