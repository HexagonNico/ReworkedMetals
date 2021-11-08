package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.client.gui.ReworkedFurnaceGui;
import hexagon.reworkedmetals.core.ReworkedMetals;
import hexagon.reworkedmetals.common.container.ReworkedFurnaceMenu;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ReworkedMetalsContainers {
    
    public static DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);
    public static RegistryObject<MenuType<ReworkedFurnaceMenu>> FURNACE = REGISTER.register("furnace", () -> IForgeContainerType.create(ReworkedFurnaceMenu::new));
    
    public static void registerGuis() {
        MenuScreens.register(FURNACE.get(), ReworkedFurnaceGui::new);
    }
}
