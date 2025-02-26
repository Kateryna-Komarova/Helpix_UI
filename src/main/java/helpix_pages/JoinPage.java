package helpix_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinPage extends BasePage {
    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]")
    WebElement joinWithGoogle;
    @FindBy(xpath = "//input[@id='identifierId']")
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
    public boolean verifyProfileIcon() {
        return isElementPresent(avatarIcon);
    }


}
