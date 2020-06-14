package testSuite.TrellooApiSutie;

import ApiTests.TrelloApi.board.Board;
import ApiTests.TrelloApi.member.Member;;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class CreationBoard {

    //Declare variable
    private Response response = null;

    @Test
    public void testCreateBoard(){
        response= Board.createBoard("HuongBoard");
      //  System.out.println(response.prettyPeek());
       String nameBoardResponse = response.getBody().jsonPath().getString("name");
      response.then().assertThat().body("name", Matchers.equalTo(nameBoardResponse));
    }

    @Test
    public void testDeleteBoard(){
        ArrayList listBoard = Member.getListBoards();
        response = Board.deleteBoard(listBoard.get(0));
        assertEquals("Status Check Failed.", 200, response.getStatusCode());

    }
}
