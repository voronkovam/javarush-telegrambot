package github.com.voronkovam.jrtb.javarushclient.dto;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * Request arguments for group requests.
 */


public class GroupRequestArgs {

    private final String query;
    private final GroupInfoType type;
    private final GroupFilter filter;

    /**
     * specified where to start getting groups
     */
    private final Integer offset;
    /**
     * Limited number of groups.
     */
    private final Integer limit;

    private GroupRequestArgs(Builder builder) {
        this.query = builder.query;
        this.type = builder.type;
        this.filter = builder.filter;
        this.offset = builder.offset;
        this.limit = builder.limit;
    }

    public Map populateQueries() {
        Map queries = new HashMap<>();
        if(nonNull(query)) {
            queries.put("query", query);
        }
        if(nonNull(type)) {
            queries.put("type", type);
        }
        if(nonNull(filter)) {
            queries.put("filter", filter);
        }
        if(nonNull(offset)) {
            queries.put("offset", offset);
        }
        if(nonNull(limit)) {
            queries.put("limit", limit);
        }
        return queries;
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

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
    // Реализация Builder
    public static class Builder {
        private String query;
        private GroupInfoType type;
        private GroupFilter filter;
        private Integer offset;
        private Integer limit;

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

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public GroupRequestArgs build() {
            return new GroupRequestArgs(this);
        }
    }
}


//Пример использования:
//java
//Копировать код
//GroupRequestArgs args = new GroupRequestArgs.Builder()
//    .query("example query")
//    .type(GroupInfoType.SOME_TYPE)
//    .filter(new GroupFilter())
//    .offset(10)
//    .limit(50)
//    .build();