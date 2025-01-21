package github.com.voronkovam.jrtb.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO for getting bot statistics.
 */

public class StatisticDTO {
    private final int activeUserCount;
    private final int inactiveUserCount;
    private final List<GroupStatDTO> groupStatDTOs;
    private final double averageGroupCountByUser;

    public StatisticDTO(int activeUserCount, int inactiveUserCount, List<GroupStatDTO> groupStatDTOs, double averageGroupCountByUser) {
        this.activeUserCount = activeUserCount;
        this.inactiveUserCount = inactiveUserCount;
        this.groupStatDTOs = groupStatDTOs;
        this.averageGroupCountByUser = averageGroupCountByUser;
    }

    public int getActiveUserCount() {
        return activeUserCount;
    }

    public int getInactiveUserCount() {
        return inactiveUserCount;
    }

    public List<GroupStatDTO> getGroupStatDTOs() {
        return groupStatDTOs;
    }

    public double getAverageGroupCountByUser() {
        return averageGroupCountByUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticDTO that)) return false;
        return getActiveUserCount() == that.getActiveUserCount() && getInactiveUserCount() == that.getInactiveUserCount() && Double.compare(that.getAverageGroupCountByUser(), getAverageGroupCountByUser()) == 0 && Objects.equals(getGroupStatDTOs(), that.getGroupStatDTOs());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActiveUserCount(), getInactiveUserCount(), getGroupStatDTOs(), getAverageGroupCountByUser());
    }
}