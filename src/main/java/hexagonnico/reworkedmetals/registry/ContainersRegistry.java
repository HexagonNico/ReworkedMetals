package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainer;
import hexagonnico.reworkedmetals.content.gui.ReworkedFurnaceGui;

import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;

/**
 * Container types registry. Contains all container types needed in ReworkedMetals.
 * 
 * @author Nico
 */
public class ContainersRegistry {
    
    public static DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);
    
    public static RegistryObject<MenuType<ReworkedFurnaceContainer>> FURNACE = REGISTER.register("furnace", () -> IForgeContainerType.create(ReworkedFurnaceContainer::new));
    
    /**
     * Registers GUIs. Called in {@link ReworkedMetals#clientSetup}.
     * Registers all container-guis in ReworkedMetals.
     */
    public static void registerGuis() {
        MenuScreens.register(FURNACE.get(), ReworkedFurnaceGui::new);
    }
}
