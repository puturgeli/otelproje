package tests.day010;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_allerts {

//
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //    ● Bir class olusturun: Alerts
       //   ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }

    @Test
    public void acceptAlertsTesti(){
        //   ● Bir metod olusturun: acceptAlert
       //        ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();

     //   ve result mesajının “You successfully clicked an alert” oldugunu test edin.

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().equals("You successfully clicked an alert"));



    }

    @Test
    public void dismissAlertsTesti() throws InterruptedException {
        //   ● Bir metod olusturun: dismissAlert
        //       ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın
        //  ve result mesajının “successfuly” icermedigini test edin.

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
       Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Assert.assertFalse(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("successfuly"));



    }

    @Test
    public void textAlertsTesti() throws InterruptedException {
        //   ● Bir metod olusturun: sendKeysAlert
        //    ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("suat");

        // OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).getText().contains("suat"));



    }


    @AfterClass
    public void teardown(){
        //driver.close();
    }
}
