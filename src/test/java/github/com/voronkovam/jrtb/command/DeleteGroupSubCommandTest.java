package github.com.voronkovam.jrtb.command;

import github.com.voronkovam.jrtb.repository.entity.GroupSub;
import github.com.voronkovam.jrtb.repository.entity.TelegramUser;
import github.com.voronkovam.jrtb.service.GroupSubService;
import github.com.voronkovam.jrtb.service.SendBotMessageService;
import github.com.voronkovam.jrtb.service.TelegramUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static github.com.voronkovam.jrtb.command.AbstractCommandTest.prepareUpdate;
import static github.com.voronkovam.jrtb.command.CommandName.DELETE_GROUP_SUB;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for DeleteGroupSubCommand")
class DeleteGroupSubCommandTest {

    private Command command;
    private SendBotMessageService sendBotMessageService;
    GroupSubService groupSubService;
    TelegramUserService telegramUserService;


    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        groupSubService = Mockito.mock(GroupSubService.class);
        telegramUserService = Mockito.mock(TelegramUserService.class);

        command = new DeleteGroupSubCommand(sendBotMessageService, groupSubService, telegramUserService);
    }

    @Test
    public void shouldProperlyReturnEmptySubscriptionList() {
        //given
        Long chatId = 23456L;

        Update update = prepareUpdate(String.valueOf(chatId), DELETE_GROUP_SUB.getCommandName());
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setGroupSub(Collections.emptyList());

        Mockito.when(telegramUserService.findByChatId(String.valueOf(chatId)))
                .thenReturn(Optional.of(telegramUser));

        String expectedMessage = "Пока нет подписок на группы. Чтобы добавить подписку напиши /addGroupSub";

        //when
        command.execute(update);

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), expectedMessage);
    }

    @Test
    public void shouldProperlyReturnSubscriptionLit() {
        //given
        Long chatId = 23456L;
        Update update = prepareUpdate(String.valueOf(chatId), DELETE_GROUP_SUB.getCommandName());
        TelegramUser telegramUser = new TelegramUser();
        GroupSub gs1 = new GroupSub();
        gs1.setId(123);
        gs1.setTitle("GS1 Title");
        telegramUser.setGroupSub(singletonList(gs1));
        Mockito.when(telegramUserService.findByChatId(String.valueOf(chatId)))
                .thenReturn(Optional.of(telegramUser));

        String expectedMessage = "Чтобы удалить подписку на группу - передай комадну вместе с ID группы. \n" +
                "Например: /deleteGroupSub 16 \n\n" +
                "я подготовил список всех групп, на которые ты подписан) \n\n" +
                "имя группы - ID группы \n\n" +
                "GS1 Title - 123 \n";

        //when
        command.execute(update);

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), expectedMessage);
    }

    @Test
    public void shouldRejectByInvalidGroupId() {
        //given
        Long chatId = 23456L;
        Update update = prepareUpdate(String.valueOf(chatId), String.format("%s %s", DELETE_GROUP_SUB.getCommandName(), "groupSubId"));
        TelegramUser telegramUser = new TelegramUser();
        GroupSub gs1 = new GroupSub();
        gs1.setId(123);
        gs1.setTitle("GS1 Title");
        telegramUser.setGroupSub(singletonList(gs1));
        Mockito.when(telegramUserService.findByChatId(String.valueOf(chatId)))
                .thenReturn(Optional.of(telegramUser));

        String expectedMessage = "неправильный формат ID группы.\n " +
                "ID должно быть целым положительным числом";

        //when
        command.execute(update);

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), expectedMessage);
    }

    @Test
    public void shouldProperlyDeleteByGroupId() {
        //given

        /// prepare update object
        Long chatId = 23456L;
        Integer groupId = 1234;
        Update update = prepareUpdate(String.valueOf(chatId), String.format("%s %s", DELETE_GROUP_SUB.getCommandName(), groupId));


        GroupSub gs1 = new GroupSub();
        gs1.setId(123);
        gs1.setTitle("GS1 Title");
        TelegramUser telegramUser = new TelegramUser();
        telegramUser.setChatId(chatId.toString());
        telegramUser.setGroupSub(singletonList(gs1));
        ArrayList<TelegramUser> users = new ArrayList<>();
        users.add(telegramUser);
        gs1.setUsers(users);
        Mockito.when(groupSubService.findById(groupId)).thenReturn(Optional.of(gs1));
        Mockito.when(telegramUserService.findByChatId(String.valueOf(chatId)))
                .thenReturn(Optional.of(telegramUser));

        String expectedMessage = "Удалил подписку на группу: GS1 Title";

        //when
        command.execute(update);

        //then
        users.remove(telegramUser);
        Mockito.verify(groupSubService).save(gs1);
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), expectedMessage);
    }

    @Test
    public void shouldDoesNotExistByGroupId() {
        //given
        Long chatId = 23456L;
        Integer groupId = 1234;
        Update update = prepareUpdate(String.valueOf(chatId), String.format("%s %s", DELETE_GROUP_SUB.getCommandName(), groupId));


        Mockito.when(groupSubService.findById(groupId)).thenReturn(Optional.empty());

        String expectedMessage = "Не нашел такой группы =/";

        //when
        command.execute(update);

        //then
        Mockito.verify(groupSubService).findById(groupId);
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), expectedMessage);
    }
}