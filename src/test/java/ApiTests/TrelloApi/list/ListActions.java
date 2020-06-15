package ApiTests.TrelloApi.list;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import utils.propertyReader.PropertyReaderManager;

public class ListActions {
    public static final String list = "/lists";
    private static String boardId;
    private static PropertyReaderManager propReaderManager;

    //Create a new List
    public static Response createList(String nameList, Object boardId){
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .queryParam("name", nameList)
                .queryParam("idBoard", boardId)
                .post(propReaderManager.getInstance().getApiReader().getBaseUrl() + list);
        return response;
    }

    //Move a list


    //Archive a list
    public static Response archiveList(Object listId){
        System.out.println("ListId is deleted: " + listId);
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("key", propReaderManager.getInstance().getApiReader().getkey())
                .queryParam("token", propReaderManager.getInstance().getApiReader().getToken())
                .put(propReaderManager.getInstance().getApiReader().getBaseUrl() + list + "/"+ listId+ "/"+ "closed");
        return response;
    }

}
