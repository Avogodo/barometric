package avogodo.barometric.component;

import avogodo.barometric.util.WeatherEvent;
import org.ladysnake.cca.api.v3.component.ComponentV3;

import java.util.ArrayList;

public interface BarometricWeatherInterfaceComponent extends ComponentV3 {
    String getValue();
}

