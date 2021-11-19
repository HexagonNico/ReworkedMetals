package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
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

/**
 * World generation registry. Handles world generation for ReworkedMetals.
 * 
 * @author Nico
 */
public class WorldGenRegistry {

    public static final ConfiguredFeature<?, ?> ORE_COPPER = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.COPPER_ORE.get().defaultBlockState(), Config.getInt("copperOreVeinSize"))
    ).range(Config.getInt("copperOreMaxHeight")).squared().count(Config.getInt("copperOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_TIN = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.TIN_ORE.get().defaultBlockState(), Config.getInt("tinOreVeinSize"))
    ).range(Config.getInt("tinOreMaxHeight")).squared().count(Config.getInt("tinOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_ALUMINUM = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.ALUMINUM_ORE.get().defaultBlockState(), Config.getInt("aluminumOreVeinSize"))
    ).range(Config.getInt("aluminumOreMaxHeight")).squared().count(Config.getInt("aluminumOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_NICKEL = Feature.ORE.configured(
            new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.NICKEL_ORE.get().defaultBlockState(), Config.getInt("nickelOreVeinSize"))
    ).range(Config.getInt("nickelOreMaxHeight")).squared().count(Config.getInt("nickelOreAttempts"));
    
    public static final ConfiguredFeature<?, ?> ORE_RUBY = Feature.EMERALD_ORE.configured(
            new ReplaceBlockConfig(Blocks.STONE.defaultBlockState(), BlocksRegistry.RUBY_ORE.get().defaultBlockState())
    ).decorated(Placement.EMERALD_ORE.configured(IPlacementConfig.NONE));
    
    /**
     * Registers a configured feature.
     * @param <FC> IFeatureConfig type.
     * @param key Name of the feature.
     * @param feature The feature to register.
     */
    private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> feature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, feature);
    }
    
    /**
     * Registers all configured features. Called in {@link ReworkedMetals#commonSetup}.
     * Note that features need to be added to biomes with an event handler in order to generate.
     */
    public static void register() {
        register("copper_ore", ORE_COPPER);
        register("ore_tin", ORE_TIN);
        register("ore_aluminum", ORE_ALUMINUM);
        register("ore_nickel", ORE_NICKEL);
        register("ore_ruby", ORE_RUBY);
    }
}
