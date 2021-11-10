package hexagon.reworkedmetals.common.crafting;

import hexagon.reworkedmetals.common.blockentity.ReworkedFurnaceBlockEntity;
import hexagon.reworkedmetals.core.ReworkedMetals;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ReworkedFurnaceRecipe implements IRecipe<ReworkedFurnaceBlockEntity> {
    
    public static final IRecipeType<ReworkedFurnaceRecipe> TYPE = IRecipeType.register(ReworkedMetals.ID + ":smelting");
    
    public static final Serializer SERIALIZER = new Serializer();
    
    private final ResourceLocation id;
    private final String group;
    private final NonNullList<Ingredient> ingredients;
    private final ItemStack output;
    private final float experience;
    private final int smeltingTime;
    private final NonNullList<String> stations;
    
    public ReworkedFurnaceRecipe(ResourceLocation id, JsonObject recipeJson) {
        this.id = id;
        this.group = JSONUtils.getAsString(recipeJson, "group", "");
        this.ingredients = NonNullList.create();
        JsonArray ingredientsJson = JSONUtils.getAsJsonArray(recipeJson, "ingredients");
        for(int i = 0; i < ingredientsJson.size(); i++) {
            Ingredient ingredient = Ingredient.fromJson(ingredientsJson.get(i));
            if(!ingredient.isEmpty()) this.ingredients.add(ingredient);
        }
        this.output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(recipeJson, "result"), true);
        this.experience = JSONUtils.getAsFloat(recipeJson, "experience", 0.0f);
        this.smeltingTime = JSONUtils.getAsInt(recipeJson, "smelting_time", 200);
        this.stations = NonNullList.create();
        JsonArray stationsArray = JSONUtils.getAsJsonArray(recipeJson, "stations");
        for(int i = 0; i < stationsArray.size(); i++) {
            this.stations.add(stationsArray.get(i).getAsString());
        }
    }
    
    public ReworkedFurnaceRecipe(ResourceLocation id, PacketBuffer buffer) {
        this.id = id;
        this.group = buffer.readUtf(32767);
        int i = buffer.readVarInt();
        this.ingredients = NonNullList.withSize(i, Ingredient.EMPTY);
        for(int j = 0; j < this.ingredients.size(); ++j) {
            this.ingredients.set(j, Ingredient.fromNetwork(buffer));
        }
        this.output = buffer.readItem();
        this.experience = buffer.readFloat();
        this.smeltingTime = buffer.readVarInt();
        i = buffer.readVarInt();
        this.stations = NonNullList.withSize(i, "");
        for(int j = 0; j < this.stations.size(); j++) {
            this.stations.set(j, buffer.readUtf());
        }
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
    public ItemStack assemble(ReworkedFurnaceBlockEntity recipeWrapper) {
        return this.output.copy();
    }
    
    public float getExperience() {
        return this.experience;
    }
    
    public int getSmeltingTime() {
        return this.smeltingTime;
    }
    
    public NonNullList<String> getStations() {
        return this.stations;
    }
    
    @Override
    public boolean matches(ReworkedFurnaceBlockEntity recipeWrapper, World world) {
        List<ItemStack> inputItems = IntStream.range(0, 4)
                .mapToObj(i -> recipeWrapper.getItem(i).copy())
                .filter(itemStack -> !itemStack.isEmpty())
                .collect(Collectors.groupingBy(ItemStack::getItem, Collectors.summingInt(ItemStack::getCount)))
                .entrySet().stream()
                .map(pair -> new ItemStack(pair.getKey(), pair.getValue()))
                .collect(Collectors.toList());
        if(inputItems.isEmpty()) {
            return false;
        } else {
            ArrayList<Ingredient> ingredients = new ArrayList<>(this.ingredients);
            Iterator<Ingredient> ingredientIterator = ingredients.iterator();
            while(ingredientIterator.hasNext()) {
                Ingredient ingredient = ingredientIterator.next();
                for(ItemStack input : inputItems) {
                    if(!input.isEmpty() && ingredient.test(input)) {
                        input.shrink(1);
                        ingredientIterator.remove();
                    }
                }
            }
            if(!ingredients.isEmpty()) {
                return false;
            } else {
                for(ItemStack input : inputItems) {
                    if(!input.isEmpty() && this.ingredients.stream().noneMatch(ingredient -> ingredient.test(input)))
                        return false;
                }
                return true;
            }
        }
    }
    
    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }
    
    @Override
    public IRecipeType<?> getType() {
        return TYPE;
    }
    
    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }
    
    private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ReworkedFurnaceRecipe> {
    
        @Override
        public ReworkedFurnaceRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
            return new ReworkedFurnaceRecipe(recipeId, jsonObject);
        }
    
        @Nullable
        @Override
        public ReworkedFurnaceRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
            return new ReworkedFurnaceRecipe(recipeId, buffer);
        }
    
        @Override
        public void toNetwork(PacketBuffer buffer, ReworkedFurnaceRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeVarInt(recipe.ingredients.size());
            for(Ingredient ingredient : recipe.ingredients) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
            buffer.writeFloat(recipe.experience);
            buffer.writeVarInt(recipe.smeltingTime);
            buffer.writeVarInt(recipe.stations.size());
            for(String string : recipe.stations) {
                buffer.writeUtf(string);
            }
        }
    }
}
