package hexagon.reworkedmetals.common.container;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;

@ParametersAreNonnullByDefault
public class ReworkedFurnaceFuelSlot extends Slot {
    
    public ReworkedFurnaceFuelSlot(IInventory container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return AbstractFurnaceTileEntity.isFuel(item);
    }
}
