package github.com.voronkovam.jrtb.command;

import static github.com.voronkovam.jrtb.command.CommandName.STAT;
import static github.com.voronkovam.jrtb.command.StatCommand.STAT_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;

public class StatCommandTest extends AbstractCommandTest {
    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(sendBotMessageService, telegramUserService);
    }
}