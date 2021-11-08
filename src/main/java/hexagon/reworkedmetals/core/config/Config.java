package hexagon.reworkedmetals.core.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec CONFIG;
    
    private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
    private static final HashMap<String, ForgeConfigSpec.IntValue> intValues = new HashMap<>();
    
    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        
        configBuilder.comment(" Crafting").push("crafting");
        createConfigValue(configBuilder, "ingotsRequireTwoOre", true, " When enabled, ingots require two raw ore materials to be smelted", " Default: true", " Set this to false to only require one raw ore per ingot");
        createConfigValue(configBuilder, "requireCampfireForSmeltery", true, " When enabled, crafting a smeltery will require a campfire and a block of clay", " Default: true", " Set this to false to make it equal to the vanilla furnace recipe");
        createConfigValue(configBuilder, "requireCoalForCampfire", false, " When set to false, the campfire crafting recipe will not require coal/charcoal", " Default: false", " Set this to true to reset the vanilla recipe");
        createConfigValue(configBuilder, "consistentNetheriteCrafting", true, " Makes netherite tools and armor craftable the same way as other tools and armor", " Default: true", " Set this to false to re-enable the vanilla crafting with the smithing table");
        createConfigValue(configBuilder, "disableDiamondsCrafting", true, " When enable, disables the crafting recipes for diamond tools", " Default: true, since ReworkedMetals replace diamond tools with steel tools", " Set this to false to make diamond tools craftable");
        configBuilder.pop();
        
        configBuilder.comment(" World generation").push("world_gen");
        createConfigValue(configBuilder, "tinOreGenEnabled", true, " Enables natural generation of tin ore", " Default: true", " Set this to false to disable tin ore generation");
        createConfigValue(configBuilder, "tinOreVeinSize", 10, 1, 32, " Max size of a tin ore vein", " Default value: 10");
        createConfigValue(configBuilder, "tinOreMinHeight", 0, 0, 256, " Min height at which tin can generate", " Default value: 0");
        createConfigValue(configBuilder, "tinOreMaxHeight", 96, 0, 256, " Max height at which tin can generate", " Default value: 96");
        createConfigValue(configBuilder, "tinOreAttempts", 4, 0, 32, " Number of generation attempts for tin ore", " Default value: 4");
        createConfigValue(configBuilder, "tungstenOreGenEnabled", true, " Enables natural generation of tungsten ore", " Default: true", " Set this to false to disable tungsten ore generation");
        createConfigValue(configBuilder, "tungstenOreVeinSize", 9, 1, 32, " Max size of a tungsten ore vein", " Default value: 9");
        createConfigValue(configBuilder, "tungstenOreMinHeight", 32, 0, 256, " Min height at which tungsten can generate", " Default value: 32");
        createConfigValue(configBuilder, "tungstenOreMaxHeight", 96, 0, 256, " Max height at which tungsten can generate", " Default value: 96");
        createConfigValue(configBuilder, "tungstenOreAttempts", 4, 0, 32, " Number of generation attempts for tungsten ore", " Default value: 4");
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
