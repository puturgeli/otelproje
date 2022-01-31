package tests.day010;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C03 {
WebDriver driver;
@BeforeClass
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
@Test
    public void IframeTest(){

    //   Bir class olusturun: IframeTest

//  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    driver.navigate().to("https://the-internet.herokuapp.com/iframe");

//  ● Bir metod olusturun: iframeTest

//       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.

    WebElement istenenYazi=driver.findElement(By.tagName("h3"));
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(istenenYazi.isDisplayed(),"Iframe yazısını Görünmüyor");
    System.out.println("istenen yazı: " + istenenYazi.getText());
//       ○ Text Box’a “Merhaba Dunya!” yazin.




    //yazı yazmak istedigimiz text kutusu iframe'in içinde oldugundan direkt ulaşamıyoruz
    // önce iframe'i locate edip onun içine switch yapmamız gereklidir.
    WebElement iframe=driver.findElement(By.tagName("iframe"));
    driver.switchTo().frame(iframe);

    WebElement textBox= driver.findElement(By.tagName("p"));
    textBox.clear();
    textBox.sendKeys("Merhaba Dünya");


    //yukarıdaki iframe'in içine switch yaptıgımız için yeniden dışarı cıkmak istedigimizde
    //önce ana sayfaya dönmeliyiz

    driver.switchTo().defaultContent();

 driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


    // ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu     dogrulayin ve  konsolda yazdirin.

    //sponsor yazısı yeni sayfada oldugundan ve driver'ımız eski sayfada kaldıgından
    //text'i locate edemedik.

    driver.get("http://elementalselenium.com/");
    WebElement sponsorYazisi=driver.findElement(By.xpath("//p[text()='Sponsored by ']"));


    softAssert.assertTrue(sponsorYazisi.isDisplayed(),"Sponsor yazısı görülemedi.");

    softAssert.assertAll();

}


@AfterClass
    public void teardown(){
    driver.quit();
}





}
