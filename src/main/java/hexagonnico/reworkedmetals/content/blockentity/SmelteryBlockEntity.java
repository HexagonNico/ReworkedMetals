package hexagonnico.reworkedmetals.content.blockentity;

import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Block entity for the smeltery.
 * @author Nico
 */
public class SmelteryBlockEntity extends ReworkedFurnaceBlockEntity {
    
    /**
     * Creates block entity
     * @param pos BlockPos
     * @param state BlockState
     */
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.SMELTERY.get(), pos, state);
    }
    
    @Override // Text title
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.smeltery");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "smeltery";
    }
}
