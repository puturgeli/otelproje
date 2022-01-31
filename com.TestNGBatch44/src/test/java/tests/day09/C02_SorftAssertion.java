package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SorftAssertion {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       }

       @Test
       public void test01(){

//     Yeni bir Class Olusturun : C03_SoftAssert
//  1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.navigate().to("http://zero.webappsecurity.com/");

//  2. Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

//  3. Login kutusuna “username” yazin
WebElement loginKutusu= driver.findElement(By.xpath("//input[@tabindex='1']"));
loginKutusu.sendKeys("username");

//  4. Password kutusuna “password” yazin
        WebElement passKutusu=driver.findElement(By.xpath("//input[@tabindex='2']"));
        passKutusu.sendKeys("password");

//  5. Sign in tusuna basin
           driver.findElement(By.xpath("//input[@type='submit']")).click();
           driver.navigate().back();//güvenli degil uyarısını geciyoruz
driver.findElement(By.xpath("//*[.='Online Banking']")).click();
driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();


//  6. Pay Bills sayfasina gidin
//  7. “Purchase Foreign Currency” tusuna basin
   driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();

//  8. “Currency” drop down menusunden Eurozone’u secin
    WebElement dropdown=driver.findElement(By.xpath("//select[@id='pc_currency']"));
           Select select=new Select(dropdown);
           select.selectByValue("EUR");


//  9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
           SoftAssert softAssert=new SoftAssert();
           String actualSecim=select.getFirstSelectedOption().getText();
           String expectedSecim="Eurozone (euro)";
           softAssert.assertEquals(actualSecim,expectedSecim,"dropdown dogru secilemedi");
           System.out.println("Hard assertion'da ilk assertion failed olsaydi, bu satir calismazdi");


//  10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
      List<WebElement> optinList=select.getOptions();


      String actualOptionListString="";

           for (WebElement each:optinList ) {
           actualOptionListString += "\""+each.getText()+"\", ";

           }

           actualOptionListString=actualOptionListString.substring(0,actualOptionListString.length()-2);
           String expectedListStringOlarak="\"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China (yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong (dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand (dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";

           softAssert.assertEquals(actualOptionListString,expectedListStringOlarak);

           softAssert.assertAll();
           System.out.println("testlerden failed olan varsa softAssert.assertAll'dan sonrasi calismaz");

           // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
 // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
 // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
 // "Thailand (baht)"



       }


    @AfterClass
    public void tearDown(){
        driver.close();

    }






}
