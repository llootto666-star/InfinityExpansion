package ru.infinityexpansion;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = InfinityExpansion.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public final class ClientEvents {
    public static final KeyMapping CONFIGURE = new KeyMapping(
        "key.infinityexpansion.configure", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_V,
        "key.categories.infinityexpansion");

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event) { event.register(CONFIGURE); }

    @EventBusSubscriber(modid = InfinityExpansion.MOD_ID, value = Dist.CLIENT)
    public static final class InputHandler {
        @SubscribeEvent
        public static void onKey(InputEvent.Key event) {
            Minecraft mc = Minecraft.getInstance();
            if (CONFIGURE.consumeClick() && mc.player != null && mc.screen == null) {
                mc.setScreen(new InfinityPickaxeScreen());
            }
        }
    }
}
