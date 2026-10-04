package avogodo.barometric.item.custom;

import avogodo.barometric.Barometric;
import avogodo.barometric.component.BarometricWeatherComponent;
import avogodo.barometric.util.BarometricWeather;
import avogodo.barometric.util.RadioHandler;
import avogodo.barometric.util.RadioOverride;
import avogodo.barometric.util.WeatherEvent;
import avogodo.barometric.weather.RainWeatherEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jspecify.annotations.Nullable;

import java.util.Map;

public class WeatherRadioItem extends Item {
    public WeatherRadioItem(Settings settings) {
        super(settings);
    }
    @Override
    public Text getName(ItemStack stack) {
        Text name = super.getName(stack);
        return name.copy().setStyle(name.getStyle().withColor(0xffe8a1));
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof PlayerEntity player && player.getStackInHand(Hand.MAIN_HAND).isOf(stack.getItem())) {
            player.sendMessage(Text.literal(RadioHandler.getPrimaryDescriptor(world)), true);
        }
    }

        @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
//            for (Map.Entry<String, WeatherEvent> s : Barometric.WEATHER_MAP.entrySet()) {
//                Barometric.LOGGER.info(s.getKey());
//            }
//            BarometricWeather.clearWeatherEvent(world);
//            BarometricWeather.tryQueueWeatherEvent(new RainWeatherEvent(), world);
//            //Barometric.LOGGER.info(BarometricWeatherComponent.get(world).getValue());

        }

        return ActionResult.PASS;
    }


}
