package hexagonnico.reworkedmetals.content.event;

import hexagonnico.reworkedmetals.ReworkedMetals;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {
    
    @SubscribeEvent // Event run when loading biomes
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        // BiomeGenerationSettingsBuilder generation = event.getGeneration();
        // if(Config.getBoolean("copperOreGenEnabled")) {
        //     WorldGenRegistry.addCopperToGenSettings(generation);
        // }
        // if(Config.getBoolean("tinOreGenEnabled")) {
        //     WorldGenRegistry.addTinToGenSettings(generation);
        // }
        // if(Config.getBoolean("aluminumOreGenEnabled")) {
        //     WorldGenRegistry.addAluminumToGenSettings(generation);
        // }
        // if(Config.getBoolean("silverOreGenEnabled")) {
        //     WorldGenRegistry.addSilverToGenSettings(generation);
        // }
        // if(Config.getBoolean("nickelOreGenEnabled")) {
        //     WorldGenRegistry.addNickelToGenSettings(generation);
        // }
        // if(Config.getBoolean("rubyOreGenEnabled") && event.getName() != null && event.getName().getPath().contains("shattered_savanna")) {
        //     WorldGenRegistry.addRubyToGenSettings(generation);
        // }
    }
}
