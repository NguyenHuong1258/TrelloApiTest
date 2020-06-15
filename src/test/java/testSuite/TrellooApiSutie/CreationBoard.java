package testSuite.TrellooApiSutie;

import ApiTests.TrelloApi.board.BoardActions;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreationBoard {

    //Declare variable
    private Response response = null;

    @Test
    public void testCreateBoard(){
        response= BoardActions.createBoard("HuongBoard2");
        System.out.println(response.prettyPeek());
       String nameBoardResponse = response.getBody().jsonPath().getString("name");
      //response.then().assertThat().body("name", Matchers.equalTo(nameBoardResponse));
        assertEquals("HuongBoard2", nameBoardResponse);
    }


}
