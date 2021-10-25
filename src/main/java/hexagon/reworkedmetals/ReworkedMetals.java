package hexagon.reworkedmetals;

import hexagon.reworkedmetals.registry.ModBlockEntities;
import hexagon.reworkedmetals.registry.ModBlocks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
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
        ModBlocks.REGISTER.register(eventBus);
        ModBlockEntities.REGISTER.register(eventBus);
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void commonSetup(final FMLCommonSetupEvent setupEvent) {
    
    }
    
    private void clientSetup(final FMLClientSetupEvent setupEvent) {
    
    }
}
