package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.common.blockentity.BlastFurnaceBlockEntity;
import hexagon.reworkedmetals.common.blockentity.FurnaceBlockEntity;
import hexagon.reworkedmetals.common.blockentity.KilnBlockEntity;
import hexagon.reworkedmetals.common.blockentity.SmelteryBlockEntity;
import hexagon.reworkedmetals.core.ReworkedMetals;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ReworkedMetalsBlockEntities {
    
    public static final DeferredRegister<TileEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ReworkedMetals.ID);
    
    public static final RegistryObject<TileEntityType<SmelteryBlockEntity>> SMELTERY = REGISTER.register("smeltery", () -> TileEntityType.Builder.of(SmelteryBlockEntity::new, ReworkedMetalsBlocks.SMELTERY.get()).build(null));
    public static final RegistryObject<TileEntityType<FurnaceBlockEntity>> FURNACE = REGISTER.register("furnace", () -> TileEntityType.Builder.of(FurnaceBlockEntity::new, ReworkedMetalsBlocks.FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<BlastFurnaceBlockEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> TileEntityType.Builder.of(BlastFurnaceBlockEntity::new, ReworkedMetalsBlocks.BLAST_FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<KilnBlockEntity>> KILN = REGISTER.register("kiln", () -> TileEntityType.Builder.of(KilnBlockEntity::new, ReworkedMetalsBlocks.KILN.get()).build(null));
}
