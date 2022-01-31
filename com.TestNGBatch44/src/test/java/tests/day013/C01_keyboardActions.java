package tests.day013;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_keyboardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions2


    @Test
    public void test01(){
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.navigate().to("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin

       Actions actions=new Actions(driver);
        actions.
        sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iframeElement=driver.findElement(By.xpath("//iframe[@class='lazy-loaded']"));
        driver.switchTo().frame(iframeElement);


        //4- videoyu izlemek icin Play tusuna basin


        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton=driver.findElement(By.xpath("//button[@title='Duraklat (k)']"));
        Assert.assertTrue(pauseButton.isEnabled(), "Video is not working. TEST FAİLED");




    }

}
