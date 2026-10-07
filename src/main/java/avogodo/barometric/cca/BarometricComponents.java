package avogodo.barometric.cca;

import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import org.ladysnake.cca.api.v3.world.WorldComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.world.WorldComponentInitializer;

public final class BarometricComponents implements WorldComponentInitializer {
    public static final ComponentKey<WindComponent> WIND =
            ComponentRegistryV3.INSTANCE.getOrCreate(Identifier.of("barometric:wind"), WindComponent.class);
    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        registry.register(WIND, WindComponent::new);
    }
}
