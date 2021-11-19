package hexagonnico.reworkedmetals.integration.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.ReworkedSmeltingRecipe;
import hexagonnico.reworkedmetals.content.gui.ReworkedFurnaceGui;

import java.util.stream.Collectors;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

@JeiPlugin
public class JeiPluginClass implements IModPlugin {

    private static final Minecraft MINECRAFT = Minecraft.getInstance();

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
            MINECRAFT.level.getRecipeManager().getRecipes().stream()
                .filter(r -> r.getType() == ReworkedSmeltingRecipe.TYPE)
                .collect(Collectors.toList()),
            SmeltingRecipeCategory.ID
        );
    }

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
		registration.addRecipeClickArea(ReworkedFurnaceGui.class, 81, 26, 24, 17, SmeltingRecipeCategory.ID);
	}

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ReworkedMetals.ID, "jei_plugin");
    }
}
