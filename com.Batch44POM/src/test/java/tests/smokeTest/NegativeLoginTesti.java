package tests.smokeTest;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTesti {
    // 1) smokeTest  paketi altinda yeni bir Class olustur: NegativeTest
    // 3 Farkli test Methodunda 3 senaryoyu test et



    //                - yanlisSifre
    //                - yanlisKulllanici
    //                - yanlisSifreKullanici
    // test data yanlis username: manager1 , yanlis password : manager1
    // 2) https://www.hotelmycamp.com adresine git
    // 3) Login butonuna bas
    // 4) Verilen senaryolar ile giris yapilamadigini test et
    HotelMyCampPage hmycp;
  @Test
  public void yanlisSifreTesti() {
      Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));
      hmycp=new HotelMyCampPage();
      hmycp.LoginButonu.click();
      hmycp.userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
      hmycp.passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCWrongpasword"));
      hmycp.loginButon.click();
      Assert.assertTrue(hmycp.girisyapilamadiYazisi.isDisplayed());
      Driver.closeDriver();

      }

    @Test
    public void yanlisKullaniciTesti() {
      Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));
        hmycp=new HotelMyCampPage();
      hmycp.LoginButonu.click();
      hmycp.userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCWrongUsername"));
      hmycp.passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
      hmycp.loginButon.click();
      Assert.assertTrue(hmycp.girisyapilamadiYazisi.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void yanlisKullaniciPasswordTesti() {
      Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));
        hmycp=new HotelMyCampPage();
      hmycp.LoginButonu.click();
      hmycp.userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCWrongUsername"));
      hmycp.passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCWrongpasword"));
      hmycp.loginButon.click();
        Assert.assertTrue(hmycp.girisyapilamadiYazisi.isDisplayed());
        Driver.closeDriver();

    }


}
