package tests.tekrarCalismalari;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C07 extends TestBase {


   @Test
           public void test(){
       driver.get("https://www.n11.com");
       driver.manage().deleteAllCookies();

       if (driver.findElement(By.xpath("//div[@id='dengage-push-perm-slide']")).isDisplayed()){
           driver.findElement(By.xpath("(//button[@class='dn-slide-accept-btn'])[1]")).click();
       }

       Actions actions=new Actions(driver);
       actions.
               moveToElement(driver.findElement(By.xpath("(//a[@title='Elektronik'])[1]"))).
               click(driver.findElement(By.xpath("//a[@title='Telefon & Aksesuarları']"))).
               perform();
       WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='searchData']"));
       aramaKutusu.sendKeys("iphone 13"+ Keys.ENTER);

       WebElement ilkUrun= driver.findElement(By.xpath("(//img[@class='lazy'])[9]"));
  actions.click(ilkUrun).perform();
    //   ilkUrun.click();





   }





}
