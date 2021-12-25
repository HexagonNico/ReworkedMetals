package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.AlloyingRecipe;
import hexagonnico.reworkedmetals.content.crafting.BlastAlloyingRecipe;
import hexagonnico.reworkedmetals.content.crafting.ConfigCondition;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.item.crafting.RecipeSerializer;

/**
 * Crafting registry.
 * Handles registration for recipe serializers.
 * @author Nico
 */
public class CraftingRegistry {

	public static final DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
	public static final RegistryObject<RecipeSerializer<?>> ALLOYING = REGISTER.register("alloying", () -> AlloyingRecipe.SERIALIZER);
	public static final RegistryObject<RecipeSerializer<?>> BLAST_ALLOYING = REGISTER.register("blast_alloying", () -> BlastAlloyingRecipe.SERIALIZER);

	/**
	 * Registers crafting condition.
	 * Called in {@link ReworkedMetals#commonSetup}.
	 */
	public static void registerConditions() {
		CraftingHelper.register(ConfigCondition.SERIALIZER);
	}
}
