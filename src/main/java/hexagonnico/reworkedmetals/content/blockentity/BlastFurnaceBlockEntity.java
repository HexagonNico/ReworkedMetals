package hexagonnico.reworkedmetals.content.blockentity;

import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for the blast furnace.
 * @author Nico
 */
public class BlastFurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    /**
     * Creates block entity
     * @param pos BlockPos
     * @param state BlockState
     */
    public BlastFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.BLAST_FURNACE.get(), pos, state);
    }
    
    @Override // Text title
    protected Component getDefaultName() {
        return new TranslatableComponent("container.blast_furnace");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "blast_furnace";
    }
}
