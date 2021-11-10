package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsBlockEntities;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

@MethodsReturnNonnullByDefault
public class SmelteryBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public SmelteryBlockEntity() {
        super(ReworkedMetalsBlockEntities.SMELTERY.get());
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
