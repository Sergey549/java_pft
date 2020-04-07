package litecart.tests;

import litecart.appmanager.ApplicationManage;
import org.junit.After;
import org.junit.Before;

public class TestBase {

    protected final ApplicationManage app = new ApplicationManage();

    @Before
    public void setUp() throws Exception {
        app.init();
    }

    @After
    public void stop() {
        app.testEnd();
    }


}
