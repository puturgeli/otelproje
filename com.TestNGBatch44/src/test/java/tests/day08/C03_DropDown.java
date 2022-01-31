package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    WebDriver driver;
//    ● Bir class oluşturun: DropDown
@BeforeTest
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

@Test
    public void Test(){
    //   ● https://the-internet.herokuapp.com/dropdown adresine gidin.

    driver.get(" https://the-internet.herokuapp.com/dropdown");

    WebElement dropList=driver.findElement(By.xpath("//select[@id='dropdown']"));

    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Select select=new Select(dropList);
    select.selectByIndex(1);
    System.out.println(select.getFirstSelectedOption().getText());

    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    select.selectByValue("1");
    System.out.println(select.getFirstSelectedOption().getText());

    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    select.selectByValue("2");
    System.out.println(select.getFirstSelectedOption().getText());

    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    select.selectByVisibleText("Option 1");
    System.out.println(select.getFirstSelectedOption().getText());

    //    4.Tüm dropdown değerleri(value) yazdırın
    List<WebElement>optionList=select.getOptions();
    int t=0;
    for (WebElement w:optionList ) {
        System.out.println(t+". index elemanı: "+w.getText());
        t++;
    }

    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.

    int actualSize=optionList.size();
    int expectedSize=4;
    Assert.assertEquals(actualSize,expectedSize,"False");



}
@AfterMethod
    public void teardown(){
    driver.close();
}

}
