package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.blockentity.BlastFurnaceBlockEntity;
import hexagon.reworkedmetals.blockentity.FurnaceBlockEntity;
import hexagon.reworkedmetals.blockentity.SmelteryBlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockEntities {
    
    public static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);
    public static final RegistryObject<BlockEntityType<SmelteryBlockEntity>> SMELTERY = REGISTER.register("smeltery", () -> BlockEntityType.Builder.of(SmelteryBlockEntity::new, ModBlocks.SMELTERY.get()).build(null));
    public static final RegistryObject<BlockEntityType<FurnaceBlockEntity>> FURNACE = REGISTER.register("furnace", () -> BlockEntityType.Builder.of(FurnaceBlockEntity::new, ModBlocks.FURNACE.get()).build(null));
    public static final RegistryObject<BlockEntityType<BlastFurnaceBlockEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> BlockEntityType.Builder.of(BlastFurnaceBlockEntity::new, ModBlocks.BLAST_FURNACE.get()).build(null));
}
