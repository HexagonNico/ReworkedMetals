package hexagon.reworkedmetals.container;

import hexagon.reworkedmetals.blockentity.SmelteryBlockEntity;
import hexagon.reworkedmetals.inventory.SmelteryFuelSlot;
import hexagon.reworkedmetals.inventory.SmelteryResultSlot;
import hexagon.reworkedmetals.registry.ModContainers;

import javax.annotation.Nonnull;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SmelteryContainerMenu extends AbstractContainerMenu {
    
    private final SmelteryBlockEntity container;
    private final ContainerData containerData;
    
    public SmelteryContainerMenu(int windowId, Inventory playerInventory, SmelteryBlockEntity container, ContainerData containerData) {
        super(ModContainers.SMELTERY.get(), windowId);
        this.container = container;
        this.containerData = containerData;
        checkContainerSize(container, 6);
        container.startOpen(playerInventory.player);
        
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                this.addSlot(new Slot(container, j + i * 2, 38 + j * 18, 17 + i * 18));
            }
        }
        
        this.addSlot(new SmelteryFuelSlot(container, 4, 47, 71));
        this.addSlot(new SmelteryResultSlot(container, 5, 118, 26));
        
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
    
    public SmelteryContainerMenu(int windowId, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(windowId, playerInventory, (SmelteryBlockEntity) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()), new SimpleContainerData(4));
    }
    
    @Override
    public boolean stillValid(@Nonnull Player player) {
        return this.container.stillValid(player);
    }
    
    @OnlyIn(Dist.CLIENT)
    public float litTime() {
        return this.containerData.get(1) == 0 ? 0 : this.containerData.get(0) * 1.0f / this.containerData.get(1);
    }
    
    @OnlyIn(Dist.CLIENT)
    public int getSmeltingProgress() {
        int i = this.containerData.get(2);
        int j = this.containerData.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }
}
