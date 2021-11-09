package hexagon.reworkedmetals.core;

import hexagon.reworkedmetals.core.config.Config;
import hexagon.reworkedmetals.core.registry.*;

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
        
        ReworkedMetalsBlocks.REGISTER.register(eventBus);
        ReworkedMetalsBlocks.OVERRIDES.register(eventBus);
        ReworkedMetalsItems.REGISTER.register(eventBus);
        ReworkedMetalsItems.OVERRIDES.register(eventBus);
        ReworkedMetalsBlockEntities.REGISTER.register(eventBus);
        ReworkedMetalsContainers.REGISTER.register(eventBus);
        ReworkedMetalsCrafting.REGISTER.register(eventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final FMLCommonSetupEvent setupEvent) {
        ReworkedMetalsWorldGen.register();
        ReworkedMetalsCrafting.registerConditions();
        ReworkedMetalsVillagers.armorerFix();
    }
    
    private void clientSetup(final FMLClientSetupEvent setupEvent) {
        ReworkedMetalsContainers.registerGuis();
    }
}
