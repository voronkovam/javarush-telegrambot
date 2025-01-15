package github.com.voronkovam.jrtb.service;

import github.com.voronkovam.jrtb.javarushclient.dto.GroupDiscussionInfo;
import github.com.voronkovam.jrtb.repository.entity.GroupSub;

/**
 * Service for manipulating with {@link GroupSub}.
 */
public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}