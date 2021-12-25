package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.item.ModArmorItem;
import hexagonnico.reworkedmetals.content.item.ModArmorMaterials;
import hexagonnico.reworkedmetals.content.item.ModToolTiers;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

/**
 * Items registry.
 * Contains all items and block-items in ReworkedMetals.
 * @author Nico
 */
public class ItemsRegistry {

	// Deferred register
	public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkedMetals.ID);
	public static final DeferredRegister<Item> OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

	// Raw metals
	public static final RegistryObject<Item> RAW_TIN = REGISTER.register("raw_tin", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_ALUMINUM = REGISTER.register("raw_aluminum", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_SILVER = REGISTER.register("raw_silver", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_NICKEL = REGISTER.register("raw_nickel", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> RAW_END_METAL = REGISTER.register("raw_end_metal", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	// Ingots
	public static final RegistryObject<Item> TIN_INGOT = REGISTER.register("tin_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> BRONZE_INGOT = REGISTER.register("bronze_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> ALUMINUM_INGOT = REGISTER.register("aluminum_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> SILVER_INGOT = REGISTER.register("silver_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> NICKEL_INGOT = REGISTER.register("nickel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> INVAR_INGOT = REGISTER.register("invar_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> STEEL_INGOT = REGISTER.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> END_METAL_INGOT = REGISTER.register("end_metal_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	// Gems
	public static final RegistryObject<Item> RUBY = REGISTER.register("ruby", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
	public static final RegistryObject<Item> END_GEM = REGISTER.register("end_gem", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

	// Copper tools
	public static final RegistryObject<Item> COPPER_PICKAXE = REGISTER.register("copper_pickaxe", () -> new PickaxeItem(ModToolTiers.COPPER, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> COPPER_SWORD = REGISTER.register("copper_sword", () -> new SwordItem(ModToolTiers.COPPER, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> COPPER_AXE = REGISTER.register("copper_axe", () -> new AxeItem(ModToolTiers.COPPER, 6.5f, -3.15f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> COPPER_SHOVEL = REGISTER.register("copper_shovel", () -> new ShovelItem(ModToolTiers.COPPER, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> COPPER_HOE = REGISTER.register("copper_hoe", () -> new HoeItem(ModToolTiers.COPPER, -1, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Bronze tools
	public static final RegistryObject<Item> BRONZE_PICKAXE = REGISTER.register("bronze_pickaxe", () -> new PickaxeItem(ModToolTiers.BRONZE, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> BRONZE_SWORD = REGISTER.register("bronze_sword", () -> new SwordItem(ModToolTiers.BRONZE, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> BRONZE_AXE = REGISTER.register("bronze_axe", () -> new AxeItem(ModToolTiers.BRONZE, 6.0f, -3.1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> BRONZE_SHOVEL = REGISTER.register("bronze_shovel", () -> new ShovelItem(ModToolTiers.BRONZE, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> BRONZE_HOE = REGISTER.register("bronze_hoe", () -> new HoeItem(ModToolTiers.BRONZE, -2, -1.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Iron tools
	public static final RegistryObject<Item> IRON_PICKAXE = OVERRIDES.register("iron_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_SWORD = OVERRIDES.register("iron_sword", () -> new SwordItem(ModToolTiers.IRON, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_AXE = OVERRIDES.register("iron_axe", () -> new AxeItem(ModToolTiers.IRON, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_SHOVEL = OVERRIDES.register("iron_shovel", () -> new ShovelItem(ModToolTiers.IRON, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_HOE = OVERRIDES.register("iron_hoe", () -> new HoeItem(ModToolTiers.IRON, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Iron + Diamond tools
	public static final RegistryObject<Item> IRON_DIAMOND_PICKAXE = REGISTER.register("iron_diamond_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON_DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_DIAMOND_SWORD = REGISTER.register("iron_diamond_sword", () -> new SwordItem(ModToolTiers.IRON_DIAMOND, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_DIAMOND_AXE = REGISTER.register("iron_diamond_axe", () -> new AxeItem(ModToolTiers.IRON_DIAMOND, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_DIAMOND_SHOVEL = REGISTER.register("iron_diamond_shovel", () -> new ShovelItem(ModToolTiers.IRON_DIAMOND, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_DIAMOND_HOE = REGISTER.register("iron_diamond_hoe", () -> new HoeItem(ModToolTiers.IRON_DIAMOND, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Iron + Emerald tools
	public static final RegistryObject<Item> IRON_EMERALD_PICKAXE = REGISTER.register("iron_emerald_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON_EMERALD, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_EMERALD_SWORD = REGISTER.register("iron_emerald_sword", () -> new SwordItem(ModToolTiers.IRON_EMERALD, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_EMERALD_AXE = REGISTER.register("iron_emerald_axe", () -> new AxeItem(ModToolTiers.IRON_EMERALD, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_EMERALD_SHOVEL = REGISTER.register("iron_emerald_shovel", () -> new ShovelItem(ModToolTiers.IRON_EMERALD, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> IRON_EMERALD_HOE = REGISTER.register("iron_emerald_hoe", () -> new HoeItem(ModToolTiers.IRON_EMERALD, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Silver tools
	public static final RegistryObject<Item> SILVER_PICKAXE = REGISTER.register("silver_pickaxe", () -> new PickaxeItem(ModToolTiers.SILVER, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_SWORD = REGISTER.register("silver_sword", () -> new SwordItem(ModToolTiers.SILVER, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> SILVER_AXE = REGISTER.register("silver_axe", () -> new AxeItem(ModToolTiers.SILVER, 7.0f, -3.2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_SHOVEL = REGISTER.register("silver_shovel", () -> new ShovelItem(ModToolTiers.SILVER, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_HOE = REGISTER.register("silver_hoe", () -> new HoeItem(ModToolTiers.SILVER, -0, -2.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Silver + Ruby tools
	public static final RegistryObject<Item> SILVER_RUBY_PICKAXE = REGISTER.register("silver_ruby_pickaxe", () -> new PickaxeItem(ModToolTiers.SILVER_RUBY, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_RUBY_SWORD = REGISTER.register("silver_ruby_sword", () -> new SwordItem(ModToolTiers.SILVER_RUBY, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> SILVER_RUBY_AXE = REGISTER.register("silver_ruby_axe", () -> new AxeItem(ModToolTiers.SILVER_RUBY, 5.0f, -3.1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_RUBY_SHOVEL = REGISTER.register("silver_ruby_shovel", () -> new ShovelItem(ModToolTiers.SILVER_RUBY, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_RUBY_HOE = REGISTER.register("silver_ruby_hoe", () -> new HoeItem(ModToolTiers.SILVER_RUBY, -2, -2.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Silver + Diamond tools
	public static final RegistryObject<Item> SILVER_DIAMOND_PICKAXE = REGISTER.register("silver_diamond_pickaxe", () -> new PickaxeItem(ModToolTiers.SILVER_DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_DIAMOND_SWORD = REGISTER.register("silver_diamond_sword", () -> new SwordItem(ModToolTiers.SILVER_DIAMOND, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> SILVER_DIAMOND_AXE = REGISTER.register("silver_diamond_axe", () -> new AxeItem(ModToolTiers.SILVER_DIAMOND, 7.0f, -3.2f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_DIAMOND_SHOVEL = REGISTER.register("silver_diamond_shovel", () -> new ShovelItem(ModToolTiers.SILVER_DIAMOND, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> SILVER_DIAMOND_HOE = REGISTER.register("silver_diamond_hoe", () -> new HoeItem(ModToolTiers.SILVER_DIAMOND, -0, -2.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Steel tools
	public static final RegistryObject<Item> STEEL_PICKAXE = REGISTER.register("steel_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_SWORD = REGISTER.register("steel_sword", () -> new SwordItem(ModToolTiers.STEEL, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_AXE = REGISTER.register("steel_axe", () -> new AxeItem(ModToolTiers.STEEL, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_SHOVEL = REGISTER.register("steel_shovel", () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_HOE = REGISTER.register("steel_hoe", () -> new HoeItem(ModToolTiers.STEEL, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Steel + Diamond tools
	public static final RegistryObject<Item> STEEL_DIAMOND_PICKAXE = REGISTER.register("steel_diamond_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL_DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_DIAMOND_SWORD = REGISTER.register("steel_diamond_sword", () -> new SwordItem(ModToolTiers.STEEL_DIAMOND, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_DIAMOND_AXE = REGISTER.register("steel_diamond_axe", () -> new AxeItem(ModToolTiers.STEEL_DIAMOND, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_DIAMOND_SHOVEL = REGISTER.register("steel_diamond_shovel", () -> new ShovelItem(ModToolTiers.STEEL_DIAMOND, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_DIAMOND_HOE = REGISTER.register("steel_diamond_hoe", () -> new HoeItem(ModToolTiers.STEEL_DIAMOND, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Steel + Emerald tools
	public static final RegistryObject<Item> STEEL_EMERALD_PICKAXE = REGISTER.register("steel_emerald_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL_EMERALD, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_EMERALD_SWORD = REGISTER.register("steel_emerald_sword", () -> new SwordItem(ModToolTiers.STEEL_EMERALD, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_EMERALD_AXE = REGISTER.register("steel_emerald_axe", () -> new AxeItem(ModToolTiers.STEEL_EMERALD, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_EMERALD_SHOVEL = REGISTER.register("steel_emerald_shovel", () -> new ShovelItem(ModToolTiers.STEEL_EMERALD, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> STEEL_EMERALD_HOE = REGISTER.register("steel_emerald_hoe", () -> new HoeItem(ModToolTiers.STEEL_EMERALD, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Gold + Ruby tools
	public static final RegistryObject<Item> GOLD_RUBY_PICKAXE = REGISTER.register("gold_ruby_pickaxe", () -> new PickaxeItem(ModToolTiers.GOLD_RUBY, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> GOLD_RUBY_SWORD = REGISTER.register("gold_ruby_sword", () -> new SwordItem(ModToolTiers.GOLD_RUBY, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> GOLD_RUBY_AXE = REGISTER.register("gold_ruby_axe", () -> new AxeItem(ModToolTiers.GOLD_RUBY, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> GOLD_RUBY_SHOVEL = REGISTER.register("gold_ruby_shovel", () -> new ShovelItem(ModToolTiers.GOLD_RUBY, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> GOLD_RUBY_HOE = REGISTER.register("gold_ruby_hoe", () -> new HoeItem(ModToolTiers.GOLD_RUBY, -2, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// End metal tools
	public static final RegistryObject<Item> END_METAL_PICKAXE = REGISTER.register("end_metal_pickaxe", () -> new PickaxeItem(ModToolTiers.END_METAL, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_METAL_SWORD = REGISTER.register("end_metal_sword", () -> new SwordItem(ModToolTiers.END_METAL, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> END_METAL_AXE = REGISTER.register("end_metal_axe", () -> new AxeItem(ModToolTiers.END_METAL, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_METAL_SHOVEL = REGISTER.register("end_metal_shovel", () -> new ShovelItem(ModToolTiers.END_METAL, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_METAL_HOE = REGISTER.register("end_metal_hoe", () -> new HoeItem(ModToolTiers.END_METAL, -4, 0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	
	// End metal + gem tools
	public static final RegistryObject<Item> END_GEM_PICKAXE = REGISTER.register("end_gem_pickaxe", () -> new PickaxeItem(ModToolTiers.END_GEM_METAL, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_GEM_SWORD = REGISTER.register("end_gem_sword", () -> new SwordItem(ModToolTiers.END_GEM_METAL, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> END_GEM_AXE = REGISTER.register("end_gem_axe", () -> new AxeItem(ModToolTiers.END_GEM_METAL, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_GEM_SHOVEL = REGISTER.register("end_gem_shovel", () -> new ShovelItem(ModToolTiers.END_GEM_METAL, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
	public static final RegistryObject<Item> END_GEM_HOE = REGISTER.register("end_gem_hoe", () -> new HoeItem(ModToolTiers.END_GEM_METAL, -5, 0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

	// Copper armor
	public static final RegistryObject<Item> COPPER_HELMET = REGISTER.register("copper_helmet", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> COPPER_CHESTPLATE = REGISTER.register("copper_chestplate", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> COPPER_LEGGINGS = REGISTER.register("copper_leggings", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> COPPER_BOOTS = REGISTER.register("copper_boots", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	// Bronze armor
	public static final RegistryObject<Item> BRONZE_HELMET = REGISTER.register("bronze_helmet", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> BRONZE_CHESTPLATE = REGISTER.register("bronze_chestplate", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> BRONZE_LEGGINGS = REGISTER.register("bronze_leggings", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> BRONZE_BOOTS = REGISTER.register("bronze_boots", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	// Iron armor
	public static final RegistryObject<Item> IRON_HELMET = OVERRIDES.register("iron_helmet", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_CHESTPLATE = OVERRIDES.register("iron_chestplate", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_LEGGINGS = OVERRIDES.register("iron_leggings", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> IRON_BOOTS = OVERRIDES.register("iron_boots", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	// Steel armor
	public static final RegistryObject<Item> STEEL_HELMET = REGISTER.register("steel_helmet", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_CHESTPLATE = REGISTER.register("steel_chestplate", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_LEGGINGS = REGISTER.register("steel_leggings", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
	public static final RegistryObject<Item> STEEL_BOOTS = REGISTER.register("steel_boots", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

	// Gilded netherite armor
	public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = REGISTER.register("gilded_netherite_helmet", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = REGISTER.register("gilded_netherite_chestplate", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = REGISTER.register("gilded_netherite_leggings", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = REGISTER.register("gilded_netherite_boots", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	// Diamonded netherite armor
	public static final RegistryObject<Item> DIAMONDED_NETHERITE_HELMET = REGISTER.register("diamonded_netherite_helmet", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> DIAMONDED_NETHERITE_CHESTPLATE = REGISTER.register("diamonded_netherite_chestplate", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> DIAMONDED_NETHERITE_LEGGINGS = REGISTER.register("diamonded_netherite_leggings", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
	public static final RegistryObject<Item> DIAMONDED_NETHERITE_BOOTS = REGISTER.register("diamonded_netherite_boots", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

	// Furnaces block items
	public static final RegistryObject<Item> ALLOYING_FURNACE = REGISTER.register("alloying_furnace", () -> new BlockItem(BlocksRegistry.ALLOYING_FURNACE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
	public static final RegistryObject<Item> ALLOYING_BLAST_FURNACE = REGISTER.register("alloying_blast_furnace", () -> new BlockItem(BlocksRegistry.ALLOYING_BLAST_FURNACE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

	// Ores block items
	public static final RegistryObject<Item> TIN_ORE = REGISTER.register("tin_ore", () -> new BlockItem(BlocksRegistry.TIN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ALUMINUM_ORE = REGISTER.register("aluminum_ore", () -> new BlockItem(BlocksRegistry.ALUMINUM_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SILVER_ORE = REGISTER.register("silver_ore", () -> new BlockItem(BlocksRegistry.SILVER_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NICKEL_ORE = REGISTER.register("nickel_ore", () -> new BlockItem(BlocksRegistry.NICKEL_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RUBY_ORE = REGISTER.register("ruby_ore", () -> new BlockItem(BlocksRegistry.RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	// Deepslate ores block items
	public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = REGISTER.register("deepslate_tin_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_TIN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_ALUMINUM_ORE = REGISTER.register("deepslate_aluminum_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_SILVER_ORE = REGISTER.register("deepslate_silver_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_SILVER_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_NICKEL_ORE = REGISTER.register("deepslate_nickel_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_NICKEL_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> DEEPSLATE_RUBY_ORE = REGISTER.register("deepslate_ruby_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_RUBY_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	// End ores
	public static final RegistryObject<Item> END_METAL_ORE = REGISTER.register("end_metal_ore", () -> new BlockItem(BlocksRegistry.END_METAL_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> END_GEM_ORE = REGISTER.register("end_gem_ore", () -> new BlockItem(BlocksRegistry.END_GEM_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	// Raw metals block items
	public static final RegistryObject<Item> RAW_TIN_BLOCK = REGISTER.register("raw_tin_block", () -> new BlockItem(BlocksRegistry.RAW_TIN_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RAW_ALUMINUM_BLOCK = REGISTER.register("raw_aluminum_block", () -> new BlockItem(BlocksRegistry.RAW_ALUMINUM_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RAW_SILVER_BLOCK = REGISTER.register("raw_silver_block", () -> new BlockItem(BlocksRegistry.RAW_SILVER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RAW_NICKEL_BLOCK = REGISTER.register("raw_nickel_block", () -> new BlockItem(BlocksRegistry.RAW_NICKEL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RAW_END_METAL_BLOCK = REGISTER.register("raw_end_metal_block", () -> new BlockItem(BlocksRegistry.RAW_END_METAL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));

	// Metal block items
	public static final RegistryObject<Item> TIN_BLOCK = REGISTER.register("tin_block", () -> new BlockItem(BlocksRegistry.TIN_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> ALUMINUM_BLOCK = REGISTER.register("aluminum_block", () -> new BlockItem(BlocksRegistry.ALUMINUM_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> BRONZE_BLOCK = REGISTER.register("bronze_block", () -> new BlockItem(BlocksRegistry.BRONZE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> SILVER_BLOCK = REGISTER.register("silver_block", () -> new BlockItem(BlocksRegistry.SILVER_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> NICKEL_BLOCK = REGISTER.register("nickel_block", () -> new BlockItem(BlocksRegistry.NICKEL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> INVAR_BLOCK = REGISTER.register("invar_block", () -> new BlockItem(BlocksRegistry.INVAR_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> STEEL_BLOCK = REGISTER.register("steel_block", () -> new BlockItem(BlocksRegistry.STEEL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> RUBY_BLOCK = REGISTER.register("ruby_block", () -> new BlockItem(BlocksRegistry.RUBY_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> END_METAL_BLOCK = REGISTER.register("end_metal_block", () -> new BlockItem(BlocksRegistry.END_METAL_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<Item> END_GEM_BLOCK = REGISTER.register("end_gem_block", () -> new BlockItem(BlocksRegistry.END_GEM_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
