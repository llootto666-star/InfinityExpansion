package ru.infinityexpansion;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

/** First UI prototype. Buttons are visual only in this test build. */
public final class InfinityPickaxeScreen extends Screen {
    private boolean magnet = false;
    private boolean trash = false;

    public InfinityPickaxeScreen() { super(Component.translatable("screen.infinityexpansion.pickaxe")); }

    @Override
    protected void init() {
        int x = width / 2 - 100;
        int y = height / 2 - 42;
        addRenderableWidget(Button.builder(toggle("screen.infinityexpansion.magnet", magnet), b -> {
            magnet = !magnet; b.setMessage(toggle("screen.infinityexpansion.magnet", magnet));
        }).bounds(x, y, 200, 20).build());
        addRenderableWidget(Button.builder(toggle("screen.infinityexpansion.trash", trash), b -> {
            trash = !trash; b.setMessage(toggle("screen.infinityexpansion.trash", trash));
        }).bounds(x, y + 26, 200, 20).build());
        addRenderableWidget(Button.builder(Component.translatable("screen.infinityexpansion.close"), b -> onClose())
            .bounds(x, y + 62, 200, 20).build());
    }

    private Component toggle(String key, boolean enabled) {
        return Component.translatable(key).append(Component.literal(enabled ? ": ВКЛ" : ": ВЫКЛ"));
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        renderBackground(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(font, title, width / 2, height / 2 - 68, 0xFFFFFF);
        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override public boolean isPauseScreen() { return false; }
}
