package ch.SummerClient.mods.impl;

import java.awt.Color;

import com.sun.jna.platform.unix.X11.Font;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.Helper.Rainbow;
import ch.SummerClient.booleans.booleans;
import ch.SummerClient.hud.ScreenPosition;
import ch.SummerClient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ModFPS extends ModDraggable {
public static FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;

	private ScreenPosition pos = ScreenPosition.fromAbsolute(1, 20);;
	
	@Override
	public int getWidth() {
		return this.ufr.getStringWidth("[FPS] : 1000");
	}

	@Override
	public int getHeight() {
		return this.ufr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		if(booleans.ModFPS) {
			if(booleans.Rainbow) {
			Rainbow.drawChromaString(" FPS:] " + mc.getDebugFPS(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, true);
			Rainbow.drawChromaString("[", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, true);
			}else {
				fr.drawString("[FPS:] " + mc.getDebugFPS(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0);
			}
	}
	}
	
	
	private int Rainbow(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void renderDummy(final ScreenPosition pos) {
		if (booleans.Rainbow) {
			
		
		Rainbow.drawChromaString("FPS : 1000] ", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, true);
		Rainbow.drawChromaString("[", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, true);
		}
			else {
				fr.drawString("[FPS : 1000]", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0);
            }
		}
	

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}

}
