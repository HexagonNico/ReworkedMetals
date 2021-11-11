package hexagon.reworkedmetals.common.tileentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsTileEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class BlastFurnaceTileEntity extends ReworkedFurnaceTileEntity {
    
    public BlastFurnaceTileEntity() {
        super(ReworkedMetalsTileEntities.BLAST_FURNACE.get());
    }
    
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.blast_furnace");
    }
    
    @Override
    public String stationType() {
        return "blast_furnace";
    }
}
