package ch.SummerClient;

import java.awt.Color;
import java.util.HashMap;

import org.lwjgl.opengl.Display;
import org.omg.CORBA.PUBLIC_MEMBER;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.booleans.booleans;
import ch.SummerClient.event.EventManager;
import ch.SummerClient.event.EventTarget;
import ch.SummerClient.hud.HUDManager;
import ch.SummerClient.mods.ModInstances;
import me.tireman.hexa.alts.AltManager;
import net.minecraft.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

public class ClientMain {

	private static final ClientMain INSTANCE = new ClientMain();
	public AltManager altManager;
	

	public static final ClientMain getInstance() {
		return INSTANCE;

	}

	public static HUDManager hudManager;

	private static HashMap<String, String> capelist = new HashMap<>();

	public void nameChange() {

		Display.setTitle("SummerClient v 1.1");

        EventManager.register(new HudRegister());

		setupcapelist();

		EventManager.register(this);

	}

	public void start() {
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
	}

	
	

	public static void ingameGUI() {
		if (booleans.Info) {
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("SummerClient", 1, 1, Help.rainbow(8000, 1));
	}
	}

	private static void setupcapelist() {
		capelist.put("d33de306-5380-4c61-acfa-214eb55bd99c", "capes/emeraldo_cape.png");
		capelist.put("e09dd9f5-49af-4f7d-8d6c-97814a297070", "capes/lsh_cape.png");
		capelist.put("e1657cc9-0472-450a-9a5a-60863f744dba", "capes/opwebn_cape.png");
		capelist.put("dedb5d9a-9ba6-4e3f-8bd5-f299679031f1", "capes/silvan_cape.png");
		capelist.put("eea9eb4c-6bc6-4fd7-964e-8ab31024aa61", "capes/sophia_cape.png");
		capelist.put("eea9eb4c-6bc6-4fd7-964e-8ab31024aa61", "capes/sophia_cape.png");
		

		
		
	}

	public static boolean hasCape(AbstractClientPlayer player) {
		return capelist.containsKey(player.getGameProfile().getId().toString());
	}

	public static ResourceLocation getCape(AbstractClientPlayer player) {
		return new ResourceLocation(capelist.get(player.getGameProfile().getId().toString()));
	}

}