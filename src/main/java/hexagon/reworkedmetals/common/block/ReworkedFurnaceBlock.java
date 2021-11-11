package hexagon.reworkedmetals.common.block;

import hexagon.reworkedmetals.common.blockentity.ReworkedFurnaceTileEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkHooks;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public abstract class ReworkedFurnaceBlock extends Block {
    
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    
    public ReworkedFurnaceBlock() {
        this(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5f).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0));
    }
    
    public ReworkedFurnaceBlock(AbstractBlock.Properties properties) {
        super(properties);
        super.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack item) {
        if(item.hasCustomHoverName()) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if(tileEntity instanceof ReworkedFurnaceTileEntity) {
                ((ReworkedFurnaceTileEntity) tileEntity).setCustomName(item.getHoverName());
            }
        }
    }
    
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
    
    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }
    
    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }
    
    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }
    
    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if(!world.isClientSide && player instanceof ServerPlayerEntity) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, packetBuffer -> packetBuffer.writeBlockPos(pos));
            return ActionResultType.CONSUME;
        }
        return ActionResultType.SUCCESS;
    }
    
    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if(!state.is(newState.getBlock())) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if(tileEntity instanceof ReworkedFurnaceTileEntity) {
                ((ReworkedFurnaceTileEntity) tileEntity).popExperience(null, (ServerWorld) world, Vector3d.atCenterOf(pos));
                InventoryHelper.dropContents(world, pos, (IInventory) tileEntity);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }
    
    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }
    
    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }
}
