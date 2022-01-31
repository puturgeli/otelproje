package tests.day012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import javax.swing.*;

public class C02_MouseActions extends TestBase {



    @Test
    public void mouseActionTest() throws InterruptedException {

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        //sag üstte "Hello SignIn" elementinin üzerinde mouse'u bekletin

        Actions actions=new Actions(driver ) ;
        WebElement helloElement=driver.findElement(By.xpath("//*[@class='nav-line-1-container']"));
        WebElement createListElementi= driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        // acılan menuden new list linkine tıklayın

        actions.moveToElement(helloElement).click(createListElementi).perform();

        //actions.click(createListElementi).perform();

        Thread.sleep(5000);

        //ve new list sayfasının açıldıgını test edin
        String actualTitle= driver.getTitle();
        String arananMetin="Your List";
        Assert.assertTrue(actualTitle.contains(arananMetin));

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains(arananMetin));



        softAssert.assertAll();


    }





}
