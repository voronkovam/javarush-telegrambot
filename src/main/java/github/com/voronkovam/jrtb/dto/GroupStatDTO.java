package github.com.voronkovam.jrtb.dto;

import java.util.Objects;

/**
 * DTO for showing group id and title without data
 */

public class GroupStatDTO {

    private final Integer id;
    private final String title;
    private final Integer activeUserCount;

    public GroupStatDTO(Integer id, String title, Integer activeUserCount) {
        this.id = id;
        this.title = title;
        this.activeUserCount = activeUserCount;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getActiveUserCount() {
        return activeUserCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupStatDTO that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}