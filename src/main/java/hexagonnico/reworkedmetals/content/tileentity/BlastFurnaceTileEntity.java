package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Tile entity for the kiln
 * 
 * @author Nico
 */
public class BlastFurnaceTileEntity extends ReworkedFurnaceTileEntity {
    
    /**
     * Create tile entity
     */
    public BlastFurnaceTileEntity() {
        super(TileEntitiesRegistry.BLAST_FURNACE.get());
    }
    
    @Override // Text title
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.blast_furnace");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "blast_furnace";
    }
}
