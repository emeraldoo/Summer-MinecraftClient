package ch.SummerClient.mods.impl;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.Helper.Rainbow;
import ch.SummerClient.booleans.booleans;
import ch.SummerClient.hud.ScreenPosition;
import ch.SummerClient.mods.ModDraggable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ModCPS extends ModDraggable{
	public static FontRenderer fr = Minecraft.getMinecraft().fontRendererObj;
	
	private ScreenPosition pos = ScreenPosition.fromAbsolute(1, 30);;
	
	private List<Long> clicks = new ArrayList<Long>();
	private List<Long> clicks2 = new ArrayList<Long>();
	private boolean wasPressed;
	private long lastPressed;
	private boolean wasPressed2;
	private long lastPressed2;

	@Override
	public int getWidth() {
		return this.ufr.getStringWidth("[CPS] : 0000");
	}

	@Override
	public int getHeight() {
		return this.ufr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		
		final boolean pressed = Mouse.isButtonDown(0);
		final boolean rpressed = Mouse.isButtonDown(1);
		
		if(pressed != this.wasPressed) {
			this.lastPressed = System.currentTimeMillis();
			this.wasPressed = pressed;
			if(pressed) {
				this.clicks.add(this.lastPressed);
			}
		}
		
		if (rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10L;
            if (this.wasPressed2 = rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
		
		
		
		
		
		if(booleans.ModCPS) {
			if (booleans.Rainbow) {
				
			
			Rainbow.drawChromaString(" CPS:] " + this.getCPS() + " : " + this.getCPS2(), this.pos.getAbsoluteX() + 1, this.pos.getAbsoluteY() + 1, true);
            Rainbow.drawChromaString("[", this.pos.getAbsoluteX() + 1, this.pos.getAbsoluteY() + 1, true);
		
	}else {
		fr.drawString("[FPS:] " + this.getCPS() + " : " + this.getCPS2(), pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, 0);
	}
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
		
	
	
	private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }
    
    private int getCPS2() {
        final long time2 = System.currentTimeMillis();
        this.clicks2.removeIf(aLong2 -> aLong2 + 1000L < time2);
        return this.clicks2.size();
    }
	
	

}
