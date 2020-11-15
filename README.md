# Particles
Simple to use engine, that allow you to make an effect of flying snowballs.

# Example 
```java
public final class MyGUI extends GuiScreen {

    private final ParticleManager particles = new ParticleManager();

    @Override
    public void initGui() {
        this.particles.register(new ScaledResolution(this.mc));
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.particles.publish(new ScaledResolution(this.mc), mouseX, mouseY);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
```

# Contribution
Feel free to contribute
