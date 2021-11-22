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

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;

@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {
    
    @SubscribeEvent // Event run when loading biomes
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(Config.getBoolean("copperOreGenEnabled")) {
            WorldGenRegistry.addCopperToGenSettings(generation);
        }
        if(Config.getBoolean("tinOreGenEnabled")) {
            WorldGenRegistry.addTinToGenSettings(generation);
        }
        if(Config.getBoolean("aluminumOreGenEnabled")) {
            WorldGenRegistry.addAluminumToGenSettings(generation);
        }
        if(Config.getBoolean("silverOreGenEnabled")) {
            WorldGenRegistry.addSilverToGenSettings(generation);
        }
        if(Config.getBoolean("nickelOreGenEnabled")) {
            WorldGenRegistry.addNickelToGenSettings(generation);
        }
        if(Config.getBoolean("rubyOreGenEnabled") && event.getName() != null && event.getName().getPath().contains("shattered_savanna")) {
            WorldGenRegistry.addRubyToGenSettings(generation);
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
