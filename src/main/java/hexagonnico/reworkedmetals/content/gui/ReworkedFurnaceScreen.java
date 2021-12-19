package hexagonnico.reworkedmetals.content.gui;

import hexagonnico.reworkedmetals.ReworkedMetals;
import hexagonnico.reworkedmetals.content.container.ReworkedFurnaceContainerMenu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * Furnace gui screen.
 * @author Nico
 */
public class ReworkedFurnaceScreen extends AbstractContainerScreen<ReworkedFurnaceContainerMenu> {

	private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(ReworkedMetals.ID, "textures/gui/furnace.png");

	/**
	 * Constructor needed to register gui.
	 * @param container ReworkedFurnaceContainerMenu
	 * @param playerInventory PlayerInventory
	 * @param title Gui title
	 */
	public ReworkedFurnaceScreen(ReworkedFurnaceContainerMenu container, Inventory playerInventory, Component title) {
		super(container, playerInventory, title);
		this.leftPos = 0;
		this.topPos = 0;
		this.imageWidth = 176;
		this.imageHeight = 184;
		this.inventoryLabelY = this.imageHeight - 94;
	}

	@Override // Render gui
	public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
		this.renderTooltip(matrixStack, mouseX, mouseY);
	}

	@Override // Render gui background
	protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
		int i = (this.width - this.imageWidth) / 2;
		int j = (this.height - this.imageHeight) / 2;
		this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
		this.renderBurning(matrixStack);
		this.renderProgress(matrixStack);
	}

	// Burning animation
	private void renderBurning(PoseStack matrixStack) {
		int lit = super.menu.litTime();
		if(lit > 0) {
			this.blit(matrixStack, this.leftPos + 47, this.topPos + 54 + 12 - lit, 176, 12 - lit, 14, lit + 1);
		}
	}

	// Arrow animation
	private void renderProgress(PoseStack matrixStack) {
		int burn = super.menu.getSmeltingProgress();
		this.blit(matrixStack, this.leftPos + 81, this.topPos + 26, 176, 14, burn + 1, 16);
	}
}
