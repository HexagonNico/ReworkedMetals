package hexagonnico.reworkedmetals.content.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;

/**
 * Fuel slot for {@link ReworkedFurnaceContainer}.
 * 
 * @author Nico
 */
public class ReworkedFurnaceFuelSlot extends Slot {
    
    /**
     * Create slot
     * @param container Container
     * @param index Slot index
     * @param x Position in pixel
     * @param y Position in pixel
     */
    public ReworkedFurnaceFuelSlot(IInventory container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override // Item is valid and can be placed
    public boolean mayPlace(ItemStack item) {
        return AbstractFurnaceTileEntity.isFuel(item);
    }
}
