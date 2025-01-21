package github.com.voronkovam.jrtb.command;

import com.google.common.collect.ImmutableMap;
import github.com.voronkovam.jrtb.command.annotation.AdminCommand;
import github.com.voronkovam.jrtb.javarushclient.JavaRushGroupClient;
import github.com.voronkovam.jrtb.service.GroupSubService;
import github.com.voronkovam.jrtb.service.SendBotMessageService;
import github.com.voronkovam.jrtb.service.StatisticsService;
import github.com.voronkovam.jrtb.service.TelegramUserService;

import java.util.List;

import static github.com.voronkovam.jrtb.command.CommandName.ADD_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.ADMIN_HELP;
import static github.com.voronkovam.jrtb.command.CommandName.DELETE_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.HELP;
import static github.com.voronkovam.jrtb.command.CommandName.LIST_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.NO;
import static github.com.voronkovam.jrtb.command.CommandName.START;
import static github.com.voronkovam.jrtb.command.CommandName.STAT;
import static github.com.voronkovam.jrtb.command.CommandName.STOP;
import static java.util.Objects.nonNull;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;
    private final List<String> admins;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
        JavaRushGroupClient javaRushGroupClient, GroupSubService groupSubService,
                List<String> admins, StatisticsService statisticsService) {
        this.admins = admins;

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .put(STAT.getCommandName(), new StatCommand(sendBotMessageService, statisticsService))
                .put(ADD_GROUP_SUB.getCommandName(), new AddGroupSubCommand(sendBotMessageService, javaRushGroupClient, groupSubService))
                .put(LIST_GROUP_SUB.getCommandName(), new ListGroupSubCommand(sendBotMessageService, telegramUserService))
                .put(DELETE_GROUP_SUB.getCommandName(),
                        new DeleteGroupSubCommand(sendBotMessageService, groupSubService, telegramUserService))
                .put(ADMIN_HELP.getCommandName(), new AdminHelpCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

//    public Command retrieveCommand(String commandIdentifier) {
//        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
//    }

    public Command retrieveCommand(String commandIdentifier, String username) {
        Command orDefault = commandMap.getOrDefault(commandIdentifier, unknownCommand);
        if (isAdminCommand(orDefault)) {
            if (admins.contains(username)) {
                return orDefault;
            } else {
                return unknownCommand;
            }
        }
        return orDefault;
    }

    private boolean isAdminCommand(Command command) {
        return nonNull(command.getClass().getAnnotation(AdminCommand.class));
    }
}
