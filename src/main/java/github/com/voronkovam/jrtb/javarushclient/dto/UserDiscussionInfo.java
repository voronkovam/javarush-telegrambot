package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.Objects;

/**
 * DTO for User discussion info.
 */

public class UserDiscussionInfo {

    private Boolean isBookmarked;
    private Integer lastTime;
    private Integer newCommentsCount;

    public Boolean getBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getNewCommentsCount() {
        return newCommentsCount;
    }

    public void setNewCommentsCount(Integer newCommentsCount) {
        this.newCommentsCount = newCommentsCount;
    }

    @Override
    public String toString() {
        return "UserDiscussionInfo{" +
                "isBookmarked=" + isBookmarked +
                ", lastTime=" + lastTime +
                ", newCommentsCount=" + newCommentsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDiscussionInfo that)) return false;
        return Objects.equals(isBookmarked, that.isBookmarked) && Objects.equals(getLastTime(), that.getLastTime()) && Objects.equals(getNewCommentsCount(), that.getNewCommentsCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isBookmarked, getLastTime(), getNewCommentsCount());
    }
}
