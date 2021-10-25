package hexagon.reworkedmetals.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SmelteryResultSlot extends Slot {
    
    public SmelteryResultSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return false;
    }
}
