package hexagon.reworkedmetals.gui;

import hexagon.reworkedmetals.container.KilnContainerMenu;

import net.minecraft.client.gui.screens.inventory.AbstractFurnaceScreen;
import net.minecraft.client.gui.screens.recipebook.SmeltingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KilnGui extends AbstractFurnaceScreen<KilnContainerMenu> {
    
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");
    
    public KilnGui(KilnContainerMenu containerMenu, Inventory playerInventory, Component title) {
        super(containerMenu, new SmeltingRecipeBookComponent(), playerInventory, title, TEXTURE);
    }
}
