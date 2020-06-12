package ApiTests.selfTest;


public class SelfHelperMethod {

    /*Get id in response body */
    public static boolean containId(String str, String id){
        return str.contains(id);
    }
}
