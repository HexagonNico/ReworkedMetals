package hexagonnico.reworkedmetals.content.container;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

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
    public ReworkedFurnaceFuelSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override // Item is valid and can be placed
    public boolean mayPlace(ItemStack item) {
        return AbstractFurnaceBlockEntity.isFuel(item);
    }
}
