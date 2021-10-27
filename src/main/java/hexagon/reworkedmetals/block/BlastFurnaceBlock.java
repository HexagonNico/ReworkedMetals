package hexagon.reworkedmetals.block;

import hexagon.reworkedmetals.FurnaceLogic;
import hexagon.reworkedmetals.blockentity.BlastFurnaceBlockEntity;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@ParametersAreNonnullByDefault
public class BlastFurnaceBlock extends ReworkedFurnaceBlock {
    
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlastFurnaceBlockEntity(pos, state);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntities.BLAST_FURNACE.get(), FurnaceLogic::tickFunction);
    }
}
