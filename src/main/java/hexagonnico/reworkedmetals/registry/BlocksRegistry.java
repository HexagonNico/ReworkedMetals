package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.block.BlastFurnaceBlock;
import hexagonnico.reworkedmetals.content.block.FurnaceBlock;
import hexagonnico.reworkedmetals.content.block.KilnBlock;
import hexagonnico.reworkedmetals.content.block.SmelteryBlock;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

/**
 * Blocks registry.
 * Contains all ReworkedMetals blocks.
 * @author Nico
 */
public class BlocksRegistry {

	// Deferred register
	public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkedMetals.ID);
	public static final DeferredRegister<Block> OVERRIDES = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

	// Furnaces
	public static final RegistryObject<Block> SMELTERY = REGISTER.register("smeltery", SmelteryBlock::new);
	public static final RegistryObject<Block> FURNACE = OVERRIDES.register("furnace", FurnaceBlock::new);
	public static final RegistryObject<Block> BLAST_FURNACE = OVERRIDES.register("blast_furnace", BlastFurnaceBlock::new);
	public static final RegistryObject<Block> KILN = REGISTER.register("kiln", KilnBlock::new);

	// Ores
	public static final RegistryObject<Block> TIN_ORE = REGISTER.register("tin_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
	public static final RegistryObject<Block> ALUMINUM_ORE = REGISTER.register("aluminum_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
	public static final RegistryObject<Block> SILVER_ORE = REGISTER.register("silver_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
	public static final RegistryObject<Block> NICKEL_ORE = REGISTER.register("nickel_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
	public static final RegistryObject<Block> RUBY_ORE = REGISTER.register("ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f), UniformInt.of(3, 7)));

	// Deepslate ores
	public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = REGISTER.register("deepslate_tin_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> DEEPSLATE_ALUMINUM_ORE = REGISTER.register("deepslate_aluminum_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(ALUMINUM_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = REGISTER.register("deepslate_silver_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(SILVER_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> DEEPSLATE_NICKEL_ORE = REGISTER.register("deepslate_nickel_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(NICKEL_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = REGISTER.register("deepslate_ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(RUBY_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));

	// Raw metal blocks
	public static final RegistryObject<Block> RAW_TIN_BLOCK = REGISTER.register("raw_tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> RAW_ALUMINUM_BLOCK = REGISTER.register("raw_aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> RAW_SILVER_BLOCK = REGISTER.register("raw_silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
	public static final RegistryObject<Block> RAW_NICKEL_BLOCK = REGISTER.register("raw_nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));

	// Metal blocks
	public static final RegistryObject<Block> TIN_BLOCK = REGISTER.register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(SoundType.COPPER)));
	public static final RegistryObject<Block> BRONZE_BLOCK = REGISTER.register("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.COPPER)));
	public static final RegistryObject<Block> ALUMINUM_BLOCK = REGISTER.register("aluminum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> SILVER_BLOCK = REGISTER.register("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> NICKEL_BLOCK = REGISTER.register("nickel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> INVAR_BLOCK = REGISTER.register("invar_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> STEEL_BLOCK = REGISTER.register("steel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
	public static final RegistryObject<Block> RUBY_BLOCK = REGISTER.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
}
