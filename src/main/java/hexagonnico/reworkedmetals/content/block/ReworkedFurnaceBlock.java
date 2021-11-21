package hexagonnico.reworkedmetals.content.block;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;

import net.minecraftforge.fmllegacy.network.NetworkHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

/**
 * Reworked Furnace Block. All furnaces in ReworkedMetals extend this class.
 * 
 * @author Nico
 */
public abstract class ReworkedFurnaceBlock extends BaseEntityBlock {
    
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    
    /**
     * Default properties.
     */
    public ReworkedFurnaceBlock() {
        this(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5f).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0));
    }
    
    /**
     * Creates block with properties.
     * @param properties BlockBehaviour.Properties.of(...
     */
    public ReworkedFurnaceBlock(BlockBehaviour.Properties properties) {
        super(properties);
        super.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }
    
    @Override // Set block state on placement
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override // Set block entity's custom name when placed
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack item) {
        if(item.hasCustomHoverName()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if(blockEntity instanceof ReworkedFurnaceTileEntity) {
                ((ReworkedFurnaceTileEntity) blockEntity).setCustomName(item.getHoverName());
            }
        }
    }
    
    @Override // Adds block states to state builder
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
    
    @Override // Tile entities are by default invisible
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }
    
    @Override // Opens gui when clicking on the block
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult rayTraceResult) {
        if(!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            NetworkHooks.openGui(serverPlayer, (MenuProvider) blockEntity, packetBuffer -> packetBuffer.writeBlockPos(pos));
            return InteractionResult.CONSUME;
        }
        return InteractionResult.SUCCESS;
    }
    
    @Override // Drop inventory and xp when the block is destroyed
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moving) {
        if(!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if(blockEntity instanceof ReworkedFurnaceTileEntity reworkedFurnaceBlockEntity) {
                reworkedFurnaceBlockEntity.popExperience(null, (ServerLevel) level, Vec3.atCenterOf(pos));
                Containers.dropContents(level, pos, reworkedFurnaceBlockEntity);
            }
            super.onRemove(state, level, pos, newState, moving);
        }
    }
    
    @Override // Comparator output
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }
    
    @Override // Comparator output
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }
}
