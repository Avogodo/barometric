package avogodo.barometric.item.custom;

import avogodo.barometric.component.WindSpeedComponent;
import avogodo.barometric.util.WeatherEventHandler;
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
            player.sendMessage(Text.literal(WeatherEventHandler.getPrimaryDescriptor(world) +" | "+ world.getBiome(player.getBlockPos()).value().getTemperature()+"°" +" | "+ Math.round(WindSpeedComponent.get(world).getValue())+"mph"), true);
        }
    }

        @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
        }
        return ActionResult.PASS;
    }


}
