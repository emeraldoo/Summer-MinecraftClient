package ch.SummerClient.mods;

import ch.SummerClient.event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class Mod
{
    private boolean isEnabled;
    protected final Minecraft mc;
    protected final FontRenderer ufr;
    
    public Mod() {
        this.isEnabled = true;
        this.mc = Minecraft.getMinecraft();
        this.ufr = this.mc.fontRendererObj;
        this.setEnabled(this.isEnabled);
    }
    
    public void setEnabled(final boolean isEnabled) {
        this.isEnabled = isEnabled;
        if (isEnabled) {
            EventManager.register(this);
        }
        else {
            EventManager.unregister(this);
        }
    }
    
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
