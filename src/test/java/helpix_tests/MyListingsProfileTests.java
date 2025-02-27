package helpix_tests;

import config.UserData;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;

import helpix_pages.profile.MyListingsProfilePage;
import helpix_pages.profileNavigation.ProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyListingsProfileTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJoinLink();
        new JoinPage(driver).enterUserData(UserData.getEmail(), UserData.getPassword());
        new HomePage(driver).getMyProfileNavMenu();
        new ProfilePage(driver).getMyListings();
    }

    @Test
    public void openMyListingPositiveTest() {
        new MyListingsProfilePage(driver).verifyMyListingName("DOGS grooming");
    }

    @Test
    public void deactivateMyListingPositiveTest() {
        new MyListingsProfilePage(driver).deactivateMyListing().verifyDeactivationSuccessMessage();
    }

    @Test
    public void deleteMyListingPositiveTest() {
        new MyListingsProfilePage(driver).deleteMyListing();
    }
}