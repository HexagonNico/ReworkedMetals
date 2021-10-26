package hexagon.reworkedmetals.gui;

import hexagon.reworkedmetals.ReworkedMetals;
import hexagon.reworkedmetals.container.SmelteryContainerMenu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SmelteryGui extends AbstractContainerScreen<SmelteryContainerMenu> {
    
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ReworkedMetals.ID, "textures/gui/smeltery.png");
    
    public SmelteryGui(SmelteryContainerMenu container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 184;
        this.inventoryLabelY = this.imageHeight - 94;
    }
    
    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(poseStack, mouseX, mouseY);
    }
    
    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(poseStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        this.renderBurning(poseStack);
        this.renderProgress(poseStack);
    }
    
    private void renderBurning(PoseStack poseStack) {
        int lit = (int) (13 * super.menu.litTime());
        if(lit > 0) {
            this.blit(poseStack, this.leftPos + 47, this.topPos + 54 + 12 - lit, 176, 12 - lit, 14, lit + 1);
        }
    }
    
    private void renderProgress(PoseStack poseStack) {
        int burn = super.menu.getSmeltingProgress();
        this.blit(poseStack, this.leftPos + 81, this.topPos + 26, 176, 14, burn + 1, 16);
    }
}
