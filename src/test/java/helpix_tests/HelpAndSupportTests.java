package helpix_tests;

import config.UserData;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;
import helpix_pages.profileNavigation.HelpAndSupportPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HelpAndSupportTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJoinLink();
        new JoinPage(driver).enterUserData(UserData.getEmail(), UserData.getPassword());
        new HomePage(driver).getHelpAndSupportLink();
    }

    @Test
    public void createHelpMessagePositiveTest() {
        new HelpAndSupportPage(driver).createHelpMassage().verifySuccessMessage();
    }

    @Test
    public void createHelpMessageWithInvalidEmailNegativeTest() {
        new HelpAndSupportPage(driver).createHelpMessageWithInvalidEmail().verifyEmailErrorMessage();
    }

    @Test
    public void sendingHelpMessageWithInvalidCharacterCount() {
        new HelpAndSupportPage(driver).sendingHelpMessageWithInvalidCharacterCount().verifyErrorCountMessage();
    }
}