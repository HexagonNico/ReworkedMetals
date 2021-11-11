package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.common.blockentity.*;
import hexagon.reworkedmetals.common.blockentity.KilnTileEntity;
import hexagon.reworkedmetals.common.blockentity.SmelteryTileEntity;
import hexagon.reworkedmetals.core.ReworkedMetals;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ReworkedMetalsTileEntities {
    
    public static final DeferredRegister<TileEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ReworkedMetals.ID);
    
    public static final RegistryObject<TileEntityType<SmelteryTileEntity>> SMELTERY = REGISTER.register("smeltery", () -> TileEntityType.Builder.of(SmelteryTileEntity::new, ReworkedMetalsBlocks.SMELTERY.get()).build(null));
    public static final RegistryObject<TileEntityType<FurnaceTileEntity>> FURNACE = REGISTER.register("furnace", () -> TileEntityType.Builder.of(FurnaceTileEntity::new, ReworkedMetalsBlocks.FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<BlastFurnaceTileEntity>> BLAST_FURNACE = REGISTER.register("blast_furnace", () -> TileEntityType.Builder.of(BlastFurnaceTileEntity::new, ReworkedMetalsBlocks.BLAST_FURNACE.get()).build(null));
    public static final RegistryObject<TileEntityType<KilnTileEntity>> KILN = REGISTER.register("kiln", () -> TileEntityType.Builder.of(KilnTileEntity::new, ReworkedMetalsBlocks.KILN.get()).build(null));
}
