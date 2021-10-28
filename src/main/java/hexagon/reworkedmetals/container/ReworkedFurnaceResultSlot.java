package hexagon.reworkedmetals.container;

import hexagon.reworkedmetals.blockentity.ReworkedFurnaceBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

@ParametersAreNonnullByDefault
public class ReworkedFurnaceResultSlot extends Slot {
    
    public ReworkedFurnaceResultSlot(Container container, int index, int x, int y) {
        super(container, index, x, y);
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return false;
    }
    
    @Override
    public void onTake(Player player, ItemStack item) {
        if(player instanceof ServerPlayer serverPlayer && this.container instanceof ReworkedFurnaceBlockEntity blockEntity) {
            blockEntity.popExperience(serverPlayer);
        }
    }
}
