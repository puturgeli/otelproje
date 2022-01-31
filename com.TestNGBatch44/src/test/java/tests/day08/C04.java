package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class C04 {
// ● Bir class oluşturun: C3_DropDownAmazon
// ● https://www.amazon.com/ adresine gidin.
    WebDriver driver;
   Select select;
    WebElement dropbox;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");
    }
    @Test
    public void Test01(){
        //             - Test 1
        //     Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        dropbox=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select =new Select(dropbox);
        List<WebElement>optionList=select.getOptions();
        int actualSize=optionList.size();
        int expectedSize=45;
        Assert.assertEquals(actualSize,expectedSize);

    }

    @Test
    public void Test02(){
        // -Test 2
        select =new Select(dropbox);
//             1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");

//     2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Java"+ Keys.ENTER);

//     3. Bulunan sonuc sayisini yazdirin
        WebElement Result=driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println("Bulunan sonuc Sayısı: " + Result.getText());
//     4. Sonucun Java kelimesini icerdigini test edin
        String actualTitle=(driver.findElement(By.xpath("(//span[@dir='auto'])[3]"))).getText();
        actualTitle=actualTitle.replaceAll("\"","");

        String expectedTitle="Java";
        Assert.assertEquals(actualTitle,expectedTitle);

    }




    @AfterClass
    public void teardown(){
        driver.close();

    }






}
