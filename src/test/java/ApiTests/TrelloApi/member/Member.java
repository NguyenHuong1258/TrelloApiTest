package ApiTests.TrelloApi.member;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import utils.propertyReader.PropertyReaderManager;

import java.util.ArrayList;

public class Member {
    public static final String member = "/members/me/";
    private static String boardId;
    private static ArrayList listBoards;

    private static PropertyReaderManager propReaderManager;


    //Get list of Boards
    public static ArrayList getListBoards (){
        ArrayList listBoards;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .get(propReaderManager.getInstance().getApiReader().getBaseUrl() + member);
        listBoards= response.jsonPath().get("idBoards");
        return listBoards;
    }
}
