package litecart.tests;

import litecart.appmanager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void tearDown() throws Exception {
        app.stop();
    }

}
