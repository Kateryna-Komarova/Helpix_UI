package helpix_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class JoinPage extends BasePage {
    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@type='submit']")
    WebElement joinWithGoogle;
    @FindBy(css = "#identifierId")
    WebElement emailField;
    @FindBy(xpath = "//*/text()[normalize-space(.)='Next']/parent::*")
    WebElement nextButton;
    @FindBy(name = "Passwd")
    WebElement passwordField;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    WebElement nextButtonTwo;
    @FindBy(xpath = "//span[contains(text(),'Продолжить')]")
    WebElement continueButton;


    public JoinPage enterUserData(String email, String password) {
        click(joinWithGoogle);
        type(emailField, email);
        click(nextButton);
        type(passwordField, password);
        click(nextButtonTwo);
        click(continueButton);
        return this;
    }

    @FindBy(xpath = "//img[@alt='User navbar avatar']")
    WebElement avatarIcon;

    public JoinPage verifyProfileIconIsDisplayed() {
        Assert.assertTrue(avatarIcon.isDisplayed(), "Login failed: profile icon not displayed");
        return this;
    }


    @FindBy(xpath = "//button[@type='button']")
    WebElement logoutButton;

    public JoinPage logOutUser() {
        click(avatarIcon);
        click(logoutButton);
        return this;
    }
}
