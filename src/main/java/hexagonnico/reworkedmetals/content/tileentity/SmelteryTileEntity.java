package hexagonnico.reworkedmetals.content.tileentity;

import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

/**
 * Tile entity for the smeltery
 * 
 * @author Nico
 */
public class SmelteryTileEntity extends ReworkedFurnaceTileEntity {
    
    /**
     * Create tile entity
     */
    public SmelteryTileEntity() {
        super(TileEntitiesRegistry.SMELTERY.get());
    }
    
    @Override // Text title
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.reworkedmetals.smeltery");
    }
    
    @Override // Reworked furnace recipe
    public String stationType() {
        return "smeltery";
    }
}
