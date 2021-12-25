package hexagonnico.reworkedmetals.registry;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;

public class VillagersRegistry {

	public static final DeferredRegister<PoiType> POI_OVERRIDES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
	public static final DeferredRegister<VillagerProfession> PROFESSIONS_OVERRIDES = DeferredRegister.create(ForgeRegistries.PROFESSIONS, "minecraft");

	// TODO
}
