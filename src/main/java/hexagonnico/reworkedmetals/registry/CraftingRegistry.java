package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.ConfigCondition;
import hexagonnico.reworkedmetals.content.crafting.ReworkedFurnaceRecipe;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.item.crafting.IRecipeSerializer;

public class CraftingRegistry {
    
    public static final DeferredRegister<IRecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
    public static final RegistryObject<IRecipeSerializer<?>> SMELTING = REGISTER.register("smelting", () -> ReworkedFurnaceRecipe.SERIALIZER);
    
    public static void registerConditions() {
        CraftingHelper.register(ConfigCondition.SERIALIZER);
    }
}
