package net.naimad.client.apperance.particles.impl;

import net.minecraft.client.gui.ScaledResolution;
import net.naimad.client.apperance.particles.utilities.MathUtility;
import net.naimad.client.utilities.ColoursUtility;
import net.naimad.client.utilities.RenderUtility;

/**
 * @author Naimad
 * @since 15/11/2020
 */

public final class Particle {

    private final float size;
    private int aimX, aimY;
    private int x, y;

    private final int aimOpacity;
    private int opacity;

    public Particle(final int x, final int y, final float size, final int opacity) {
        this.x = x;
        this.y = y;

        this.size = size;

        this.aimOpacity = opacity;
    }

    public void update(final ScaledResolution res) {
        if ((this.aimX == 0 || this.aimY == 0) || (this.x == this.aimX && this.y == this.aimY)) {
            this.aimX = (int) MathUtility.getRandomInRange(0, res.getScaledWidth());
            this.aimY = (int) MathUtility.getRandomInRange(0, res.getScaledHeight());
        }

        if (this.x > this.aimX)
            this.x -= 1;
        else if (this.aimX > this.x)
            this.x += 1;

        if (this.y > this.aimY)
            this.y -= 1;
        else if (this.aimY > this.y)
            this.y += 1;
    }

    public void publish() {
        if (this.opacity < this.aimOpacity) 
            this.opacity += 2;
        
        RenderUtility.drawFilledCircle(this.x, this.y, this.size, ColoursUtility.getRGBA(255, 255, 255, this.opacity));
    }

    public void makeLines(final int x, final int y) {
        RenderUtility.drawLine(this.x, this.y, x, y, 1, ColoursUtility.getRGBA(255, 255, 255, (int) MathUtility.getRandomInRange(50, 255)));
    }

    public void setAim(final int x, final int y) {
        this.aimX = x;
        this.aimY = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
