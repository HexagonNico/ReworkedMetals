package hexagonnico.reworkedmetals.registry;

import com.google.common.collect.ImmutableSet;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;

public class VillagersRegistry {
    
    public static final DeferredRegister<PointOfInterestType> POI_OVERRIDES = DeferredRegister.create(ForgeRegistries.POI_TYPES, "minecraft");
    public static final DeferredRegister<VillagerProfession> PROFESSIONS_OVERRIDES = DeferredRegister.create(ForgeRegistries.PROFESSIONS, "minecraft");

    public static final RegistryObject<PointOfInterestType> BLAST_FURNACE = POI_OVERRIDES.register("armorer", () -> new PointOfInterestType("armorer", ImmutableSet.copyOf(BlocksRegistry.BLAST_FURNACE.get().getStateDefinition().getPossibleStates()), 1, 1));
    public static final RegistryObject<VillagerProfession> ARMORER = PROFESSIONS_OVERRIDES.register("armorer", () -> new VillagerProfession("armorer", BLAST_FURNACE.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));
}
