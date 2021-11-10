package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.common.crafting.ConfigCondition;
import hexagon.reworkedmetals.common.crafting.ReworkedFurnaceRecipe;
import hexagon.reworkedmetals.core.ReworkedMetals;

import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ReworkedMetalsCrafting {
    
    public static DeferredRegister<IRecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
    public static RegistryObject<IRecipeSerializer<?>> SMELTING = REGISTER.register("smelting", () -> ReworkedFurnaceRecipe.SERIALIZER);
    
    public static void registerConditions() {
        CraftingHelper.register(ConfigCondition.SERIALIZER);
    }
}
