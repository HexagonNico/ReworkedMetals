package hexagonnico.reworkedmetals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ReworkedMetals.ID)
public final class ReworkedMetals {
    
    /** ReworkedMetals Mod Id */
    public static final String ID = "reworkedmetals";
    
    /**
     * Mod initializer
     */
    public ReworkedMetals() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        eventBus.addListener(this::clientSetup);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    /**
     * Common setup event to register things.
     * @param setupEvent FMLCommonSetupEvent.
     */
    private void commonSetup(final FMLCommonSetupEvent setupEvent) {

    }
    
    /**
     * Client setup event for client stuff.
     * @param setupEvent FMLClientSetupEvent.
     */
    private void clientSetup(final FMLClientSetupEvent setupEvent) {

    }
}
