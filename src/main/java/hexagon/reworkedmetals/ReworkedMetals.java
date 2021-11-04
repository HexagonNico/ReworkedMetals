package hexagon.reworkedmetals;

import hexagon.reworkedmetals.registry.*;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ReworkedMetals.ID)
public final class ReworkedMetals {
    
    public static final String ID = "reworkedmetals";
    
    public ReworkedMetals() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.CONFIG);
        ModBlocks.REGISTER.register(eventBus);
        ModBlocks.OVERRIDES.register(eventBus);
        ModItems.REGISTER.register(eventBus);
        ModItems.OVERRIDES.register(eventBus);
        ModBlockEntities.REGISTER.register(eventBus);
        ModContainers.REGISTER.register(eventBus);
        ModRecipes.REGISTER.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final FMLCommonSetupEvent setupEvent) {
        ModWorldGen.register();
        ModRecipes.registerConditions();
    }
    
    private void clientSetup(final FMLClientSetupEvent setupEvent) {
        ModGuis.register();
    }
}
