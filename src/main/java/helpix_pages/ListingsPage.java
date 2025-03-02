package helpix_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ListingsPage extends BasePage {
    public ListingsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]")
    WebElement listing;

    public ListingsPage verifyListingName() {
        Assert.assertTrue(shouldHaveText(listing, "DOGS grooming", 5),
                "The title does not match");
        return this;
    }

    @FindBy(xpath = "//body/main[1]/div[1]/div[1]/div[1]")
    WebElement listing2;

    public ListingsPage verifyGridListingName() {
        Assert.assertTrue(shouldHaveText(listing, "DOGS grooming", 5),
                "The title does not match");
        return this;
    }
}
