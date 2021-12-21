package hexagonnico.reworkedmetals.content.blockentity;

import hexagonnico.reworkedmetals.registry.BlockEntitiesRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.level.block.state.BlockState;

public class NetherForgeBlockEntity extends ReworkedFurnaceBlockEntity {
	
	/**
	 * Creates block entity
	 * @param pos BlockPos
	 * @param state BlockState
	 */
	public NetherForgeBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesRegistry.NETHER_FORGE.get(), pos, state);
	}

	@Override // Text title
	protected Component getDefaultName() {
		return new TranslatableComponent("container.reworkedmetals.nether_forge");
	}

	@Override // Reworked furnace recipe
	public String stationType() {
		return "nether_forge";
	}
}
