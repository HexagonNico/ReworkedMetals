package hexagonnico.reworkedmetals.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec CONFIG;
    
    private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
    private static final HashMap<String, ForgeConfigSpec.IntValue> intValues = new HashMap<>();
    
    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
    
        configBuilder.comment("Reworked smelting options").push("smelting");
        createConfigValue(configBuilder, "ingotsRequireTwoOre", true, "When enabled, ingots require two raw ore materials to be smelted", "Default: true", "Set this to false to only require one raw ore per ingot");
        createConfigValue(configBuilder, "allowSmeltingFromOreBlock", false, "Allows the player to smelt ingots from ore blocks, not just raw ores chunk", "Default: false", "Turn on in case it is needed by other mods");
        configBuilder.pop();
    
        configBuilder.comment("Vanilla crafting changes").push("crafting_changes");
        createConfigValue(configBuilder, "requireCampfireForSmeltery", true, "When enabled, crafting a smeltery will require a campfire and a block of clay", "Default: true", "Set this to false to make it equal to the vanilla furnace recipe");
        createConfigValue(configBuilder, "requireCoalForCampfire", false, "When set to false, the campfire crafting recipe will not require coal/charcoal", "Default: false", "Set this to true to reset the vanilla recipe");
        createConfigValue(configBuilder, "consistentNetheriteCrafting", true, "Makes netherite tools and armor craftable the same way as other tools and armor", "Default: true", "Set this to false to re-enable the vanilla crafting with the smithing table");
        createConfigValue(configBuilder, "disableDiamondsCrafting", true, "When enable, disables the crafting recipes for diamond tools", "Default: true, since ReworkedMetals replace diamond tools with steel tools", "Set this to false to make diamond tools craftable");
        configBuilder.pop();
    
        configBuilder.comment("Blocks crafting").push("blocks_crafting");
        createConfigValue(configBuilder, "enableTinBlock", true, "Enables crafting block of tin", "Default: true");
        createConfigValue(configBuilder, "enableRawTinBlock", true, "Enables crafting block of raw tin", "Default: true");
        createConfigValue(configBuilder, "enableAluminumBlock", true, "Enables crafting block of aluminum", "Default: true");
        createConfigValue(configBuilder, "enableRawAluminumBlock", true, "Enables crafting block of raw aluminum", "Default: true");
        createConfigValue(configBuilder, "enableBronzeBlock", true, "Enables crafting block of bronze", "Default: true");
        createConfigValue(configBuilder, "enableNickelBlock", true, "Enables crafting block of nickel", "Default: true");
        createConfigValue(configBuilder, "enableRawNickelBlock", true, "Enables crafting block of raw nickel", "Default: true");
        createConfigValue(configBuilder, "enableInvarBlock", true, "Enables crafting block of invar", "Default: true");
        createConfigValue(configBuilder, "enableSteelBlock", true, "Enables crafting block of steel", "Default: true");
        createConfigValue(configBuilder, "enableRubyBlock", true, "Enables crafting block of ruby", "Default: true");
        configBuilder.pop();
    
        configBuilder.comment("Copper ore generation").push("copper_ore_gen");
        createConfigValue(configBuilder, "copperOreGenEnabled", true, "Enables natural generation of copper ore", "Default: true", "Set this to false to disable copper ore generation");
        createConfigValue(configBuilder, "copperOreVeinSize", 10, 1, 32, "Max size of a copper ore vein", "Default value: 10");
        createConfigValue(configBuilder, "copperOreMaxHeight", 96, 0, 256, "Max height at which copper can generate", "Default value: 96");
        createConfigValue(configBuilder, "copperOreAttempts", 6, 0, 32, "Number of generation attempts for copper ore", "Default value: 6");
        configBuilder.pop();
    
        configBuilder.comment("Tin ore generation").push("tin_ore_gen");
        createConfigValue(configBuilder, "tinOreGenEnabled", true, "Enables natural generation of tin ore", "Default: true", "Set this to false to disable tin ore generation");
        createConfigValue(configBuilder, "tinOreVeinSize", 10, 1, 32, "Max size of a tin ore vein", "Default value: 10");
        createConfigValue(configBuilder, "tinOreMaxHeight", 96, 0, 256, "Max height at which tin can generate", "Default value: 96");
        createConfigValue(configBuilder, "tinOreAttempts", 5, 0, 32, "Number of generation attempts for tin ore", "Default value: 5");
        configBuilder.pop();
    
        configBuilder.comment("Aluminum ore generation").push("aluminum_ore_gen");
        createConfigValue(configBuilder, "aluminumOreGenEnabled", true, "Enables natural generation of aluminum ore", "Default: true", "Set this to false to disable aluminum ore generation");
        createConfigValue(configBuilder, "aluminumOreVeinSize", 9, 1, 32, "Max size of a aluminum ore vein", "Default value: 9");
        createConfigValue(configBuilder, "aluminumOreMaxHeight", 63, 0, 256, "Max height at which aluminum can generate", "Default value: 63");
        createConfigValue(configBuilder, "aluminumOreAttempts", 4, 0, 32, "Number of generation attempts for aluminum ore", "Default value: 4");
        configBuilder.pop();
    
        configBuilder.comment("Nickel ore generation").push("nickel_ore_gen");
        createConfigValue(configBuilder, "nickelOreGenEnabled", true, "Enables natural generation of nickel ore", "Default: true", "Set this to false to disable nickel ore generation");
        createConfigValue(configBuilder, "nickelOreVeinSize", 8, 1, 32, "Max size of a nickel ore vein", "Default value: 8");
        createConfigValue(configBuilder, "nickelOreMaxHeight", 24, 0, 256, "Max height at which nickel can generate", "Default value: 24");
        createConfigValue(configBuilder, "nickelOreAttempts", 1, 0, 32, "Number of generation attempts for nickel ore", "Default value: 1");
        configBuilder.pop();
    
        configBuilder.comment("Ruby ore generation").push("ruby_ore_gen");
        createConfigValue(configBuilder, "rubyOreGenEnabled", true, "Enables natural generation of ruby ore", "Default: true", "Set this to false to disable ruby ore generation");
        configBuilder.pop();
    
        CONFIG = configBuilder.build();
    }
    
    private static void createConfigValue(ForgeConfigSpec.Builder builder, String key, boolean defaultValue, String... comments) {
        booleanValues.put(key, builder.comment(comments).define(key, defaultValue));
    }
    
    private static void createConfigValue(ForgeConfigSpec.Builder builder, String key, int defaultValue, int min, int max, String... comments) {
        intValues.put(key, builder.comment(comments).defineInRange(key, defaultValue, min, max));
    }
    
    public static boolean getBoolean(String key) {
        return booleanValues.get(key).get();
    }
    
    public static int getInt(String key) {
        return intValues.get(key).get();
    }
}
