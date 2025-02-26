package helpix_pages.profileNavigation;

import helpix_pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    }

