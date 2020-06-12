package ApiTests.exampleTest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.*;
import org.junit.runners.MethodSorters;
import utils.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@FixMethodOrder(MethodSorters.NAME_ASCENDING) // For Ascending order test execution.
public class TestCase1 {

    //Declare Response and JsonPath objects.
    private Response res = null;
    private JsonPath jp = null;

    HelperMethods helperMethods = new HelperMethods();

    /*
    Setup operations, get JSON response from the API and put it into JsonPath object
    Then, query and manipulations with JsonPath class’s methods.
    We can do all of the preparation operations after @Before Junit annotation.
    */

    @Before
    public void setup(){
        //Test Setup.
        RestUtil.setBaseURI("http://api.5min.com"); //Setup Base URI.
        RestUtil.setBasePath("search"); //Setup Base Path.
        RestUtil.setContentType(ContentType.JSON); //Setup Content type.
        RestUtil.createSearchQueryPath("paris hilton", "videos.json", "num_of_videos", "5");
        res = RestUtil.getResponse();
        jp = RestUtil.getJsonPath(res);
    }

    @Test
    public void T01_StatusCodeTest() {
        //Verify the http response status returned. Check Status Code is 200?
        assertEquals("Status Check Failed.", 200, res.getStatusCode());
    }

    @Test
    public void T02_SearchTermTest() {
        //Verify the response contained the relevant search term (barack obama)
        Assert.assertEquals("Title is wrong!", ("Search results for \"paris hilton\""), jp.get("api-info.title"));
        //assertThat(jp.get("api-info.title"), containsString("barrack obama"));
    }
}
