package avogodo.barometric.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record RadioOverrideRegistryEntry(String name, int priority) {
    public static final Codec<RadioOverrideRegistryEntry> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.STRING.fieldOf("name").forGetter(RadioOverrideRegistryEntry::name),
                    Codec.INT.fieldOf("priority").forGetter(RadioOverrideRegistryEntry::priority)
            ).apply(instance, RadioOverrideRegistryEntry::new)
    );
}
