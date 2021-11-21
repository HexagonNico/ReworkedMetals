package hexagonnico.reworkedmetals.config;

import java.util.HashMap;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * Config class. Handles common config.
 * 
 * @author Nico
 */
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
        createConfigValue(configBuilder, "changeBlastFurnaceCrafting", true, "Changes the blast furnace crafting to use invar instead of iron", "Default: true");
        createConfigValue(configBuilder, "changeSmokerCrafting", true, "Changes the smoker crafting to be consistent with other furnaces", "Default: true");
        createConfigValue(configBuilder, "consistentNetheriteCrafting", true, "Makes netherite tools and armor craftable the same way as other tools and armor", "Default: true", "Set this to false to re-enable the vanilla crafting with the smithing table");
        createConfigValue(configBuilder, "disableDiamondsCrafting", true, "When enable, disables the crafting recipes for diamond tools", "Default: true, since ReworkedMetals replace diamond tools with steel tools", "Set this to false to make diamond tools craftable");
        createConfigValue(configBuilder, "additionalCookingRecipes", true, "Adds more recipes to the campfire and the smoker so they don't need furnaces", "Default: true");
        createConfigValue(configBuilder, "additionalStonecuttingRecipes", true, "Adds more recipes to the stonecutter so they don't need furnaces", "Default: true");
        createConfigValue(configBuilder, "stonecutterAllowsAluminum", true, "Allows the stonecutter to be crafted with aluminum instead of iron", "Default: true");
        configBuilder.pop();
    
        configBuilder.comment("Blocks crafting").push("blocks_crafting");
        createConfigValue(configBuilder, "enableCopperBlock", true, "Enables crafting block of copper", "Default: true");
        createConfigValue(configBuilder, "enableRawCopperBlock", true, "Enables crafting block of raw copper", "Default: true");
        createConfigValue(configBuilder, "enableTinBlock", true, "Enables crafting block of tin", "Default: true");
        createConfigValue(configBuilder, "enableRawTinBlock", true, "Enables crafting block of raw tin", "Default: true");
        createConfigValue(configBuilder, "enableAluminumBlock", true, "Enables crafting block of aluminum", "Default: true");
        createConfigValue(configBuilder, "enableRawAluminumBlock", true, "Enables crafting block of raw aluminum", "Default: true");
        createConfigValue(configBuilder, "enableBronzeBlock", true, "Enables crafting block of bronze", "Default: true");
        createConfigValue(configBuilder, "enableSilverBlock", true, "Enables crafting block of silver", "Default: true");
        createConfigValue(configBuilder, "enableRawSilverBlock", true, "Enables crafting block of raw silver", "Default: true");
        createConfigValue(configBuilder, "enableNickelBlock", true, "Enables crafting block of nickel", "Default: true");
        createConfigValue(configBuilder, "enableRawNickelBlock", true, "Enables crafting block of raw nickel", "Default: true");
        createConfigValue(configBuilder, "enableInvarBlock", true, "Enables crafting block of invar", "Default: true");
        createConfigValue(configBuilder, "enableSteelBlock", true, "Enables crafting block of steel", "Default: true");
        createConfigValue(configBuilder, "enableRubyBlock", true, "Enables crafting block of ruby", "Default: true");
        configBuilder.pop();
    
        configBuilder.comment("Tin ore generation").push("tin_ore_gen");
        createConfigValue(configBuilder, "tinOreGenEnabled", true, "Enables natural generation of tin ore", "Default: true", "Set this to false to disable tin ore generation");
        createConfigValue(configBuilder, "tinVeinSize", 10, 1, 32, "Max size of a tin ore vein", "Default value: 10");
        createConfigValue(configBuilder, "tinMaxHeight", 96, 0, 256, "Max height at which tin can generate", "Default value: 96");
        createConfigValue(configBuilder, "tinMinHeight", 32, 0, 256, "Min height at which tin can generate", "Default value: 32");
        createConfigValue(configBuilder, "tinMinAttempts", 5, 0, 32, "Min number of generation attempts for tin ore", "Default value: 5");
        createConfigValue(configBuilder, "tinMaxAttempts", 15, 0, 32, "Max number of generation attempts for tin ore", "Default value: 15");
        configBuilder.pop();
    
        configBuilder.comment("Aluminum ore generation").push("aluminum_ore_gen");
        createConfigValue(configBuilder, "aluminumOreGenEnabled", true, "Enables natural generation of aluminum ore", "Default: true", "Set this to false to disable aluminum ore generation");
        createConfigValue(configBuilder, "aluminumVeinSize", 9, 1, 32, "Max size of a aluminum ore vein", "Default value: 9");
        createConfigValue(configBuilder, "aluminumMaxHeight", 64, 0, 256, "Max height at which aluminum can generate", "Default value: 64");
        createConfigValue(configBuilder, "aluminumMinHeight", 0, 0, 256, "Min height at which aluminum can generate", "Default value: 0");
        createConfigValue(configBuilder, "aluminumMinAttempts", 2, 0, 32, "Min number of generation attempts for aluminum ore", "Default value: 2");
        createConfigValue(configBuilder, "aluminumMaxAttempts", 8, 0, 32, "Max number of generation attempts for aluminum ore", "Default value: 8");
        configBuilder.pop();
    
        configBuilder.comment("Silver ore generation").push("silver_ore_gen");
        createConfigValue(configBuilder, "silverOreGenEnabled", true, "Enables natural generation of silver ore", "Default: true", "Set this to false to disable silver ore generation");
        createConfigValue(configBuilder, "silverVeinSize", 9, 1, 32, "Max size of a silver ore vein", "Default value: 9");
        createConfigValue(configBuilder, "silverMaxHeight", 32, 0, 256, "Max height at which silver can generate", "Default value: 32");
        createConfigValue(configBuilder, "silverMinHeight", 0, 0, 256, "Min height at which silver can generate", "Default value: 0");
        createConfigValue(configBuilder, "silverMinAttempts", 1, 0, 32, "Min number of generation attempts for silver ore", "Default value: 1");
        createConfigValue(configBuilder, "silverMaxAttempts", 3, 0, 32, "Max number of generation attempts for silver ore", "Default value: 3");
        configBuilder.pop();
    
        configBuilder.comment("Nickel ore generation").push("nickel_ore_gen");
        createConfigValue(configBuilder, "nickelOreGenEnabled", true, "Enables natural generation of nickel ore", "Default: true", "Set this to false to disable nickel ore generation");
        createConfigValue(configBuilder, "nickelVeinSize", 8, 1, 32, "Max size of a nickel ore vein", "Default value: 8");
        createConfigValue(configBuilder, "nickelMaxHeight", 24, 0, 256, "Max height at which nickel can generate", "Default value: 24");
        createConfigValue(configBuilder, "nickelMinHeight", 0, 0, 256, "Min height at which nickel can generate", "Default value: 0");
        createConfigValue(configBuilder, "nickelMinAttempts", 1, 0, 32, "Min number of generation attempts for nickel ore", "Default value: 1");
        createConfigValue(configBuilder, "nickelMaxAttempts", 2, 0, 32, "Max number of generation attempts for nickel ore", "Default value: 2");
        configBuilder.pop();
    
        configBuilder.comment("Ruby ore generation").push("ruby_ore_gen");
        createConfigValue(configBuilder, "rubyOreGenEnabled", true, "Enables natural generation of ruby ore", "Default: true", "Set this to false to disable ruby ore generation");
        createConfigValue(configBuilder, "rubyMaxHeight", 32, 0, 256, "Max height at which ruby can generate", "Default value: 32");
        createConfigValue(configBuilder, "rubyMinHeight", 4, 0, 256, "Min height at which ruby can generate", "Default value: 4");
        createConfigValue(configBuilder, "rubyMinAttempts", 3, 0, 32, "Min number of generation attempts for ruby ore", "Default value: 3");
        createConfigValue(configBuilder, "rubyMaxAttempts", 8, 0, 32, "Max number of generation attempts for ruby ore", "Default value: 8");
        configBuilder.pop();

        configBuilder.comment("Tools crafting").push("tools_crafting");
        createConfigValue(configBuilder, "enableCopperTools", true, "Enables crafting for copper tools", "Default: true");
        createConfigValue(configBuilder, "enableBronzeTools", true, "Enables crafting for bronze tools", "Default: true");
        createConfigValue(configBuilder, "enableIronDiamondTools", true, "Enables upgrading iron tools with a diamond", "Default: true");
        createConfigValue(configBuilder, "enableIronEmeraldTools", true, "Enables upgrading iron tools with an emerald", "Default: true");
        createConfigValue(configBuilder, "enableSilverTools", true, "Enables crafting for silver tools", "Default: true");
        createConfigValue(configBuilder, "enableSilverRubyTools", true, "Enables upgrading silver tools with a ruby", "Default: true");
        createConfigValue(configBuilder, "enableSilverDiamondTools", true, "Enables upgrading silver tools with a diamond", "Default: true");
        createConfigValue(configBuilder, "enableSteelTools", true, "Enables crafting for steel tools", "Default: true");
        createConfigValue(configBuilder, "enableSteelDiamondTools", true, "Enables upgrading steel tools with a diamond", "Default: true");
        createConfigValue(configBuilder, "enableSteelEmeraldTools", true, "Enables upgrading steel tools with an emerald", "Default: true");
        createConfigValue(configBuilder, "enableGoldRubyTools", true, "Enables upgrading gold tools with a ruby", "Default: true");
        configBuilder.pop();

        configBuilder.comment("Armor crafting").push("armor_crafting");
        createConfigValue(configBuilder, "enableCopperArmor", true, "Enables crafting for copper armor");
        createConfigValue(configBuilder, "enableBronzeArmor", true, "Enables crafting for bronze armor");
        createConfigValue(configBuilder, "enableSteelArmor", true, "Enables crafting for steel armor");
        createConfigValue(configBuilder, "enableDiamondedNetheriteArmor", true, "Enables upgrading netherite armor to diamonded netherite");
        createConfigValue(configBuilder, "enableGildedNetheriteArmor", true, "Enables upgrading netherite armor to gilded netherite");
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
     * Creates an int config value
     * @param builder ForgeConfigSpec.Builder
     * @param key Name of config value
     * @param defaultValue Default value
     * @param min Minimum value
     * @param max Maximum value
     * @param comments # Comments
     */
    private static void createConfigValue(ForgeConfigSpec.Builder builder, String key, int defaultValue, int min, int max, String... comments) {
        intValues.put(key, builder.comment(comments).defineInRange(key, defaultValue, min, max));
    }
    
    /**
     * Gets a boolean config
     * @param key Config key
     * @return True or false config value
     */
    public static boolean getBoolean(String key) {
        return booleanValues.containsKey(key) ? booleanValues.get(key).get() : false;
    }
    
    /**
     * Gets an int config
     * @param key Config key
     * @return Config value
     */
    public static int getInt(String key) {
        return intValues.containsKey(key) ? intValues.get(key).get() : 0;
    }
}
