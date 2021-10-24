package hexagon.reworkedmetals;

import hexagon.reworkedmetals.block.SmelteryBlock;
import hexagon.reworkedmetals.block.entity.SmelteryBlockEntity;

import com.google.common.collect.Sets;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ReworkedMetals.ID);
    public static final RegistryObject<Item> TEST_ITEM = ITEMS.register("test", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ReworkedMetals.ID);
    public static final RegistryObject<Block> SMELTERY_BLOCK = BLOCKS.register("smeltery", SmelteryBlock::new);
    
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ReworkedMetals.ID);
    public static final RegistryObject<BlockEntityType<SmelteryBlockEntity>> SMELTERY_BLOCK_ENTITY = BLOCK_ENTITIES.register("smeltery", () -> new BlockEntityType<>(SmelteryBlockEntity::new, Sets.newHashSet(SMELTERY_BLOCK.get()), null));
}
