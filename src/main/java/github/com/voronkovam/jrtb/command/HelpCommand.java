package github.com.voronkovam.jrtb.command;

import github.com.voronkovam.jrtb.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static github.com.voronkovam.jrtb.command.CommandName.ADD_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.DELETE_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.HELP;
import static github.com.voronkovam.jrtb.command.CommandName.LIST_GROUP_SUB;
import static github.com.voronkovam.jrtb.command.CommandName.START;
import static github.com.voronkovam.jrtb.command.CommandName.STAT;
import static github.com.voronkovam.jrtb.command.CommandName.STOP;


/**
 * Help {@link Command}.
 */
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("✨Дотупные команды✨\n\n"

                    + "Начать\\закончить работу с ботом:\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"

                    + "Работа с подписками на группы:\n"
                    + "%s - подписаться на группу статей\n"
                    + "%s - отписаться от группы статей\n"
                    + "%s - получить список групп, на которые подписан\n\n"

                    + "%s - получить помощь в работе со мной\n"
            +"%s - получить мою статистику использования\n",
            START.getCommandName(), STOP.getCommandName(), ADD_GROUP_SUB.getCommandName(),
            DELETE_GROUP_SUB.getCommandName(), LIST_GROUP_SUB.getCommandName(), HELP.getCommandName(), STAT.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
