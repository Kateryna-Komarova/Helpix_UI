package helpix_pages.profile;

import helpix_pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyListingsPage extends BasePage {
    public MyListingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.flex.flex-col.items-start.justify-between")
    WebElement profileInformation;

    public MyListingsPage verifyMyListingName(String text) {
        Assert.assertTrue(shouldHaveText(profileInformation, text, 5));
        return this;
    }

    @FindBy(xpath = "//*/text()[normalize-space(.)='Deactivate']/parent::*")
    WebElement deactivateButton;
    @FindBy(xpath = "//*/text()[normalize-space(.)='Confirm']/parent::*")
    WebElement confirmButton;

    public MyListingsPage deactivateMyListing() {
        click(deactivateButton);
        click(confirmButton);
        return this;
    }
    public void verifyDeactivationSuccessMessage() {
        WebElement successMessage = driver.findElement(By.className("success-message"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "Listing deactivation successfully.";
        Assert.assertEquals(actualMessage, expectedMessage, "The message about successful deactivation does not match the expected one.");
    }


    @FindBy(xpath = "/html/body/main/div/ul/li[2]/div/div[2]/div[2]/div[2]/div/button")
    WebElement deleteButton;
    @FindBy(xpath = "/html/body/main/div/ul/li[2]/div/div[2]/div[2]/div[2]/div/dialog/div/div/button[2]")
    WebElement confirmDeleteButton;

    public MyListingsPage deleteMyListing() {
        click(deleteButton);
        click(confirmDeleteButton);
        return this;
    }
}