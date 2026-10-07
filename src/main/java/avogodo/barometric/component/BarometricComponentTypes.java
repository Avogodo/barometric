package avogodo.barometric.component;

import avogodo.barometric.Barometric;
import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class BarometricComponentTypes {
    public static final ComponentType<Boolean> FREEDOM_MODE =
            register("freedom_mode", builder -> builder.codec(Codec.BOOL));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Barometric.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void init() {
    }
}