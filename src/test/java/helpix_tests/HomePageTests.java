package helpix_tests;

import helpix_pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {


    @Test
    public void homePageIsPresent() {
        Assert.assertTrue(new HomePage(driver).isHomeComponentPresent(), "Home page is not present" + driver.getCurrentUrl());
    }
}
