package hexagonnico.reworkedmetals.content.worldgen;

import hexagonnico.reworkedmetals.registry.BlocksRegistry;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModdedOreFeatures {

	// Tin
	private static final ConfiguredFeature<?, ?> TIN_CONFIGURATION = FeatureUtils.register("tin", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.TIN_ORE.get(), BlocksRegistry.DEEPSLATE_TIN_ORE.get(), 10)));
	public static final PlacedFeature TIN_ORE = PlacementUtils.register("tin_ore", TIN_CONFIGURATION.placed(ModdedOres.trianglePlacement(12, 48, 112)));
	public static final PlacedFeature TIN_ORE_LOWER = PlacementUtils.register("tin_ore_lower", TIN_CONFIGURATION.placed(ModdedOres.trianglePlacement(12, -16, 48)));

	// Aluminum
	private static final ConfiguredFeature<?, ?> ALUMINUM_CONFIGURATION = FeatureUtils.register("aluminum", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.ALUMINUM_ORE.get(), BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get(), 9)));
	private static final ConfiguredFeature<?, ?> ALUMINUM_BURIED_CONFIGURATION = FeatureUtils.register("aluminum_buried", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.ALUMINUM_ORE.get(), BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get(), 9, 0.5f)));
	public static final PlacedFeature ALUMINUM_ORE = PlacementUtils.register("aluminum_ore", ALUMINUM_CONFIGURATION.placed(ModdedOres.trianglePlacement(6, 8, 8, 88)));
	public static final PlacedFeature ALUMINUM_ORE_LOWER = PlacementUtils.register("aluminum_ore_lower", ALUMINUM_BURIED_CONFIGURATION.placed(ModdedOres.uniformPlacement(8, 12, -64, -32)));

	// Silver
	private static final ConfiguredFeature<?, ?> SILVER_CONFIGURATION = FeatureUtils.register("silver", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.SILVER_ORE.get(), BlocksRegistry.DEEPSLATE_SILVER_ORE.get(), 9)));
	private static final ConfiguredFeature<?, ?> SILVER_BURIED_CONFIGURATION = FeatureUtils.register("silver_buried", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.SILVER_ORE.get(), BlocksRegistry.DEEPSLATE_SILVER_ORE.get(), 9, 0.25f)));
	public static final PlacedFeature SILVER_ORE = PlacementUtils.register("silver_ore", SILVER_CONFIGURATION.placed(ModdedOres.trianglePlacement(4, -16, 32)));
	public static final PlacedFeature SILVER_ORE_LOWER = PlacementUtils.register("silver_ore_lower", SILVER_CONFIGURATION.placed(ModdedOres.trianglePlacement(4, -64, -16)));
	public static final PlacedFeature SILVER_ORE_MOUNTAINS = PlacementUtils.register("silver_ore_mountains", SILVER_BURIED_CONFIGURATION.placed(ModdedOres.trianglePlacement(1, 4, 112, 144)));

	// Nickel
	private static final ConfiguredFeature<?, ?> NICKEL_CONFIGURATION = FeatureUtils.register("nickel", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.NICKEL_ORE.get(), BlocksRegistry.DEEPSLATE_NICKEL_ORE.get(), 8)));
	private static final ConfiguredFeature<?, ?> NICKEL_BURIED_CONFIGURATION = FeatureUtils.register("nickel_buried", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.NICKEL_ORE.get(), BlocksRegistry.DEEPSLATE_NICKEL_ORE.get(), 8, 0.0f)));
	public static final PlacedFeature NICKEL_ORE = PlacementUtils.register("nickel_ore", NICKEL_CONFIGURATION.placed(ModdedOres.trianglePlacement(4, 9, -144, 16)));
	public static final PlacedFeature NICKEL_ORE_ABOVE = PlacementUtils.register("nickel_ore_above", NICKEL_BURIED_CONFIGURATION.placed(ModdedOres.trianglePlacement(5, -16, 16)));

	// Ruby
	private static final ConfiguredFeature<?, ?> RUBY_CONFIGURATION = FeatureUtils.register("ruby", Feature.ORE.configured(ModdedOres.configuration(BlocksRegistry.RUBY_ORE.get(), BlocksRegistry.DEEPSLATE_RUBY_ORE.get(), 3)));
	public static final PlacedFeature RUBY_ORE = PlacementUtils.register("ruby_ore", RUBY_CONFIGURATION.placed(ModdedOres.trianglePlacement(100, -16, 480)));

	// End
	private static final ConfiguredFeature<?, ?> END_METAL_CONFIGURATION = FeatureUtils.register("end_metal", Feature.ORE.configured(ModdedOres.configurationEnd(BlocksRegistry.END_METAL_ORE.get(), 8, 0.1f)));
	private static final ConfiguredFeature<?, ?> END_GEM_CONFIGURED = FeatureUtils.register("end_gem", Feature.ORE.configured(ModdedOres.configurationEnd(BlocksRegistry.END_GEM_ORE.get(), 4, 0.1f)));
	public static final PlacedFeature END_METAL_ORE = PlacementUtils.register("end_metal_ore", END_METAL_CONFIGURATION.placed(ModdedOres.uniformPlacement(0, 2, 1, 200)));
	public static final PlacedFeature END_GEM_ORE = PlacementUtils.register("end_gem_ore", END_GEM_CONFIGURED.placed(ModdedOres.uniformPlacement(0, 2, 1, 200)));
}
