package tests.day012;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05KeyboardBaseAction extends TestBase {
    //1- Bir Class olusturalim KeyboardActions1


    @Test
    public void KeyboardActions1() throws InterruptedException {

        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    WebElement aramaBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        Actions actions=new Actions(driver);
        actions.click(aramaBox).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();




        //4- aramanin gerceklestigini test edin



       // aramaBox.sendKeys("Samsung A71"+ Keys.ENTER);
        Thread.sleep(7000);
    }

}
