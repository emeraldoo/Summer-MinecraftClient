package ch.SummerClient.cosmetics;

import java.awt.Color;

import ch.SummerClient.Helper.Help;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticController {
	
	public static boolean shouldRenderTopHat(AbstractClientPlayer player) {
		
		if(player.getUniqueID() == Minecraft.getMinecraft().thePlayer.getUniqueID()) 
			return true;
		
		return false;
	}
	
	public static float[] getTopHatColor(AbstractClientPlayer player) {
		Color rgb = new Color(Help.rainbow(2000, 1));
		float[] colorComponets = rgb.getColorComponents(null);
		return new float[] {colorComponets[0], colorComponets[1], colorComponets[2]};
	}
	
	public static boolean shouldRenderEyes(AbstractClientPlayer player) {
		if(player.getUniqueID() == Minecraft.getMinecraft().thePlayer.getUniqueID()) {
			return true;
		}
		return false;
	}
	
}
