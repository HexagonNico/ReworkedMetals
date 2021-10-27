package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.block.BlastFurnaceBlock;
import hexagon.reworkedmetals.block.FurnaceBlock;
import hexagon.reworkedmetals.block.SmelteryBlock;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkedMetals.ID);
    public static final DeferredRegister<Block> OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final RegistryObject<Block> SMELTERY = REGISTER.register("smeltery", SmelteryBlock::new);
    public static final RegistryObject<Block> FURNACE = OVERRIDES.register("furnace", FurnaceBlock::new);
    public static final RegistryObject<Block> BLAST_FURNACE = OVERRIDES.register("blast_furnace", BlastFurnaceBlock::new);
}
