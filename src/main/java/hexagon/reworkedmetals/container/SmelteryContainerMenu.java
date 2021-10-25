package hexagon.reworkedmetals.container;

import hexagon.reworkedmetals.inventory.SmelteryFuelSlot;
import hexagon.reworkedmetals.inventory.SmelteryResultSlot;
import hexagon.reworkedmetals.registry.ModContainers;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

@ParametersAreNonnullByDefault
public class SmelteryContainerMenu extends AbstractContainerMenu {
    
    private final Container container;
    
    public SmelteryContainerMenu(int windowId, Inventory playerInventory, Container container) {
        super(ModContainers.SMELTERY.get(), windowId);
        this.container = container;
        checkContainerSize(container, 6);
        container.startOpen(playerInventory.player);
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                this.addSlot(new Slot(container, j + i * 2, 38 + j * 18, 17 + i * 18));
            }
        }
        
        this.addSlot(new SmelteryFuelSlot(container, 4, 47, 70));
        this.addSlot(new SmelteryResultSlot(container, 5, 118, 27));
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, i * 18 + 101));
            }
        }
    
        for(int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 159));
        }
    }
    
    public SmelteryContainerMenu(int windowId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(windowId, playerInventory, (Container) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()));
    }
    
    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }
}
