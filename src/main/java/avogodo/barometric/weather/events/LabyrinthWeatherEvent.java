package avogodo.barometric.weather.events;

import avogodo.barometric.weather.WeatherEvent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.function.Predicate;

public class LabyrinthWeatherEvent extends WeatherEvent {

    // hi apostasy code reviewer! it's come to my attention (asher leaked it) that big l will be taking place during the mist event, in a custom dimension.
    // thus, i've added a lore-inaccurate weather event that activates in any dimension besides the vanilla three (including the big l dimension by fallback)
    // i don't have access to the code, dimension id, nor do i know how to enter the dimension. i'm fully under the assumption that this'll even work.
    // please don't freak out.

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getIdentifier() {
        return "apostasy:labyrinth";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal(String.valueOf(((float)Math.random()*100)/100)).setStyle(Text.empty().getStyle().withObfuscated(true));
    }

    @Override
    public boolean activeCondition(World world) {
        Predicate<RegistryKey<DimensionType>> p = d -> !d.equals(DimensionTypes.OVERWORLD) && !d.equals(DimensionTypes.THE_NETHER) && !d.equals(DimensionTypes.THE_END);
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
    public boolean omnidirectionalWinds() {
        return true;
    }
}
