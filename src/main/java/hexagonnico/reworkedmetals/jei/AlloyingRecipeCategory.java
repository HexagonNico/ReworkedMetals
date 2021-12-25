package hexagonnico.reworkedmetals.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.AlloyingRecipe;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;

public class AlloyingRecipeCategory extends AbstractAlloyingRecipeCategory<AlloyingRecipe> {

    public static final ResourceLocation ID = new ResourceLocation(ReworkedMetals.ID, "alloying");
    
    private IDrawable icon;

    public AlloyingRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ItemsRegistry.ALLOYING_FURNACE.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return ID;
    }

    @Override
    public Class<? extends AlloyingRecipe> getRecipeClass() {
        return AlloyingRecipe.class;
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("gui.reworkedmetals.jei_alloying");
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }
}
