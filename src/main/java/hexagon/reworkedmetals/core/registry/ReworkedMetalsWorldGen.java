package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.core.config.Config;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;

public class ReworkedMetalsWorldGen {
    
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.TIN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
    );
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TUNGSTEN_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState())
    );
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_VANADIUM_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.VANADIUM_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_VANADIUM_ORE.get().defaultBlockState())
    );
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_RUBY_TARGET_LIST = ImmutableList.of(
            OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ReworkedMetalsBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ReworkedMetalsBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())
    );
    
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(
            new OreConfiguration(ORE_TIN_TARGET_LIST, Config.getInt("tinOreVeinSize"))
    ).rangeTriangle(VerticalAnchor.absolute(Config.getInt("tinOreMinHeight")), VerticalAnchor.absolute(Config.getInt("tinOreMaxHeight"))).squared().count(Config.getInt("tinOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_TUNGSTEN = Feature.ORE.configured(
            new OreConfiguration(ORE_TUNGSTEN_TARGET_LIST, Config.getInt("tungstenOreVeinSize"))
    ).rangeTriangle(VerticalAnchor.absolute(Config.getInt("tungstenOreMinHeight")), VerticalAnchor.absolute(Config.getInt("tungstenOreMaxHeight"))).squared().count(Config.getInt("tungstenOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_VANADIUM = Feature.ORE.configured(
            new OreConfiguration(ORE_VANADIUM_TARGET_LIST, Config.getInt("vanadiumOreVeinSize"))
    ).rangeTriangle(VerticalAnchor.absolute(Config.getInt("vanadiumOreMinHeight")), VerticalAnchor.absolute(Config.getInt("vanadiumOreMaxHeight"))).squared().count(Config.getInt("vanadiumOreAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_RUBY = Feature.REPLACE_SINGLE_BLOCK.configured(
            new ReplaceBlockConfiguration(ORE_RUBY_TARGET_LIST)
    ).rangeTriangle(VerticalAnchor.absolute(Config.getInt("rubyOreMinHeight")), VerticalAnchor.absolute(Config.getInt("rubyOreMaxHeight"))).squared().count(UniformInt.of(Config.getInt("rubyOreMinAttempts"), Config.getInt("rubyOreMaxAttempts")));
    
    private static <FC extends FeatureConfiguration> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    public static void register() {
        register("ore_tin", ORE_TIN);
        register("ore_tungsten", ORE_TUNGSTEN);
        register("ore_vanadium", ORE_VANADIUM);
        register("ore_ruby", ORE_RUBY);
    }
}
