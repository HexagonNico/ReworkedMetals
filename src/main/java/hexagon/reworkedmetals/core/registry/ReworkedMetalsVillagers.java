package hexagon.reworkedmetals.core.registry;

import java.lang.reflect.Field;

import com.google.common.collect.ImmutableSet;
import net.minecraft.village.PointOfInterestType;

public class ReworkedMetalsVillagers {
    
    public static void armorerFix() {
        try {
            Field statesField = PointOfInterestType.ARMORER.getClass().getDeclaredField("matchingStates");
            statesField.setAccessible(true);
            statesField.set(PointOfInterestType.ARMORER, ImmutableSet.copyOf(ReworkedMetalsBlocks.BLAST_FURNACE.get().getStateDefinition().getPossibleStates()));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
