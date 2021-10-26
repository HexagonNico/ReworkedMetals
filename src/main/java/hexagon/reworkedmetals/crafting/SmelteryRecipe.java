package hexagon.reworkedmetals.crafting;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.blockentity.SmelteryBlockEntity;

import javax.annotation.Nullable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.util.RecipeMatcher;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SmelteryRecipe implements Recipe<SmelteryBlockEntity> {
    
    public static final RecipeType<SmelteryRecipe> TYPE = RecipeType.register(ReworkedMetals.ID + ":smeltery");
    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final String group;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;
    private final float experience;
    private int smeltingTime;
    
    public SmelteryRecipe(ResourceLocation id, String group, NonNullList<Ingredient> ingredients, ItemStack output, float experience, int smeltingTime) {
        this.id = id;
        this.group = group;
        this.ingredients = ingredients;
        this.output = output;
        this.experience = experience;
        this.smeltingTime = smeltingTime;
    }
    
    @Override
    public ResourceLocation getId() {
        return this.id;
    }
    
    @Override
    public String getGroup() {
        return this.group;
    }
    
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }
    
    @Override
    public ItemStack getResultItem() {
        return this.output;
    }
    
    @Override
    public ItemStack assemble(SmelteryBlockEntity recipeWrapper) {
        return this.output.copy();
    }
    
    public float getExperience() {
        return this.experience;
    }
    
    public int getSmeltingTime() {
        return this.smeltingTime;
    }
    
    @Override
    public boolean matches(SmelteryBlockEntity recipeWrapper, Level level) {
        List<ItemStack> inputs = IntStream.range(0, 4)
                .mapToObj(recipeWrapper::getItem)
                .filter(itemStack -> !itemStack.isEmpty())
                .collect(Collectors.toList());
        return inputs.size() == this.ingredients.size() && RecipeMatcher.findMatches(inputs, this.ingredients) != null;
    }
    
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }
    
    @Override
    public RecipeType<?> getType() {
        return TYPE;
    }
    
    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }
    
    private static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<SmelteryRecipe> {
    
        @Override
        public SmelteryRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
            String group = GsonHelper.getAsString(jsonObject, "group", "");
            NonNullList<Ingredient> inputItems = NonNullList.create();
            JsonArray ingredients = GsonHelper.getAsJsonArray(jsonObject, "ingredients");
            for(int i = 0; i < ingredients.size(); i++) {
                Ingredient ingredient = Ingredient.fromJson(ingredients.get(i));
                if(!ingredient.isEmpty()) inputItems.add(ingredient);
            }
            if (inputItems.isEmpty()) {
                throw new JsonParseException("No ingredients for cooking recipe");
            } else if (inputItems.size() > 4) {
                throw new JsonParseException("Too many ingredients for cooking recipe! The max is 4");
            } else {
                ItemStack output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(jsonObject, "result"), true);
                float experience = GsonHelper.getAsFloat(jsonObject, "experience", 0.0F);
                int cookTime = GsonHelper.getAsInt(jsonObject, "cookingtime", 200);
                return new SmelteryRecipe(recipeId, group, inputItems, output, experience, cookTime);
            }
        }
    
        @Nullable
        @Override
        public SmelteryRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            String groupIn = buffer.readUtf(32767);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> inputItemsIn = NonNullList.withSize(i, Ingredient.EMPTY);
            for(int j = 0; j < inputItemsIn.size(); ++j) {
                inputItemsIn.set(j, Ingredient.fromNetwork(buffer));
            }
            ItemStack outputIn = buffer.readItem();
            float experienceIn = buffer.readFloat();
            int cookTimeIn = buffer.readVarInt();
            return new SmelteryRecipe(recipeId, groupIn, inputItemsIn, outputIn, experienceIn, cookTimeIn);
        }
    
        @Override
        public void toNetwork(FriendlyByteBuf buffer, SmelteryRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.ingredients.size());
            for (Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.smeltingTime);
        }
    }
}
