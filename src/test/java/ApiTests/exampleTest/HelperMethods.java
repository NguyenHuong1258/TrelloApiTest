package ApiTests.exampleTest;

/*
Collect all helpers which be able to reusable in 2 class TestCase1 & TestCase2
*/

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import java.util.*;


import static org.junit.Assert.assertEquals;

public class HelperMethods {

    /*
    Get Video Ids (For Testcase11)
    We can use get method of Rest Assured library's JsonPath Class's Get method
    Part of a response is shown below:
    "items": [{
    "id": 519377522,
     ....
     We can get all id's with this code --> "jp.get("items.id");" this will return
     all id's under "items" tag.
    */

    public static ArrayList getVideoIdList (JsonPath jp){
        ArrayList  videoIdList = jp.get("items.id");
        return videoIdList;
    }

    /*
    Get Related Video Ids (For TestCase2)
    Structure of response is shown below:
    items:
     "related": [{
     "id": 519148754,
     ....
     In order to get all id's under related tag,
    We can use JsonPath's get method like "jp.get("items.related.id");"
    It will give us all id's under related tag.
    */

    public static ArrayList getRelatedVideoIdList (JsonPath jp){
        //jp.get method returns all ids
        ArrayList relatedVideoList = jp.get("items.related.id");
        /*
        Result of relatedVideosList: [[519148754, 519115214, 519235328, 519235341]]
        Have to convert above result in this format: [519148754, 519115214, 519235328, 519235341]
        In order to split first element of "relatedVideosList" and assign it to a new ArrayList (as splittedRelatedVideoList)
        */

        ArrayList splittedRelatedVideoList = (ArrayList) relatedVideoList.get(0);
        return splittedRelatedVideoList;
    }

    //Merge videoIdList and relatedVideoIdList as mergerdVideoList
    public static ArrayList mergeLists (ArrayList videoList, ArrayList realatedVideoList){
        ArrayList mergedVideoList = new ArrayList(videoList);
        mergedVideoList.addAll(realatedVideoList);
        return mergedVideoList;

    }

    //Find Duplicate Videos
    public static boolean findDuplicateVideos (List<Integer> videoIdList){
        for (int i=0; i < videoIdList.size(); i++){
            if(Collections.frequency(videoIdList, videoIdList.get(i)) > 1){
                System.out.println("This video is duplicated: " + videoIdList.get(i));

                return false;
            }
        }
        return true;
    }



}
