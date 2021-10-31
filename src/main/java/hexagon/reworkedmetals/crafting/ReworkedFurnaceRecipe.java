package hexagon.reworkedmetals.crafting;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.blockentity.ReworkedFurnaceBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.MethodsReturnNonnullByDefault;
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
import net.minecraftforge.registries.ForgeRegistryEntry;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ReworkedFurnaceRecipe implements Recipe<ReworkedFurnaceBlockEntity> {
    
    public static final RecipeType<ReworkedFurnaceRecipe> TYPE = RecipeType.register(ReworkedMetals.ID + ":smelting");
    
    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final String group;
    private final NonNullList<ItemStack> itemsIngredients;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;
    private final float experience;
    private final int smeltingTime;
    private final int tier;
    
    public ReworkedFurnaceRecipe(ResourceLocation id, JsonObject recipeJson) {
        this.id = id;
        this.group = GsonHelper.getAsString(recipeJson, "group", "");
        this.ingredients = NonNullList.create();
        this.itemsIngredients = NonNullList.create();
        JsonArray ingredientsJson = GsonHelper.getAsJsonArray(recipeJson, "ingredients");
        for(int i = 0; i < ingredientsJson.size(); i++) {
            Ingredient ingredient = Ingredient.fromJson(ingredientsJson.get(i));
            ItemStack itemStack = CraftingHelper.getItemStack(ingredientsJson.get(i).getAsJsonObject(), true);
            if(!ingredient.isEmpty()) this.ingredients.add(ingredient);
            if(!itemStack.isEmpty()) this.itemsIngredients.add(itemStack);
        }
        this.output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(recipeJson, "result"), true);
        this.experience = GsonHelper.getAsFloat(recipeJson, "experience", 0.0f);
        this.smeltingTime = GsonHelper.getAsInt(recipeJson, "smelting_time", 200);
        this.tier = GsonHelper.getAsInt(recipeJson, "tier", 0);
    }
    
    public ReworkedFurnaceRecipe(ResourceLocation id, FriendlyByteBuf buffer) {
        this.id = id;
        this.group = buffer.readUtf(32767);
        int i = buffer.readVarInt();
        this.ingredients = NonNullList.withSize(i, Ingredient.EMPTY);
        this.itemsIngredients = NonNullList.withSize(i, ItemStack.EMPTY);
        for(int j = 0; j < this.ingredients.size(); ++j) {
            this.ingredients.set(j, Ingredient.fromNetwork(buffer));
        }
        for(int j = 0; j < this.itemsIngredients.size(); j++) {
            this.itemsIngredients.set(j, buffer.readItem());
        }
        this.output = buffer.readItem();
        this.experience = buffer.readFloat();
        this.smeltingTime = buffer.readVarInt();
        this.tier = buffer.readVarInt();
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
    
    public NonNullList<ItemStack> getItemsIngredients() {
        return itemsIngredients;
    }
    
    @Override
    public ItemStack getResultItem() {
        return this.output;
    }
    
    @Override
    public ItemStack assemble(ReworkedFurnaceBlockEntity recipeWrapper) {
        return this.output.copy();
    }
    
    public float getExperience() {
        return this.experience;
    }
    
    public int getSmeltingTime() {
        return this.smeltingTime;
    }
    
    public int getTier() {
        return this.tier;
    }
    
    @Override
    public boolean matches(ReworkedFurnaceBlockEntity recipeWrapper, Level level) {
        List<ItemStack> inputItems = IntStream.range(0, 4)
                .mapToObj(recipeWrapper::getItem)
                .filter(itemStack -> !itemStack.isEmpty())
                .collect(Collectors.groupingBy(ItemStack::getItem, Collectors.summingInt(ItemStack::getCount)))
                .entrySet().stream()
                .map(pair -> new ItemStack(pair.getKey(), pair.getValue()))
                .collect(Collectors.toList());
        if(inputItems.isEmpty()) {
            return false;
        } else {
            for(ItemStack ingredient : this.itemsIngredients) {
                if(!inputItems.removeIf(inputItem -> inputItem.sameItem(ingredient) && inputItem.getCount() >= ingredient.getCount()))
                    return false;
            }
            return inputItems.isEmpty();
        }
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
    
    private static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<ReworkedFurnaceRecipe> {
    
        @Override
        public ReworkedFurnaceRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
            return new ReworkedFurnaceRecipe(recipeId, jsonObject);
        }
    
        @Nullable
        @Override
        public ReworkedFurnaceRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            return new ReworkedFurnaceRecipe(recipeId, buffer);
        }
    
        @Override
        public void toNetwork(FriendlyByteBuf buffer, ReworkedFurnaceRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.ingredients.size());
            for(Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buffer);
            }
            for(ItemStack itemStack : recipe.itemsIngredients) {
                buffer.writeItem(itemStack);
            }
            buffer.writeItem(recipe.output);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.smeltingTime);
            buffer.writeVarInt(recipe.tier);
        }
    }
}
