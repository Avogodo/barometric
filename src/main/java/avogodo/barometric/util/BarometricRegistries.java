package avogodo.barometric.util;

import avogodo.barometric.Barometric;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public class BarometricRegistries {
    public static final RegistryKey<Registry<RadioOverrideRegistryEntry>> RADIO_OVERRIDE_REGISTRY_KEY =
            RegistryKey.ofRegistry(Barometric.id("radio_override_registry"));

    public static void initialize() {
        DynamicRegistries.registerSynced(RADIO_OVERRIDE_REGISTRY_KEY, RadioOverrideRegistryEntry.CODEC);
    }
}
