package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.tileentity.BlastFurnaceTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.FurnaceTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.KilnTileEntity;
import hexagonnico.reworkedmetals.content.tileentity.SmelteryTileEntity;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.tileentity.TileEntityType;

public class TileEntitiesRegistry {
    
    public static final DeferredRegister<TileEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ReworkedMetals.ID);
    
    public static final RegistryObject<TileEntityType<SmelteryTileEntity>> SMELTERY = REGISTER.register("smeltery", () -> TileEntityType.Builder.of(SmelteryTileEntity::new, BlocksRegistry.SMELTERY.get()).build(null));
    public static final RegistryObject<TileEntityType<FurnaceTileEntity>> FURNACE = REGISTER.register("furnace", () -> TileEntityType.Builder.of(FurnaceTileEntity::new, BlocksRegistry.FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<BlastFurnaceTileEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> TileEntityType.Builder.of(BlastFurnaceTileEntity::new, BlocksRegistry.BLAST_FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<KilnTileEntity>> KILN = REGISTER.register("kiln", () -> TileEntityType.Builder.of(KilnTileEntity::new, BlocksRegistry.KILN.get()).build(null));
}
