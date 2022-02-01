import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class JUnitTest {
  static WebDriver driver;

  @BeforeClass
  public static void setup() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  }

  @Test
  public void test01() throws InterruptedException {
    // https://www.amazon.com.tr sitesine gidelim
    driver.get("https://www.amazon.com");

    // Ana sayfanın açıldıgı kontrol edin

    boolean titleTest = driver.getTitle().contains("Amazon");
    Assert.assertTrue(titleTest);

    // çerez tercihlerinden Çerezleri kabul et seçilir

    // siteye login olun
    mouseAcountListUstune(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-al-signin']")));
    loginOl(driver);

    // login işlemi kontrol edin
    mouseAcountListUstune(driver);
    WebElement sigOutElement = driver.findElement(By.xpath("//span[text()='Sign Out']"));
    // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Sign
    // Out']")));
    Assert.assertTrue(sigOutElement.isDisplayed());

    // arama butonunun yanındaki kategörüler tabından bilgisayar secilir
    WebElement dropBoxMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
    Select select = new Select(dropBoxMenu);
    select.selectByVisibleText("Computers");

    // bilgisayar kategorisi seçildigi kontrol edilir
    Assert.assertTrue(driver.findElement(By.xpath("//option[text()='Computers']")).isDisplayed());

    // arama aranına msi yaz ve arama yapın
    WebElement textBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
    textBox.sendKeys("msi" + Keys.ENTER);

    // aramanın yapıldıgını kontrol et
    WebElement sonucYazisi =
        driver.findElement(
            By.cssSelector("[class=\"a-section a-spacing-small a-spacing-top-small\"]"));
    boolean sonucYazisiTesti = sonucYazisi.getText().contains("msi");
    Assert.assertTrue(sonucYazisiTesti);

    // arama sonucları sayfasından 2. sayfa açılır
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("scroll(0,1000)");
    driver.findElement(By.cssSelector("[class=\"s-pagination-item s-pagination-button\"]")).click();

    // 2. sayfanın açıldıgı kontrol edilir
    boolean ikinciSayfaKontrol = driver.getCurrentUrl().contains("page=2");
    Assert.assertTrue(ikinciSayfaKontrol);

    // sayfadaki 2. ürün favorilere eklenir
    driver.findElement(By.xpath("(//img[@class='s-image'])[2]")).click();

    String ikinCiUrunTitle = driver.findElement(By.xpath("//span[@id='productTitle']")).getText();

    driver.findElement(By.xpath("//input[@title='Add to List']")).click();

    js.executeScript("scroll(0,300)");
    Thread.sleep(3000);
    List<WebElement> createList =
        driver.findElements(By.xpath("//span[@class='a-button a-button-primary']"));
    if (!createList.isEmpty()) {
      driver.findElement(By.xpath("//span[@class='a-button a-button-primary']")).click();
      driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();

    } else {
      driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
    }

    // 2. ürünün favorilere eklendigi kontrol edilir
    mouseAcountListUstune(driver);
    Thread.sleep(1000);
    WebElement shoppingList = driver.findElement(By.xpath("//span[text()='Shopping List']"));
    shoppingList.click();
    //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-row
    // a-size-small']")));
    String sepettekiUrunTitle =
        driver.findElement(By.xpath("//h2[@class='a-size-base']")).getText();
    Assert.assertEquals(sepettekiUrunTitle, ikinCiUrunTitle);
  }

  @Test
  public void test02() {

    // hesabım->  favori listem sayfasına gidilir
    driver.get("https://www.amazon.com");
    mouseAcountListUstune(driver);
    WebElement shoppingList = driver.findElement(By.xpath("//span[.='Shopping List']"));
    shoppingList.click();

    // favori Listem sayfası açıldıgı kontrol edilir
    boolean yourListElement =
        driver.findElement(By.xpath("//li[@id='my-lists-tab']")).isDisplayed();
    Assert.assertTrue(yourListElement);

    // eklenen ürün favorilerden silinir
    driver.findElement(By.xpath("//input[@name='submit.deleteItem']")).click();

    // silme işleminin gerçekleştigi kontrol edilir.
    boolean deleteElement = driver.findElement(By.xpath("(//div[.='Deleted'])[3]")).isDisplayed();
    Assert.assertTrue(deleteElement);

    // üye çıkış işlemi yapılır
    mouseAcountListUstune(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Sign Out']")));
    driver.findElement(By.xpath("//span[.='Sign Out']")).click();

    // çıkış işleminin yapıldıgı kontrol edilir.
    boolean sigInElement = driver.findElement(By.tagName("h1")).getText().contains("Sign-In");
    Assert.assertTrue(sigInElement);
  }

  private void loginOl(WebDriver driver) {
    driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();

    WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
    Actions actions = new Actions(driver);
    actions
        .click(email)
        .sendKeys("puturgeli1isi@gmail.com")
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.ENTER)
        .perform();
    WebElement pasword = driver.findElement(By.xpath("//input[@id='ap_password']"));
    actions
        .click(pasword)
        .sendKeys("Aa115436--")
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB)
        .sendKeys(Keys.ENTER)
        .perform();
  }

  private void mouseAcountListUstune(WebDriver driver) {
    WebElement SingInElement = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
    Actions actions = new Actions(driver);
    actions.moveToElement(SingInElement).perform();
  }
}
