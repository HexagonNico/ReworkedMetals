package hexagon.reworkedmetals.core.registry;

import java.lang.reflect.Field;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class ReworkedMetalsVillagers {
    
    public static void armorerFix() {
        try {
            Field statesField = PoiType.ARMORER.getClass().getDeclaredField("matchingStates");
            statesField.setAccessible(true);
            statesField.set(PoiType.ARMORER, ImmutableSet.copyOf(ReworkedMetalsBlocks.BLAST_FURNACE.get().getStateDefinition().getPossibleStates()));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
