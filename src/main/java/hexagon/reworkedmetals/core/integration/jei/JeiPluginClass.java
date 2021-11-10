package hexagon.reworkedmetals.core.integration.jei;

import hexagon.reworkedmetals.common.crafting.ReworkedFurnaceRecipe;
import hexagon.reworkedmetals.core.ReworkedMetals;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.stream.Collectors;

import mcp.MethodsReturnNonnullByDefault;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

@JeiPlugin
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class JeiPluginClass implements IModPlugin {
    
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(
                Minecraft.getInstance().level.getRecipeManager().getRecipes().stream()
                        .filter(r -> r.getType() == ReworkedFurnaceRecipe.TYPE)
                        .collect(Collectors.toList()),
                SmeltingRecipeCategory.ID
        );
    }
    
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(ReworkedMetals.ID, "jei_plugin");
    }
}
