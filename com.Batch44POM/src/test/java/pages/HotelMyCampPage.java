package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {
  public   HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement LoginButonu;

  @FindBy(id="UserName")
    public WebElement userNameKutusu;

  @FindBy (id="Password")
    public WebElement passWordKutusu;

  @FindBy(id="btnSubmit")
    public WebElement loginButon;
  @FindBy(css="[class=\"validation-summary-errors\"]")
  public WebElement girisyapilamadiYazisi;

  @FindBy(xpath="//span[text()='ListOfUsers']")
  public WebElement basariliGirisYaziElementi;

  public void bekleme(int bekle){
    try {
      Thread.sleep(bekle);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @FindBy(xpath = "//span[text()='Hotel Management']")
  public WebElement HotelManagementElement;

  @FindBy(xpath = "(//i[@class='icon-calendar'])[2]")
  public WebElement hotelListElement;

  @FindBy(xpath = "//a[@class='btn btn-circle btn-default']")
  public WebElement addHotelMetodu;

  @FindBy(css = "[id=\"Code\"]")
  public WebElement addHotelCodeKutusu;

  @FindBy(css = "[name=\"IDGroup\"]")
  public WebElement IDGRoup;

  @FindBy(css = "[id=\"btnSubmit\"]")
  public WebElement AddListSaveButonu;

  @FindBy(xpath = "(//div[@class='modal-body'])[2]")
  public WebElement addHotelSaveSuccesWord;

  @FindBy(xpath = "(//i[@class='icon-calendar'])[3]")
  public WebElement addHotelRoomsMetodu;

  @FindBy(css = "[name=\"IDHotelRoom\"]")
  public WebElement addHotelIdText;

  @FindBy(css = "[id=\"lkpHotels\"]")
  public WebElement addHotelIdHotelDropBox;

  @FindBy(css = "[id=\"lkpGroupRoomTypes\"]")
  public  WebElement addHotelIdGroupRoomTypesElement;




  public void girisYap() {

    Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));
    LoginButonu.click();
    userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
    passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
    loginButon.click();
  }



}
