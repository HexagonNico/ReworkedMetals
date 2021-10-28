package hexagon.reworkedmetals.registry;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class ModWorldGen {
    
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TIN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState()));
    public static final ImmutableList<OreConfiguration.TargetBlockState> ORE_TUNGSTEN_TARGET_LIST = ImmutableList.of(OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ModBlocks.TUNGSTEN_ORE.get().defaultBlockState()), OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get().defaultBlockState()));
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(new OreConfiguration(ORE_TIN_TARGET_LIST, 10)).rangeTriangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(96)).squared().count(2);
    public static final ConfiguredFeature<?, ?> ORE_TUNGSTEN = Feature.ORE.configured(new OreConfiguration(ORE_TUNGSTEN_TARGET_LIST, 9)).rangeTriangle(VerticalAnchor.absolute(32), VerticalAnchor.absolute(96)).squared().count(2);
    
    private static <FC extends FeatureConfiguration> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    public static void register() {
        register("ore_tin", ORE_TIN);
        register("ore_tungsten", ORE_TUNGSTEN);
    }
}
