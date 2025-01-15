package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.Objects;

/**
 * Group discussion info class.
 */

public class GroupDiscussionInfo extends GroupInfo {

    private UserDiscussionInfo userDiscussionInfo;
    private Integer commentsCount;

    public UserDiscussionInfo getUserDiscussionInfo() {
        return userDiscussionInfo;
    }

    public void setUserDiscussionInfo(UserDiscussionInfo userDiscussionInfo) {
        this.userDiscussionInfo = userDiscussionInfo;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupDiscussionInfo that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getUserDiscussionInfo(), that.getUserDiscussionInfo()) && Objects.equals(getCommentsCount(), that.getCommentsCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserDiscussionInfo(), getCommentsCount());
    }

    @Override
    public String toString() {
        return "GroupDiscussionInfo{" +
                "userDiscussionInfo=" + userDiscussionInfo +
                ", commentsCount=" + commentsCount +
                "} " + super.toString();
    }
}