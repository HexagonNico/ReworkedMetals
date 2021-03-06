package hexagonnico.reworkedmetals;

import hexagonnico.reworkedmetals.config.CommonConfig;
import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;
import hexagonnico.reworkedmetals.registry.BlocksRegistry;
import hexagonnico.reworkedmetals.registry.ContainerMenusRegistry;
import hexagonnico.reworkedmetals.registry.CraftingRegistry;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ReworkedMetals.ID)
public class ReworkedMetals {

	/** ReworkedMetals Mod Id */
	public static final String ID = "reworkedmetals";

	/**
	 * Mod initializer
	 */
	public ReworkedMetals() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::commonSetup);
		eventBus.addListener(this::clientSetup);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.CONFIG);

		BlocksRegistry.REGISTER.register(eventBus);
		ItemsRegistry.REGISTER.register(eventBus);
		ItemsRegistry.OVERRIDES.register(eventBus);
		BlockEntitiesRegistry.REGISTER.register(eventBus);
		ContainerMenusRegistry.REGISTER.register(eventBus);
		CraftingRegistry.REGISTER.register(eventBus);

		MinecraftForge.EVENT_BUS.register(this);
	}

	/**
	 * Common setup event to register things.
	 * @param setupEvent FMLCommonSetupEvent.
	 */
	private void commonSetup(final FMLCommonSetupEvent setupEvent) {
		CraftingRegistry.registerConditions();
	}

	/**
	 * Client setup event for client stuff.
	 * @param setupEvent FMLClientSetupEvent.
	 */
	private void clientSetup(final FMLClientSetupEvent setupEvent) {
		ContainerMenusRegistry.registerGuis();
	}
}
