package github.com.voronkovam.jrtb.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class JavaRushTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String username;
    @Value("${bot.token}")
    private String token;

   /* точка входа, куда будут поступать сообщения от пользователей. Отсюда будет идти вся новая логика;
    Здесь все предельно просто: мы проверяем, что сообщение реально существует, потому извлекаем само
    сообщение (message) и айдишник чата (chatId), в котором идет переписка.
       Далее мы создаем объект для отправки сообщения SendMessage,
       передаем в него само сообщение и айдишник чата — то есть то, что отправить боту и куда.
    */

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String chatId = update.getMessage().getChatId().toString();

            SendMessage sm = new SendMessage();
            sm.setChatId(chatId);
            sm.setText(message);

            try {
                execute(sm);
            } catch (TelegramApiException e) {
                //todo add logging to the project.
                e.printStackTrace();
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




