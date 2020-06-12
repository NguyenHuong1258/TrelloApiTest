package testSuite;


import ApiTests.selfTest.TestGET;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestGET.class,
       // TestCase2.class,
})
public class AllApiTest {
}
