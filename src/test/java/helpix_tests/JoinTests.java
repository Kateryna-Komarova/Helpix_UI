package helpix_tests;

import config.UserData;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JoinTests extends TestBase {

    @BeforeMethod

    public void precondition() {
        new HomePage(driver).getJoinLink();
    }

    @Test
    public void joinPositiveTest() {
        JoinPage joinPage = new JoinPage(driver);
        joinPage.enterUserData(UserData.getEmail(),UserData.getPassword());
        Assert.assertTrue(joinPage.verifyProfileIcon(), "Login failed: profile icon not displayed");
    }
}