package hexagonnico.reworkedmetals.content.event;

import java.util.Arrays;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.CommonConfig;
import hexagonnico.reworkedmetals.content.worldgen.ModdedOreFeatures;
import hexagonnico.reworkedmetals.registry.VillagersRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.levelgen.GenerationStep;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.SILVER_ORE_MOUNTAINS);
		}
		if(CommonConfig.getBoolean("nickelOre")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.NICKEL_ORE);
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.NICKEL_ORE_ABOVE);
		}
		if(CommonConfig.getBoolean("rubyOre") && event.getName() != null && event.getName().getPath().contains("windswept_savanna")) {
			generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModdedOreFeatures.RUBY_ORE);
		}
	}

	@SubscribeEvent // Event fired when loading villager professions
	public static void onVillagerLoad(VillagerTradesEvent event) {
		if(event.getType() == VillagersRegistry.ARMORER.get()) {
			event.getTrades().put(1, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(1)));
			event.getTrades().put(2, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(2)));
			event.getTrades().put(3, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(3)));
			event.getTrades().put(4, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(4)));
			event.getTrades().put(5, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(5)));
		}
	}
}
