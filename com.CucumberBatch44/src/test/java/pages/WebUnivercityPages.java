package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebUnivercityPages {
    public WebUnivercityPages(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "(//div[@class='section-title'])[2]")
    public WebElement webUniversityLoginButton;

    @FindBy(xpath = "//input[@id='text']")
    public WebElement webUniversityUserNameButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement webUniversityPasswordButton;

    @FindBy(css = "[id=\"text\"]")
    public WebElement usernameBox;

    @FindBy(css = "[id=\"password\"]")
    public WebElement passwordBox;

    @FindBy(css = "[id=\"login-button\"]")
    public WebElement loginbutonElement;





}
