import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03 {

static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();
        ChromeOptions op=new ChromeOptions();
        op.addArguments("--disable-notifications");

    }

    @AfterClass
    public static void teardown(){



    }

    @Test
    public void test01(){

        //https://www.teknosa.com adresine gidelim
        driver.get("https://www.teknosa.com/");

    // arama cubuguna oppa yazıp aratalım
    driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);

        //sonuc sayısını yazdıralım
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
    System.out.println("Sonuc Sayısı:  " + sonucSayisi.getText());

        //çıkan ilk ürüne tıklayalım
        driver.findElement(By.xpath("(//div[@id='product-item'])[1]")).click();

        //sepete ekleyelim
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");


        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();

        //sepetime git'e tıklayalım
        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

    // consol da sipariş özeti" webelementinin text'ini yazdırın
    System.out.println(driver.findElement(By.xpath("//div[@class='cart-sum-body']")).getText());

        //alışverişi tamamlayın
        driver.findElement(By.xpath("//a[@title='Alışverişi Tamamla']")).click();

    // son olarakda "teknosa'ya hoş geldiniz" webelementinin text'ini yazdırın
    System.out.println(
        driver.findElement(By.xpath("//div[.='Teknosa’ya hoş geldiniz']")).getText());

        //driver'ı kapatın
        driver.close();


    }







}
