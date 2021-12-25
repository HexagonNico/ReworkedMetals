package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.blockentity.AlloyingBlastFurnaceBlockEntity;
import hexagonnico.reworkedmetals.content.blockentity.AlloyingFurnaceBlockEntity;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * Block entity types registry.
 * Contains all block entity types in ReworkedMetals.
 * @author Nico
 */
public class BlockEntitiesRegistry {

	public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);

	public static final RegistryObject<BlockEntityType<AlloyingFurnaceBlockEntity>> ALLOYING_FURNACE = REGISTER.register("alloying_furnace", () -> BlockEntityType.Builder.of(AlloyingFurnaceBlockEntity::new, BlocksRegistry.ALLOYING_FURNACE.get()).build(null));
	public static final RegistryObject<BlockEntityType<AlloyingBlastFurnaceBlockEntity>> ALLOYING_BLAST_FURNACE = REGISTER.register("alloying_blast_furnace", () -> BlockEntityType.Builder.of(AlloyingBlastFurnaceBlockEntity::new, BlocksRegistry.ALLOYING_BLAST_FURNACE.get()).build(null));
}
