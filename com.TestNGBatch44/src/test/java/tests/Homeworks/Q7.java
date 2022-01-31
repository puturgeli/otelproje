package tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q7 {
WebDriver driver;
    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void n11Test(){
        driver.navigate().to("https://www.n11.com/");

    }

    @Test (priority = 2)
    public void gittigidiyorTest(){
        driver.navigate().to("https://www.gittigidiyor.com/");

    }

    @Test(dependsOnMethods = "gittigidiyorTest")
    public void getirTesti(){
        driver.navigate().to(" https://getir.com/");


    }

    @Test (dependsOnMethods = "getirTesti")
    public void sahibindenTest(){
        driver.navigate().to("https://www.sahibinden.com/");

    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
