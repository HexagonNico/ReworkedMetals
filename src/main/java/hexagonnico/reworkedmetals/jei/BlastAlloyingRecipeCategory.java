package hexagonnico.reworkedmetals.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.BlastAlloyingRecipe;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;

public class BlastAlloyingRecipeCategory extends AbstractAlloyingRecipeCategory<BlastAlloyingRecipe> {
	
	public static final ResourceLocation ID = new ResourceLocation(ReworkedMetals.ID, "blast_alloying");

	private IDrawable icon;

	public BlastAlloyingRecipeCategory(IGuiHelper guiHelper) {
		super(guiHelper);
		this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ItemsRegistry.ALLOYING_BLAST_FURNACE.get()));
	}

	@Override
	public ResourceLocation getUid() {
		return ID;
	}

	@Override
	public Class<? extends BlastAlloyingRecipe> getRecipeClass() {
		return BlastAlloyingRecipe.class;
	}

	@Override
	public Component getTitle() {
		return new TranslatableComponent("gui.reworkedmetals.jei_blast_alloying");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}
}
