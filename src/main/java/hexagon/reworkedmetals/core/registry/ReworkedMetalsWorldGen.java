package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.core.config.Config;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ReworkedMetalsWorldGen {
    
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
    );
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TUNGSTEN_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())
    );
    
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(
            new OreConfiguration(ORE_TIN_TARGET_LIST, Config.getInt("tinOreVeinSize")))
                .rangeTriangle(VerticalAnchor.absolute(Config.getInt("tinOreMinHeight")), VerticalAnchor.absolute(Config.getInt("tinOreMaxHeight"))).squared().count(Config.getInt("tinOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_TUNGSTEN = Feature.ORE.configured(
            new OreConfiguration(ORE_TUNGSTEN_TARGET_LIST, Config.getInt("tungstenOreVeinSize")))
                .rangeTriangle(VerticalAnchor.absolute(Config.getInt("tungstenOreMinHeight")), VerticalAnchor.absolute(Config.getInt("tungstenOreMaxHeight"))).squared().count(Config.getInt("tungstenOreAttempts"));
    
    private static <FC extends FeatureConfiguration> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    public static void register() {
        register("ore_tin", ORE_TIN);
        register("ore_tungsten", ORE_TUNGSTEN);
    }
}
