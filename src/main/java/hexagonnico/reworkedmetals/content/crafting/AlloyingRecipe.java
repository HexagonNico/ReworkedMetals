package hexagonnico.reworkedmetals.content.crafting;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.blockentity.AbstractAlloyingFurnaceBlockEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

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

/**
 * Recipe for the reworked furnace.
 * @author Nico
 */
public class AlloyingRecipe implements Recipe<AbstractAlloyingFurnaceBlockEntity> {

	public static final RecipeType<AlloyingRecipe> TYPE = RecipeType.register(ReworkedMetals.ID + ":smelting"); // TODO - Rename

	public static final Serializer SERIALIZER = new Serializer();

	private final ResourceLocation id;
	private final String group;
	private final NonNullList<Ingredient> ingredients;
	private final ItemStack output;
	private final float experience;
	private final int smeltingTime;
	private final NonNullList<String> stations;

	/**
	 * Create recipe from JSON object
	 * @param id ResourceLocation
	 * @param recipeJson JsonObject
	 */
	public AlloyingRecipe(ResourceLocation id, JsonObject recipeJson) {
		this.id = id;
		this.group = GsonHelper.getAsString(recipeJson, "group", "");
		this.ingredients = NonNullList.create();
		JsonArray ingredientsJson = GsonHelper.getAsJsonArray(recipeJson, "ingredients");
		for(int i = 0; i < ingredientsJson.size(); i++) {
			Ingredient ingredient = Ingredient.fromJson(ingredientsJson.get(i));
			if(!ingredient.isEmpty()) this.ingredients.add(ingredient);
		}
		this.output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(recipeJson, "result"), true);
		this.experience = GsonHelper.getAsFloat(recipeJson, "experience", 0.0f);
		this.smeltingTime = GsonHelper.getAsInt(recipeJson, "smelting_time", 200);
		this.stations = NonNullList.create();
		JsonArray stationsArray = GsonHelper.getAsJsonArray(recipeJson, "stations");
		for(int i = 0; i < stationsArray.size(); i++) {
			this.stations.add(stationsArray.get(i).getAsString());
		}
	}

	/**
	 * Create recipe from Network
	 * @param id ResourceLocation
	 * @param buffer PacketBuffer
	 */
	public AlloyingRecipe(ResourceLocation id, FriendlyByteBuf buffer) {
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
	public ItemStack assemble(AbstractAlloyingFurnaceBlockEntity recipeWrapper) {
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
	public boolean matches(AbstractAlloyingFurnaceBlockEntity recipeWrapper, Level world) {
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
						break;
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
	public RecipeType<?> getType() {
		return TYPE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}

	private static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<AlloyingRecipe> {

		@Override
		public AlloyingRecipe fromJson(ResourceLocation recipeId, JsonObject jsonObject) {
			return new AlloyingRecipe(recipeId, jsonObject);
		}

		@Override
		public AlloyingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
			return new AlloyingRecipe(recipeId, buffer);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buffer, AlloyingRecipe recipe) {
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
