package hexagon.reworkedmetals.blockentity;

import hexagon.reworkedmetals.container.KilnContainerMenu;
import hexagon.reworkedmetals.registry.ModBlockEntities;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class KilnBlockEntity extends AbstractFurnaceBlockEntity {
    
    public KilnBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.KILN.get(), pos, state, RecipeType.SMELTING);
    }
    
    @Override
    protected Component getDefaultName() {
        return new TranslatableComponent("container.reworkedmetals.kiln");
    }
    
    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
        return new KilnContainerMenu(id, playerInventory, this, this.dataAccess);
    }
}
