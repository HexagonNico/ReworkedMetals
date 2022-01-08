package hexagonnico.reworkedmetals.content.item;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.registry.ItemsRegistry;

import java.util.List;

import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

/**
 * Tool tier class.
 * @author Nico
 */
public final class ModToolTiers {
	public static final Tag.Named<Block> COPPER_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_copper_tool"));
	public static final Tag.Named<Block> BRONZE_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_bronze_tool"));
	public static final Tag.Named<Block> IRON_DIAMOND_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_iron_diamond_tool"));
	public static final Tag.Named<Block> IRON_EMERALD_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_iron_emerald_tool"));
	public static final Tag.Named<Block> SILVER_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_silver_tool"));
	public static final Tag.Named<Block> SILVER_RUBY_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_silver_ruby_tool"));
	public static final Tag.Named<Block> SILVER_DIAMOND_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_silver_diamond_tool"));
	public static final Tag.Named<Block> STEEL_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_steel_tool"));
	public static final Tag.Named<Block> STEEL_DIAMOND_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_steel_diamond_tool"));
	public static final Tag.Named<Block> STEEL_EMERALD_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_steel_emerald_tool"));
	public static final Tag.Named<Block> GOLD_RUBY_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_gold_ruby_tool"));
	public static final Tag.Named<Block> END_METAL_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_end_metal_tool"));
	public static final Tag.Named<Block> END_GEM_METAL_TIER_TAG = BlockTags.createOptional(new ResourceLocation(ReworkedMetals.ID, "needs_end_gem_metal_tool"));
	
	public static final Tier COPPER; // (1, 190, 5.0f, 1.5f, 12) 
	public static final Tier BRONZE; // (2, 250, 6.0f, 2.0f, 15)
	public static final Tier IRON; // (2, 700, 7.0f, 2.5f, 12)
	public static final Tier IRON_DIAMOND; // (2, 1125, 5.0f, 2.5f, 12)
	public static final Tier IRON_EMERALD; // (2, 450, 8.5f, 2.5f, 16)
	public static final Tier SILVER; // (1, 100, 10.0f, 1.0f, 18)
	public static final Tier SILVER_RUBY; // (2, 250, 10.0f, 2.0f, 18)
	public static final Tier SILVER_DIAMOND; // (2, 300, 8.0f, 1.0f, 18)
	public static final Tier STEEL; // (3, 1561, 8.0f, 3.0f, 10)
	public static final Tier STEEL_DIAMOND; // (3, 1970, 6.0f, 3.0f, 10)
	public static final Tier STEEL_EMERALD; // (3, 1000, 9.5f, 3.0f, 14)
	public static final Tier GOLD_RUBY; // (1, 200, 12.0f, 2.0F, 22)
	public static final Tier END_METAL; // (4, 450, 8.0f, 3.0f, 17)
	public static final Tier END_GEM_METAL; // (4, 1970, 10.0f, 4.0f, 5)

	static {
		GOLD_RUBY = TierSortingRegistry.registerTier(
				new ForgeTier(1, 200, 12.0f, 2.0f, 22, GOLD_RUBY_TIER_TAG, () -> Ingredient.of(Items.GOLD_INGOT)),
				new ResourceLocation(ReworkedMetals.ID, "gold_ruby"),
				List.of(Tiers.STONE), List.of(Tiers.IRON)
		);
		SILVER = TierSortingRegistry.registerTier(
				new ForgeTier(1, 100, 10.0f, 1.0f, 18, SILVER_TIER_TAG, () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "silver"),
				List.of(Tiers.STONE), List.of(Tiers.IRON)
		);
		COPPER = TierSortingRegistry.registerTier(
				new ForgeTier(1, 190, 5.0f, 1.5f, 12, COPPER_TIER_TAG, () -> Ingredient.of(Items.COPPER_INGOT)),
				new ResourceLocation(ReworkedMetals.ID, "copper"),
				List.of(Tiers.STONE), List.of(Tiers.IRON)
		);
		SILVER_RUBY = TierSortingRegistry.registerTier(
				new ForgeTier(2, 250, 10.0f, 2.0f, 18, SILVER_RUBY_TIER_TAG, () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "silver_ruby"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		SILVER_DIAMOND = TierSortingRegistry.registerTier(
				new ForgeTier(2, 300, 8.0f, 1.0f, 18, SILVER_DIAMOND_TIER_TAG, () -> Ingredient.of(ItemsRegistry.SILVER_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "silver_diamond"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		BRONZE = TierSortingRegistry.registerTier(
				new ForgeTier(2, 250, 6.0f, 2.0f, 15, BRONZE_TIER_TAG, () -> Ingredient.of(ItemsRegistry.BRONZE_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "bronze"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		IRON = TierSortingRegistry.registerTier(
				new ForgeTier(2, 700, 7.0f, 2.5f, 12, BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT)),
				new ResourceLocation(ReworkedMetals.ID, "iron"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		IRON_EMERALD = TierSortingRegistry.registerTier(
				new ForgeTier(2, 450, 8.5f, 2.5f, 16, IRON_EMERALD_TIER_TAG, () -> Ingredient.of(Items.IRON_INGOT)),
				new ResourceLocation(ReworkedMetals.ID, "iron_emerald"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		IRON_DIAMOND = TierSortingRegistry.registerTier(
				new ForgeTier(2, 1125, 5.0f, 2.5f, 12, IRON_DIAMOND_TIER_TAG, () -> Ingredient.of(Items.IRON_INGOT)),
				new ResourceLocation(ReworkedMetals.ID, "iron_diamond"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
		);
		STEEL = TierSortingRegistry.registerTier(
				new ForgeTier(3, 1561, 8.0f, 3.0f, 10, STEEL_TIER_TAG, () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "steel"),
				List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE)
		);
		STEEL_EMERALD = TierSortingRegistry.registerTier(
				new ForgeTier(3, 1000, 9.5f, 3.0f, 14, STEEL_EMERALD_TIER_TAG, () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "steel_emerald"),
				List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE)
		);
		STEEL_DIAMOND = TierSortingRegistry.registerTier(
				new ForgeTier(3, 1970, 6.0f, 3.0f, 10, STEEL_DIAMOND_TIER_TAG, () -> Ingredient.of(ItemsRegistry.STEEL_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "steel_diamond"),
				List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE)
		);
		END_METAL = TierSortingRegistry.registerTier(
				new ForgeTier(4, 450, 8.0f, 3.0f, 17, END_METAL_TIER_TAG, () -> Ingredient.of(ItemsRegistry.END_METAL_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "end_metal"),
				List.of(Tiers.NETHERITE), List.of()
		);
		END_GEM_METAL = TierSortingRegistry.registerTier(
				new ForgeTier(4, 1970, 10.0f, 4.0f, 5, END_GEM_METAL_TIER_TAG, () -> Ingredient.of(ItemsRegistry.END_METAL_INGOT.get())),
				new ResourceLocation(ReworkedMetals.ID, "end_gem_metal"),
				List.of(Tiers.NETHERITE), List.of()
		);
	}
}
