package hexagonnico.reworkedmetals.content.event;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.config.Config;
import hexagonnico.reworkedmetals.registry.WorldGenRegistry;

import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
}
