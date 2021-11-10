package hexagon.reworkedmetals.core.integration.jei;

import hexagon.reworkedmetals.common.crafting.ReworkedFurnaceRecipe;
import hexagon.reworkedmetals.core.ReworkedMetals;
import hexagon.reworkedmetals.core.registry.ReworkedMetalsItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.mojang.blaze3d.matrix.MatrixStack;
import mcp.MethodsReturnNonnullByDefault;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SmeltingRecipeCategory implements IRecipeCategory<ReworkedFurnaceRecipe> {
    
    public static final ResourceLocation ID = new ResourceLocation(ReworkedMetals.ID, "smelting");
    
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawable arrow;
    
    public SmeltingRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation texture = new ResourceLocation(ReworkedMetals.ID, "textures/gui/jei_gui.png");
        this.background = guiHelper.createDrawable(texture, 0, 0, 102, 57);
        this.icon = guiHelper.createDrawableIngredient(new ItemStack(ReworkedMetalsItems.FURNACE.get()));
        this.arrow = guiHelper.drawableBuilder(texture, 0, 102, 24, 17).buildAnimated(200, IDrawableAnimated.StartDirection.LEFT, false);
    }
    
    @Override
    public ResourceLocation getUid() {
        return ID;
    }
    
    @Override
    public Class<? extends ReworkedFurnaceRecipe> getRecipeClass() {
        return ReworkedFurnaceRecipe.class;
    }
    
    @Override
    public String getTitle() {
        return "reworkedmetals.jei_category";
    }
    
    @Override
    public IDrawable getBackground() {
        return this.background;
    }
    
    @Override
    public IDrawable getIcon() {
        return this.icon;
    }
    
    @Override
    public void setIngredients(ReworkedFurnaceRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getResultItem());
    }
    
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ReworkedFurnaceRecipe recipe, IIngredients ingredients) {
        IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
        List<ItemStack[]> ingredientItems = recipe.getIngredients().stream()
                .map(ingredient -> Arrays.stream(ingredient.getItems()).map(ItemStack::copy).toArray(ItemStack[]::new))
                .collect(Collectors.toList());
        groupLists(ingredientItems);
        itemStacks.init(0, false, 9, 0);
        itemStacks.set(0, getStations(recipe));
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                int item = i * 2 + j;
                if(item < ingredientItems.size()) {
                    itemStacks.init(1 + item, true, j * 18, i * 18 + 21);
                    itemStacks.set(1 + item, Arrays.asList(ingredientItems.get(item)));
                }
            }
        }
        itemStacks.init(5, false, 80, 30);
        itemStacks.set(5, recipe.getResultItem());
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
    
    private List<ItemStack> getStations(ReworkedFurnaceRecipe recipe) {
        return recipe.getStations().stream().map(string -> {
            switch(string) {
                case "smeltery": return new ItemStack(ReworkedMetalsItems.SMELTERY.get());
                case "furnace": return new ItemStack(ReworkedMetalsItems.FURNACE.get());
                case "blast_furnace": return new ItemStack(ReworkedMetalsItems.BLAST_FURNACE.get());
                case "kiln": return new ItemStack(ReworkedMetalsItems.KILN.get());
                default: return ItemStack.EMPTY;
            }
        }).collect(Collectors.toList());
    }
    
    @Override
    public void draw(ReworkedFurnaceRecipe recipe, MatrixStack stack, double mouseX, double mouseY) {
        this.arrow.draw(stack, 44, 32);
    }
}
