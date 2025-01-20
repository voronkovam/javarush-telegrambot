package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.Objects;

/**
 * DTO, which represents base user information.
 */

public class BaseUserInfo {
    private String city;
    private String country;
    private String displayName;
    private Integer id;
    private String job;
    private String key;
    private Integer level;
    private String pictureUrl;
    private String position;
    private UserPublicStatus publicStatus;
    private String publicStatusMessage;
    private Integer rating;
    private Integer userId;

    public BaseUserInfo(String city, String country, String displayName, Integer id, String job, String key, Integer level, String pictureUrl, String position, UserPublicStatus publicStatus, String publicStatusMessage, Integer rating, Integer userId) {
        this.city = city;
        this.country = country;
        this.displayName = displayName;
        this.id = id;
        this.job = job;
        this.key = key;
        this.level = level;
        this.pictureUrl = pictureUrl;
        this.position = position;
        this.publicStatus = publicStatus;
        this.publicStatusMessage = publicStatusMessage;
        this.rating = rating;
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserPublicStatus getPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(UserPublicStatus publicStatus) {
        this.publicStatus = publicStatus;
    }

    public String getPublicStatusMessage() {
        return publicStatusMessage;
    }

    public void setPublicStatusMessage(String publicStatusMessage) {
        this.publicStatusMessage = publicStatusMessage;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseUserInfo that)) return false;
        return Objects.equals(getCity(), that.getCity()) && Objects.equals(getCountry(), that.getCountry()) && Objects.equals(getDisplayName(), that.getDisplayName()) && Objects.equals(getId(), that.getId()) && Objects.equals(getJob(), that.getJob()) && Objects.equals(getKey(), that.getKey()) && Objects.equals(getLevel(), that.getLevel()) && Objects.equals(getPictureUrl(), that.getPictureUrl()) && Objects.equals(getPosition(), that.getPosition()) && getPublicStatus() == that.getPublicStatus() && Objects.equals(getPublicStatusMessage(), that.getPublicStatusMessage()) && Objects.equals(getRating(), that.getRating()) && Objects.equals(getUserId(), that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getCountry(), getDisplayName(), getId(), getJob(), getKey(), getLevel(), getPictureUrl(), getPosition(), getPublicStatus(), getPublicStatusMessage(), getRating(), getUserId());
    }

    @Override
    public String toString() {
        return "BaseUserInfo{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", displayName='" + displayName + '\'' +
                ", id=" + id +
                ", job='" + job + '\'' +
                ", key='" + key + '\'' +
                ", level=" + level +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", position='" + position + '\'' +
                ", publicStatus=" + publicStatus +
                ", publicStatusMessage='" + publicStatusMessage + '\'' +
                ", rating=" + rating +
                ", userId=" + userId +
                '}';
    }
}