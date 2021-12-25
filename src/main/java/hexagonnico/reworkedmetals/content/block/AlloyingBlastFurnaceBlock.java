package hexagonnico.reworkedmetals.content.block;

import hexagonnico.reworkedmetals.content.blockentity.AbstractAlloyingFurnaceBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.AlloyingBlastFurnaceBlockEntity;
import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AlloyingBlastFurnaceBlock extends AbstractAlloyingFurnaceBlock {

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new AlloyingBlastFurnaceBlockEntity(pos, state);
	}

	@Override // Block sounds and particles
	public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
		// TODO
	}

	@Override // Creates ticker for block entity
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, BlockEntitiesRegistry.ALLOYING_BLAST_FURNACE.get(), AbstractAlloyingFurnaceBlockEntity::serverTick);
	}
}
