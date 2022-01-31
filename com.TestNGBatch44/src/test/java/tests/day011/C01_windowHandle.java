package tests.day011;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_windowHandle {

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        String windowsHanddle1 = driver.getWindowHandle();
        System.out.println("İlk Sayfanın Window  handle Degeri: " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);//yeni bir pencere açılır
        driver.get("https://www.bestbuy.com");
        String windowsHanddle2 = driver.getWindowHandle();
        System.out.println("ikinci Sayfanın Window  handle Degeri: " + driver.getWindowHandle());

        Set<String> handleDegerleri = driver.getWindowHandles();
        System.out.println("handle degerleri: " + handleDegerleri);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        //  bu anda amazonun açık oldugu sayfaya gecin ve nutella için arama yapın

        driver.switchTo().window(windowsHanddle1);
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("nutella" + Keys.ENTER);


        //bestbuy açık olan sayfaya gecin ve title'nın bestbuy içerdigini test edin
        driver.switchTo().window(windowsHanddle2);

        Assert.assertFalse(driver.getTitle().contains("bestbuy"));


        //facebook'un acık oldugu sayfaya geçin ve url'in https://www.facebook.com oldugunu test edin
        //eger açık olan pencelerden sadece bir tanesinin windowhandle degeri biliniyorsa
        //önce tüm handle degerlerini bulup bir set'e koyarız


        handleDegerleri = driver.getWindowHandles();

        //bu soru için şu anda bu set elemanınnda 3 adet handle degeri var
        // 1. ve 2. sayfanın windowhandle degerini biliyoruz
        //setimizde olmayan windowhandle degeri 3. sayfanın handle degeri olucaktır.

        String handleDegeri3 = "";
        for (String each : handleDegerleri) {
            if (!each.equals(windowsHanddle1) || !each.equals(windowsHanddle2)) {
                handleDegeri3 = each;

            }

        }


        driver.switchTo().window(handleDegeri3);
        String actualURL = driver.getCurrentUrl();
        String aranan = "https://www.facebook.com";
        Assert.assertEquals(actualURL, actualURL);

    }

    @AfterClass
    public void teardown() {
        driver.quit();


    }

}