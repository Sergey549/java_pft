package litecart.tests;

import litecart.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() throws Exception {
        app.stop();
    }

}
