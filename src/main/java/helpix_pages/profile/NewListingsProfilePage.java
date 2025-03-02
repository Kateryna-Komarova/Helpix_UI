package helpix_pages.profile;

import helpix_pages.BasePage;
import helpix_pages.HomePage;
import helpix_pages.JoinPage;
import helpix_pages.profileNavigation.ProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewListingsProfilePage extends BasePage {
    public NewListingsProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "categoryId")
    WebElement categoryDropdownButton;
    @FindBy(xpath = "//input[@name='title']")
    WebElement titleField;
    @FindBy(xpath = "//select[@name='language']")
    WebElement languageDropdown;
    @FindBy(xpath = "//textarea[@name='description']")
    WebElement descriptionField;
    @FindBy(id = "contactPhone")
    WebElement contactPhoneField;
    @FindBy(id = "contactEmail")
    WebElement contactEmailField;
    @FindBy(id = "websiteUrl")
    WebElement websiteUrlField;
    @FindBy(id = "address")
    WebElement addressField;
    @FindBy(name = "price")
    WebElement priceField;
    @FindBy(name = "currencyCode")
    WebElement currencyCodeDropdown;
    @FindBy(name = "images[0].imageUrl")
    WebElement imageField;
    @FindBy(xpath = "//button[contains(text(),'Submit Listing')]")
    WebElement submitButton;

    public NewListingsProfilePage createNewListing() {
        selectDropdownOption(categoryDropdownButton, "Pets");
        //selectOption(languageDropdown, "US United States");
        type(titleField, "DOGS grooming");
        type(descriptionField, "We have a large grooming area that you can watch over a cup of hot coffee or cold lemonade. Also, in our store, consultants will help you choose daily care products for your pet, stylish accessories and treats.");
        type(contactPhoneField, "+380672211245");
        type(contactEmailField, "kitty.purrwhiskers@gmail.com");
        type(websiteUrlField, "https://prideandgroom.com");
        type(addressField, "John Smith 123 Main Street Anytown, NY 12345 United States");
        type(priceField, "200");
        //selectOption(currencyCodeDropdown,"USD");
        type(imageField, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFUAfyVe3Easiycyh3isP9wDQTYuSmGPsPQvLIJdEYvQ_DsFq5Ez2Nh_QjiS3oZ3B8ZPfK9cZQyIStmQMV1lDPLw");
        click(submitButton);
        return this;

    }

    public NewListingsProfilePage createNewListingsWithoutDescription() {
        selectDropdownOption(categoryDropdownButton, "Pets");
        //selectOption(languageDropdown, "US United States");
        type(titleField, "DOGS grooming");
        type(descriptionField, "");
        return this;
    }

    @FindBy(xpath = "//*/text()[normalize-space(.)='Please fix the following errors:']/parent::*")
    WebElement errorMessage;

    public NewListingsProfilePage verifyErrorMessage(String text) {
        Assert.assertTrue(shouldHaveText(errorMessage, text, 5));
        return this;
    }
}