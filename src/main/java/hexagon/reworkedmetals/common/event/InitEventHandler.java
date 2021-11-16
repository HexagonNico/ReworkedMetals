package hexagon.reworkedmetals.common.event;

import hexagon.reworkedmetals.core.ReworkedMetals;
import hexagon.reworkedmetals.core.config.Config;
import hexagon.reworkedmetals.core.registry.ReworkedMetalsWorldGen;

import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {
    
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(Config.getBoolean("tinOreGenEnabled")) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ReworkedMetalsWorldGen.ORE_TIN);
        }
        if(Config.getBoolean("tungstenOreGenEnabled")) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ReworkedMetalsWorldGen.ORE_TUNGSTEN);
        }
        if(Config.getBoolean("vanadiumOreGenEnabled")) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ReworkedMetalsWorldGen.ORE_VANADIUM);
        }
        if(Config.getBoolean("rubyOreGenEnabled") && event.getName() != null && event.getName().getPath().equals("shattered_savanna_plateau")) {
            generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ReworkedMetalsWorldGen.ORE_RUBY);
        }
    }
}
