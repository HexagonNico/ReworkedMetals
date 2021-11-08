package hexagon.reworkedmetals.common.container;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

@ParametersAreNonnullByDefault
public class ReworkedFurnaceFuelSlot extends Slot {
    
    public ReworkedFurnaceFuelSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return AbstractFurnaceBlockEntity.isFuel(item);
    }
}
