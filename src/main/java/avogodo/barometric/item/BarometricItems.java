package avogodo.barometric.item;

import avogodo.barometric.Barometric;
import avogodo.barometric.item.custom.WeatherRadioItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BarometricItems {
    public static final Item WEATHER_RADIO = register("weather_radio", WeatherRadioItem::new, new Item.Settings().maxCount(1));

    public static <T extends Item> T register(String name, Function<Item.Settings, T> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), Identifier.of(Barometric.MOD_ID, name));
        T item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }
    public static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.addAfter(Items.SPYGLASS, BarometricItems.WEATHER_RADIO));
    }
}
