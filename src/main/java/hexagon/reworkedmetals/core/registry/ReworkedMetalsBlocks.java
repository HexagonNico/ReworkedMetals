package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.core.ReworkedMetals;
import hexagon.reworkedmetals.common.block.BlastFurnaceBlock;
import hexagon.reworkedmetals.common.block.FurnaceBlock;
import hexagon.reworkedmetals.common.block.KilnBlock;
import hexagon.reworkedmetals.common.block.SmelteryBlock;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
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
    
    public static final RegistryObject<Block> TIN_ORE = REGISTER.register("tin_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = REGISTER.register("deepslate_tin_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = REGISTER.register("tungsten_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = REGISTER.register("deepslate_tungsten_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> VANADIUM_ORE = REGISTER.register("vanadium_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f)));
    public static final RegistryObject<Block> DEEPSLATE_VANADIUM_ORE = REGISTER.register("deepslate_vanadium_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(VANADIUM_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> RUBY_ORE = REGISTER.register("ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0f, 3.0f), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = REGISTER.register("deepslate_ruby_ore", () -> new OreBlock(BlockBehaviour.Properties.copy(RUBY_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5f, 3.0f).sound(SoundType.DEEPSLATE), UniformInt.of(3, 7)));
    
    public static final RegistryObject<Block> TIN_BLOCK = REGISTER.register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(3.0f, 6.0f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = REGISTER.register("raw_tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = REGISTER.register("tungsten_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_TUNGSTEN_BLOCK = REGISTER.register("raw_tungsten_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
    public static final RegistryObject<Block> BRONZE_BLOCK = REGISTER.register("bronze_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BROWN).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> STEEL_BLOCK = REGISTER.register("steel_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RAW_VANADIUM_BLOCK = REGISTER.register("raw_vanadium_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f)));
    public static final RegistryObject<Block> VANADIUM_BLOCK = REGISTER.register("vanadium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
    public static final RegistryObject<Block> RUBY_BLOCK = REGISTER.register("ruby_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0f, 6.0f).sound(SoundType.METAL)));
}
