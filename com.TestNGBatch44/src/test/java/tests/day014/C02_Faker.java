package tests.day014;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {


    @Test
    public void facebookKayit() throws InterruptedException {
        ////"https://facebook.com"  Adresine gidin

        driver.get("https://facebook.com");

        //    //“create new account”  butonuna basin
        WebElement crateButton=driver.findElement(By.cssSelector("[data-testid=\"open-registration-form-button\"]"));
crateButton.click();

        //    //“firstName” giris kutusuna bir isim yazin
        WebElement firstName=driver.findElement(By.cssSelector("[name=\"firstname\"]"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();

        Actions actions=new Actions(driver);
        actions.click(firstName).
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).
                sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("21").sendKeys(Keys.TAB).sendKeys("Mar").sendKeys(Keys.TAB).
                sendKeys("1975").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).perform();


        WebElement erkeksecim=driver.findElement(By.xpath("//input[@value=\"2\"]"));
        WebElement kadınsecim=driver.findElement(By.xpath("//input[@value=\"1\"]"));
        Assert.assertFalse(erkeksecim.equals(kadınsecim));
        Thread.sleep(5000);

        //    //“surname” giris kutusuna bir soyisim yazin
        //    //“email” giris kutusuna bir email yazin
        //    //“email” onay kutusuna emaili tekrar yazin
        //    //Bir sifre girin
        //    //Tarih icin gun secin
        //    //Tarih icin ay secin
        //    //Tarih icin yil secin
        //    //Cinsiyeti secin
        //    //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //    //Sayfayi kapatin



    }


}
