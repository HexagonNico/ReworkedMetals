package hexagonnico.reworkedmetals.content.event;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.Config;
import hexagonnico.reworkedmetals.registry.VillagersRegistry;
import hexagonnico.reworkedmetals.registry.WorldGenRegistry;

import java.util.Arrays;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.levelgen.GenerationStep;

@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {
    
    @SubscribeEvent // Event run when loading biomes
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(Config.getBoolean("tinOreGenEnabled")) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenRegistry.ORE_TIN);
        }
        if(Config.getBoolean("aluminumOreGenEnabled")) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenRegistry.ORE_ALUMINUM);
        }
        if(Config.getBoolean("silverOreGenEnabled")) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenRegistry.ORE_SILVER);
        }
        if(Config.getBoolean("nickelOreGenEnabled")) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenRegistry.ORE_NICKEL);
        }
        if(Config.getBoolean("rubyOreGenEnabled") && event.getName() != null && event.getName().getPath().contains("shattered_savanna")) {
            generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, WorldGenRegistry.ORE_RUBY);
        }
    }

    @SubscribeEvent // Event run when loading villager professions
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
