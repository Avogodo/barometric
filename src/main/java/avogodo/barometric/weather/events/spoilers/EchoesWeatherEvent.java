package avogodo.barometric.weather.events.spoilers;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.Objects;
import java.util.function.Predicate;

public class EchoesWeatherEvent extends WeatherEvent {

    // hi apostasy code reviewer! it's come to my attention (asher leaked it) that big l will be taking place during the mist event, in a custom dimension.
    // thus, i've added a lore-inaccurate weather event that corresponds to the dimension id (which i assume to be perpetuity:the_echoes from /execute in)
    // i don't have access to the code, nor have i entered the dimension, for my sake and the devs'. i'm fully under the assumption that this'll even work.
    // please don't freak out.

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getIdentifier() {
        return "perpetuity:the_echoes";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("☽ ???");
    }

    @Override
    public boolean activeCondition(World world) {
        Predicate<RegistryKey<DimensionType>> p = d -> Objects.equals(d.getValue(), Identifier.of("perpetuity", "the_echoes"));
        return world.getDimensionEntry().matches(p);
    }

    @Override
    public float windSpeedMultiplier() {
        return 2;
    }

    @Override
    public float windSpeedMinimum() {
        return 850;
    }

    @Override
    public float windSpeedMaximum() {
        return 860;
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
