import com.beust.jcommander.Parameterized;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilies.TestBase;

import java.time.Duration;
import java.util.List;

public class C01  {
static WebDriver driver;
  static   WebElement MerhabaElementi;



    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @AfterClass
    public static void teardown(){
          // driver.quit();


    }


    @Test
    public void test01() throws InterruptedException {

        // https://www.amazon.com.tr sitesine gidelim

        driver.get("https://www.amazon.com.tr");

        sigInElement(driver);

        // Ana sayfanın açıldıgı kontrol edin
        boolean titleTest=driver.getTitle().contains("Amazon");
        // String expectedTitle="Amazon";
        Assert.assertTrue("TitleTest :FAILED ",titleTest);

        // çerez tercihlerinden Çerezleri kabul et seçilir
        WebElement cerezAccept=driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cerezAccept.click();

    // siteye login olun
  MerhabaElementi = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(MerhabaElementi).perform();
        Thread.sleep(2000);
      WebElement signInElenti=driver.findElement(By.xpath("(//span[@class=\"nav-action-inner\"])[1]"));
        actions.click(signInElenti).perform();
        WebElement epostaElenmti=driver.findElement(By.xpath("//input[@type='email']"));
        actions.click(epostaElenmti).sendKeys("puturgeli1isi@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        WebElement passwordElenmti=driver.findElement(By.xpath("//input[@type='password']"));
        actions.click(passwordElenmti).sendKeys("Aa115436--").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // login işlemi kontrol edin
        WebElement MerhabaElement = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));

       actions.moveToElement(MerhabaElement).perform();
        Thread.sleep(2000);
        WebElement hesabımElementi=driver.findElement(By.xpath("//span[text()='Hesabım']"));

        Assert.assertTrue(hesabımElementi.isDisplayed());

        //arama butonunun yanındaki kategörüler tabından bilgisayar secilir

        WebElement dropBox=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropBox);
        select.selectByVisibleText("Bilgisayarlar");

        // bilgisayar kategorisi seçildigi kontrol edilir
        Assert.assertTrue("Bilgisayar Elementi Secilmedi",driver.findElement(By.xpath("//option[text()='Bilgisayarlar']")).isDisplayed());

        // arama aranına msi yaz ve arama yapın
        WebElement aramaKutus=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutus.sendKeys("msi"+Keys.ENTER);

        // aramanın yapıldıgını kontrol et
        WebElement ResultText=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue("arama yapılmadı",ResultText.getText().contains("msi"));

        // arama sonucları sayfasından 2. sayfa açılır
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='2']")).click();


        // 2. sayfanın açıldıgı kontrol edilir
        String page2=driver.getCurrentUrl();
        Assert.assertTrue("2.sayfada degiliz. ",page2.contains("page=2"));


        //sayfadaki 2. ürün favorilere eklenir
        WebElement ikinciUrunElementi=driver.findElement(By.xpath("(//img[@data-image-latency='s-product-image'])[2]"));
        actions.click(ikinciUrunElementi).perform();

        WebElement addList=driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-submit']"));
        addList.click();
        Thread.sleep(2000);

        List<WebElement>listeOlusturElement=driver.findElements(By.xpath("(//input[@class='a-button-input a-declarative'])[3]"));

        if (!listeOlusturElement.isEmpty()) {

            driver.findElement(By.xpath("(//input[@class='a-button-input a-declarative'])[3]")).click();
           driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();


        }else { driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();



        }



        // 2. ürünün favorilere eklendigi kontrol edilir
        String productTitle=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();

        WebElement merhabaElement = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
        actions.moveToElement(merhabaElement).perform();
        Thread.sleep(2000);
        WebElement listem=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
        actions.click(listem).perform();

        String listeTitle=driver.findElement(By.xpath("//h2[@class='a-size-base']")).getText();

        Assert.assertTrue("Ürünler eşleşmiyor",productTitle.equals(listeTitle));


  /*      public static void hover(WebElement element) {
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(element).perform();
        }*/





    }

    private void sigInElement(WebDriver driver) {
    }

    @Test
    @Ignore
    public void hesapolurma(){
       Actions actions=new Actions(driver);
        WebElement yeniHesapOluştur=driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
        actions.click(yeniHesapOluştur).perform();

        WebElement adSoyad=driver.findElement(By.xpath("//input[@type='text']"));
        actions.click(adSoyad).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("uat ").
                keyDown(Keys.SHIFT).sendKeys("o").
                keyUp(Keys.SHIFT).sendKeys("ruç").
                sendKeys(Keys.TAB).
                sendKeys("puturgeli1isi@gmail.com").
                sendKeys(Keys.TAB).sendKeys("aA12324-").
                sendKeys(Keys.TAB).sendKeys("aA12324-").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
@Test
    public void test02() throws InterruptedException {
    Actions actions=new Actions(driver);
    // hesabım->  favori listem sayfasına gidilir
    WebElement MerhabaElementi= driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
    actions.moveToElement(MerhabaElementi).perform();
    Thread.sleep(2000);
    WebElement listem=driver.findElement(By.xpath("(//span[@class='nav-text'])[1]"));
    actions.click(listem).perform();

    // favori Listem sayfası açıldıgı kontrol edilir
    Assert.assertTrue("listelerim yazısı gözükmüyor",driver.findElement(By.xpath("//div[@role='heading']")).isDisplayed());

    // eklenen ürün favorilerden silinir
    driver.findElement(By.xpath("//input[@name='submit.deleteItem']")).click();


    // silme işleminin gerçekleştigi kontrol edilir.
    WebElement silindiYazisiElemnti=driver.findElement(By.xpath("//div[text()='Silindi']"));
    Assert.assertTrue(silindiYazisiElemnti.isDisplayed());

    // üye çıkış işlemi yapılır
   // WebElement merhabaElement2 = driver.findElement(By.xpath("//a[@id=\"nav-link-accountList\"]"));
    actions.moveToElement(MerhabaElementi).perform();
    Thread.sleep(2000);


    //çıkış işleminin yapıldıgı kontrol edilir.

    actions.click(driver.findElement(By.xpath("//span[text()='Çıkış Yap']"))).perform();




}






}
