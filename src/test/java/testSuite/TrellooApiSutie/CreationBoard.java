package testSuite.TrellooApiSutie;

import com.web.api.Trello.board.BoardActions;
import com.jayway.restassured.response.Response;
import com.web.api.constants.ApiCommonConstants;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreationBoard {

    //Declare variable
    private Response response = null;

    @Test
    public void testCreateBoard(){
        response= BoardActions.createBoard("With ApiCommonConstants");
        System.out.println(response.prettyPeek());
       String nameBoardResponse = response.getBody().jsonPath().getString(ApiCommonConstants.NAMEBOARD);
      response.then().assertThat().body("name", Matchers.equalTo(nameBoardResponse));
        //assertEquals("With ApiCommonConstants", nameBoardResponse);
    }


}
