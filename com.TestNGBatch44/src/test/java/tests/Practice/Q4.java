package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4 {
    WebDriver driver;



    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.saucedemo.com/");

    }

    @Test
    public void sauceDemoTest01(){

        WebElement userElement=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passElement=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginElement=driver.findElement(By.xpath("//input[@id='login-button']"));


       /* Actions actions=new Actions(driver);
        actions.click(userElement)
                .sendKeys("standard_user").
                sendKeys(Keys.TAB).
                sendKeys("secret_sauce").sendKeys(Keys.ENTER).perform();*/

        userElement.sendKeys("standard_user");
        passElement.sendKeys("secret_sauce");
        loginElement.click();

        WebElement dd=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(dd);
        select.selectByVisibleText("Price (low to high)");

        String expected="PRICE (LOW TO HIGH)";
        String actual=driver.findElement(By.className("active_option")).getText();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actual,expected,"Fiyatlar İstenildigi gibi sıralanamadı.");

        softAssert.assertAll();


        /*
         * Navigate to  https://www.saucedemo.com/
         *
         *
         * Enter the user name  as standard_user
         * Enter the password as   secret_sauce
         * Click on login button
         *     T1 : Choose price low to high
         *     T2 : Verify item prices are sorted from low to high with soft Assert
         */








    }
    @Test
    public void sauceDemoTest02(){

        WebElement userElement=driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passElement=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement loginElement=driver.findElement(By.xpath("//input[@id='login-button']"));
        userElement.sendKeys("standard_user");
        passElement.sendKeys("secret_sauce");
        loginElement.click();

        WebElement dd=driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        Select select=new Select(dd);
        select.selectByIndex(2);

        List<WebElement>fiyatlar=driver.findElements(By.className("inventory_item_price"));
        ArrayList <Double>fiyatlarDouble=new ArrayList<>();
        for (WebElement w:fiyatlar){
            String fiyatStr=w.getText().replaceAll("\\D","");
            fiyatlarDouble.add((Double.parseDouble(fiyatStr)));

        }

        ArrayList<Double> kontrolList=new ArrayList<>(fiyatlarDouble);

        Collections.sort(kontrolList);


        Assert.assertEquals(kontrolList,fiyatlarDouble);







    }




    @AfterClass
    public void teardown(){

        driver.close();
    }

}
