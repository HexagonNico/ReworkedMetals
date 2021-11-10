package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsBlockEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class FurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public FurnaceBlockEntity() {
        super(ReworkedMetalsBlockEntities.FURNACE.get());
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
