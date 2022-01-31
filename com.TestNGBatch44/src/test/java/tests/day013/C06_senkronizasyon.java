package tests.day013;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_senkronizasyon extends TestBase {


    @Test
    public void test01() throws InterruptedException {

       /*
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-submit")).click();
*/
       /* driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]")).click();
*/

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        //enable butonuna tıklayalım sonra alttaki, yazının Its eneabled yazısı çıktıgını test edin
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();




       // Thread.sleep(3000);
        WebElement sonucYazisi=driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertTrue(sonucYazisi.isDisplayed());

                        Thread.sleep(5000);





    }



}
