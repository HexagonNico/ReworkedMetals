package hexagonnico.reworkedmetals.content.container;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

/**
 * Result slot for {@link ReworkedFurnaceContainer}.
 * 
 * @author Nico
 */
public class ReworkedFurnaceResultSlot extends Slot {
    
    private final Player player;
    
    /**
     * Create slot
     * @param container Container
     * @param index Slot index
     * @param x Position in pixel
     * @param y Position in pixel
     */
    public ReworkedFurnaceResultSlot(Container container, Player player, int index, int x, int y) {
        super(container, index, x, y);
        this.player = player;
    }
    
    @Override // Item is valid and can be placed
    public boolean mayPlace(ItemStack item) {
        return false;
    }
    
    @Override // When item is taken
    public void onTake(Player player, ItemStack item) {
        this.checkTakeAchievements(item);
        super.onTake(player, item);
    }
    
    @Override
    public void onQuickCraft(ItemStack itemStack, ItemStack itemStack1) {
        super.onQuickCraft(itemStack, itemStack1);
        this.checkTakeAchievements(itemStack);
    }
    
    @Override // Pop experience
    protected void checkTakeAchievements(ItemStack itemStack) {
        super.checkTakeAchievements(itemStack);
        if(this.player instanceof ServerPlayer serverPlayer && this.container instanceof ReworkedFurnaceTileEntity blockEntity) {
            blockEntity.popExperience(serverPlayer, serverPlayer.getLevel(), serverPlayer.position());
        }
    }
}
