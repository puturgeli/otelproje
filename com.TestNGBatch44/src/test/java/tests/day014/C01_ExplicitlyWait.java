package tests.day014;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
//1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //     Iki metod icin de asagidaki adimlari test edin.




    @Test
    public void implicitylWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
          //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]")).click();


        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
       WebElement xDoneElemet= driver.findElement(By.xpath("//p[@id='message']"));
       String expected="It's gone!";
        Assert.assertTrue(xDoneElemet.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]")).click();


        //7. It’s back mesajinin gorundugunu test edin
        WebElement backMesageElemet= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(backMesageElemet.isDisplayed());







    }



    @Test
    public void explicitylWaitTest(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.


    //    Iki metod icin de asagidaki adimlari test edin.
    //    3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //explici kullanabilmek için bir wait objesi tanımlama lazım
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
    //    4. Remove butonuna basin.
        driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]")).click();

        /*    WebElement xDoneElemet= driver.findElement(By.xpath("//p[@id='message']"));
        wait.until(ExpectedConditions.visibilityOf(xDoneElemet));

        Her ne kadar önce locate edelim sonra bekleyelim davranışı daha güzel görünse de
         web element zaten görünüz olmadıgından locate etmemiz de mümkün olmayacaktır.
         bunun için locate ve bekleme işlemini beraber yapmamaız gerekmektedir.

        */

    //    5. “It’s gone!” mesajinin goruntulendigini dogrulayin.

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement xDoneElemet= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(xDoneElemet.isDisplayed());


        //    6. Add buttonuna basin
        driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]")).click();


        //    7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement backMesageElemet= driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(backMesageElemet.isDisplayed());

        //


    }




}
