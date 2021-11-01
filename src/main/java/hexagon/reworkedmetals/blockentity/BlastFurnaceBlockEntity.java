package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.registry.ModBlockEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public class BlastFurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public BlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLAST_FURNACE.get(), pos, state);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.blast_furnace");
    }
    
    @Override
    public String stationType() {
        return "blast_furnace";
    }
}
