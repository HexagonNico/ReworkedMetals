package hexagon.reworkedmetals.core.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec CONFIG;
    
    private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
    
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
        createConfigValue(configBuilder, "tungstenOreGenEnabled", true, " Enables natural generation of tungsten ore", " Default: true", " Set this to false to disable tungsten ore generation");
        configBuilder.pop();
        
        CONFIG = configBuilder.build();
    }
    
    private static void createConfigValue(ForgeConfigSpec.Builder builder, String key, boolean defaultValue, String... comments) {
        booleanValues.put(key, builder.comment(comments).define(key, defaultValue));
    }
    
    public static boolean getBoolean(String key) {
        return booleanValues.get(key).get();
    }
}
