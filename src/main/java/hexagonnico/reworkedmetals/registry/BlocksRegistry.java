package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.block.BlastFurnaceBlock;
import hexagonnico.reworkedmetals.content.block.FurnaceBlock;
import hexagonnico.reworkedmetals.content.block.KilnBlock;
import hexagonnico.reworkedmetals.content.block.ModOreBlock;
import hexagonnico.reworkedmetals.content.block.SmelteryBlock;

import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

/**
 * Blocks registry. Contains all ReworkedMetals blocks.
 * 
 * @author Nico
 */
public class BlocksRegistry {

    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkedMetals.ID);
    public static final DeferredRegister<Block> OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    
    public static final RegistryObject<Block> SMELTERY = REGISTER.register("smeltery", SmelteryBlock::new);
    public static final RegistryObject<Block> FURNACE = OVERRIDES.register("furnace", FurnaceBlock::new);
    public static final RegistryObject<Block> BLAST_FURNACE = OVERRIDES.register("blast_furnace", BlastFurnaceBlock::new);
    public static final RegistryObject<Block> KILN = REGISTER.register("kiln", KilnBlock::new);
    public static final RegistryObject<Block> COPPER_ORE = REGISTER.register("copper_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> TIN_ORE = REGISTER.register("tin_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = REGISTER.register("tungsten_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> VANADIUM_ORE = REGISTER.register("vanadium_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> RUBY_ORE = REGISTER.register("ruby_ore", () -> new ModOreBlock(AbstractBlock.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2), 3, 7));
    public static final RegistryObject<Block> RAW_COPPER_BLOCK = REGISTER.register("raw_copper_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = REGISTER.register("raw_tin_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = REGISTER.register("raw_tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> RAW_IRON_BLOCK = REGISTER.register("raw_iron_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> RAW_GOLD_BLOCK = REGISTER.register("raw_gold_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.GOLD).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> RAW_VANADIUM_BLOCK = REGISTER.register("raw_vanadium_block", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> COPPER_BLOCK = REGISTER.register("copper_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> TIN_BLOCK = REGISTER.register("tin_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = REGISTER.register("tungsten_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> BRONZE_BLOCK = REGISTER.register("bronze_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> STEEL_BLOCK = REGISTER.register("steel_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> VANADIUM_BLOCK = REGISTER.register("vanadium_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final RegistryObject<Block> RUBY_BLOCK = REGISTER.register("ruby_block", () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
}
