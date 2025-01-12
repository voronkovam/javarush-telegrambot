package github.com.voronkovam.jrtb.command;

import org.junit.jupiter.api.DisplayName;

import static github.com.voronkovam.jrtb.command.CommandName.STOP;
import static github.com.voronkovam.jrtb.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-level testing for StopCommand")
public class StopCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}