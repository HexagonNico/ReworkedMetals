package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.container.AlloyingFurnaceContainerMenu;
import hexagonnico.reworkedmetals.content.gui.AlloyingFurnaceScreen;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.MenuType;

/**
 * Container types registry.
 * Contains all container types needed in ReworkedMetals.
 * @author Nico
 */
public class ContainerMenusRegistry {

	public static DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);

	public static RegistryObject<MenuType<AlloyingFurnaceContainerMenu>> FURNACE = REGISTER.register("furnace", () -> IForgeMenuType.create(AlloyingFurnaceContainerMenu::new));

	/**
	 * Registers GUIs. Called in {@link ReworkedMetals#clientSetup}.
	 * Registers all container-guis in ReworkedMetals.
	 */
	public static void registerGuis() {
		MenuScreens.register(FURNACE.get(), AlloyingFurnaceScreen::new);
	}
}
