package hexagonnico.reworkedmetals.content.block;

import hexagonnico.reworkedmetals.content.blockentity.FurnaceBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.ReworkedFurnaceBlockEntity;
import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Class for furnace block.
 * @author Nico
 */
public class FurnaceBlock extends ReworkedFurnaceBlock {

	@Override // Create block entity
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new FurnaceBlockEntity(pos, state);
	}

	@Override // Block sounds and particles
	public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
		if(state.getValue(LIT)) {
			double x = pos.getX() + 0.5;
			double y = pos.getY();
			double z = pos.getZ() + 0.5;
			if(random.nextDouble() < 0.1) {
				level.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0f, 1.0f, false);
			}

			Direction facing = state.getValue(FACING);
			Direction.Axis axis = facing.getAxis();
			double d = random.nextDouble() * 0.6 - 0.3;
			double dx = axis == Direction.Axis.X ? (double) facing.getStepX() * 0.52 : d;
			double dy = random.nextDouble() * 6.0 / 16.0 + 0.5;
			double dz = axis == Direction.Axis.Z ? (double) facing.getStepZ() * 0.52 : d;
			level.addParticle(ParticleTypes.SMOKE, x + dx, y + dy, z + dz, 0.0, 0.0, 0.0);
		}
	}

	@Override // Creates ticker for block entity
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
		return level.isClientSide ? null : createTickerHelper(blockEntityType, BlockEntitiesRegistry.FURNACE.get(), ReworkedFurnaceBlockEntity::serverTick);
	}
}
