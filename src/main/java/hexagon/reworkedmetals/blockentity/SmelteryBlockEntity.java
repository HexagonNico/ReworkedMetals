package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.container.ReworkedFurnaceMenu;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SmelteryBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTERY.get(), pos, state);
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new ReworkedFurnaceMenu(id, playerInventory, this, this.containerData);
    }
}
