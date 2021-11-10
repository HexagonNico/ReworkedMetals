package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsBlockEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class BlastFurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public BlastFurnaceBlockEntity() {
        super(ReworkedMetalsBlockEntities.BLAST_FURNACE.get());
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
