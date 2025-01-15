package github.com.voronkovam.jrtb.javarushclient;

import github.com.voronkovam.jrtb.javarushclient.dto.GroupDiscussionInfo;
import github.com.voronkovam.jrtb.javarushclient.dto.GroupInfo;
import github.com.voronkovam.jrtb.javarushclient.dto.GroupRequestArgs;
import github.com.voronkovam.jrtb.javarushclient.dto.GroupsCountRequestArgs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static github.com.voronkovam.jrtb.javarushclient.dto.GroupInfoType.TECH;

@DisplayName("Integration-level testing for JavaRushGroupClientImplTest")
class JavaRushGroupClientTest {

    private final JavaRushGroupClient groupClient = new JavaRushGroupClientImpl("https://javarush.com/api/1.0/rest");

    @Test
    public void shouldProperlyGetGroupsWithEmptyArgs() {
        //given
        // GroupRequestArgs args = GroupRequestArgs.builder().build();
        GroupRequestArgs args = new GroupRequestArgs.Builder().build();

        //when
        List<GroupInfo> groupList = groupClient.getGroupList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetWithOffSetAndLimit() {
        //given
        //GroupRequestArgs args = GroupRequestArgs.builder()
        GroupRequestArgs args = new GroupRequestArgs.Builder()
                .offset(1)
                .limit(3)
                .build();

        //when
        List<GroupInfo> groupList = groupClient.getGroupList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupsDiscWithEmptyArgs() {
        //given
        //  GroupRequestArgs args = GroupRequestArgs.builder().build();
        GroupRequestArgs args = new GroupRequestArgs.Builder().build();

        //when
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertFalse(groupList.isEmpty());
    }

    @Test
    public void shouldProperlyGetGroupDiscWithOffSetAndLimit() {
        //given
        // GroupRequestArgs args = GroupRequestArgs.builder()
        GroupRequestArgs args = new GroupRequestArgs.Builder()
                .offset(1)
                .limit(3)
                .build();

        //when
        List<GroupDiscussionInfo> groupList = groupClient.getGroupDiscussionList(args);

        //then
        Assertions.assertNotNull(groupList);
        Assertions.assertEquals(3, groupList.size());
    }

    @Test
    public void shouldProperlyGetGroupCount() {
        //given
        GroupsCountRequestArgs args = new GroupsCountRequestArgs.Builder().build();

        //when
        Integer groupCount = groupClient.getGroupCount(args);

        //then
        Assertions.assertEquals(30, groupCount);
    }

    @Test
    public void shouldProperlyGetGroupTECHCount() {
        //given
        GroupsCountRequestArgs args = new GroupsCountRequestArgs.Builder()
                .type(TECH)
                .build();

        //when
        Integer groupCount = groupClient.getGroupCount(args);

        //then
        Assertions.assertEquals(7, groupCount);
    }

    @Test
    public void shouldProperlyGetGroupById() {
        //given
        Integer androidGroupId = 16;

        //when
        GroupDiscussionInfo groupById = groupClient.getGroupById(androidGroupId);

        //then
        Assertions.assertNotNull(groupById);
        Assertions.assertEquals(16, groupById.getId());
        Assertions.assertEquals(TECH, groupById.getType());
        Assertions.assertEquals("android", groupById.getKey());
    }
}