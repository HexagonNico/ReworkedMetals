package hexagon.reworkedmetals.core.registry;

import hexagon.reworkedmetals.client.gui.ReworkedFurnaceGui;
import hexagon.reworkedmetals.common.container.ReworkedFurnaceContainer;
import hexagon.reworkedmetals.core.ReworkedMetals;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ReworkedMetalsContainers {
    
    public static DeferredRegister<ContainerType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.CONTAINERS, ReworkedMetals.ID);
    
    public static RegistryObject<ContainerType<ReworkedFurnaceContainer>> FURNACE = REGISTER.register("furnace", () -> IForgeContainerType.create(ReworkedFurnaceContainer::new));
    
    public static void registerGuis() {
        ScreenManager.register(FURNACE.get(), ReworkedFurnaceGui::new);
    }
}
