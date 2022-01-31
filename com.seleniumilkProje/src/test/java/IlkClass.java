import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class IlkClass {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Suat\\IdeaProjects\\com.seleniumilkProje\\resources\\drivers\\chromedriver.exe");
        System.setProperty("webdriver.edge.driver","C:\\Users\\Suat\\IdeaProjects\\com.seleniumilkProje\\resources\\drivers\\msedgedriver.exe");


        WebDriver driver=new ChromeDriver();
          driver.get("https://www.google.com");

          WebDriver driver1=new EdgeDriver();
          driver1.get("https://www.amazon.com");


    }
}
