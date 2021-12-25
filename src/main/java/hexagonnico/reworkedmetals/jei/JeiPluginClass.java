package hexagonnico.reworkedmetals.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.AlloyingRecipe;
import hexagonnico.reworkedmetals.content.gui.AlloyingFurnaceScreen;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import java.util.stream.Collectors;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

@JeiPlugin
public class JeiPluginClass implements IModPlugin {

    private static final Minecraft MINECRAFT = Minecraft.getInstance();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloyingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
            MINECRAFT.level.getRecipeManager().getRecipes().stream()
                .filter(r -> r.getType() == AlloyingRecipe.TYPE)
                .collect(Collectors.toList()),
            AlloyingRecipeCategory.ID
        );
    }

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addRecipeClickArea(AlloyingFurnaceScreen.class, 81, 26, 24, 17, AlloyingRecipeCategory.ID);
	}

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ItemsRegistry.ALLOYING_FURNACE.get()), AlloyingRecipeCategory.ID);
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ReworkedMetals.ID, "jei_plugin");
    }
}
