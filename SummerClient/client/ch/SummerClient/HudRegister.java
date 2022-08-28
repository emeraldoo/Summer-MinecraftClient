package ch.SummerClient;

import ch.SummerClient.event.EventTarget;
import ch.SummerClient.event.impl.ClientTickEvent;
import net.minecraft.client.Minecraft;

public class HudRegister {
	
	@EventTarget
	public void fooBlah3001(ClientTickEvent e) {
		if(Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
			ClientMain.getInstance().hudManager.openConfigScreen();
		}
	}

}
