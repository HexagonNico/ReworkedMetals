package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
    public static final RegistryObject<Item> BRONZE_INGOT = REGISTER.register("bronze_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
    public static final RegistryObject<Item> STEEL_INGOT = REGISTER.register("steel_ingot", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));
}
