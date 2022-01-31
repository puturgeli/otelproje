package tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q3 {
    WebDriver driver;

    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/



    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");

        //-->Task1 Find Dropdown on Multi Selection
        driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();

        //-->Task2 Find Dropdown Elements on page
        List<WebElement>dropList=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

        //-->Task3 printout DropDown Elements number
        System.out.println("DropDown menusunddeki Element Sayısı: " + dropList.size());


        //-->Task4 choose all dropdown elements and printout dropdown elements name
                // 1. yöntem   dropList.stream().forEach(t-> System.out.println(t.getText()+" "));
                //2. yöntem
        for (int i = 0; i <dropList.size() ; i++) {
String text=dropList.get(i).getText();
            System.out.println("text: " + text);
            if (!text.isEmpty()) {
                dropList.get(i).click();
            }
            if(text.equals("choice 6")) {
                dropList.get(1).click();


            }



        }


        //-->Task5 check until choise 6




    }

    @AfterClass
    public void teardown(){

        driver.close();
    }

}
