package helpix_tests;

import helpix_pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void homePageIsPresent() {
        new HomePage(driver).verifyHomePage();
    }
}
