package testSuite.jsonplaceholderTest;


import ApiTests.jsonplaceholderApi.TestGET;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestGET.class,
       // TestCase2.class,
})
public class AllApiTest {
}
