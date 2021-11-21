package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Tile entity for the kiln
 * 
 * @author Nico
 */
public class KilnTileEntity extends ReworkedFurnaceTileEntity {
    
    /**
     * Create tile entity
     */
    public KilnTileEntity(BlockPos pos, BlockState state) {
        super(TileEntitiesRegistry.KILN.get(), pos, state);
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
