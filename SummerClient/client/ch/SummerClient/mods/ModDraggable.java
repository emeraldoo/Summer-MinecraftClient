package ch.SummerClient.mods;

import ch.SummerClient.hud.IRenderer;
import ch.SummerClient.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer{

	public final int getLineOffset(ScreenPosition pos, int lineNumb) {
		return pos.getAbsoluteY() + getLineOffset(lineNumb);
	}

	private int getLineOffset(int lineNumb) {
		return(this.ufr.FONT_HEIGHT + 3 ) * lineNumb;
	}
	
}
