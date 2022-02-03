package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    // bir page class'ı açtıgımızda ilk yapmamız gereken şey
    // parametresiz bir constructur oluşturup
    // bu constructur içinde pageFactory ile driver'a ilk deger atamasını yapmak olmalıdır


   public AmazonPage(){
    PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id="twotabsearchtextbox")
    public WebElement amazonAramaKutusu;

   @FindBy(xpath="//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucYazisiElemnti;



}
