package hexagon.reworkedmetals.block;

import hexagon.reworkedmetals.blockentity.SmelteryBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@ParametersAreNonnullByDefault
public class SmelteryBlock extends ReworkedFurnaceBlock {
    
    public SmelteryBlock() {
        super();
    }
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SmelteryBlockEntity(pos, state);
    }
}
