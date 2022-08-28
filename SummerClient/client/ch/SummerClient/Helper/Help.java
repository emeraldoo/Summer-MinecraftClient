package ch.SummerClient.Helper;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

public class Help {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	public static FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	public static ScaledResolution sr = new ScaledResolution(mc);
		public static int rainbow(final int speed, final int offset) {
	        float hue = (float)((System.currentTimeMillis() + offset) % speed);
	        hue /= speed;
	        return Color.getHSBColor(hue, 0.5f, 1.0f).getRGB();
		
		
	}
	

}

