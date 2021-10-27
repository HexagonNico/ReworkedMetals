package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.registry.ModBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class FurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public FurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FURNACE.get(), pos, state);
    }
    
    @Override
    public int tier() {
        return 1;
    }
}
