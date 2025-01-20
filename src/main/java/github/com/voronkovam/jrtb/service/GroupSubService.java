package github.com.voronkovam.jrtb.service;

import github.com.voronkovam.jrtb.javarushclient.dto.GroupDiscussionInfo;
import github.com.voronkovam.jrtb.repository.entity.GroupSub;

import java.util.List;
import java.util.Optional;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);

    Optional<GroupSub> findById(Integer valueOf);

    GroupSub save(GroupSub groupSub);
    List<GroupSub> findAll();
}