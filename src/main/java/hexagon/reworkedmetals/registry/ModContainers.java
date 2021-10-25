package hexagon.reworkedmetals.registry;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.container.SmelteryContainerMenu;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {
    
    public static DeferredRegister<MenuType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);
    public static RegistryObject<MenuType<SmelteryContainerMenu>> SMELTERY = REGISTER.register("smeltery", () -> IForgeContainerType.create(SmelteryContainerMenu::new));
}
