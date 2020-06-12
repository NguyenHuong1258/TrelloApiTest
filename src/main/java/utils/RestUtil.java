package utils;
/*
Contain all methods related to Rest Assured.
 */
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import static com.jayway.restassured.RestAssured.*;

public class RestUtil {

    //Global Setup Variable
    public static String jsonPathTerm;
    public static String path; //Rest request path

    /*
    ***Sets Base URI***
    Before starting the test, we should set the RestAssured.baseURI
    */
    public static void setBaseURI (String baseURI){
        RestAssured.baseURI = baseURI;
    }

    /*
    *** Set Base path ***
     Set the RestAssured.basePath before starting test.
    */
    public static void setBasePath(String basePathTerm){
        RestAssured.basePath = basePathTerm;
    }

    /*
    *** Reset Base URI after test **
    Reset the RestAssured.baseURI after the test.
     */
    public static void restBaseURI(){
        RestAssured.baseURI = null;
    }

    /*
    *** Rest base path (after test)***
     Reset the RestAssured.basePath after the test
     */
    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    /*
    *** Set ContentType ****
    * Set content type as JSON or XML before starting the test
     */
    public static void setContentType (ContentType Type){
        given().contentType(Type);
    }

    /*
    *** Search query path of the first example **
    * It is equal to "barack obama/videos.json?num_of_videos=4"
     */
    public static void createSearchQueryPath (String searchTerm, String jsonPathTerm, String param, String paramValue){
        path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;

    }

    /*Input id by path  */
    public static void inputId (String id){
        path = id;
    }

    /*
    *** Returns response ***
    * We send "path " as a parameter to the Rest Assured'a Get method
    * and GET method returns response of API
     */
    public static Response getResponse(){
        System.out.print("path: " + path +"\n");
        return get(path);
    }

    /*
    ** Returns JsonPath object **
    * First convert API's response to String type with "asString()" method.
    * Then, send this String formatted json response to the JsonPath class and return JsonPath
     */
    public static JsonPath getJsonPath (Response res){
        String json = res.asString();
        System.out.print("returned json: " + json +"\n");
        return new JsonPath(json);
    }

    /*Get Response body */
    public static ResponseBody getResponseBody(Response res){
        return res.getBody();
    }


}
