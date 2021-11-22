package hexagonnico.reworkedmetals.registry;

import com.google.common.collect.ImmutableSet;

import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;

public class VillagersRegistry {

    public static final DeferredRegister<PoiType> POI_OVERRIDES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
    public static final DeferredRegister<VillagerProfession> PROFESSIONS_OVERRIDES = DeferredRegister.create(ForgeRegistries.PROFESSIONS, "minecraft");

    public static final RegistryObject<PoiType> BLAST_FURNACE = POI_OVERRIDES.register("armorer", () -> new PoiType("armorer", ImmutableSet.copyOf(BlocksRegistry.BLAST_FURNACE.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> ARMORER = PROFESSIONS_OVERRIDES.register("armorer", () -> new VillagerProfession("armorer", BLAST_FURNACE.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
}
