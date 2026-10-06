package avogodo.barometric.component;

import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistryV3;
import org.ladysnake.cca.api.v3.world.WorldComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.world.WorldComponentInitializer;

public final class BarometricComponents implements WorldComponentInitializer {
    public static final ComponentKey<WindSpeedComponent> WIND_SPEED =
            ComponentRegistryV3.INSTANCE.getOrCreate(Identifier.of("barometric:wind_speed"), WindSpeedComponent.class);
    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {
        //registry.register(BAROMETRIC_WEATHER, BarometricWeatherComponent::new);
        registry.register(WIND_SPEED, WindSpeedComponent::new);
    }
}
