package day05_mavenProjeOlusturma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
  public static void main(String[] args) {
    //
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


  //  1. http://zero.webappsecurity.com sayfasina gidin
      driver.navigate().to("http://zero.webappsecurity.com");
  //  2. Signin buttonuna tiklayin
      driver.findElement(By.id("signin_button")).click();

  //  3. Login alanine  “username” yazdirin
      WebElement userName=driver.findElement(By.xpath("//input[@type='text']"));
      userName.sendKeys("username");
  //  4. Password alanine “password” yazdirin
      WebElement passWord=driver.findElement(By.xpath("//input[@type='password']"));
      passWord.sendKeys("password");

  //  5. Sign in buttonuna tiklayin
      driver.findElement(By.xpath("//input[@type='submit']")).click();

      driver.findElement(By.xpath("//button[@id='details-button']")).click();
      driver.findElement(By.xpath("//a[text()='zero.webappsecurity.com sitesine ilerle (güvenli değil)']")).click();

  //  6. Pay Bills sayfasina gidin
      driver.findElement(By.xpath("//a[text()='Pay Bills']")).click();

  //  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
      WebElement amountSend=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
      amountSend.sendKeys("20");

  //  8. tarih kismina “2020-09-10” yazdirin
WebElement date=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
date.sendKeys("2020-09-10");


  //  9. Pay buttonuna tiklayin

      driver.findElement(By.xpath("(//input[@type='submit'])")).click();

  //  10. “The payment was successfully submitted.” mesajinin ciktigini control edin

      String actualTitle=driver.findElement(By.xpath("(//span[text()='The payment was successfully submitted.'])")).getText();
      String expectedTitle="The payment was successfully submitted.";

    System.out.println(
        actualTitle.equals(expectedTitle)
            ? "Title Test: PASSED"
            : ("Title Test:FAILED\nACtual Title: " + actualTitle));

    driver.close();
  }
}
