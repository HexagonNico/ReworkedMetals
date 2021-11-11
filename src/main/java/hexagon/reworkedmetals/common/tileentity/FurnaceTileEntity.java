package hexagon.reworkedmetals.common.tileentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsTileEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class FurnaceTileEntity extends ReworkedFurnaceTileEntity {
    
    public FurnaceTileEntity() {
        super(ReworkedMetalsTileEntities.FURNACE.get());
    }
    
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.furnace");
    }
    
    @Override
    public String stationType() {
        return "furnace";
    }
}
