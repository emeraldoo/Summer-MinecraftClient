package ch.SummerClient.mods.impl;

import org.lwjgl.opengl.GL11;

import ch.SummerClient.booleans.booleans;
import ch.SummerClient.hud.ScreenPosition;
import ch.SummerClient.mods.ModDraggable;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModArmorStatus extends ModDraggable
{
    ScreenPosition pos;
    
    public ModArmorStatus() {
        this.pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
    }
    
    @Override
    public int getWidth() {
        return 60;
    }
    
    @Override
    public int getHeight() {
        return 65;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
    	if(booleans.ModArmor) {	
        for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
            final ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
            this.renderItemStack(pos, i, itemStack);
        }
    	}
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
    	if(booleans.ModArmor) {
        this.renderItemStack(pos, 3, new ItemStack(Items.diamond_helmet));
        this.renderItemStack(pos, 2, new ItemStack(Items.diamond_chestplate));
        this.renderItemStack(pos, 1, new ItemStack(Items.diamond_leggings));
        this.renderItemStack(pos, 0, new ItemStack(Items.diamond_boots));
    }
    }
    private void renderItemStack(final ScreenPosition pos, final int i, final ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        if(booleans.ModArmor) {	
        final int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            final double damage = (is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            this.ufr.drawString(String.format("%.2f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, -1);
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
    }
    
    @Override
    public void save(final ScreenPosition pos) {
        this.pos = pos;
    }
    
    @Override
    public ScreenPosition load() {
        return this.pos;
    }
}
