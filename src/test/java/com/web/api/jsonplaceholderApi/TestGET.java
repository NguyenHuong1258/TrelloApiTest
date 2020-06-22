package com.web.api.jsonplaceholderApi;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import utils.RestUtil;

import static org.junit.Assert.*;

public class TestGET {
    //Declare Response and JsonPath objects.
    private Response res = null;
    private JsonPath jp = null;
    private ResponseBody body = null;

    @Before
    public void setup(){
        //Test Setup.
        RestUtil.setBaseURI("https://jsonplaceholder.typicode.com"); //Setup Base URI.
        RestUtil.setBasePath("posts"); //Setup Base Path.
        RestUtil.setContentType(ContentType.JSON); //Setup Content type.
        RestUtil.inputId("10");
        res = RestUtil.getResponse();
        jp = RestUtil.getJsonPath(res);
        body = RestUtil.getResponseBody(res);
    }

    @Test
    public void verifyReturnStatusCode() {
        //Verify the http response status returned. Check Status Code is 200?
        assertEquals("Status Check Failed.", 200, res.getStatusCode());
    }

    @Test
    public void verifyReturnId(){
        String bodyAsString = body.asString();
        boolean checkId = SelfHelperMethod.containId(bodyAsString,"10");
        assertTrue(checkId);
    }



}
