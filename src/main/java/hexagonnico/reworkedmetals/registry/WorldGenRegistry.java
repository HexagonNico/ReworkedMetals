package hexagonnico.reworkedmetals.registry;


/**
 * World generation registry.
 * Handles world generation for ReworkedMetals.
 * @author Nico
 */
public class WorldGenRegistry {

    // public static final DeferredRegister<Placement<?>> REGISTER = DeferredRegister.create(ForgeRegistries.DECORATORS, ReworkedMetals.ID);

    // public static final RegistryObject<Placement<NoPlacementConfig>> COPPER_PLACEMENT = REGISTER.register("copper_ore", () -> new OreRangePlacement(Config.getInt("copperMinAttempts"), Config.getInt("copperMaxAttempts"), Config.getInt("copperMinHeight"), Config.getInt("copperMaxHeight")));
    // public static final RegistryObject<Placement<NoPlacementConfig>> TIN_PLACEMENT = REGISTER.register("tin_ore", () -> new OreRangePlacement(Config.getInt("tinMinAttempts"), Config.getInt("tinMaxAttempts"), Config.getInt("tinMinHeight"), Config.getInt("tinMaxHeight")));
    // public static final RegistryObject<Placement<NoPlacementConfig>> ALUMINUM_PLACEMENT = REGISTER.register("aluminum_ore", () -> new OreRangePlacement(Config.getInt("aluminumMinAttempts"), Config.getInt("aluminumMaxAttempts"), Config.getInt("aluminumMinHeight"), Config.getInt("aluminumMaxHeight")));
    // public static final RegistryObject<Placement<NoPlacementConfig>> SILVER_PLACEMENT = REGISTER.register("silver_ore", () -> new OreRangePlacement(Config.getInt("silverMinAttempts"), Config.getInt("silverMaxAttempts"), Config.getInt("silverMinHeight"), Config.getInt("silverMaxHeight")));
    // public static final RegistryObject<Placement<NoPlacementConfig>> NICKEL_PLACEMENT = REGISTER.register("nickel_ore", () -> new OreRangePlacement(Config.getInt("nickelMinAttempts"), Config.getInt("nickelMaxAttempts"), Config.getInt("nickelMinHeight"), Config.getInt("nickelMaxHeight")));
    // public static final RegistryObject<Placement<NoPlacementConfig>> RUBY_PLACEMENT = REGISTER.register("ruby_ore", () -> new OreRangePlacement(Config.getInt("rubyMinAttempts"), Config.getInt("rubyMaxAttempts"), Config.getInt("rubyMinHeight"), Config.getInt("rubyMaxHeight")));

    // private static ConfiguredFeature<?, ?> copperOreConfigured;
    // private static ConfiguredFeature<?, ?> tinOreConfigured;
    // private static ConfiguredFeature<?, ?> aluminumOreConfigured;
    // private static ConfiguredFeature<?, ?> silverOreConfigured;
    // private static ConfiguredFeature<?, ?> nickelOreConfigured;
    // private static ConfiguredFeature<?, ?> rubyOreConfigured;
    
    // /**
    //  * Registers a configured feature.
    //  * @param <FC> IFeatureConfig type.
    //  * @param key Name of the feature.
    //  * @param feature The feature to register.
    //  */
    // private static <FC extends IFeatureConfig> void register(String key, ConfiguredFeature<FC, ?> feature) {
    //     Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, feature);
    // }
    
    // /**
    //  * Registers all configured features. Called in {@link ReworkedMetals#commonSetup}.
    //  * Note that features need to be added to biomes with an event handler in order to generate.
    //  */
    // public static void register() {
    //     register("copper_ore", copperOreConfigured = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.COPPER_ORE.get().defaultBlockState(), Config.getInt("copperVeinSize"))).decorated(COPPER_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    //     register("ore_tin", tinOreConfigured = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.TIN_ORE.get().defaultBlockState(), Config.getInt("tinVeinSize"))).decorated(TIN_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    //     register("ore_aluminum", aluminumOreConfigured = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.ALUMINUM_ORE.get().defaultBlockState(), Config.getInt("aluminumVeinSize"))).decorated(ALUMINUM_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    //     register("ore_silver", silverOreConfigured = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.SILVER_ORE.get().defaultBlockState(), Config.getInt("silverVeinSize"))).decorated(SILVER_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    //     register("ore_nickel", nickelOreConfigured = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlocksRegistry.NICKEL_ORE.get().defaultBlockState(), Config.getInt("nickelVeinSize"))).decorated(NICKEL_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    //     register("ore_ruby", rubyOreConfigured = Feature.EMERALD_ORE.configured(new ReplaceBlockConfig(Blocks.STONE.defaultBlockState(), BlocksRegistry.RUBY_ORE.get().defaultBlockState())).decorated(RUBY_PLACEMENT.get().configured(IPlacementConfig.NONE)));
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addCopperToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(copperOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, copperOreConfigured);
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addTinToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(tinOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, tinOreConfigured);
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addAluminumToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(aluminumOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, aluminumOreConfigured);
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addSilverToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(silverOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, silverOreConfigured);
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addNickelToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(nickelOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, nickelOreConfigured);
    // }

    // /**
    //  * Adds ore generation to biome settings. Called in {@link InitEventHandler#onBiomeLoad}.
    //  * We cannot use public static because of DeferredRegistry.
    //  * @param generationSettings BiomeGenerationSettingsBuilder
    //  */
    // public static void addRubyToGenSettings(BiomeGenerationSettingsBuilder generationSettings) {
    //     if(rubyOreConfigured != null) generationSettings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, rubyOreConfigured);
    // }
}
