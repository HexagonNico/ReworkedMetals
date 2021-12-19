package hexagonnico.reworkedmetals.content.worldgen;

import java.util.List;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModdedOreFeatures {
	
	public static final ConfiguredFeature<?, ?> TEST_ORE_CONFIGURED = FeatureUtils.register("test", Feature.ORE.configured(new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, Blocks.COBBLESTONE.defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, Blocks.COBBLED_DEEPSLATE.defaultBlockState())), 10)));
	public static final PlacedFeature TEST_ORE_PLACED = PlacementUtils.register("test", TEST_ORE_CONFIGURED.placed(List.of(CountPlacement.of(20), InSquarePlacement.spread(), HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)), BiomeFilter.biome())));
}
