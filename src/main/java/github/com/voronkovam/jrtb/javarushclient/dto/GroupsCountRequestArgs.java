package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * Request arguments for group count requests.
 */

public class GroupsCountRequestArgs {
    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    private GroupsCountRequestArgs(Builder builder) {
        this.query = builder.query;
        this.type = builder.type;
        this.filter = builder.filter;
    }
    public String getQuery() {
        return query;
    }

    public GroupInfoType getType() {
        return type;
    }

    public GroupFilter getFilter() {
        return filter;
    }
    public Map populateQueries() {
        Map queries = new HashMap<>();
        if (nonNull(query)) {
            queries.put("query", query);
        }
        if (nonNull(type)) {
            queries.put("type", type);
        }
        if (nonNull(filter)) {
            queries.put("filter", filter);
        }
        return queries;
    }


    public static class Builder {
        private String query;
        private GroupInfoType type;
        private GroupFilter filter;

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder type(GroupInfoType type) {
            this.type = type;
            return this;
        }

        public Builder filter(GroupFilter filter) {
            this.filter = filter;
            return this;
        }

        public GroupsCountRequestArgs build() {
            return new GroupsCountRequestArgs(this);
        }
    }
}