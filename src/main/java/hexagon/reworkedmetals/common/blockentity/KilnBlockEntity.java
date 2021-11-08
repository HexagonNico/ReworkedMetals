package hexagon.reworkedmetals.common.blockentity;

import hexagon.reworkedmetals.core.registry.ReworkedMetalsBlockEntities;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public class KilnBlockEntity extends ReworkedFurnaceBlockEntity {
    
    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(ReworkedMetalsBlockEntities.KILN.get(), pos, state);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.kiln");
    }
    
    @Override
    public String stationType() {
        return "kiln";
    }
    
    // TODO - Glazed terracotta, cracked bricks, charcoal, chorus fruit, sponges
}
