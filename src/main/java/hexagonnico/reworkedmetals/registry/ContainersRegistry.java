package hexagonnico.reworkedmetals.registry;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainer;
import hexagonnico.reworkedmetals.content.gui.ReworkedFurnaceGui;

import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;

public class ContainersRegistry {
    
    public static DeferredRegister<ContainerType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);
    
    public static RegistryObject<ContainerType<ReworkedFurnaceContainer>> FURNACE = REGISTER.register("furnace", () -> IForgeContainerType.create(ReworkedFurnaceContainer::new));
    
    public static void registerGuis() {
        ScreenManager.register(FURNACE.get(), ReworkedFurnaceGui::new);
    }
}
