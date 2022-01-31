package tests.tekrarCalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techproeducation.com/");
        driver.manage().deleteAllCookies();
    }

    @Test
    public void test01(){
        String actualTitle=driver.getTitle();
        String expectedTitle="Profesyonel Teknoloji Eğitimi";

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title'da Profesyonel Teknoloji Eğitimi yazısı yok");

        //programlar bölümüne gidelim
        driver.findElement(By.xpath("//a[@class='nav-link dropdown-toggle']")).click();



    }



    @AfterClass
    public void teardown(){


    }

}
