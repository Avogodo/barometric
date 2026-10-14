package avogodo.barometric.weather.events.spoilers;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.Objects;
import java.util.function.Predicate;

public class RemainsWeatherEvent extends WeatherEvent {
    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getIdentifier() {
        return "petrichor:remains";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("☈ Fractalline Haze");
    }

    @Override
    public boolean activeCondition(World world) {
        Predicate<RegistryKey<DimensionType>> p = d -> Objects.equals(d.getValue(), Identifier.of("petrichor", "remains"));
        return world.getDimensionEntry().matches(p);
    }

    @Override
    public float windSpeedMultiplier() {
        return 3;
    }

    @Override
    public float windSpeedMaximum() {
        return 1336;
    }

    @Override
    public float windSpeedMinimum() {
        return 1024;
    }

    @Override
    public String windDirectionOverride() {
        return "Omnidirectional";
    }

    @Override
    public boolean cancelWindMovement() {
        return true;
    }
}
