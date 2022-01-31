package homeWorks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class day05_Q4 {
  public static void main(String[] args) {
    // 1. Bir class oluşturun: LocatorsIntro
    // 2. Main method oluşturun ve aşağıdaki görevi tamamlayın.
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    // a. http://a.testaddressbook.com adresine gidiniz.
      driver.navigate().to(" http://a.testaddressbook.com");

    // b. Sign in butonuna basin
      driver.findElement(By.id("sign-in")).click();

    // c. email textbox,password textbox, and signin button elementlerini locate ediniz..
      WebElement emailBoxText=driver.findElement(By.xpath("//input[@type='email']"));
      WebElement passBoxText=driver.findElement(By.xpath("//input[@type='password']"));
      WebElement signInButon=driver.findElement(By.xpath("//input[@type='submit']"));

    // d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    // i. Username : testtechproed@gmail.com
    // ii.Password : Test1234!
      emailBoxText.sendKeys("testtechproed@gmail.com");
      passBoxText.sendKeys("Test1234!");
      signInButon.click();

    // e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
      WebElement dogrulamaText=driver.findElement(By.tagName("h1"));
      String actualText=dogrulamaText.getText();
      String expectedText="Welcome to Address Book";
    System.out.println(
        actualText.equals(expectedText)
            ? "User Id Test: PASSED"
            : ("User Id Test: FAILED\n Actual Title: " + actualText));

    //  f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
    System.out.println(
        (driver.findElement(By.linkText("Addresses")).isDisplayed())
            ? "Adres Text Test: PASSED"
                : "Adres Text Test:FAILED");

      System.out.println(
              (driver.findElement(By.linkText("Sign out")).isDisplayed())
                      ? "Sign out Text Test: PASSED"
                      : "Sign out Text Test:FAILED");

    // 3. Sayfada kac tane link oldugunu bulun.
      List<WebElement>linklist=driver.findElements(By.tagName("a"));
    // 4.Linklerin yazisini nasil yazdirabiliriz
    System.out.println("Sayfadaki Link Sayısı: " + linklist.size());

    // 5. driver i kapatin
      driver.close();







  }
}
