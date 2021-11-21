package hexagonnico.reworkedmetals.content.blockentity;

import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for the kiln.
 * @author Nico
 */
public class KilnBlockEntity extends ReworkedFurnaceBlockEntity {
    
    /**
     * Creates block entity
     * @param pos BlockPos
     * @param state BlockState
     */
    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.KILN.get(), pos, state);
    }
    
    @Override // Text title
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.kiln");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "kiln";
    }
}
