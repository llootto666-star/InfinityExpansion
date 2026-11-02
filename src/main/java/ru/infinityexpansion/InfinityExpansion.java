package ru.infinityexpansion;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(InfinityExpansion.MOD_ID)
public final class InfinityExpansion {
    public static final String MOD_ID = "infinityexpansion";

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<InfinityPickaxeItem> INFINITY_PICKAXE =
            ITEMS.register("infinity_pickaxe",
                    () -> new InfinityPickaxeItem(
                            new Item.Properties().stacksTo(1).fireResistant()
                    ));

    public InfinityExpansion(IEventBus modBus) {
        ITEMS.register(modBus);
        modBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(INFINITY_PICKAXE.get());
        }
    }
}