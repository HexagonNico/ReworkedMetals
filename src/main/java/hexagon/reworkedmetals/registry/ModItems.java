package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.item.ModArmorItem;
import hexagon.reworkedmetals.item.ModArmorMaterials;
import hexagon.reworkedmetals.item.ModToolTiers;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("unused")
public class ModItems {
    
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkedMetals.ID);
    public static final DeferredRegister<Item> OVERRIDES = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");
    
    public static final RegistryObject<Item> SMELTERY = REGISTER.register("smeltery", () -> new BlockItem(ModBlocks.SMELTERY.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> FURNACE = OVERRIDES.register("furnace", () -> new BlockItem(ModBlocks.FURNACE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> BLAST_FURNACE = OVERRIDES.register("blast_furnace", () -> new BlockItem(ModBlocks.BLAST_FURNACE.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final RegistryObject<Item> KILN = REGISTER.register("kiln", () -> new BlockItem(ModBlocks.KILN.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    
    public static final RegistryObject<Item> RAW_TIN = REGISTER.register("raw_tin", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TIN_INGOT = REGISTER.register("tin_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> RAW_TUNGSTEN = REGISTER.register("raw_tungsten", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = REGISTER.register("tungsten_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> BRONZE_INGOT = REGISTER.register("bronze_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_INGOT = REGISTER.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    
    public static final RegistryObject<Item> TIN_ORE = REGISTER.register("tin_ore", () -> new BlockItem(ModBlocks.TIN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = REGISTER.register("deepslate_tin_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_TIN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> TUNGSTEN_ORE = REGISTER.register("tungsten_ore", () -> new BlockItem(ModBlocks.TUNGSTEN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static final RegistryObject<Item> DEEPSLATE_TUNGSTEN_ORE = REGISTER.register("deepslate_tungsten_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_TUNGSTEN_ORE.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    
    public static final RegistryObject<Item> COPPER_PICKAXE = REGISTER.register("copper_pickaxe", () -> new PickaxeItem(ModToolTiers.COPPER, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_SWORD = REGISTER.register("copper_sword", () -> new SwordItem(ModToolTiers.COPPER, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_AXE = REGISTER.register("copper_axe", () -> new AxeItem(ModToolTiers.COPPER, 6.5f, -3.15f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_SHOVEL = REGISTER.register("copper_shovel", () -> new ShovelItem(ModToolTiers.COPPER, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> COPPER_HOE = REGISTER.register("copper_hoe", () -> new HoeItem(ModToolTiers.COPPER, -1, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> BRONZE_PICKAXE = REGISTER.register("bronze_pickaxe", () -> new PickaxeItem(ModToolTiers.BRONZE, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_SWORD = REGISTER.register("bronze_sword", () -> new SwordItem(ModToolTiers.BRONZE, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_AXE = REGISTER.register("bronze_axe", () -> new AxeItem(ModToolTiers.BRONZE, 6.0f, -3.1f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_SHOVEL = REGISTER.register("bronze_shovel", () -> new ShovelItem(ModToolTiers.BRONZE, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> BRONZE_HOE = REGISTER.register("bronze_hoe", () -> new HoeItem(ModToolTiers.BRONZE, -2, -1.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> IRON_PICKAXE = OVERRIDES.register("iron_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_SWORD = OVERRIDES.register("iron_sword", () -> new SwordItem(ModToolTiers.IRON, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_AXE = OVERRIDES.register("iron_axe", () -> new AxeItem(ModToolTiers.IRON, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_SHOVEL = OVERRIDES.register("iron_shovel", () -> new ShovelItem(ModToolTiers.IRON, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_HOE = OVERRIDES.register("iron_hoe", () -> new HoeItem(ModToolTiers.IRON, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> IRON_DIAMOND_PICKAXE = REGISTER.register("iron_diamond_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON_DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_DIAMOND_SWORD = REGISTER.register("iron_diamond_sword", () -> new SwordItem(ModToolTiers.IRON_DIAMOND, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_DIAMOND_AXE = REGISTER.register("iron_diamond_axe", () -> new AxeItem(ModToolTiers.IRON_DIAMOND, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_DIAMOND_SHOVEL = REGISTER.register("iron_diamond_shovel", () -> new ShovelItem(ModToolTiers.IRON_DIAMOND, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_DIAMOND_HOE = REGISTER.register("iron_diamond_hoe", () -> new HoeItem(ModToolTiers.IRON_DIAMOND, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> IRON_EMERALD_PICKAXE = REGISTER.register("iron_emerald_pickaxe", () -> new PickaxeItem(ModToolTiers.IRON_EMERALD, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_EMERALD_SWORD = REGISTER.register("iron_emerald_sword", () -> new SwordItem(ModToolTiers.IRON_EMERALD, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_EMERALD_AXE = REGISTER.register("iron_emerald_axe", () -> new AxeItem(ModToolTiers.IRON_EMERALD, 5.5f, -3.05f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_EMERALD_SHOVEL = REGISTER.register("iron_emerald_shovel", () -> new ShovelItem(ModToolTiers.IRON_EMERALD, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> IRON_EMERALD_HOE = REGISTER.register("iron_emerald_hoe", () -> new HoeItem(ModToolTiers.IRON_EMERALD, -2, -1.5f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> STEEL_PICKAXE = REGISTER.register("steel_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_SWORD = REGISTER.register("steel_sword", () -> new SwordItem(ModToolTiers.STEEL, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_AXE = REGISTER.register("steel_axe", () -> new AxeItem(ModToolTiers.STEEL, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_SHOVEL = REGISTER.register("steel_shovel", () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_HOE = REGISTER.register("steel_hoe", () -> new HoeItem(ModToolTiers.STEEL, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> STEEL_DIAMOND_PICKAXE = REGISTER.register("steel_diamond_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL_DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_DIAMOND_SWORD = REGISTER.register("steel_diamond_sword", () -> new SwordItem(ModToolTiers.STEEL_DIAMOND, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_DIAMOND_AXE = REGISTER.register("steel_diamond_axe", () -> new AxeItem(ModToolTiers.STEEL_DIAMOND, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_DIAMOND_SHOVEL = REGISTER.register("steel_diamond_shovel", () -> new ShovelItem(ModToolTiers.STEEL_DIAMOND, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_DIAMOND_HOE = REGISTER.register("steel_diamond_hoe", () -> new HoeItem(ModToolTiers.STEEL_DIAMOND, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> STEEL_EMERALD_PICKAXE = REGISTER.register("steel_emerald_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL_EMERALD, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_EMERALD_SWORD = REGISTER.register("steel_emerald_sword", () -> new SwordItem(ModToolTiers.STEEL_EMERALD, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_EMERALD_AXE = REGISTER.register("steel_emerald_axe", () -> new AxeItem(ModToolTiers.STEEL_EMERALD, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_EMERALD_SHOVEL = REGISTER.register("steel_emerald_shovel", () -> new ShovelItem(ModToolTiers.STEEL_EMERALD, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_EMERALD_HOE = REGISTER.register("steel_emerald_hoe", () -> new HoeItem(ModToolTiers.STEEL_EMERALD, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> COPPER_HELMET = REGISTER.register("copper_helmet", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = REGISTER.register("copper_chestplate", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = REGISTER.register("copper_leggings", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_BOOTS = REGISTER.register("copper_boots", () -> new ModArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> BRONZE_HELMET = REGISTER.register("bronze_helmet", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = REGISTER.register("bronze_chestplate", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = REGISTER.register("bronze_leggings", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_BOOTS = REGISTER.register("bronze_boots", () -> new ModArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> IRON_HELMET = OVERRIDES.register("iron_helmet", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_CHESTPLATE = OVERRIDES.register("iron_chestplate", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_LEGGINGS = OVERRIDES.register("iron_leggings", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_BOOTS = OVERRIDES.register("iron_boots", () -> new ModArmorItem(ModArmorMaterials.IRON, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> STEEL_HELMET = REGISTER.register("steel_helmet", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = REGISTER.register("steel_chestplate", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_LEGGINGS = REGISTER.register("steel_leggings", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_BOOTS = REGISTER.register("steel_boots", () -> new ModArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> GILDED_NETHERITE_HELMET = REGISTER.register("gilded_netherite_helmet", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_CHESTPLATE = REGISTER.register("gilded_netherite_chestplate", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_LEGGINGS = REGISTER.register("gilded_netherite_leggings", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> GILDED_NETHERITE_BOOTS = REGISTER.register("gilded_netherite_boots", () -> new ModArmorItem(ModArmorMaterials.GILDED_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    
    public static final RegistryObject<Item> DIAMONDED_NETHERITE_HELMET = REGISTER.register("diamonded_netherite_helmet", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> DIAMONDED_NETHERITE_CHESTPLATE = REGISTER.register("diamonded_netherite_chestplate", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> DIAMONDED_NETHERITE_LEGGINGS = REGISTER.register("diamonded_netherite_leggings", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
    public static final RegistryObject<Item> DIAMONDED_NETHERITE_BOOTS = REGISTER.register("diamonded_netherite_boots", () -> new ModArmorItem(ModArmorMaterials.DIAMONDED_NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT).fireResistant()));
}
