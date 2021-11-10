package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.common.block.BlastFurnaceBlock;
import hexagon.reworkedmetals.common.block.FurnaceBlock;
import hexagon.reworkedmetals.common.block.KilnBlock;
import hexagon.reworkedmetals.common.block.SmelteryBlock;
import hexagon.reworkedmetals.core.ReworkedMetals;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ReworkedMetalsBlocks {
    
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkedMetals.ID);
    public static final DeferredRegister<Block> OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    
    public static final RegistryObject<Block> SMELTERY = REGISTER.register("smeltery", SmelteryBlock::new);
    public static final RegistryObject<Block> FURNACE = OVERRIDES.register("furnace", FurnaceBlock::new);
    public static final RegistryObject<Block> BLAST_FURNACE = OVERRIDES.register("blast_furnace", BlastFurnaceBlock::new);
    public static final RegistryObject<Block> KILN = REGISTER.register("kiln", KilnBlock::new);
    
    public static final RegistryObject<Block> TIN_ORE = REGISTER.register("tin_ore", () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
//    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = REGISTER.register("deepslate_tin_ore", () -> new OreBlock(AbstractBlock.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = REGISTER.register("tungsten_ore", () -> new OreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
//    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = REGISTER.register("deepslate_tungsten_ore", () -> new OreBlock(AbstractBlock.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));
    
    public static final RegistryObject<Block> TIN_BLOCK = REGISTER.register("tin_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(/*SoundType.COPPER*/ SoundType.ANVIL)));
//    public static final RegistryObject<Block> RAW_TIN_BLOCK = REGISTER.register("raw_tin_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = REGISTER.register("tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
//    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = REGISTER.register("raw_tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
    public static final RegistryObject<Block> BRONZE_BLOCK = REGISTER.register("bronze_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(/*SoundType.COPPER*/ SoundType.ANVIL)));
    public static final RegistryObject<Block> STEEL_BLOCK = REGISTER.register("steel_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
}
