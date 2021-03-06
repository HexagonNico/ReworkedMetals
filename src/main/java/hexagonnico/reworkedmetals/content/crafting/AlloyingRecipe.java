package hexagonnico.reworkedmetals.content.crafting;

import hexagonnico.reworkedmetals.ReworkedMetals;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class AlloyingRecipe extends AbstractAlloyingRecipe {

	public static final RecipeType<AlloyingRecipe> TYPE = RecipeType.register(ReworkedMetals.ID + ":alloying");
	public static final Serializer SERIALIZER = new Serializer();

	public AlloyingRecipe(ResourceLocation id, JsonObject recipeJson) {
		super(id, recipeJson);
	}

	public AlloyingRecipe(ResourceLocation id, FriendlyByteBuf buffer) {
		super(id, buffer);
	}

	@Override
	public RecipeType<?> getType() {
		return TYPE;
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return SERIALIZER;
	}

	private static class Serializer extends AbstractAlloyingRecipe.Serializer {

		@Override
		public AbstractAlloyingRecipe fromJson(ResourceLocation id, JsonObject recipeJson) {
			return new AlloyingRecipe(id, recipeJson);
		}

		@Override
		public AbstractAlloyingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
			return new AlloyingRecipe(id, buffer);
		}
	}
}
