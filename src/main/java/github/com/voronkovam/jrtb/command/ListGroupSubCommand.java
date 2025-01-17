package github.com.voronkovam.jrtb.command;

import github.com.voronkovam.jrtb.repository.entity.GroupSub;
import github.com.voronkovam.jrtb.repository.entity.TelegramUser;
import github.com.voronkovam.jrtb.service.SendBotMessageService;
import github.com.voronkovam.jrtb.service.TelegramUserService;
import org.springframework.util.CollectionUtils;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.ws.rs.NotFoundException;

import java.util.stream.Collectors;

import static github.com.voronkovam.jrtb.command.CommandUtils.getChatId;


/**
 * {@link Command} for getting list of {@link GroupSub}.
 */
public class ListGroupSubCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public ListGroupSubCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        //todo add exception handling
        TelegramUser telegramUser = telegramUserService.findByChatId(getChatId(update))
                .orElseThrow(NotFoundException::new);
        String message;
    //    if(telegramUser.getGroupSub().isEmpty()) {
        if(CollectionUtils.isEmpty(telegramUser.getGroupSub())) {
            message = "Пока нет подписок на группы. Чтобы добавить подписку напиши /addGroupSub";
        } else {
            String collectedGroups = telegramUser.getGroupSub().stream()
                    .map(it -> "Группа: " + it.getTitle() + " , ID = " + it.getId() + " \n")
                    .collect(Collectors.joining());
            message =  String.format("Я нашел все подписки на группы: \n\n %s", collectedGroups);
        }


        sendBotMessageService.sendMessage(telegramUser.getChatId(), message);
    }
}