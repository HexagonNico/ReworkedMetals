package hexagonnico.reworkedmetals.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class CommonConfig {
	
	public static final ForgeConfigSpec CONFIG;

	private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
	
	static {
		ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();

		// TODO - Finish config

		configBuilder.comment("Ore generation").push("oreGen");
		createConfigValue(configBuilder, "tin", true, "Enables generation of tin");
		createConfigValue(configBuilder, "aluminum", true, "Enables generation of bauxite/aluminum");
		createConfigValue(configBuilder, "silver", true, "Enables generation of silver");
		createConfigValue(configBuilder, "nickel", true, "Enables generation of nickel");
		createConfigValue(configBuilder, "ruby", true, "Enables generation of ruby");
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
