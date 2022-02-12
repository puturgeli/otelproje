package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.lang.invoke.CallSite;
import java.util.List;

public class HotelMyCampPage {

    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
         }


    @FindBy(xpath = "//a[.='Log in']")
    public WebElement anaSatfaLoginButonu;

    @FindBy(css = "[name=\"UserName\"]")
    public WebElement  userNameTextBox;

    @FindBy(css = "[id=\"Password\"]")
    public WebElement passwordTextBox;

    @FindBy(css = "[id=\"btnSubmit\"]")
    public WebElement loginSayfaiLoginButonu;

    @FindBy(xpath="//span[text()='ListOfUsers']")
    public WebElement basariliGirisYaziElementi;

    @FindBy(css = "[class=\"validation-summary-errors\"]")
    public WebElement girisYapilamadiYaziElemendi;

    @FindBy(xpath = "//*[contains(text(),'Single ')]")
    public WebElement kullaniciPageSigleRoomButonElement;

    @FindBy(xpath = "(//a[@class=\"btn-custom\"])")
    public List<WebElement> kullanisiPageSinngleRoomOdaListesi;


    @FindBy(css = "[id=\"checkin_date\"]")
    public WebElement checkInDateelement;

    @FindBy(css = "[id=\"checkout_date\"]")
    public WebElement checkOutDateElement;

    @FindBy(css = "[id=\"AdultCount\"]")
    public WebElement selectAdultCountElement;

    @FindBy(css = "[id=\"ChildrenCount\"]")
    public WebElement selectChildCountElement;
    @FindBy(css = "[id=\"NameOnCreditCard\"]")
    public WebElement nameonCrediCartElement;

    @FindBy (css = "[name=\"CreditCardNumber\"]")
    public WebElement numberOnCreditCard;

    @FindBy(css = "[id=\"CreditCardExpirationYear\"]")
    public WebElement crediCardExpirationyearElement;

    @FindBy(css = "[id=\"CreditCardExpirationMonth\"]")
    public WebElement crediCartExpiratinMonthElement;

    @FindBy(css = "[id=\"CVV\"]")
    public WebElement crediCartCVVElement;

    @FindBy(css = "[id=\"Message\"]")
    public WebElement mesageFormElement;

    @FindBy(css = "[value=\"Book this room\"]")
    public WebElement bookThisRoomButonElement;

    @FindBy(css = "[class=\"bootbox-body\"]")
    public WebElement BasariliRezervasyonYapildiYaziElement;

    @FindBy(css = "[data-bb-handler=\"ok\"]")
    public WebElement basariliKayitPenceresiOkButonElementi;






}
