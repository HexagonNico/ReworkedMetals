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
    
    private final Player player;
    
    public ReworkedFurnaceResultSlot(Container container, Player player, int index, int x, int y) {
        super(container, index, x, y);
        this.player = player;
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return false;
    }
    
    @Override
    public void onTake(Player player, ItemStack item) {
        this.checkTakeAchievements(item);
        super.onTake(player, item);
    }
    
    @Override
    public void onQuickCraft(ItemStack itemStack, ItemStack itemStack1) {
        super.onQuickCraft(itemStack, itemStack1);
        this.checkTakeAchievements(itemStack);
    }
    
    @Override
    protected void checkTakeAchievements(ItemStack itemStack) {
        super.checkTakeAchievements(itemStack);
        if(this.player instanceof ServerPlayer serverPlayer && this.container instanceof ReworkedFurnaceBlockEntity blockEntity) {
            blockEntity.popExperience(serverPlayer, serverPlayer.getLevel(), serverPlayer.position());
        }
    }
}
