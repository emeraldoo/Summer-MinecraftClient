package ch.SummerClient.mods;

import ch.SummerClient.booleans.booleans;
import ch.SummerClient.hud.HUDManager;
import ch.SummerClient.mods.impl.ModArmorStatus;
import ch.SummerClient.mods.impl.ModCPS;
import ch.SummerClient.mods.impl.ModFPS;
import ch.SummerClient.mods.impl.ModHelloWorld;
import ch.SummerClient.mods.impl.ModKeystrokes;

public class ModInstances {

	private static ModHelloWorld modHelloWorld;
	
	public static ModFPS modFPS;
	
	private static ModCPS modCPS;
	
	private static ModKeystrokes modKeystrokes;
	
//	private static ModArmorStatus modArmorStatus;
	
	public static void register(HUDManager api) {
//		modHelloWorld = new ModHelloWorld();
//		api.register(modHelloWorld);
		
		modFPS = new ModFPS();
		api.register(modFPS);
		
		modCPS = new ModCPS();
		api.register(modCPS);
		
		if(booleans.ModKeystrokes) {
		modKeystrokes = new ModKeystrokes();
		api.register(modKeystrokes);
		
//		modArmorStatus = new ModArmorStatus();
//	        api.register(modArmorStatus);
		
	}
	
//	public static ModHelloWorld getModHelloWorld() {
//		return modHelloWorld;
//	}
	
}
}
	
