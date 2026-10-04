package avogodo.barometric.component;

import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class BarometricWeatherComponent implements BarometricWeatherInterfaceComponent, AutoSyncedComponent {
    public BarometricWeatherComponent(World provider) {
        this.provider = provider;
    }

    private String value;
    private final World provider;

    public static BarometricWeatherComponent get(@NotNull World world) {
        return (BarometricWeatherComponent) BarometricComponents.BAROMETRIC_WEATHER.get(world);
    }

    @Override
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
        BarometricComponents.BAROMETRIC_WEATHER.sync(this.provider);
    }

    @Override
    public void readData(ReadView readView) {
        this.value = readView.getString("barometric:weather", "if you're somehow reading this string, something has gone very, very wrong. -avo, barometric devenv");
    }

    @Override
    public void writeData(WriteView writeView) {
        writeView.putString("barometric:weather", this.value);
    }
}
