package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsBlockEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public class FurnaceBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public FurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(ReworkedMetalsBlockEntities.FURNACE.get(), pos, state);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.furnace");
    }
    
    @Override
    public String stationType() {
        return "furnace";
    }
}
