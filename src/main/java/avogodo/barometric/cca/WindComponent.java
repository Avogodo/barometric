package avogodo.barometric.cca;

import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.ComponentV3;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class WindComponent implements AutoSyncedComponent, ComponentV3 {
    public WindComponent(World provider) {
        this.provider = provider;
    }

    private float speed;
    private int direction;
    private final World provider;

    public static WindComponent get(@NotNull World world) {
        return (WindComponent) BarometricComponents.WIND.get(world);
    }

    public float getSpeed() {
        return this.speed;
    }

    public void setSpeed(float value) {
        this.speed = value;
        BarometricComponents.WIND.sync(this.provider);
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int value) {
        this.direction = value;
        BarometricComponents.WIND.sync(this.provider);
    }

    @Override
    public void readData(ReadView readView) {
        this.speed = readView.getFloat("barometric:wind_speed", 0);
        this.direction = readView.getInt("barometric:wind_direction", 0);
    }

    @Override
    public void writeData(WriteView writeView) {
        writeView.putFloat("barometric:wind_speed", this.speed);
        writeView.putInt("barometric:wind_direction", this.direction);
    }
}
