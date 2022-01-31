package tests.tekrarCalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01 {
    WebDriver driver;
    WebElement dropbox;
    WebElement dropbox1;
    WebElement dropbox2;
    WebElement dropbox3;
    Select select;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void Test01() throws InterruptedException {
       //sahibinden com adresine gidelim
        driver.get("https://www.sahibinden.com");

        //emlak bölümünü tıklayalım
        driver.findElement(By.xpath("//a[@title='Emlak']")).click();

        //arama kısmını konut olarak secelim
        driver.findElement(By.xpath("//a[@data-tab='home']")).click();

        //home kısmının altındaki satılık bölümündeki dropbox'ı locate edip satılık secenegini secelim
        dropbox=driver.findElement(By.xpath("(//div[@class='jspPane'])[2]"));
        select=new Select(dropbox);
        select.selectByIndex(0);

        //home kısmının altındaki form'da ikinci menuyu dropbox olarak locate edip daireyi secelim
        dropbox1=driver.findElement(By.xpath("//div[@class='sahibindenSelect subCategoryArea activeSelect']"));
        select=new Select(dropbox1);
        select.selectByIndex(1);

        //home kısmının altındaki formda il dropbox'ını locate edip locate edip şehir olarak istanbul'u secelim
        dropbox2=driver.findElement(By.xpath("//div[@class='sahibindenSelect city activeSelect']"));
        select=new Select(dropbox2);
        select.selectByVisibleText("İstanbul");

        //ilçe dropBox'ını locate edelim
        dropbox3=driver.findElement(By.xpath("(//li[@data-value=''])[1]"));
        select=new Select(dropbox3);
        select.selectByVisibleText("Esenler");

        Thread.sleep(2000);






    }





    @AfterClass
    public void teardown(){
        driver.close();
    }

}
