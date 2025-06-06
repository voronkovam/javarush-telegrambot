package github.com.voronkovam.jrtb.bot;


import github.com.voronkovam.jrtb.command.CommandContainer;
import github.com.voronkovam.jrtb.javarushclient.JavaRushGroupClient;
import github.com.voronkovam.jrtb.service.GroupSubService;
import github.com.voronkovam.jrtb.service.SendBotMessageServiceImpl;
import github.com.voronkovam.jrtb.service.StatisticsService;
import github.com.voronkovam.jrtb.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static github.com.voronkovam.jrtb.command.CommandName.NO;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;
    private final CommandContainer commandContainer;

    @Autowired
    public JavaRushTelegramBot (TelegramUserService telegramUserService, JavaRushGroupClient groupClient, GroupSubService groupSubService,
                               @Value("#{'${bot.admins}'.split(',')}") List<String> admins, StatisticsService statisticsService) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService,
              groupClient,groupSubService,admins,statisticsService);

    }




   /* точка входа, куда будут поступать сообщения от пользователей. Отсюда будет идти вся новая логика;
    Здесь все предельно просто: мы проверяем, что сообщение реально существует, потому извлекаем само
    сообщение (message) и айдишник чата (chatId), в котором идет переписка.
       Далее мы создаем объект для отправки сообщения SendMessage,
       передаем в него само сообщение и айдишник чата — то есть то, что отправить боту и куда.
    */

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String username = update.getMessage().getFrom().getUserName();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier, username).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName(), username).execute(update);
            }
        }
    }

    //  здесь нужно добавить username нашего бота, к которому будем соединяться;
    @Override
    public String getBotUsername() {
        return username;
    }


    //токен бота
    @Override
    public String getBotToken() {
        return token;
    }
}



//@Override
//    public void onUpdateReceived(Update update) {
//        if(update.hasMessage() && update.getMessage().hasText()) {
//            String message = update.getMessage().getText().trim();
//            String chatId = update.getMessage().getChatId().toString();
//
//            SendMessage sm = new SendMessage();
//            sm.setChatId(chatId);
//            sm.setText(message);
//
//            try {
//                execute(sm);
//            } catch (TelegramApiException e) {
//                //todo add logging to the project.
//                e.printStackTrace();
//            }
//        }
//    }
