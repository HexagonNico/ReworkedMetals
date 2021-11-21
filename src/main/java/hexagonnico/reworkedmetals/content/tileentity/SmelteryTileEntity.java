package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Tile entity for the smeltery
 * 
 * @author Nico
 */
public class SmelteryTileEntity extends ReworkedFurnaceTileEntity {
    
    public SmelteryTileEntity(BlockPos pos, BlockState state) {
        super(TileEntitiesRegistry.SMELTERY.get(), pos, state);
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
