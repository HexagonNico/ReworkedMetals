package hexagonnico.reworkedmetals.content.blockentity;

import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class AlloyingFurnaceBlockEntity extends AbstractAlloyingFurnaceBlockEntity {

	public AlloyingFurnaceBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesRegistry.ALLOYING_FURNACE.get(), pos, state);
	}

	@Override
	public String stationType() {
		return "nether_forge"; // TODO - Remove entirely
	}

	@Override
	protected Component getDefaultName() {
		return new TranslatableComponent("container.reworkedmetals.alloying_furnace");
	}
}
