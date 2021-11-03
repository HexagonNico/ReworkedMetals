package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.block.BlastFurnaceBlock;
import hexagon.reworkedmetals.block.FurnaceBlock;
import hexagon.reworkedmetals.block.KilnBlock;
import hexagon.reworkedmetals.block.SmelteryBlock;

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
public class ModBlocks {
    
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
}
