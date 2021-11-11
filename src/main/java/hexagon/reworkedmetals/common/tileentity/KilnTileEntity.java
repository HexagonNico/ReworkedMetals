package hexagon.reworkedmetals.common.tileentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsTileEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class KilnTileEntity extends ReworkedFurnaceTileEntity {
    
    public KilnTileEntity() {
        super(ReworkedMetalsTileEntities.KILN.get());
    }
    
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.reworkedmetals.kiln");
    }
    
    @Override
    public String stationType() {
        return "kiln";
    }
}
