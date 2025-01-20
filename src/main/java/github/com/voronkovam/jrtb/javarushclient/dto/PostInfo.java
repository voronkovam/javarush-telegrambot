package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.Objects;

/**
 * DTO, which represents post information.
 */

public class PostInfo {

    private BaseUserInfo authorInfo;
    private Integer commentsCount;
    private String content;
    private Long createdTime;
    private String description;
    private GroupInfo groupInfo;
    private Integer id;
    private String key;
    private Language language;
    private LikesInfo likesInfo;
    private GroupInfo originalGroupInfo;
    private String pictureUrl;
    private Double rating;
    private Integer ratingCount;
    private String title;
    private PostType type;
    private Long updatedTime;
    private UserDiscussionInfo userDiscussionInfo;
    private Integer views;
    private VisibilityStatus visibilityStatus;

    public PostInfo(BaseUserInfo authorInfo, Integer commentsCount, String content, Long createdTime, String description, GroupInfo groupInfo, Integer id, String key, Language language, LikesInfo likesInfo, GroupInfo originalGroupInfo, String pictureUrl, Double rating, Integer ratingCount, String title, PostType type, Long updatedTime, UserDiscussionInfo userDiscussionInfo, Integer views, VisibilityStatus visibilityStatus) {
        this.authorInfo = authorInfo;
        this.commentsCount = commentsCount;
        this.content = content;
        this.createdTime = createdTime;
        this.description = description;
        this.groupInfo = groupInfo;
        this.id = id;
        this.key = key;
        this.language = language;
        this.likesInfo = likesInfo;
        this.originalGroupInfo = originalGroupInfo;
        this.pictureUrl = pictureUrl;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.title = title;
        this.type = type;
        this.updatedTime = updatedTime;
        this.userDiscussionInfo = userDiscussionInfo;
        this.views = views;
        this.visibilityStatus = visibilityStatus;
    }

    public BaseUserInfo getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(BaseUserInfo authorInfo) {
        this.authorInfo = authorInfo;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LikesInfo getLikesInfo() {
        return likesInfo;
    }

    public void setLikesInfo(LikesInfo likesInfo) {
        this.likesInfo = likesInfo;
    }

    public GroupInfo getOriginalGroupInfo() {
        return originalGroupInfo;
    }

    public void setOriginalGroupInfo(GroupInfo originalGroupInfo) {
        this.originalGroupInfo = originalGroupInfo;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public UserDiscussionInfo getUserDiscussionInfo() {
        return userDiscussionInfo;
    }

    public void setUserDiscussionInfo(UserDiscussionInfo userDiscussionInfo) {
        this.userDiscussionInfo = userDiscussionInfo;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public VisibilityStatus getVisibilityStatus() {
        return visibilityStatus;
    }

    public void setVisibilityStatus(VisibilityStatus visibilityStatus) {
        this.visibilityStatus = visibilityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostInfo postInfo)) return false;
        return Objects.equals(getAuthorInfo(), postInfo.getAuthorInfo()) && Objects.equals(getCommentsCount(), postInfo.getCommentsCount()) && Objects.equals(getContent(), postInfo.getContent()) && Objects.equals(getCreatedTime(), postInfo.getCreatedTime()) && Objects.equals(getDescription(), postInfo.getDescription()) && Objects.equals(getGroupInfo(), postInfo.getGroupInfo()) && Objects.equals(getId(), postInfo.getId()) && Objects.equals(getKey(), postInfo.getKey()) && getLanguage() == postInfo.getLanguage() && Objects.equals(getLikesInfo(), postInfo.getLikesInfo()) && Objects.equals(getOriginalGroupInfo(), postInfo.getOriginalGroupInfo()) && Objects.equals(getPictureUrl(), postInfo.getPictureUrl()) && Objects.equals(getRating(), postInfo.getRating()) && Objects.equals(getRatingCount(), postInfo.getRatingCount()) && Objects.equals(getTitle(), postInfo.getTitle()) && getType() == postInfo.getType() && Objects.equals(getUpdatedTime(), postInfo.getUpdatedTime()) && Objects.equals(getUserDiscussionInfo(), postInfo.getUserDiscussionInfo()) && Objects.equals(getViews(), postInfo.getViews()) && getVisibilityStatus() == postInfo.getVisibilityStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthorInfo(), getCommentsCount(), getContent(), getCreatedTime(), getDescription(), getGroupInfo(), getId(), getKey(), getLanguage(), getLikesInfo(), getOriginalGroupInfo(), getPictureUrl(), getRating(), getRatingCount(), getTitle(), getType(), getUpdatedTime(), getUserDiscussionInfo(), getViews(), getVisibilityStatus());
    }

    @Override
    public String toString() {
        return "PostInfo{" +
                "authorInfo=" + authorInfo +
                ", commentsCount=" + commentsCount +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                ", description='" + description + '\'' +
                ", groupInfo=" + groupInfo +
                ", id=" + id +
                ", key='" + key + '\'' +
                ", language=" + language +
                ", likesInfo=" + likesInfo +
                ", originalGroupInfo=" + originalGroupInfo +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", updatedTime=" + updatedTime +
                ", userDiscussionInfo=" + userDiscussionInfo +
                ", views=" + views +
                ", visibilityStatus=" + visibilityStatus +
                '}';
    }
}