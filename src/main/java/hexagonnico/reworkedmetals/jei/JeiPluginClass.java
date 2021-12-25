package hexagonnico.reworkedmetals.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.AlloyingRecipe;
import hexagonnico.reworkedmetals.content.crafting.BlastAlloyingRecipe;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import java.util.stream.Collectors;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

@JeiPlugin
public class JeiPluginClass implements IModPlugin {

    private static final Minecraft MINECRAFT = Minecraft.getInstance();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloyingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new BlastAlloyingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
            MINECRAFT.level.getRecipeManager().getRecipes().stream()
                .filter(r -> r.getType() == AlloyingRecipe.TYPE)
                .collect(Collectors.toList()),
            AlloyingRecipeCategory.ID
        );
        registration.addRecipes(
            MINECRAFT.level.getRecipeManager().getRecipes().stream()
                .filter(r -> r.getType() == BlastAlloyingRecipe.TYPE)
                .collect(Collectors.toList()),
            BlastAlloyingRecipeCategory.ID
        );
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemsRegistry.ALLOYING_FURNACE.get()), AlloyingRecipeCategory.ID);
        registration.addRecipeCatalyst(new ItemStack(ItemsRegistry.ALLOYING_BLAST_FURNACE.get()), BlastAlloyingRecipeCategory.ID);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ReworkedMetals.ID, "jei_plugin");
    }
}
