package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SmelteryBlockEntity extends AbstractFurnaceBlockEntity {
    
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTERY.get(), pos, state, RecipeType.BLASTING);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.smeltery");
    }
    
    @Override
    protected int getBurnDuration(ItemStack item) {
        return super.getBurnDuration(item) / 4;
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new BlastFurnaceMenu(id, inventory, this, this.dataAccess);
    }
}
