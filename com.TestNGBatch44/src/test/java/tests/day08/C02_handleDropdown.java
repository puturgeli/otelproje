package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_handleDropdown {
    WebDriver driver;
    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void dropDownTest() throws InterruptedException {
        //dropdown'da varolan seceneklerden birini secmek için
        // 1. adım : dropdownelementini locate edip degişkeni atıyoruz
        driver.get("https://www.amazon.com");
        WebElement dropdownElement=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        //ikinci adım select class'ından bir obje oluşturalım
        // ve parametre olarak locate ettigimiz webelementi yazalım

        Select select=new Select(dropdownElement);

        //3. adım select objesini kullanarak select class'ından varolan 3 secim metodundan
        // istedigimizi kullanarak dropdown'da var olan optionlardan birini secebiliriz
        //önemli olan şey şu: secim yapmamıza yardım eden bu üç metod void 'dir dolayısıyla bize bir şey döndürmezler.

        select.selectByIndex(3);

        //eger sectigimiz option degerini yazdırmak istersek
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);


        select.selectByVisibleText("Deals");
        Thread.sleep(2000);


        select.selectByValue("search-alias=baby-products-intl-ship");
        Thread.sleep(2000);

        List<WebElement> optionList=select.getOptions();
        for (WebElement w:optionList) {
            System.out.println(w.getText());


        }



    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }

}
