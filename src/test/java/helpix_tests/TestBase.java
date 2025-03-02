package helpix_tests;

import config.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
        protected ApplicationManager app;
        Logger logger = LoggerFactory.getLogger(TestBase.class);
        protected WebDriver driver;

        @BeforeMethod
        public void setUp(Method method) {
            app = new ApplicationManager(System.getProperty("browser", "chrome"));
            driver = app.startTest();
            logger.info("Start test: " + method.getName());
        }

        @AfterMethod
        public void tearDown(ITestResult result) {
            if (result.isSuccess()) {
                logger.info("Test result: Passed " + result.getMethod().getMethodName());
            } else {
                logger.error("Test result: Failed " + result.getMethod().getMethodName());
            }
            logger.info("****************************************************************");

            if (driver != null) {
                app.stopTest();
            }
        }
    }


