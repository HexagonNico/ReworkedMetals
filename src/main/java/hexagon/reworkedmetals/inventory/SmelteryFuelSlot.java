package hexagon.reworkedmetals.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SmelteryFuelSlot extends Slot {
    
    public SmelteryFuelSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return item.getItem().equals(Items.COAL);
    }
}
