package github.com.voronkovam.jrtb.service;

import github.com.voronkovam.jrtb.dto.GroupStatDTO;
import github.com.voronkovam.jrtb.dto.StatisticDTO;
import github.com.voronkovam.jrtb.repository.entity.TelegramUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final GroupSubService groupSubService;
    private final TelegramUserService telegramUserService;

    public StatisticsServiceImpl(GroupSubService groupSubService, TelegramUserService telegramUserService) {
        this.groupSubService = groupSubService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public StatisticDTO countBotStatistic() {
        List<GroupStatDTO> groupStatDTOS = groupSubService.findAll().stream()
                .filter(it -> !isEmpty(it.getUsers()))
                .map(groupSub -> new GroupStatDTO(groupSub.getId(), groupSub.getTitle(), groupSub.getUsers().size()))
                .collect(Collectors.toList());
        List<TelegramUser> allInActiveUsers = telegramUserService.findAllInActiveUsers();
        List<TelegramUser> allActiveUsers = telegramUserService.findAllActiveUsers();

        double groupsPerUser = getGroupsPerUser(allActiveUsers);
        return new StatisticDTO(allActiveUsers.size(), allInActiveUsers.size(), groupStatDTOS, groupsPerUser);
    }

    private double getGroupsPerUser(List<TelegramUser> allActiveUsers) {
        return (double) allActiveUsers.stream().mapToInt(it -> it.getGroupSub().size()).sum() / allActiveUsers.size();
    }
}