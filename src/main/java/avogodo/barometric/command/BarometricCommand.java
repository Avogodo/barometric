package avogodo.barometric.command;

import avogodo.barometric.cca.WindComponent;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;

public class BarometricCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(LiteralArgumentBuilder.<ServerCommandSource>literal("barometric")
                .then(CommandManager.literal("setWindSpeed")
                    .then(CommandManager.argument("speed", IntegerArgumentType.integer())
                        .executes(commandContext -> {
                WindComponent.get(commandContext.getSource().getWorld()).setSpeed(IntegerArgumentType.getInteger(commandContext, "speed"));
                return Command.SINGLE_SUCCESS;
                }
        ))));
    }
}