package ch.SummerClient.Helper;

import java.awt.*;
import net.minecraft.client.*;

public class Rainbow
{
    public static Color rainbowEffect(final long offset, final float fade) {
        final float hue = (System.nanoTime() + offset) / 1.0E10f % 1.0f;
        final long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0f, 1.0f)), 16);
        final Color c = new Color((int)color);
        return new Color(c.getRed() / 255.0f * fade, c.getGreen() / 255.0f * fade, c.getBlue() / 255.0f * fade, c.getAlpha() / 255.0f);
    }
    
    public static Color rainbowEffectFast(final long offset, final float fade) {
        final float hue = (System.nanoTime() + offset) / 1.0E10f % 1.0f;
        final long color = Long.parseLong(Integer.toHexString(Color.HSBtoRGB(hue, 1.0f, 1.0f)), 19);
        final Color c = new Color((int)color);
        return new Color(c.getRed() / 255.0f * fade, c.getGreen() / 255.0f * fade, c.getBlue() / 255.0f * fade, c.getAlpha() / 255.0f);
    }
    
    public static Color colorLerpv2(final Color start, final Color end, final float ratio) {
        final int red = (int)Math.abs(ratio * start.getRed() + (1.0f - ratio) * end.getRed());
        final int green = (int)Math.abs(ratio * start.getGreen() + (1.0f - ratio) * end.getGreen());
        final int blue = (int)Math.abs(ratio * start.getBlue() + (1.0f - ratio) * end.getBlue());
        return new Color(red, green, blue);
    }
    
    public static void drawChromaString(final String string, final int x, final int y, final boolean shadow) {
        final Minecraft mc = Minecraft.getMinecraft();
        int xTmp = x;
        char[] charArray;
        for (int length = (charArray = string.toCharArray()).length, j = 0; j < length; ++j) {
            final char textChar = charArray[j];
            final long l = System.currentTimeMillis() - (xTmp * 10 - y * 10);
            final int i = Color.HSBtoRGB(l % 2000L / 2000.0f, 0.8f, 0.8f);
            final String tmp = String.valueOf(textChar);
            mc.fontRendererObj.drawString(tmp, (float)xTmp, (float)y, i, shadow);
            xTmp += mc.fontRendererObj.getCharWidth(textChar);
        }
    }
    
    public static int getChromaColor() {
        final Minecraft mc = Minecraft.getMinecraft();
        final int xTmp = 1;
        final long l = System.currentTimeMillis() - (xTmp * 10 - 10);
        final int i = Color.HSBtoRGB(l % 2000L / 2000.0f, 0.8f, 0.8f);
        return i;
    }
    
    public static class RainbowColor
    {
        public static int getColor() {
            final long l = System.currentTimeMillis();
            return Color.HSBtoRGB(l % 2000L / 2000.0f, 0.8f, 0.8f);
        }
    }
}
