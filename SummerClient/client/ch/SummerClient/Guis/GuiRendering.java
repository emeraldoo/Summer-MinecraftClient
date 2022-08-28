package ch.SummerClient.Guis;

import java.io.IOException;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.booleans.booleans;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;

public class GuiRendering extends GuiScreen
{

	int j = this.height / 4 + 48;
	protected String field_146442_a = "Render";
	public GuiRendering(GuiIngameMenu guiIngameMenu) {
		
	}
	@Override
	public void initGui()
	{
		
//		this.buttonList.clear();
//		if (booleans.Fullbright) {
//		 this.buttonList.add(new GuiButton(1, this.width / 2 - 120, this.height / 4 + 48 , 98, 20, I18n.format("Brightness", new Object[0])));
//		 
//		}
		
		
		 this.buttonList.add(new GuiButton(2, this.width / 2 + 20, this.height / 4 + 48 , 98, 20, I18n.format("BlockOverlayRGB", new Object[0])));
		 this.buttonList.add(new GuiButton(3, this.width / 2 - 120, this.height / 4 + 98 , 98, 20, I18n.format("OldAnimations", new Object[0])));
		 this.buttonList.add(new GuiButton(4, this.width / 2 + 20, this.height / 4 + 98 , 98, 20, I18n.format("Rainbow", new Object[0])));
		 this.buttonList.add(new GuiButton(1, this.width / 2 - 120, this.height / 4 + 48 , 98, 20, I18n.format("Brightness", new Object[0])));
	}
	
	@Override
	
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if(button.id == 1) {
			booleans.Fullbright = !booleans.Fullbright;
		}
		
		if(button.id == 2) {
			booleans.BlockOverlayRGB = !booleans.BlockOverlayRGB;
		}
		
		if(button.id == 3) {
			booleans.oldAnimations = !booleans.oldAnimations;
		}
		
		if(button.id == 4) {
			booleans.Rainbow = !booleans.Rainbow;
		}
				
	}
	
		@Override
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		{
			this.drawDefaultBackground();
			this.drawCenteredString(this.fontRendererObj, this.field_146442_a, this.width / 2, 15, 16777215);
			super.drawScreen(mouseX, mouseY, partialTicks);

		}
		
	}
	
}
		
	
