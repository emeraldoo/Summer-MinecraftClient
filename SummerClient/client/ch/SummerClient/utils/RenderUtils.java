package ch.SummerClient.utils;

import net.minecraft.client.gui.Gui;

public class RenderUtils {

	public static void drawBorderedRect(double x, double y, double x1, double y1, double width, int internalColor,
            int borderColor) {
        rectangle(x + width, y + width, x1 - width, y1 - width, internalColor);
        rectangle(x + width, y, x1 - width, y + width, borderColor);
        rectangle(x, y, x + width, y1, borderColor);
        rectangle(x1 - width, y, x1, y1, borderColor);
        rectangle(x + width, y1 - width, x1 - width, y1, borderColor);
        
        
    }
	
	public static void rectangle(double left, double top, double right, double bottom, int color) {
        Gui.drawRect(left, top, right, bottom, color);
    }

}
