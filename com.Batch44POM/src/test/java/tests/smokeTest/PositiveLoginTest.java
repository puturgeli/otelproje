package tests.smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {


    // 1) com.techproed altinda bir package olustur : smoketest
    // 2) Bir Class olustur : PositiveTest
    // 3) Bir test method olustur positiveLoginTest()
  @Test
  public void positiveLoginTest() {

    //         https://www.hotelmycamp.com adresine git
      Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));

    //        login butonuna bas
      HotelMyCampPage hmcp=new HotelMyCampPage();
      hmcp.LoginButonu.click();
    // test data username: manager ,
      hmcp.userNameKutusu.sendKeys(ConfigReader.getProperty("HMYCValidUserName"));

    // test data password : Manager1!
      hmcp.passWordKutusu.sendKeys(ConfigReader.getProperty("HMYCValidPassword"));
    hmcp.loginButon.click();
      // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

    Assert.assertTrue(hmcp.basariliGirisYaziElementi.isDisplayed());

    Driver.closeDriver();


  }
}
