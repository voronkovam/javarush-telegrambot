package github.com.voronkovam.jrtb.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

@Entity
@Table(name = "group_sub")

public class GroupSub {

    @Id
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "last_article_id")
    private Integer lastArticleId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "group_x_user",
            joinColumns = @JoinColumn(name = "group_sub_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<TelegramUser> users;

    public void addUser(TelegramUser telegramUser) {
        if (isNull(users)) {
            users = new ArrayList<>();
        }
        users.add(telegramUser);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(Integer lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public List<TelegramUser> getUsers() {
        return users;
    }

    public void setUsers(List<TelegramUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupSub groupSub)) return false;
        return Objects.equals(getId(), groupSub.getId()) && Objects.equals(getTitle(), groupSub.getTitle()) && Objects.equals(getLastArticleId(), groupSub.getLastArticleId()) && Objects.equals(getUsers(), groupSub.getUsers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getLastArticleId(), getUsers());
    }

    @Override
    public String toString() {
        return "GroupSub{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", lastArticleId=" + lastArticleId +
                ", users=" + users +
                '}';
    }
}