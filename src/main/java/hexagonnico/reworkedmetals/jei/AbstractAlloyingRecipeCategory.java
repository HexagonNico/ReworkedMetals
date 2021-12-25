package hexagonnico.reworkedmetals.jei;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.crafting.AbstractAlloyingRecipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;

public abstract class AbstractAlloyingRecipeCategory<T extends AbstractAlloyingRecipe> implements IRecipeCategory<T> {

	private final IDrawable background;
	private final IDrawableAnimated arrow;
	private final IDrawableAnimated fire;

	public AbstractAlloyingRecipeCategory(IGuiHelper guiHelper) {
		ResourceLocation texture = new ResourceLocation(ReworkedMetals.ID, "textures/gui/furnace.png");
		this.background = guiHelper.createDrawable(texture, 36, 15, 104, 54);
		this.arrow = guiHelper.drawableBuilder(texture, 176, 14, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
		this.fire = guiHelper.drawableBuilder(texture, 176, 0, 14, 14).buildAnimated(300, IDrawableAnimated.StartDirection.TOP, true);
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public void setIngredients(T recipe, IIngredients ingredients) {
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());        
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, T recipe, IIngredients ingredients) {
		IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
		List<ItemStack[]> ingredientItems = recipe.getIngredients().stream()
				.map(ingredient -> Arrays.stream(ingredient.getItems()).map(ItemStack::copy).toArray(ItemStack[]::new))
				.collect(Collectors.toList());
		groupLists(ingredientItems);
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				int item = i * 2 + j;
				if(item < ingredientItems.size()) {
					itemStacks.init(item, true, j * 18 + 1, i * 18 + 1);
					itemStacks.set(item, Arrays.asList(ingredientItems.get(item)));
				}
			}
		}
		itemStacks.init(4, false, 81, 10);
		itemStacks.set(4, recipe.getResultItem());
	}

	private void groupLists(List<ItemStack[]> lists) {
		List<Integer> toRemove = new ArrayList<>();
		List<Integer> toGrow = new ArrayList<>();
		for(int i = 0; i < lists.size() - 1; i++) {
			for(int j = i + 1; j < lists.size(); j++) {
				ItemStack[] iList = lists.get(i);
				ItemStack[] jList = lists.get(j);
				if(iList.length == jList.length && IntStream.range(0, iList.length).allMatch(k -> iList[k].sameItem(jList[k]))) {
					toGrow.add(i);
					toRemove.add(j);
				}
			}
		}
		Iterator<ItemStack[]> iterator = lists.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			ItemStack[] list = iterator.next();
			if(toRemove.contains(i)) iterator.remove();
			if(toGrow.contains(i)) {
				int finalI = i;
				Arrays.stream(list).forEach(item -> item.grow(Collections.frequency(toGrow, finalI)));
			}
			i++;
		}
	}

	@Override
	public void draw(AbstractAlloyingRecipe recipe, PoseStack stack, double mouseX, double mouseY) {
		this.arrow.draw(stack, 45, 11);
		this.fire.draw(stack, 12, 40);
	}
}
