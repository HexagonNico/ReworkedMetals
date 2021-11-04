package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.crafting.ConfigCondition;
import hexagon.reworkedmetals.crafting.ReworkedFurnaceRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ModRecipes {
    
    public static DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
    public static RegistryObject<RecipeSerializer<?>> SMELTING = REGISTER.register("smelting", () -> ReworkedFurnaceRecipe.SERIALIZER);
    
    public static void registerConditions() {
        CraftingHelper.register(ConfigCondition.SERIALIZER);
    }
}
