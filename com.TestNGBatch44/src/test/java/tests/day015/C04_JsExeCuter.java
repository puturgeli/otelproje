package tests.day015;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExeCuter extends TestBase {


    @Test
    public void jsExecuterTest(){
        //amazon.com ana sayfaya gidelim
        driver.get("https://www.amazon.com");

        //1. adım Jsexecuter objesi oluştururuz
        JavascriptExecutor jss=(JavascriptExecutor)driver;

        //2. adım ilgili web elementini locate edelim

        WebElement selElementi=driver.findElement(By.xpath("//a[normalize-space()='Sell']"));

        //3. adım iligli script ve argumanı(bizim web elementi )ile objemiz üzerinden
        //executeScript method'umuzu çalıştıralım

        jss.executeScript("arguments[0].click();",selElementi);



//sell linkini javascriptExecuter ile tıklayalım

//ve ilgili sayfaya gittigimizi test edelim


    }

}
