package hexagonnico.reworkedmetals.content.worldgen;

import java.util.List;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModdedOres {
	
	public static OreConfiguration configuration(Block ore, Block deepslateOre, int count) {
		return new OreConfiguration(targetStates(ore, deepslateOre), count);
	}
	
	public static OreConfiguration configuration(Block ore, Block deepslateOre, int count, float airExposure) {
		return new OreConfiguration(targetStates(ore, deepslateOre), count, 1.0f - airExposure);
	}

	public static List<OreConfiguration.TargetBlockState> targetStates(Block ore, Block deepslateOre) {
		return List.of(
			OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ore.defaultBlockState()),
			OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, deepslateOre.defaultBlockState())
		);
	}

	public static List<PlacementModifier> trianglePlacement(int count, int minHeight, int maxHeight) {
		return List.of(
			CountPlacement.of(count),
			InSquarePlacement.spread(),
			HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
			BiomeFilter.biome()
		);
	}

	public static List<PlacementModifier> trianglePlacement(int minCount, int maxCount, int minHeight, int maxHeight) {
		return List.of(
			CountPlacement.of(UniformInt.of(minCount, maxCount)),
			InSquarePlacement.spread(),
			HeightRangePlacement.triangle(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight)),
			BiomeFilter.biome()
		);
	}
}
