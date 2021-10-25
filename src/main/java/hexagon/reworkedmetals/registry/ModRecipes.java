package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.crafting.SmelteryRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModRecipes {
    
    public static DeferredRegister<RecipeSerializer<?>> REGISTER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, ReworkedMetals.ID);
    public static RegistryObject<RecipeSerializer<?>> SMELTERY = REGISTER.register("smeltery", () -> SmelteryRecipe.SERIALIZER);
}
