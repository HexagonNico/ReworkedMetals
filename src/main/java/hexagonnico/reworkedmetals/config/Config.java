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
        createConfigValue(configBuilder, "allowSmeltingFromOreBlock", true, "Allows the player to smelt ingots from ore blocks, not just raw ores chunk", "Default: true", "This option is only needed for compatibility with other mods, it may be turned off if it is not needed");
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
        createConfigValue(configBuilder, "enableTungstenBlock", true, "Enables crafting block of tungsten", "Default: true");
        createConfigValue(configBuilder, "enableRawTungstenBlock", true, "Enables crafting block of raw tungsten", "Default: true");
        createConfigValue(configBuilder, "enableBronzeBlock", true, "Enables crafting block of bronze", "Default: true");
        createConfigValue(configBuilder, "enableSteelBlock", true, "Enables crafting block of steel", "Default: true");
        createConfigValue(configBuilder, "enableVanadiumBlock", true, "Enables crafting block of vanadium", "Default: true");
        createConfigValue(configBuilder, "enableRawVanadiumBlock", true, "Enables crafting block of raw vanadium", "Default: true");
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
        createConfigValue(configBuilder, "tinOreAttempts", 4, 0, 32, "Number of generation attempts for tin ore", "Default value: 4");
        configBuilder.pop();
    
        configBuilder.comment("Tungsten ore generation").push("tungsten_ore_gen");
        createConfigValue(configBuilder, "tungstenOreGenEnabled", true, "Enables natural generation of tungsten ore", "Default: true", "Set this to false to disable tungsten ore generation");
        createConfigValue(configBuilder, "tungstenOreVeinSize", 9, 1, 32, "Max size of a tungsten ore vein", "Default value: 9");
        createConfigValue(configBuilder, "tungstenOreMaxHeight", 96, 0, 256, "Max height at which tungsten can generate", "Default value: 96");
        createConfigValue(configBuilder, "tungstenOreAttempts", 4, 0, 32, "Number of generation attempts for tungsten ore", "Default value: 4");
        configBuilder.pop();
    
        configBuilder.comment("Vanadium ore generation").push("vanadium_ore_gen");
        createConfigValue(configBuilder, "vanadiumOreGenEnabled", true, "Enables natural generation of vanadium ore", "Default: true", "Set this to false to disable vanadium ore generation");
        createConfigValue(configBuilder, "vanadiumOreVeinSize", 8, 1, 32, "Max size of a vanadium ore vein", "Default value: 8");
        createConfigValue(configBuilder, "vanadiumOreMaxHeight", 15, 0, 256, "Max height at which vanadium can generate", "Default value: 15");
        createConfigValue(configBuilder, "vanadiumOreAttempts", 1, 0, 32, "Number of generation attempts for vanadium ore", "Default value: 1");
        configBuilder.pop();
    
        configBuilder.comment("Ruby ore generation").push("ruby_ore_gen");
        createConfigValue(configBuilder, "rubyOreGenEnabled", true, "Enables natural generation of ruby ore", "Default: true", "Set this to false to disable ruby ore generation");
        createConfigValue(configBuilder, "rubyOreVeinSize", 1, 1, 32, "Max size of a ruby ore vein", "Default value: 1");
        createConfigValue(configBuilder, "rubyOreMaxHeight", 31, 0, 256, "Max height at which ruby can generate", "Default value: 31");
        createConfigValue(configBuilder, "rubyOreAttempts", 6, 0, 32, "Number of generation attempts for ruby ore", "Default value: 6");
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
