package hexagonnico.reworkedmetals.content.event;

import java.util.Arrays;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.registry.VillagersRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ReworkedMetals.ID)
public class InitEventHandler {

	// TODO - Ore generation on BiomeLoadingEvent

	@SubscribeEvent // Event run when loading villager professions
	public static void onVillagerLoad(VillagerTradesEvent event) {
		if(event.getType() == VillagersRegistry.ARMORER.get()) {
			event.getTrades().put(1, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(1)));
			event.getTrades().put(2, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(2)));
			event.getTrades().put(3, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(3)));
			event.getTrades().put(4, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(4)));
			event.getTrades().put(5, Arrays.asList(VillagerTrades.TRADES.get(VillagerProfession.ARMORER).get(5)));
		}
	}
}
