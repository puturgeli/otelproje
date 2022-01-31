package tests.day011;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_windowHandle2 {

    //   ● Tests package’inda yeni bir class olusturun: WindowHandle2
    //   ● https://the-internet.herokuapp.com/windows adresine gidin.
    //           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //           ● Click Here butonuna basın.
    //           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test() {
        //   ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        String windowhandle = driver.getWindowHandle();
        System.out.println(windowhandle);

        //           ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actual = driver.findElement(By.tagName("h3")).getText();
        String expected = "Opening a new window";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actual, expected);

        //           ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        softAssert.assertEquals(driver.getTitle(), "The Internet");

        //           ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //           ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().activeElement();
        Set<String> handles = driver.getWindowHandles();
        String newWindowhandle = "";
        for (String each : handles) {
            if (!each.equals(windowhandle)) {
                newWindowhandle = each;
            }

        }


         driver.switchTo().window(newWindowhandle);
        softAssert.assertEquals(driver.getTitle(), "New Window");

        //           ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        softAssert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        //           ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(windowhandle);
        softAssert.assertEquals(driver.getTitle(), "The Internet");


        softAssert.assertAll();
    }

    @AfterClass
    public void teardown() {
        driver.quit();


    }


}
