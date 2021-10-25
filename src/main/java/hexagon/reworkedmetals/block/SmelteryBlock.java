package hexagon.reworkedmetals.block;

import hexagon.reworkedmetals.blockentity.SmelteryBlockEntity;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;

public class SmelteryBlock extends AbstractFurnaceBlock {
    
    public SmelteryBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0));
    }
    
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SmelteryBlockEntity(pos, state);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> blockEntity) {
        return createFurnaceTicker(world, blockEntity, ModBlockEntities.SMELTERY.get());
    }
    
    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockentity = world.getBlockEntity(pos);
        if(blockentity instanceof SmelteryBlockEntity) {
            player.openMenu((MenuProvider) blockentity);
//            player.awardStat(Stats.INTERACT_WITH_BLAST_FURNACE);
        }
    }
}
