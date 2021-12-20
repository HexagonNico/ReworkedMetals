package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.blockentity.BlastFurnaceBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.FurnaceBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.KilnBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.NetherForgeBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.SmelteryBlockEntity;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * Block entity types registry.
 * Contains all block entity types in ReworkedMetals.
 * @author Nico
 */
public class BlockEntitiesRegistry {

	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);

	public static final RegistryObject<BlockEntityType<SmelteryBlockEntity>> SMELTERY = REGISTER.register("smeltery", () -> BlockEntityType.Builder.of(SmelteryBlockEntity::new, BlocksRegistry.SMELTERY.get()).build(null));
	public static final RegistryObject<BlockEntityType<FurnaceBlockEntity>> FURNACE = REGISTER.register("furnace", () -> BlockEntityType.Builder.of(FurnaceBlockEntity::new, BlocksRegistry.FURNACE.get()).build(null));
	public static final RegistryObject<BlockEntityType<BlastFurnaceBlockEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> BlockEntityType.Builder.of(BlastFurnaceBlockEntity::new, BlocksRegistry.BLAST_FURNACE.get()).build(null));
	public static final RegistryObject<BlockEntityType<NetherForgeBlockEntity>> NETHER_FORGE = REGISTER.register("nether_forge", () -> BlockEntityType.Builder.of(NetherForgeBlockEntity::new, BlocksRegistry.NETHER_FORGE.get()).build(null));
	public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = REGISTER.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, BlocksRegistry.KILN.get()).build(null));
}
