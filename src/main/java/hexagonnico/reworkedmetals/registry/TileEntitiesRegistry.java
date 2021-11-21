package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.tileentity.BlastFurnaceTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.FurnaceTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.KilnTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.SmelteryTileEntity;

import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * Tile entity types registry. Contains all tile entity types in ReworkedMetals.
 * 
 * @author Nico
 */
public class TileEntitiesRegistry {
    
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);
    
    public static final RegistryObject<BlockEntityType<SmelteryTileEntity>> SMELTERY = REGISTER.register("smeltery", () -> BlockEntityType.Builder.of(SmelteryTileEntity::new, BlocksRegistry.SMELTERY.get()).build(null));
    public static final RegistryObject<BlockEntityType<FurnaceTileEntity>> FURNACE = REGISTER.register("furnace", () -> BlockEntityType.Builder.of(FurnaceTileEntity::new, BlocksRegistry.FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<BlastFurnaceTileEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> BlockEntityType.Builder.of(BlastFurnaceTileEntity::new, BlocksRegistry.BLAST_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<KilnTileEntity>> KILN = REGISTER.register("kiln", () -> BlockEntityType.Builder.of(KilnTileEntity::new, BlocksRegistry.KILN.get()).build(null));
}
