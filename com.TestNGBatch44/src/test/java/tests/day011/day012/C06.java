package tests.day012;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06 extends TestBase {

    @Test
    public void D15_MouseActions4() throws InterruptedException {
        //Yeni bir class olusturalim: D15_MouseActions4
        //1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement ad = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.click(ad).
                sendKeys("suat").
                sendKeys(Keys.TAB).
                sendKeys("oruc").
                sendKeys(Keys.TAB).
                sendKeys("abc@hotmail.com").
                sendKeys(Keys.TAB).
                sendKeys("abc@hotmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Aa11s2345-").
                perform();

        //4- Kaydol tusuna basalim

        WebElement kaydolButonElementi = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
        actions.click(kaydolButonElementi).perform();
        Thread.sleep(5000);


    }


}
