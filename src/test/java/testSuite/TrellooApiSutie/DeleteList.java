package testSuite.TrellooApiSutie;

import ApiTests.TrelloApi.board.BoardActions;
import ApiTests.TrelloApi.list.ListActions;
import ApiTests.TrelloApi.member.MemberActions;
import com.jayway.restassured.response.Response;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class DeleteList {

    //Declare variable
    private Response response = null;

    @Test
    public void testArchiveList(){
        ArrayList boardList = MemberActions.getBoardList();
        ArrayList listOnBoard = BoardActions.getListOnBoard(boardList.get(0));
        System.out.println(listOnBoard.get(0));
        response = ListActions.archiveList(listOnBoard.get(0));
        assertEquals("Status Check Failed.", 200, response.getStatusCode());

    }
}
