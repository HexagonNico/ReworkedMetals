package hexagonnico.reworkedmetals.content.block;

import hexagonnico.reworkedmetals.content.tileentity.ReworkedFurnaceTileEntity;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
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
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/**
 * Reworked Furnace Block. All furnaces in ReworkedMetals extend this class.
 * 
 * @author Nico
 */
public abstract class ReworkedFurnaceBlock extends Block {
    
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    
    /**
     * Default properties.
     */
    public ReworkedFurnaceBlock() {
        this(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5f).lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 13 : 0));
    }
    
    /**
     * Creates block with properties.
     * @param properties AbstractBlock.Properties.of(...
     */
    public ReworkedFurnaceBlock(AbstractBlock.Properties properties) {
        super(properties);
        super.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }
    
    @Override // Set block state on placement
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    
    @Override // Set tile entity's custom name when placed
    public void setPlacedBy(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack item) {
        if(item.hasCustomHoverName()) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            if(tileEntity instanceof ReworkedFurnaceTileEntity) {
                ((ReworkedFurnaceTileEntity) tileEntity).setCustomName(item.getHoverName());
            }
        }
    }
    
    @Override // Adds block states to state builder
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }
    
    @Override // Tile entities are by default invisible
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }
    
    @Override // Forge hook
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    
    @Override // Opens gui when clicking on the block
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {
        if(!world.isClientSide && player instanceof ServerPlayerEntity) {
            TileEntity tileEntity = world.getBlockEntity(pos);
            NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) tileEntity, packetBuffer -> packetBuffer.writeBlockPos(pos));
            return ActionResultType.CONSUME;
        }
        return ActionResultType.SUCCESS;
    }
    
    @Override // Drop inventory and xp when the block is destroyed
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
    
    @Override // Comparator output
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }
    
    @Override // Comparator output
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }
}
