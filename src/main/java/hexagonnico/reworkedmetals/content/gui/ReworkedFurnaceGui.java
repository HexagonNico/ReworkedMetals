package hexagonnico.reworkedmetals.content.gui;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainer;

import javax.annotation.ParametersAreNonnullByDefault;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

@ParametersAreNonnullByDefault
public class ReworkedFurnaceGui extends ContainerScreen<ReworkedFurnaceContainer> {
    
    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ReworkedMetals.ID, "textures/gui/furnace.png");
    
    public ReworkedFurnaceGui(ReworkedFurnaceContainer container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 184;
        this.inventoryLabelY = this.imageHeight - 94;
    }
    
    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }
    
    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        this.renderBurning(matrixStack);
        this.renderProgress(matrixStack);
    }
    
    private void renderBurning(MatrixStack matrixStack) {
        int lit = super.menu.litTime();
        if(lit > 0) {
            this.blit(matrixStack, this.leftPos + 47, this.topPos + 54 + 12 - lit, 176, 12 - lit, 14, lit + 1);
        }
    }
    
    private void renderProgress(MatrixStack matrixStack) {
        int burn = super.menu.getSmeltingProgress();
        this.blit(matrixStack, this.leftPos + 81, this.topPos + 26, 176, 14, burn + 1, 16);
    }
}
