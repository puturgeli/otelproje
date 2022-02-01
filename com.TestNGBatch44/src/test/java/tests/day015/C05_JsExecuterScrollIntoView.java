package tests.day015;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class C05_JsExecuterScrollIntoView extends TestBase {


    @Test
    public void scrollAction() throws InterruptedException {
        //1- Yeni bir class olusturun : ScroolInto

        //2- hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com");

        //3- 2 farkli test method’u olusturarak actions clasi ve Js Executor kullanarak asagidaki oda turlerinden ust sira ortadaki odayi tiklayin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        WebElement odaInceleElementi= driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        odaInceleElementi.click();

        Thread.sleep(3000);


        //4- istediginiz oda inceleme sayfasi acildigini test edin

    }


    @Test
    public void scrollJsExecuter() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
       driver.navigate().refresh();

       //javascript executer için ilk adım olarak  obje oluşturup driverı cast edelim
       JavascriptExecutor jss=(JavascriptExecutor) driver;

       //2. adım çalışacagımız web elementi locate edelim
        WebElement odaInceleElementi= driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));

        //3. adım ilgili script ve argument ile jse.executerscript metodunu çalıştıralım
        jss.executeScript("arguments[0].scrollIntoView(true);",odaInceleElementi);
        Thread.sleep(3000);
        jss.executeScript("arguments[0].click();",odaInceleElementi);
        Thread.sleep(3000);




    }
}
