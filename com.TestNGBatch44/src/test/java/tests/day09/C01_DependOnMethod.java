package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependOnMethod {
WebDriver driver;


  //  1. Test : Amazon ana sayfaya gittiginizi test edin
  //  2. Test : 1.Test basarili ise search Box’i kullanarak “Nutella” icin
  //  arama yapin ve aramanizin gerceklestigini Test edin
  //  3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin
  //  $16.83 oldugunu test edin

@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}

@Test()
public void logoTest(){
    //  Bir class oluşturun: DependsOnTest
    //   ● https://www.amazon.com/ adresine gidin.
    driver.get("https://www.amazon.com");
    WebElement logoElementi=driver.findElement(By.id("nav-logo-sprites"));
    Assert.assertTrue(logoElementi.isDisplayed());

}

@Test(dependsOnMethods = "logoTest")
public void aramaTesti() {
    WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
    String actualTitle= driver.getTitle();
    String expectedTitle="Nutella";
    Assert.assertTrue(actualTitle.contains(expectedTitle));

}

@Test(dependsOnMethods = "aramaTesti")
public void fiyatTesti(){
    //  3.Test : “Nutella” icin arama yapildiysa ilk urunu tiklayin ve fiyatinin

    driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
    String actual=driver.findElement(By.xpath("//span[@class='a-size-base a-color-price']")).getText();
String aranan="$14.99";
    Assert.assertEquals(actual,aranan);

    //  $14.99 oldugunu test edin




}



@AfterClass
    public void tearDown(){
driver.close();
    }

}
