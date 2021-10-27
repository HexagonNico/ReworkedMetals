package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlastFurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public BlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLAST_FURNACE.get(), pos, state);
    }
    
    @Override
    public int tier() {
        return 2;
    }
}
