package tests.tekrarCalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02 {

    WebDriver driver;
    Select select;
    WebElement dropdownElementi;
    WebElement aramaKutusu;
    WebElement sepet;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void test1(){


        dropdownElementi = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        select=new Select(dropdownElementi);
        //- Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);
        select.selectByVisibleText("Electronics");
        //    2. Arama kutusuna kulaklık yazin ve aratin
        aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("kulaklık"+ Keys.ENTER);
        WebElement kulaklıkiphone=driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
        kulaklıkiphone.click();
        sepet=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        sepet.click();

    }

    @Test
    public void test2(){
        // 2 . ürün ara
       dropdownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropdownElementi);
        select.selectByVisibleText("Bayby");
        aramaKutusu.sendKeys("slime"+Keys.ENTER);

        WebElement ördek=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ördek.click();
        sepet.click();
    }

}

