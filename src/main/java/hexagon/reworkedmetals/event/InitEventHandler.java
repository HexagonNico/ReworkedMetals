package hexagon.reworkedmetals.event;

import hexagon.reworkedmetals.Config;
import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.registry.ModWorldGen;

import net.minecraft.world.level.levelgen.GenerationStep;
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
        if(Config.getBoolean("tinOreGenEnabled")) generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModWorldGen.ORE_TIN);
        if(Config.getBoolean("tungstenOreGenEnabled")) generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModWorldGen.ORE_TUNGSTEN);
    }
}
