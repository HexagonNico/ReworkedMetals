package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.gui.SmelteryGui;

import net.minecraft.client.gui.screens.MenuScreens;

public class ModGuis {
    
    public static void register() {
        MenuScreens.register(ModContainers.SMELTERY.get(), SmelteryGui::new);
    }
}
