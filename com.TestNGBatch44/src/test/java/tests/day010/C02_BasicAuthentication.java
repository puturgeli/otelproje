package tests.day010;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BasicAuthentication {


    //   1- Bir class olusturun : BasicAuthentication

WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void authenticationTest(){
        //   2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //   3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //                Html komutu : https://username:password@URL
        //                Username     : admin
        //                password      : admin


        //basic autohentication isteyen web servisleri bize nasıl ve hangi bilgileri birebir uygulayarak
        //bi de bize tarif edilen yöntem ve bize verilen bilgileri  birebir uygulayarak
        //istedigimiz web servise gitmemizi saglar

         driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //   4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement cograntMessageElement=driver.findElement(By.tagName("p"));
        Assert.assertTrue(cograntMessageElement.isDisplayed());

    }


    @AfterClass
    public void tearDown(){
        driver.close();

    }

}
