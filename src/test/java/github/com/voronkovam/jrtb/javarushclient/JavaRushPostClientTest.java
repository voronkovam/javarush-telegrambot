package github.com.voronkovam.jrtb.javarushclient;

import github.com.voronkovam.jrtb.javarushclient.dto.PostInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Integration-level testing for JavaRushPostClient")
class JavaRushPostClientTest {
    public static final String JAVARUSH_API_PATH = "https://javarush.ru/api/1.0/rest";

    private final JavaRushPostClient postClient = new JavaRushPostClientImpl(JAVARUSH_API_PATH);

    @Test
    public void shouldProperlyGetNew15Posts() {
        //when
        List<PostInfo> newPosts = postClient.findNewPosts(30, 2935);

        //then
        Assertions.assertEquals(15, newPosts.size());
    }
}