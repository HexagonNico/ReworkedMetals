package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.config.Config;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

/**
 * World generation registry.
 * Handles world generation for ReworkedMetals.
 * @author Nico
 */
public class WorldGenRegistry {

    public static final ConfiguredFeature<?, ?> ORE_TIN = register("ore_tin", BlocksRegistry.TIN_ORE.get(), BlocksRegistry.DEEPSLATE_TIN_ORE.get(), Config.getInt("tinVeinSize"), Config.getInt("tinMinHeight"), Config.getInt("tinMaxHeight"), Config.getInt("tinMinAttempts"), Config.getInt("tinMaxAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_ALUMINUM = register("ore_aluminum", BlocksRegistry.ALUMINUM_ORE.get(), BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get(), Config.getInt("aluminumVeinSize"), Config.getInt("aluminumMinHeight"), Config.getInt("aluminumMaxHeight"), Config.getInt("aluminumMinAttempts"), Config.getInt("aluminumMaxAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_SILVER = register("ore_silver", BlocksRegistry.SILVER_ORE.get(), BlocksRegistry.DEEPSLATE_SILVER_ORE.get(), Config.getInt("silverVeinSize"), Config.getInt("silverMinHeight"), Config.getInt("silverMaxHeight"), Config.getInt("silverMinAttempts"), Config.getInt("silverMaxAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_NICKEL = register("ore_nickel", BlocksRegistry.NICKEL_ORE.get(), BlocksRegistry.DEEPSLATE_NICKEL_ORE.get(), Config.getInt("nickelVeinSize"), Config.getInt("nickelMinHeight"), Config.getInt("nickelMaxHeight"), Config.getInt("nickelMinAttempts"), Config.getInt("nickelMaxAttempts"));
    public static final ConfiguredFeature<?, ?> ORE_RUBY = register("ore_ruby", BlocksRegistry.RUBY_ORE.get(), BlocksRegistry.DEEPSLATE_RUBY_ORE.get(), Config.getInt("rubyVeinSize"), Config.getInt("rubyMinHeight"), Config.getInt("rubyMaxHeight"), Config.getInt("rubyMinAttempts"), Config.getInt("rubyMaxAttempts"));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<?, ?> register(String key, Block ore, Block deepslateOre, int veinSize, int minHeight, int maxHeight, int minAttempts, int maxAttempts) {
        OreConfiguration.TargetBlockState oreTarget = OreConfiguration.target(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, ore.defaultBlockState());
        OreConfiguration.TargetBlockState deepslateOreTarget = OreConfiguration.target(OreConfiguration.Predicates.DEEPSLATE_ORE_REPLACEABLES, deepslateOre.defaultBlockState());
        ImmutableList<OreConfiguration.TargetBlockState> targetList = ImmutableList.of(oreTarget, deepslateOreTarget);
        OreConfiguration oreConfiguration = new OreConfiguration(targetList, veinSize);
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(oreConfiguration)
                .rangeUniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight))
                .squared().count(UniformInt.of(minAttempts, maxAttempts));
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key, feature);
    }
}
