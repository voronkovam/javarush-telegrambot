package github.com.voronkovam.jrtb.command;

import github.com.voronkovam.jrtb.dto.GroupStatDTO;
import github.com.voronkovam.jrtb.dto.StatisticDTO;
import github.com.voronkovam.jrtb.service.SendBotMessageService;
import github.com.voronkovam.jrtb.service.StatisticsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static github.com.voronkovam.jrtb.command.AbstractCommandTest.prepareUpdate;
import static github.com.voronkovam.jrtb.command.CommandName.STAT;
import static github.com.voronkovam.jrtb.command.StatCommand.STAT_MESSAGE;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit-level testing for StatCommand")
public class StatCommandTest {

    private SendBotMessageService sendBotMessageService;
    private StatisticsService statisticsService;
    private Command statCommand;
    @BeforeEach
    public void init() {
        sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        statisticsService = Mockito.mock(StatisticsService.class);
        statCommand = new StatCommand(sendBotMessageService, statisticsService);
    }
    @Test
    public void shouldProperlySendMessage() {
        //given
        String chatId = "1234567";
        GroupStatDTO groupDto = new GroupStatDTO(1, "group", 1);
        StatisticDTO statisticDTO = new StatisticDTO(1, 1, Collections.singletonList(groupDto), 2.5);
        Mockito.when(statisticsService.countBotStatistic())
                .thenReturn(statisticDTO);

        //when
        statCommand.execute(prepareUpdate(chatId, CommandName.STAT.getCommandName()));

        //then
        Mockito.verify(sendBotMessageService).sendMessage(chatId.toString(), format(STAT_MESSAGE,
                statisticDTO.getActiveUserCount(),
                statisticDTO.getInactiveUserCount(),
                statisticDTO.getAverageGroupCountByUser(),
                format("%s (id = %s) - %s подписчиков", groupDto.getTitle(), groupDto.getId(), groupDto.getActiveUserCount())));
    }

}