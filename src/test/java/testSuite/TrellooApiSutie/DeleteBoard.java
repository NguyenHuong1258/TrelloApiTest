package testSuite.TrellooApiSutie;

import com.web.api.Trello.board.BoardActions;
import com.web.api.Trello.member.MemberActions;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class DeleteBoard {

    //Declare variable
    private Response response = null;

    @Test
    public void testDeleteBoard(){
        ArrayList listBoard = MemberActions.getBoardList();
        for (int i =0; i < listBoard.size(); i++){
            response = BoardActions.deleteBoard(listBoard.get(i));
        }
        assertEquals("Status Check Failed.", 200, response.getStatusCode());
    }
}
