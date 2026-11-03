package avogodo.barometric.cca;

import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.ladysnake.cca.api.v3.component.ComponentV3;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class AlertComponent implements AutoSyncedComponent, ComponentV3 {
    public AlertComponent(World provider) {
        this.provider = provider;
    }

    private float cooldown;
    private final World provider;

    public static AlertComponent get(@NotNull World world) {
        return (AlertComponent) BarometricComponents.ALERT.get(world);
    }

    public float getCooldown() {
        return this.cooldown;
    }

    public void setCooldown(float value) {
        this.cooldown = value;
        BarometricComponents.WIND.sync(this.provider);
    }

    public void decrementCooldown() {
        this.cooldown--;
        BarometricComponents.WIND.sync(this.provider);
    }

    @Override
    public void readData(ReadView readView) {
        this.cooldown = readView.getFloat("barometric:alert_cooldown", 0);
    }

    @Override
    public void writeData(WriteView writeView) {
        writeView.putFloat("barometric:alert_cooldown", this.cooldown);
    }
}