package hexagon.reworkedmetals.container;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class ReworkedFurnaceResultSlot extends Slot {
    
    public ReworkedFurnaceResultSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return false;
    }
    
    @Override
    public ItemStack remove(int item) {
        return super.remove(item);
    }
}
