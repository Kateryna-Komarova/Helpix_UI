package helpix_pages;

import helpix_pages.profileNavigation.HelpAndSupportPage;
import helpix_pages.profileNavigation.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    public HomePage verifyHomePage() {
        Assert.assertTrue(new HomePage(driver).isHomeComponentPresent(), "Home page is not present" + driver.getCurrentUrl());
        return this;
    }

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Listings'])[1]/following::*[name()='svg'][1]")
    WebElement listViewButton;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Listings'])[1]/following::div[4]")
    WebElement listingGrooming;

    public ListingsPage openListingInListView() {
        click(listViewButton);
        click(listingGrooming);
        return new ListingsPage(driver);
    }

    @FindBy(xpath = "//*/text()[normalize-space(.)='DOGS grooming']/parent::*")
    WebElement gridButton;
    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[1]/div[2]/div[1]")
    WebElement groomingListing;

    public ListingsPage openListingInGridView() {
        click(gridButton);
        click(groomingListing);
        return new ListingsPage(driver);
    }
}
