package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Tile entity for the kiln
 * 
 * @author Nico
 */
public class KilnTileEntity extends ReworkedFurnaceTileEntity {
    
    /**
     * Create tile entity
     */
    public KilnTileEntity() {
        super(TileEntitiesRegistry.KILN.get());
    }
    
    @Override // Text title
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.reworkedmetals.kiln");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "kiln";
    }
}
