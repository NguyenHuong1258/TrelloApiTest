package testSuite.TrellooApiSutie;

import com.web.api.Trello.list.ListActions;
import com.web.api.Trello.member.MemberActions;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class CreationList {

    //Declare variable
    private Response response = null;

    @Test
    public void testCreateList(){
        ArrayList listBoard = MemberActions.getBoardList();
        response= ListActions.createList("HNGList10", listBoard.get(0));
        //  System.out.println(response.prettyPeek());
        String nameListResponse = response.getBody().jsonPath().getString("name");
        assertEquals("HNGList10", nameListResponse);
    }


}
