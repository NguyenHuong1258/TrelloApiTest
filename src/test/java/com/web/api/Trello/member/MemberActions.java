package com.web.api.Trello.member;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.web.api.constants.ApiCommonConstants;
import utils.propertyReader.PropertyReaderManager;
import java.util.ArrayList;


public class MemberActions {
    public static final String member = "/members/me/";
    private static String boardId;
    private static ArrayList listBoards;

    private static PropertyReaderManager propReaderManager;


    //Get list of Boards
    public static ArrayList getBoardList (){
        ArrayList boardList;
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam(ApiCommonConstants.KEY, propReaderManager.getInstance().getApiReader().getkey())
                .queryParam(ApiCommonConstants.TOKEN, propReaderManager.getInstance().getApiReader().getToken())
                .get(propReaderManager.getInstance().getApiReader().getBaseUrl() + member);
        boardList= response.jsonPath().get(ApiCommonConstants.IDBOARD);
        return boardList;
    }
}
