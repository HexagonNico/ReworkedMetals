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
    
    public static void tickFunction(Level level, BlockPos pos, BlockState state, ReworkedFurnaceBlockEntity reworkedFurnaceBlockEntity) {
        Optional<ReworkedFurnaceRecipe> recipe = level.getRecipeManager().getRecipeFor(ReworkedFurnaceRecipe.TYPE, reworkedFurnaceBlockEntity, level);
        ItemStack outputSlotItem = reworkedFurnaceBlockEntity.getItem(5);
        if(recipe.isPresent() && recipe.get().matches(reworkedFurnaceBlockEntity, level) && (outputSlotItem.isEmpty() || outputSlotItem.sameItem(recipe.get().getResultItem()))) {
            if(!reworkedFurnaceBlockEntity.isLit()) {
                ItemStack fuel = reworkedFurnaceBlockEntity.getItem(4);
                if(!fuel.isEmpty() && fuel.getItem().equals(Items.COAL)) {
                    reworkedFurnaceBlockEntity.litUp(1600);
                    state = state.setValue(ReworkedFurnaceBlock.LIT, true);
                    level.setBlock(pos, state, 3);
                    fuel.shrink(1);
                }
            } else {
                reworkedFurnaceBlockEntity.setSmeltingTime(recipe.get().getSmeltingTime());
                reworkedFurnaceBlockEntity.smeltingProgress(1);
                if(reworkedFurnaceBlockEntity.hasFinishedSmelting()) {
                    reworkedFurnaceBlockEntity.getItem(0).shrink(1);
                    reworkedFurnaceBlockEntity.getItem(1).shrink(1);
                    reworkedFurnaceBlockEntity.getItem(2).shrink(1);
                    reworkedFurnaceBlockEntity.getItem(3).shrink(1);
                    reworkedFurnaceBlockEntity.resetSmeltingProgress();
                    ItemStack result = recipe.get().assemble(reworkedFurnaceBlockEntity);
                    if(outputSlotItem.isEmpty()) {
                        reworkedFurnaceBlockEntity.setItem(5, result);
                    } else {
                        outputSlotItem.grow(result.getCount());
                    }
//                    reworkedFurnaceBlockEntity.storedExp += recipe.get().getExperience();
                }
            }
        }
        if(reworkedFurnaceBlockEntity.isLit()) {
            reworkedFurnaceBlockEntity.decreaseLitTime();
        } else {
            reworkedFurnaceBlockEntity.resetLitTime();
            reworkedFurnaceBlockEntity.smeltingProgress(-1);
            if(!reworkedFurnaceBlockEntity.isSmelting())
                reworkedFurnaceBlockEntity.resetSmeltingTime();
            state = state.setValue(ReworkedFurnaceBlock.LIT, false);
            level.setBlock(pos, state, 3);
        }
    }
}
