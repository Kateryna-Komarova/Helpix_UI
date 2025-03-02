package helpix_pages.profileNavigation;

import helpix_pages.BasePage;
import helpix_pages.profile.NewListingsProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import helpix_pages.profile.MyListingsProfilePage;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]")
    WebElement profileInformation;

    public ProfilePage verifyMyProfileName(String text) {
        Assert.assertTrue(shouldHaveText(profileInformation, text, 5));
        return this;

    }

    @FindBy(xpath = "//*/text()[normalize-space(.)='My Listings']/parent::*")
    WebElement myListings;

    public MyListingsProfilePage getMyListings() {
        click(myListings);
        return new MyListingsProfilePage(driver);

    }

    @FindBy(xpath = "//body/main[1]/div[1]/div[3]/a[1]/div[1]")
    WebElement newListingButton;

    public NewListingsProfilePage getNewListingLink() {
        click(newListingButton);
        return new NewListingsProfilePage(driver);
    }
}

