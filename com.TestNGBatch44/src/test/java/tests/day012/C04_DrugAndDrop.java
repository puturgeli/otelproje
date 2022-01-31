package tests.day012;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_DrugAndDrop extends TestBase {

    //Yeni bir class olusturalim: MouseActions2

    @Test
    public void MouseActions2() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim

        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement tasinacakElement= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement tasinacakHedefElement= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(tasinacakElement,tasinacakHedefElement).perform();



        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualDropYazisi1=tasinacakHedefElement.getText();
        String expectedDopYazisi="Dropped!";
        Assert.assertEquals(actualDropYazisi1,expectedDopYazisi);

        Thread.sleep(5000);


    }





}
