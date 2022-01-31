package tests.Homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q6 {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test01() {

        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actuaclText = driver.findElement(By.xpath("//h3[1]")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actuaclText, expectedText);


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualtitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualtitle, expectedTitle);


        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualnewTitle = driver.getTitle();
        String expectednewTitle = "New Window";
        Assert.assertEquals(actualnewTitle, expectednewTitle);


        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualnewText = driver.findElement(By.tagName("h3")).getText();
        String expectednewText = "New Window";
        Assert.assertEquals(actualnewText, expectednewText);


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.navigate().back();
        String title= driver.getTitle();
        String expexted="The Internet";
        Assert.assertEquals(title,expexted);


    }


    @AfterClass
    public void teardown(){

        driver.close();
    }




}
