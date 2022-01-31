import com.google.j2objc.annotations.Weak;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class c02 {

  // http://the-internet.herokuapp.com/add_remove_elements/ sitwesine gidelim
  // add elemenbt butonuna tıklayalım 100 kere
  // wtıklamak için bir foksiyon yazın
  // cıkan delete butonu belirledigimiz bir sayıda tıklamak içn bir fonsksiyon yazın

  // 1 mthod :createmethod(100)
  // deletebuttn validate

  public static void main(String[] args) {

      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

      createButtons(driver,100);
      delebuttonsAndValidate(driver,60);






  }
    private static void createButtons(WebDriver driver, int i) {
        WebElement addButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

    for (int j = 0; j < 100; j++) {
        addButton.click();

    }
    }


    private static void delebuttonsAndValidate(WebDriver driver, int number) {
        List<WebElement>elements=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizebeforeDelete=elements.size();

       // List<WebElement>butonDelete=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sayac=0;
        for (WebElement w:elements){
            sayac++;
            if (sayac>number){
                break;
            }
            w.click();
        }

        List<WebElement>butonDeleteAfter=driver.findElements(By.cssSelector("[onclick='deleteElement()']"));
        int sizeAfterDelete=butonDeleteAfter.size();

        if ((sizebeforeDelete-number)==sizeAfterDelete){
      System.out.println("sizeAfterDelete: " + sizeAfterDelete);
      System.out.println("success");

        }else{
      System.out.println("FAILED");
        }





    }


}
