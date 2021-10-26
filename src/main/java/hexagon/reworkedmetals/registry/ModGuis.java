package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.gui.ReworkedFurnaceGui;

import net.minecraft.client.gui.screens.MenuScreens;

public class ModGuis {
    
    public static void register() {
        MenuScreens.register(ModContainers.FURNACE.get(), ReworkedFurnaceGui::new);
    }
}
