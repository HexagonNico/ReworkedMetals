package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.config.Config;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class WorldGenRegistry {

    public static final ConfiguredFeature<?, ?> ORE_COPPER = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.COPPER_ORE.get().defaultBlockState(), Config.getInt("copperOreVeinSize"))
    ).range(Config.getInt("copperOreMaxHeight")).squared().count(Config.getInt("copperOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.TIN_ORE.get().defaultBlockState(), Config.getInt("tinOreVeinSize"))
    ).range(Config.getInt("tinOreMaxHeight")).squared().count(Config.getInt("tinOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_TUNGSTEN = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.TUNGSTEN_ORE.get().defaultBlockState(), Config.getInt("tungstenOreVeinSize"))
    ).range(Config.getInt("tungstenOreMaxHeight")).squared().count(Config.getInt("tungstenOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_VANADIUM = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.VANADIUM_ORE.get().defaultBlockState(), Config.getInt("vanadiumOreVeinSize"))
    ).range(Config.getInt("vanadiumOreMaxHeight")).squared().count(Config.getInt("vanadiumOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_RUBY = Feature.EMERALD_ORE.configured(
            new ReplaceBlockConfig(Blocks.STONE.defaultBlockState(), BlocksRegistry.RUBY_ORE.get().defaultBlockState())
    ).decorated(Placement.EMERALD_ORE.configured(IPlacementConfig.NONE));
    
    private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    public static void register() {
        register("copper_ore", ORE_COPPER);
        register("ore_tin", ORE_TIN);
        register("ore_tungsten", ORE_TUNGSTEN);
        register("ore_vanadium", ORE_VANADIUM);
        register("ore_ruby", ORE_RUBY);
    }
}
