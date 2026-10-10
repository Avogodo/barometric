package avogodo.barometric.weather.events;

import avogodo.barometric.util.WindHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class DerechoWeatherEvent extends ThunderWeatherEvent {
    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String getIdentifier() {
        return "barometric:derecho";
    }

    @Override
    public Text getDescriptor() {
        return Text.literal("⚡ Derecho");
    }

    @Override
    public boolean activeCondition(World world) {
        return world.isThundering() && WindHandler.getWindSpeed(world) >= 38;
    }

    @Override
    public float windSpeedMinimum() {
        return 64;
    }

    @Override
    public float windSpeedMaximum() {
        return 128;
    }

    @Override
    public float windSpeedRate() {
        return 0.1f;
    }

    @Override
    public Identifier rainTexture() {
        return Identifier.of("barometric", "textures/environment/derecho_rain.png");
    }
}
