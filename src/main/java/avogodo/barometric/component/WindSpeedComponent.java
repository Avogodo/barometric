package avogodo.barometric.component;

import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.ComponentV3;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class WindSpeedComponent implements AutoSyncedComponent, ComponentV3 {
    public WindSpeedComponent(World provider) {
        this.provider = provider;
    }

    private float value;
    private final World provider;

    public static WindSpeedComponent get(@NotNull World world) {
        return (WindSpeedComponent) BarometricComponents.WIND_SPEED.get(world);
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
        BarometricComponents.WIND_SPEED.sync(this.provider);
    }

    @Override
    public void readData(ReadView readView) {
        this.value = readView.getFloat("barometric:wind_speed", 0);
    }

    @Override
    public void writeData(WriteView writeView) {
        writeView.putFloat("barometric:wind_speed", this.value);
    }
}
