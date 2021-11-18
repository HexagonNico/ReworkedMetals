package hexagonnico.reworkedmetals;

import hexagonnico.reworkedmetals.config.Config;
import hexagonnico.reworkedmetals.registry.BlocksRegistry;
import hexagonnico.reworkedmetals.registry.ContainersRegistry;
import hexagonnico.reworkedmetals.registry.CraftingRegistry;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;
import hexagonnico.reworkedmetals.registry.TileEntitiesRegistry;
import hexagonnico.reworkedmetals.registry.WorldGenRegistry;

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
        
        BlocksRegistry.REGISTER.register(eventBus);
        BlocksRegistry.OVERRIDES.register(eventBus);
        ItemsRegistry.REGISTER.register(eventBus);
        ItemsRegistry.OVERRIDES.register(eventBus);
        TileEntitiesRegistry.REGISTER.register(eventBus);
        ContainersRegistry.REGISTER.register(eventBus);
        CraftingRegistry.REGISTER.register(eventBus);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final FMLCommonSetupEvent setupEvent) {
        WorldGenRegistry.register();
        CraftingRegistry.registerConditions();
    }
    
    private void clientSetup(final FMLClientSetupEvent setupEvent) {
        ContainersRegistry.registerGuis();
    }
}
