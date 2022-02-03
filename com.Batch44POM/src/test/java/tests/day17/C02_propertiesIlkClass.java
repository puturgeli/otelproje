package tests.day17;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_propertiesIlkClass {

  @Test
  public void positiveLoginTesti() {

    // hotel mycamp sitesine positie login testini POM'a tam uygun olarak yapınız

    // https://www. hotelmycamp.com/ adresine git
    //  Driver.getDriver().get("buraya properties dosyasına git HMYCUrl'e karşılık gelen degeri getir");
    Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));

    //        login butonuna bas
    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    hotelMyCampPage.LoginButonu.click();
    hotelMyCampPage.userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));
    hotelMyCampPage.passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
    hotelMyCampPage.loginButon.click();

    //    test data username: manager ,
    //    test data password : Manager1!
    //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    Assert.assertTrue(hotelMyCampPage.basariliGirisYaziElementi.isDisplayed());



    Driver.closeDriver();

  }
}
