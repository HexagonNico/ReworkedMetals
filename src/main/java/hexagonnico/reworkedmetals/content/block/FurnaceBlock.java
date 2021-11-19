package hexagonnico.reworkedmetals.content.block;

import hexagonnico.reworkedmetals.content.tileentity.FurnaceTileEntity;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

/**
 * Class for furnace block.
 * 
 * @author Nico
 */
public class FurnaceBlock extends ReworkedFurnaceBlock {
    
    @Override // Get the right tile entity
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FurnaceTileEntity();
    }
    
    @Override // Block sounds and particles
    public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
        if(state.getValue(LIT)) {
            double x = pos.getX() + 0.5;
            double y = pos.getY();
            double z = pos.getZ() + 0.5;
            if(random.nextDouble() < 0.1) {
                world.playLocalSound(x, y, z, SoundEvents.FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            
            Direction facing = state.getValue(FACING);
            Direction.Axis axis = facing.getAxis();
            double d = random.nextDouble() * 0.6 - 0.3;
            double dx = axis == Direction.Axis.X ? (double) facing.getStepX() * 0.52 : d;
            double dy = random.nextDouble() * 6.0 / 16.0 + 0.5;
            double dz = axis == Direction.Axis.Z ? (double) facing.getStepZ() * 0.52 : d;
            world.addParticle(ParticleTypes.SMOKE, x + dx, y + dy, z + dz, 0.0, 0.0, 0.0);
        }
    }
}
