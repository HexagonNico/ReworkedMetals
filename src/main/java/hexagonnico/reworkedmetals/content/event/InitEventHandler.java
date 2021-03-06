package hexagonnico.reworkedmetals.content.event;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.CommonConfig;
import hexagonnico.reworkedmetals.content.worldgen.ModdedOreFeatures;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.GenerationStep;

@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {

	@SubscribeEvent // Event fired when loading biomes
	public static void onBiomeLoadEvent(BiomeLoadingEvent event) {
		BiomeGenerationSettingsBuilder generation = event.getGeneration();
		if(CommonConfig.getBoolean("tinOre")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.TIN_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.TIN_ORE_LOWER);
		}
		if(CommonConfig.getBoolean("aluminumOre")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.ALUMINUM_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.ALUMINUM_ORE_LOWER);
		}
		if(CommonConfig.getBoolean("silverOre")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.SILVER_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.SILVER_ORE_LOWER);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.SILVER_ORE_MOUNTAINS);
		}
		if(CommonConfig.getBoolean("nickelOre")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.NICKEL_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.NICKEL_ORE_ABOVE);
		}
		if(CommonConfig.getBoolean("rubyOre") && event.getName() != null && event.getName().getPath().contains("windswept_savanna")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.RUBY_ORE);
		}
		if(CommonConfig.getBoolean("endOre") && event.getName() != null && event.getName().getPath().contains("end")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.END_METAL_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.END_GEM_ORE);
		}
	}
}
