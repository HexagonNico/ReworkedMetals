package hexagon.reworkedmetals.container;

import hexagon.reworkedmetals.blockentity.KilnBlockEntity;
import hexagon.reworkedmetals.registry.ModContainers;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.crafting.RecipeType;

public class KilnContainerMenu extends AbstractFurnaceMenu {
    
    public KilnContainerMenu(int id, Inventory playerInventory, Container container, ContainerData containerData) {
        super(ModContainers.KILN.get(), RecipeType.SMELTING, RecipeBookType.FURNACE, id, playerInventory, container, containerData);
    }
    
    public KilnContainerMenu(int id, Inventory playerInventory, FriendlyByteBuf buffer) {
        this(id, playerInventory, (KilnBlockEntity) playerInventory.player.level.getBlockEntity(buffer.readBlockPos()), new SimpleContainerData(4));
    }
}
