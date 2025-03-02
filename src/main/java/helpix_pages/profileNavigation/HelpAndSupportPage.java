package helpix_pages.profileNavigation;

import helpix_pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class HelpAndSupportPage extends BasePage {
    public HelpAndSupportPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(id = "message")
    WebElement messageField;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public HelpAndSupportPage createHelpMassage() {
        type(emailField, "kitty.purrwhiskers@gmail.com");
        type(messageField, "I need help, test message");
        click(submitButton);
        return this;
    }

    public HelpAndSupportPage verifySuccessMessage() {
        By successMessageLocator = By.xpath("//div[@id='_rht_toaster']//div[contains(text(), 'Message successfully send. successfully.')]");
        WebElement successMessage = waitForVisibility(successMessageLocator, Duration.ofSeconds(10));
        Assert.assertTrue(isElementDisplayed(successMessage), "Success message is not displayed");
        return this;
    }

    public HelpAndSupportPage createHelpMessageWithInvalidEmail() {
        type(emailField, "kitty.purrwhiskersgmail.com");
        type(messageField, "I need help, test message");
        click(submitButton);
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Incorrect email format')]")
    WebElement emailError;

    public HelpAndSupportPage verifyEmailErrorMessage() {
        Assert.assertTrue(shouldHaveText(emailError, "Incorrect email format", 10),
                "Email validation error did not appear!");
        return this;

    }

    public HelpAndSupportPage sendingHelpMessageWithInvalidCharacterCount() {
        type(emailField, "kitty.purrwhiskers@gmail.com");
        type(messageField, "I need");
        click(submitButton);
        return this;

    }

    @FindBy(xpath = "//div[contains(text(),'Message must be at least 10 characters long')]")
    WebElement characterCountErrorMessage;

    public HelpAndSupportPage verifyErrorCountMessage() {
        Assert.assertTrue(shouldHaveText(characterCountErrorMessage, "Message must be at least 10 characters long", 5),
                "Email validation error did not appear!");
        return this;

    }
}

