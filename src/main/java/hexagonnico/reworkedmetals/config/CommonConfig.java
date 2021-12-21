package hexagonnico.reworkedmetals.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
	
	public static final ForgeConfigSpec CONFIG;

	private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
	
	static {
		ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

		configBuilder.comment("Changes to the vanilla crafting").push("vanillaChanges");
		createConfigValue(configBuilder, "campfire", true, "Changes the campfire recipe to not use coal");
		createConfigValue(configBuilder, "disableDiamond", true, "Disables the crafting for diamond tools");
		createConfigValue(configBuilder, "consistentNetherite", true, "Changes netherite tools recipe to make it more consistent");
		createConfigValue(configBuilder, "additionalCooking", true, "Adds some recipes to the smoker/campfire that don't fit in other furnaces");
		createConfigValue(configBuilder, "additionalStonecutting", true, "Adds some recipes to the stonecutter that don't fit in furnaces");
		configBuilder.pop();

		configBuilder.comment("Enables or disables ore generation").push("oreGeneration");
		createConfigValue(configBuilder, "tinOre", true, "Enables generation of tin");
		createConfigValue(configBuilder, "aluminumOre", true, "Enables generation of bauxite/aluminum");
		createConfigValue(configBuilder, "silverOre", true, "Enables generation of silver");
		createConfigValue(configBuilder, "nickelOre", true, "Enables generation of nickel");
		createConfigValue(configBuilder, "rubyOre", true, "Enables generation of ruby");
		createConfigValue(configBuilder, "endOre", true, "Enables generation of end metal and end gems");
		configBuilder.pop();

		configBuilder.comment("Enables or disables tools crafting").push("toolsCrafting");
		createConfigValue(configBuilder, "copperTools", true, "Enables crafting for copper tools");
		createConfigValue(configBuilder, "bronzeTools", true, "Enables crafting for bronze tools");
		createConfigValue(configBuilder, "silverTools", true, "Enables crafting for silver tools");
		createConfigValue(configBuilder, "steelTools", true, "Enables crafting for steel tools");
		createConfigValue(configBuilder, "endMetalTools", true, "Enables crafting for endor tools");
		configBuilder.pop();

		configBuilder.comment("Enables or disables armor crafting").push("armorCrafting");
		createConfigValue(configBuilder, "copperArmor", true, "Enables crafting for copper armor");
		createConfigValue(configBuilder, "bronzeArmor", true, "Enables crafting for bronze armor");
		createConfigValue(configBuilder, "steelArmor", true, "Enables crafting for steel armor");
		configBuilder.pop();

		configBuilder.comment("Enables or disables blocks crafting").push("blocksCrafting");
		createConfigValue(configBuilder, "rawTinBlock", true, "Enables crafting for raw tin block");
		createConfigValue(configBuilder, "tinBlock", true, "Enables crafting for tin block");
		createConfigValue(configBuilder, "rawAluminumBlock", true, "Enables crafting for raw aluminum block");
		createConfigValue(configBuilder, "aluminumBlock", true, "Enables crafting for aluminum block");
		createConfigValue(configBuilder, "bronzeBlock", true, "Enables crafting for bronze block");
		createConfigValue(configBuilder, "rawSilverBlock", true, "Enables crafting for raw silver block");
		createConfigValue(configBuilder, "silverBlock", true, "Enables crafting for silver block");
		createConfigValue(configBuilder, "rawNickelBlock", true, "Enables crafting for raw nickel block");
		createConfigValue(configBuilder, "nickelBlock", true, "Enables crafting for nickel block");
		createConfigValue(configBuilder, "invarBlock", true, "Enables crafting for invar block");
		createConfigValue(configBuilder, "steelBlock", true, "Enables crafting for steel block");
		createConfigValue(configBuilder, "rubyBlock", true, "Enables crafting for ruby block");
		configBuilder.pop();

		configBuilder.comment("Enables or disables smithing upgrades").push("smithingUpgrades");
		createConfigValue(configBuilder, "ironDiamond", true, "Enables upgrading iron tools with a diamond");
		createConfigValue(configBuilder, "ironEmerald", true, "Enables upgrading iron tools with an emerald");
		createConfigValue(configBuilder, "steelDiamond", true, "Enables upgrading steel tools with a diamond");
		createConfigValue(configBuilder, "steelEmerald", true, "Enables upgrading steel tools with an emerald");
		createConfigValue(configBuilder, "goldRuby", true, "Enables upgrading gold tools with a ruby");
		createConfigValue(configBuilder, "silverDiamond", true, "Enables upgrading silver tools with a diamond");
		createConfigValue(configBuilder, "silverRuby", true, "Enables upgrading silver tools with a ruby");
		createConfigValue(configBuilder, "gildedNetherite", true, "Enables upgrading netherite armor with gold");
		createConfigValue(configBuilder, "diamondedNetherite", true, "Enables upgrading netherite armor with a diamond");
		createConfigValue(configBuilder, "endGem", true, "Enables upgrading endor tools with an endor gem");
		configBuilder.pop();

		CONFIG = configBuilder.build();
	}

	/**
	 * Creates a boolean config value
	 * @param builder ForgeConfigSpec.Builder
	 * @param key Name of config value
	 * @param defaultValue Default value
	 * @param comments # Comments
	 */
	private static void createConfigValue(ForgeConfigSpec.Builder builder, String key, boolean defaultValue, String... comments) {
		booleanValues.put(key, builder.comment(comments).define(key, defaultValue));
	}

	/**
	 * Gets a boolean config
	 * @param key Config key
	 * @return True or false config value
	 */
	public static boolean getBoolean(String key) {
		return booleanValues.containsKey(key) ? booleanValues.get(key).get() : false;
	}
}
