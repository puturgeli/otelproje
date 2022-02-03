package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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





}
