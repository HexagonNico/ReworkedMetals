package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
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
    
    public static final RegistryObject<Item> STEEL_PICKAXE = REGISTER.register("steel_pickaxe", () -> new PickaxeItem(ModToolTiers.STEEL, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_SWORD = REGISTER.register("steel_sword", () -> new SwordItem(ModToolTiers.STEEL, 3, -2.4f, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_AXE = REGISTER.register("steel_axe", () -> new AxeItem(ModToolTiers.STEEL, 5.0f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_SHOVEL = REGISTER.register("steel_shovel", () -> new ShovelItem(ModToolTiers.STEEL, 1.5f, -3.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> STEEL_HOE = REGISTER.register("steel_hoe", () -> new HoeItem(ModToolTiers.STEEL, -3, -0.0f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    
    public static final RegistryObject<Item> COPPER_HELMET = REGISTER.register("copper_helmet", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = REGISTER.register("copper_chestplate", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_LEGGINGS = REGISTER.register("copper_leggings", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> COPPER_BOOTS = REGISTER.register("copper_boots", () -> new ArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> BRONZE_HELMET = REGISTER.register("bronze_helmet", () -> new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_CHESTPLATE = REGISTER.register("bronze_chestplate", () -> new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_LEGGINGS = REGISTER.register("bronze_leggings", () -> new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> BRONZE_BOOTS = REGISTER.register("bronze_boots", () -> new ArmorItem(ModArmorMaterials.BRONZE, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> IRON_HELMET = OVERRIDES.register("iron_helmet", () -> new ArmorItem(ModArmorMaterials.IRON, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_CHESTPLATE = OVERRIDES.register("iron_chestplate", () -> new ArmorItem(ModArmorMaterials.IRON, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_LEGGINGS = OVERRIDES.register("iron_leggings", () -> new ArmorItem(ModArmorMaterials.IRON, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> IRON_BOOTS = OVERRIDES.register("iron_boots", () -> new ArmorItem(ModArmorMaterials.IRON, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    
    public static final RegistryObject<Item> STEEL_HELMET = REGISTER.register("steel_helmet", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.HEAD, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = REGISTER.register("steel_chestplate", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.CHEST, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_LEGGINGS = REGISTER.register("steel_leggings", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.LEGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
    public static final RegistryObject<Item> STEEL_BOOTS = REGISTER.register("steel_boots", () -> new ArmorItem(ModArmorMaterials.STEEL, EquipmentSlot.FEET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
}
