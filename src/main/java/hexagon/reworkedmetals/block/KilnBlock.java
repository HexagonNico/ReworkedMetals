package hexagon.reworkedmetals.block;

import hexagon.reworkedmetals.blockentity.KilnBlockEntity;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import java.util.Random;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.fmllegacy.network.NetworkHooks;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class KilnBlock extends AbstractFurnaceBlock {
    
    public KilnBlock() {
        super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(3.5F).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0));
    }
    
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            NetworkHooks.openGui(serverPlayer, (MenuProvider) blockEntity, packetBuffer -> packetBuffer.writeBlockPos(pos));
            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }
    
    @Override
    protected void openContainer(Level p_48690_, BlockPos p_48691_, Player p_48692_) {
    
    }
    
//    @Override
//    protected void openContainer(Level level, BlockPos pos, Player player) {
//        BlockEntity blockEntity = level.getBlockEntity(pos);
//        if(player instanceof ServerPlayer serverPlayer && blockEntity instanceof KilnBlockEntity kilnBlockEntity) {
//            NetworkHooks.openGui(serverPlayer, kilnBlockEntity, buffer -> buffer.writeBlockPos(pos));
//        }
//    }
    
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KilnBlockEntity(pos, state);
    }
    
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, ModBlockEntities.KILN.get(), AbstractFurnaceBlockEntity::serverTick);
    }
    
    @Override
    public void animateTick(BlockState p_49888_, Level p_49889_, BlockPos p_49890_, Random p_49891_) {
        super.animateTick(p_49888_, p_49889_, p_49890_, p_49891_); //TODO
    }
}
