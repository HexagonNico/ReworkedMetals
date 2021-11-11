package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsTileEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class SmelteryTileEntity extends ReworkedFurnaceTileEntity {
    
    public SmelteryTileEntity() {
        super(ReworkedMetalsTileEntities.SMELTERY.get());
    }
    
    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.reworkedmetals.smeltery");
    }
    
    @Override
    public String stationType() {
        return "smeltery";
    }
}
