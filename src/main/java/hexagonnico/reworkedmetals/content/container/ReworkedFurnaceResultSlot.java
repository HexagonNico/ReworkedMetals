package hexagonnico.reworkedmetals.content.container;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ReworkedFurnaceResultSlot extends Slot {
    
    private final PlayerEntity player;
    
    public ReworkedFurnaceResultSlot(IInventory container, PlayerEntity player, int index, int x, int y) {
        super(container, index, x, y);
        this.player = player;
    }
    
    @Override
    public boolean mayPlace(ItemStack item) {
        return false;
    }
    
    @Override
    public ItemStack onTake(PlayerEntity player, ItemStack item) {
        this.checkTakeAchievements(item);
        return super.onTake(player, item);
    }
    
    @Override
    public void onQuickCraft(ItemStack itemStack, ItemStack itemStack1) {
        super.onQuickCraft(itemStack, itemStack1);
        this.checkTakeAchievements(itemStack);
    }
    
    @Override
    protected void checkTakeAchievements(ItemStack itemStack) {
        super.checkTakeAchievements(itemStack);
        if(this.player instanceof ServerPlayerEntity && this.container instanceof ReworkedFurnaceTileEntity) {
            ((ReworkedFurnaceTileEntity) this.container).popExperience((ServerPlayerEntity) player, ((ServerPlayerEntity) player).getLevel(), player.position());
        }
    }
}
