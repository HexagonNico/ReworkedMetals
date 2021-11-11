package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.core.config.Config;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ReworkedMetalsWorldGen {
    
    public static final ConfiguredFeature<?, ?> ORE_COPPER = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ReworkedMetalsBlocks.COPPER_ORE.get().defaultBlockState(), Config.getInt("copperOreVeinSize")))
            .range(Config.getInt("copperOreMaxHeight")).squared().count(Config.getInt("copperOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ReworkedMetalsBlocks.TIN_ORE.get().defaultBlockState(), Config.getInt("tinOreVeinSize")))
            .range(Config.getInt("tinOreMaxHeight")).squared().count(Config.getInt("tinOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_TUNGSTEN = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ReworkedMetalsBlocks.TUNGSTEN_ORE.get().defaultBlockState(), Config.getInt("tungstenOreVeinSize")))
                .range(Config.getInt("tungstenOreMaxHeight")).squared().count(Config.getInt("tungstenOreAttempts"));
    
    private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    public static void register() {
        register("copper_ore", ORE_COPPER);
        register("ore_tin", ORE_TIN);
        register("ore_tungsten", ORE_TUNGSTEN);
    }
}
