package testSuite.TrelloApiRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testSuite.TrellooApiSutie.CreationBoard;
import testSuite.TrellooApiSutie.CreationList;
import testSuite.TrellooApiSutie.DeleteBoard;
import testSuite.TrellooApiSutie.DeleteList;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreationBoard.class,
        CreationList.class,
        DeleteList.class,
        DeleteBoard.class
})

public class TrelloApiTestRunner {
}
