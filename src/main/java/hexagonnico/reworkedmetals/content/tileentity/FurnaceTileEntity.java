package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Tile entity for the kiln
 * 
 * @author Nico
 */
public class FurnaceTileEntity extends ReworkedFurnaceTileEntity {
    
    /**
     * Create tile entity
     */
    public FurnaceTileEntity() {
        super(TileEntitiesRegistry.FURNACE.get());
    }
    
    @Override // Text title
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.furnace");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "furnace";
    }
}
