package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.ConfigCondition;
import hexagonnico.reworkedmetals.content.crafting.ReworkedSmeltingRecipe;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.item.crafting.IRecipeSerializer;

/**
 * Crafting registry. Handles registration for recipe serializers.
 * 
 * @author Nico
 */
public class CraftingRegistry {
    
    public static final DeferredRegister<IRecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
    public static final RegistryObject<IRecipeSerializer<?>> SMELTING = REGISTER.register("smelting", () -> ReworkedSmeltingRecipe.SERIALIZER);
    
    /**
     * Registers crafting condition. Called in {@link ReworkedMetals#commonSetup}.
     */
    public static void registerConditions() {
        CraftingHelper.register(ConfigCondition.SERIALIZER);
    }
}
