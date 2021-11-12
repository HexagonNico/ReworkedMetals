package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.core.ReworkedMetals;
import hexagon.reworkedmetals.common.blockentity.BlastFurnaceBlockEntity;
import hexagon.reworkedmetals.common.blockentity.FurnaceBlockEntity;
import hexagon.reworkedmetals.common.blockentity.KilnBlockEntity;
import hexagon.reworkedmetals.common.blockentity.SmelteryBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ReworkedMetalsBlockEntities {
    
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);
    
    public static final RegistryObject<BlockEntityType<SmelteryBlockEntity>> SMELTERY = REGISTER.register("smeltery", () -> BlockEntityType.Builder.of(SmelteryBlockEntity::new, ReworkedMetalsBlocks.SMELTERY.get()).build(null));
    public static final RegistryObject<BlockEntityType<FurnaceBlockEntity>> FURNACE = REGISTER.register("furnace", () -> BlockEntityType.Builder.of(FurnaceBlockEntity::new, ReworkedMetalsBlocks.FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<BlastFurnaceBlockEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> BlockEntityType.Builder.of(BlastFurnaceBlockEntity::new, ReworkedMetalsBlocks.BLAST_FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<KilnBlockEntity>> KILN = REGISTER.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, ReworkedMetalsBlocks.KILN.get()).build(null));
}
