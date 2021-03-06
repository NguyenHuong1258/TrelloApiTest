package ApiTests.TrelloApi.board;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import utils.propertyReader.PropertyReaderManager;

import java.util.ArrayList;


public class BoardActions {
    public static final String board = "/boards/";
    private static String boardId;
    private static PropertyReaderManager propReaderManager;

    //Create a new Board
    public static Response createBoard(String nameBoard){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .queryParam("name", nameBoard)
                .post(propReaderManager.getInstance().getApiReader().getBaseUrl() + board);
        boardId = response.getBody().jsonPath().getString("id");
        return response;
    }

    //Delete Board
    public static Response deleteBoard(Object boardId){
        System.out.println("boardId is deleted: " + boardId);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .delete(propReaderManager.getInstance().getApiReader().getBaseUrl() + board+ boardId);
        return response;
    }

    //Get a Board
    public static String getBoardId(){
        return boardId;

    }

    //Get List on a Board
    public static ArrayList getListOnBoard (Object boardId){
        ArrayList listsOnBoard;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .get(propReaderManager.getInstance().getApiReader().getBaseUrl() + board + "/" + boardId + "/" + "lists");
        System.out.println(propReaderManager.getInstance().getApiReader().getBaseUrl() + board + boardId + "/" + "lists");
        listsOnBoard= response.jsonPath().get("id");
        return listsOnBoard;
    }


}
