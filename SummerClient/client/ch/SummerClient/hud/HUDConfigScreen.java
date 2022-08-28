package ch.SummerClient.hud;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset.Entry;

import ch.SummerClient.Helper.Help;
import ch.SummerClient.IngameRenderer.Renderer;
import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

public class HUDConfigScreen extends GuiScreen {

	private final HashMap<IRenderer, ScreenPosition> renderers = new HashMap<IRenderer, ScreenPosition>();
	
	private Optional<IRenderer> selectedRenderer = Optional.empty();
	
	private int prevX, prevY;
	
	public HUDConfigScreen(HUDManager api) {
	
		Collection<IRenderer> registeredRenderers = api.getRegisteredRenderers();
		
		for(IRenderer ren : registeredRenderers) {
			if(!ren.isEnabled()) {
				continue;
			}
			
			ScreenPosition position = ren.load();
			
			if(position == null) {
				position = ScreenPosition.fromRelativePosition(0.5, 0.5);
				
			}
			
			adjustBounds(ren, position);
			this.renderers.put(ren, position);
		}
		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		super.drawDefaultBackground();
		
		final float zBackup = this.zLevel;
		this.zLevel = 200;
		
		this.drawHollowRect(0, 0, this.width -1, this.height -1, Help.rainbow(8000, 1));
		
		for(IRenderer renderer : renderers.keySet()) {
			
			ScreenPosition position = renderers.get(renderer);
			
			renderer.renderDummy(position);
			
			this.drawHollowRect(position.getAbsoluteX(), position.getAbsoluteY(), renderer.getWidth(), renderer.getHeight(), Help.rainbow(8000, 1));
			
		}
		
		this.zLevel = zBackup;
	}

	private void drawHollowRect(int x, int y, int w, int h, int color) {
		this.drawHorizontalLine(x, x + w, y, color);
		this.drawHorizontalLine(x, x + w, y + h, color);
		
		this.drawVerticalLine(x, y + h, y, color);
		this.drawVerticalLine(x + w, y + h, y, color);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(keyCode == org.lwjgl.input.Keyboard.KEY_ESCAPE) {
			renderers.entrySet().forEach((entry) -> {
				entry.getKey().save(entry.getValue());
				
			});
			this.mc.displayGuiScreen(null);
			
		}
	}
	
	@Override
	protected void mouseClickMove(int x, int y, int button, long time) {
		if(selectedRenderer.isPresent()) {
			moveSelectedRenderBy(x - prevX, y - prevY);
		}
		
		this.prevX = x;
		this.prevY = y;
		
		
	}

	private void moveSelectedRenderBy(int offsetX, int offsetY) {
		IRenderer renderer = selectedRenderer.get();
		ScreenPosition position = renderers.get(renderer);
		
		position.setAbsolute(position.getAbsoluteX() + offsetX, position.getAbsoluteY() + offsetY);
		
		adjustBounds(renderer, position);
	}
	
	@Override
	public void onGuiClosed() {
		
		for(IRenderer renderer : renderers.keySet()) {
			renderer.save(renderers.get(renderer));
		}
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
	
	private void adjustBounds(IRenderer renderer, ScreenPosition position) {
		
		ScaledResolution resolution = new ScaledResolution(Minecraft.getMinecraft());
		
		int screenWidth = resolution.getScaledWidth();
		int screenHeight = resolution.getScaledHeight();
		
		int AbsoluteX = Math.max(0, Math.min(position.getAbsoluteX(), Math.max(screenWidth - renderer.getWidth(), 0)));
		int AbsoluteY = Math.max(0, Math.min(position.getAbsoluteY(), Math.max(screenHeight - renderer.getHeight(), 0)));
		
		position.setAbsolute(AbsoluteX, AbsoluteY);
		
	}
	
	@Override
	protected void mouseClicked(int x, int y, int mouseButton) throws IOException {
		this.prevX = x;
		this.prevY = y;
		
		loadMouseOver(x, y);
	}

	private void loadMouseOver(int x, int y) {
		this.selectedRenderer = renderers.keySet().stream().filter((java.util.function.Predicate<? super IRenderer>) new MouseOverFinder(x, y)).findFirst();
	}
	
	private class MouseOverFinder implements java.util.function.Predicate<IRenderer> {

		private int MouseX, MouseY;
		
		public MouseOverFinder(int x, int y) {
			this.MouseX = x;
			this.MouseY = y;
		}

		@Override
		public boolean test(IRenderer renderer) {
			
			ScreenPosition position = renderers.get(renderer);
			
			int absoluteX = position.getAbsoluteX();
			int absoluteY = position.getAbsoluteY();
			
			if(MouseX >= absoluteX && MouseX <= absoluteX + renderer.getWidth()) {
				
				if(MouseY >= absoluteY && MouseY <= absoluteY + renderer.getHeight()) {
					
					return true;
					
				}
				
			}
			
			return false;
		}
		
	}
	
}
