package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.registry.ModBlockEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public class SmelteryBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public SmelteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SMELTERY.get(), pos, state);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.smeltery");
    }
    
    @Override
    public String stationType() {
        return "smeltery";
    }
}
