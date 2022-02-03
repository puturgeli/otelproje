package tests.day16;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_FacebookPace {

  @Test
  public void test01() throws InterruptedException {
    // 1 - https://www.facebook.com/ adresine gidin
      Driver.getDriver().get("https://www.facebook.com");

    // 2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

    // 3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
      FaceBookPage faceBookPage=new FaceBookPage();
      Faker faker=new Faker();
      faceBookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
      faceBookPage.passKutusu.sendKeys(faker.internet().password());
      faceBookPage.loginButonu.click();

    // 4- Basarili giris yapilamadigini test edin

     Assert.assertTrue(faceBookPage.GirilemediYazisi.isDisplayed());

      Thread.sleep(2000);
      Driver.closeDriver();


  }
}
