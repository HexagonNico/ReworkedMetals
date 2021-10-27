package hexagon.reworkedmetals;

import hexagon.reworkedmetals.block.ReworkedFurnaceBlock;
import hexagon.reworkedmetals.blockentity.ReworkedFurnaceBlockEntity;
import hexagon.reworkedmetals.crafting.ReworkedFurnaceRecipe;

import java.util.Optional;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FurnaceLogic {
    
    public static void tickFunction(Level level, BlockPos pos, BlockState state, ReworkedFurnaceBlockEntity blockEntity) {
        Optional<ReworkedFurnaceRecipe> recipe = level.getRecipeManager().getRecipeFor(ReworkedFurnaceRecipe.TYPE, blockEntity, level);
        ItemStack outputSlotItem = blockEntity.getItem(5);
        if(recipe.isPresent() && recipe.get().getTier() <= blockEntity.tier() && recipe.get().matches(blockEntity, level) && (outputSlotItem.isEmpty() || outputSlotItem.sameItem(recipe.get().getResultItem()))) {
            if(!blockEntity.isLit()) {
                ItemStack fuel = blockEntity.getItem(4);
                if(!fuel.isEmpty() && fuel.getItem().equals(Items.COAL)) {
                    blockEntity.litUp(1600);
                    state = state.setValue(ReworkedFurnaceBlock.LIT, true);
                    level.setBlock(pos, state, 3);
                    fuel.shrink(1);
                }
            } else {
                blockEntity.setSmeltingTime(recipe.get().getSmeltingTime());
                blockEntity.smeltingProgress(1);
                if(blockEntity.hasFinishedSmelting()) {
                    blockEntity.getItem(0).shrink(1);
                    blockEntity.getItem(1).shrink(1);
                    blockEntity.getItem(2).shrink(1);
                    blockEntity.getItem(3).shrink(1);
                    blockEntity.resetSmeltingProgress();
                    ItemStack result = recipe.get().assemble(blockEntity);
                    if(outputSlotItem.isEmpty()) {
                        blockEntity.setItem(5, result);
                    } else {
                        outputSlotItem.grow(result.getCount());
                    }
//                    reworkedFurnaceBlockEntity.storedExp += recipe.get().getExperience();
                }
            }
        }
        if(blockEntity.isLit()) {
            blockEntity.decreaseLitTime();
        } else {
            blockEntity.resetLitTime();
            blockEntity.smeltingProgress(-1);
            if(!blockEntity.isSmelting())
                blockEntity.resetSmeltingTime();
            state = state.setValue(ReworkedFurnaceBlock.LIT, false);
            level.setBlock(pos, state, 3);
        }
    }
}
