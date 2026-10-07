package avogodo.barometric.item.custom;

import avogodo.barometric.component.BarometricComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ClickType;
import net.minecraft.util.Colors;

import java.util.function.Consumer;

public class WeatherRadioItem extends Item {
    public WeatherRadioItem(Settings settings) {
        super(settings);
    }
    @Override
    public Text getName(ItemStack stack) {
        Text name = super.getName(stack);
        return name.copy().setStyle(name.getStyle().withColor(0xffe8a1));
    }
}
