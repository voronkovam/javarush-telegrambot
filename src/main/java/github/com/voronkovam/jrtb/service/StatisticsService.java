package github.com.voronkovam.jrtb.service;

import github.com.voronkovam.jrtb.dto.StatisticDTO;

/**
 * Service for getting bot statistics.
 */
public interface StatisticsService {
    StatisticDTO countBotStatistic();
}