package ch.SummerClient.mods.impl;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.hud.ScreenPosition;
import ch.SummerClient.mods.ModDraggable;

public class ModHelloWorld extends ModDraggable{

	private ScreenPosition pos = ScreenPosition.fromAbsolute(0, 0);
	
	@Override
	public int getWidth() {
		return this.ufr.getStringWidth("Hello World (Dummy)");
	}

	@Override
	public int getHeight() {
		return this.ufr.FONT_HEIGHT;
	}

	@Override
	public void render(ScreenPosition pos) {
		this.ufr.drawString("Hello World", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, -1);
	}
	
	
	@Override
	public void renderDummy(final ScreenPosition pos) {
		this.ufr.drawString("Hello World (Dummy)", pos.getAbsoluteX() + 1, pos.getAbsoluteY() + 1, Help.rainbow(3000, 1));
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
