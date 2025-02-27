package helpix_tests;

import config.UserData;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;
import helpix_pages.profileNavigation.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJoinLink();
        new JoinPage(driver).enterUserData(UserData.getEmail(), UserData.getPassword());
        new HomePage(driver).getMyProfileNavMenu();
    }

    @Test
    public void myProfileIsOpenedPositiveTest() {
        new ProfilePage(driver).verifyMyProfileName("Kitty Purrwhiskers");
    }
}