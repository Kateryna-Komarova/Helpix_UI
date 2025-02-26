package helpix_tests;

import config.UserData;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;
import helpix_pages.profile.NewListingsProfilePage;
import helpix_pages.profileNavigation.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewListingsProfileTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJoinLink();
        new JoinPage(driver).enterUserData(UserData.getEmail(), UserData.getPassword());
        new HomePage(driver).getMyProfileNavMenu();
        new ProfilePage(driver).getNewListingLink();
    }

    @Test
    public void createNewListingsProfilePositiveTest() {
        new NewListingsProfilePage(driver).createNewListing();
    }

    @Test
    public void createNewListingsWithoutDescriptionNegativeTest() {
        new NewListingsProfilePage(driver).createNewListingsWithoutDescription().verifyErrorMessage("Please fix the following errors:");

    }
}