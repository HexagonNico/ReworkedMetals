package hexagon.reworkedmetals;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {

    public static final ForgeConfigSpec CONFIG;
    
    private static final HashMap<String, ForgeConfigSpec.BooleanValue> booleanValues = new HashMap<>();
    
    static {
        ForgeConfigSpec.Builder configBuilder = new ForgeConfigSpec.Builder();
        
        configBuilder.comment(" Crafting").push("crafting");
        createConfigValue(configBuilder, "ingotsRequireTwoOre", true, " When enabled, ingots require two raw ore materials to be smelted", " Default: true", " Set this to false to only require one raw ore per ingot");
        createConfigValue(configBuilder, "consistentNetheriteCrafting", true, " Makes netherite tools and armor craftable the same way as other tools and armor", " Default: true", " Set this to false to re-enable the vanilla crafting with the smithing table");
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
