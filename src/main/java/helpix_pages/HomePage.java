package helpix_pages;

import helpix_pages.profileNavigation.HelpAndSupportPage;
import helpix_pages.profileNavigation.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Helpix')]")
    WebElement homePageComponent;

    public boolean isHomeComponentPresent() {
        return isElementPresent(homePageComponent);
    }

    @FindBy(xpath = "//a[contains(text(),'Join')]")
    WebElement joinButton;

    public JoinPage getJoinLink() {
        click(joinButton);
        return new JoinPage(driver);
    }

    @FindBy(xpath = "//img[@alt='User navbar avatar']")
    WebElement profileNav;
    @FindBy(xpath = "//a[contains(@href, '/profile')]")
    WebElement myProfile;

    public ProfilePage getMyProfileNavMenu() {
        click(profileNav);
        click(myProfile);
        return new ProfilePage(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Help & Support')]")
    WebElement helpAndSupportButton;
    public HelpAndSupportPage getHelpAndSupportLink() {
        click(profileNav);
        click(helpAndSupportButton);
        return new HelpAndSupportPage(driver);
    }
}
