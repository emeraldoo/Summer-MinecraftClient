package ch.SummerClient.IngameRenderer;

import ch.SummerClient.Helper.Help;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;

public class Renderer extends GuiIngame{

	public Renderer(Minecraft mcIn) {
		super(mcIn);
	}
	
	public void func_181551_a(ScaledResolution p_181551_1_) {
		super.func_181551_a(p_181551_1_);
		
		int ping; 
		
		if (Help.mc.isSingleplayer()) {
			ping = 0;
		}else{
			ping = (int)Minecraft.getMinecraft().getCurrentServerData().pingToServer; 
		}
		
//		Help.renderIngameOverlay("[FPS:] " + Help.mc.getDebugFPS(), 2, 20, 	0x6481);
//		Help.renderIngameOverlay("[Ping:] " + ping, 2, 30, 	0x6481);
//		
}



		
		
	}


