package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.Objects;

/**
 * Group information related to authorized user. If there is no user - will be null.
 */

public class MeGroupInfo {
    private MeGroupInfoStatus status;
    private Integer userGroupId;

    public MeGroupInfo(MeGroupInfoStatus status, Integer userGroupId) {
        this.status = status;
        this.userGroupId = userGroupId;
    }

    public MeGroupInfo() {
    }

    public MeGroupInfoStatus getStatus() {
        return status;
    }

    public void setStatus(MeGroupInfoStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MeGroupInfo that)) return false;
        return status == that.status && Objects.equals(userGroupId, that.userGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, userGroupId);
    }

    @Override
    public String toString() {
        return "MeGroupInfo{" +
                "status=" + status +
                ", userGroupId=" + userGroupId +
                '}';
    }
}