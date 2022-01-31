package tests.tekrarCalismalari;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C03 {
    WebDriver driver;
    WebElement dropBox;
    Select select;
   String ilkUrunTitle, ilkUrunfiyat;
   String ikinciUrunTitle, ikinciUrunfiyat;
   String ucuncuUrunTitle, ucuncuUrunfiyat;


    @BeforeClass()
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.com");


    }

    @Test(priority = 1)
    public void test01() throws InterruptedException {
        // test-1
        //amazona gidelim


        //kitaplar bölümüne girelim
        dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropBox);
        select.selectByVisibleText("Books");


        //"Java"yı  aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        //son 30 gün de cıkan yayınlar olarak tekrar filitreleyelim
        driver.findElement(By.xpath("//*[.='Last 30 days']")).click();

        //dil olarak ingilizceyi secelim
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]")).click();


        //cıkan sonucların sayısını yazdıralım
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("sonuc sayısı: " + result.getText());

        //ilk ürüne tıklayalım
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();


        //ilk ürünün title'nı ve fiyatını yazdıralım
        ilkUrunTitle = (driver.findElement(By.xpath("//span[@id='productTitle']"))).getText();
        ilkUrunfiyat = (driver.findElement(By.xpath("//span[@id='newBuyBoxPrice']"))).getText();
        System.out.println("ilk Urun Title: " + ilkUrunTitle);
        System.out.println("ilk Urun Fiyatı: " + ilkUrunfiyat);

        //ilk ürünü sepete ekleyelim
        if (driver.findElement(By.xpath("//input[@value='Add to Cart']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        } else {
            driver.findElement(By.xpath("//a[text()='Add to Cart']")).click();
        }

    /*   //bazen kenarda öneri için frame çıkıyor eger çıkarsa ona tıklayıp geçmek için bu if blogunu ekleyelim
        if (driver.findElement(By.xpath("//div[@id='aod-container']")).isEnabled()){
            driver.findElement(By.xpath("(//input[@name='submit.addToCart'])[2]")).click();
        }*/

        //spor bölümün e gidelim
        dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropBox);
        select.selectByVisibleText("Sports & Outdoors");

        //raket  diye aratıyoruz
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("raket" + Keys.ENTER);

        //ilk ürüne tıklayalım
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //title ve fiyatı yazdırıp sepete ekleyelim
        ikinciUrunTitle = (driver.findElement(By.xpath("//span[@id='productTitle']"))).getText();
        ikinciUrunfiyat = (driver.findElement(By.xpath("//span[@data-a-color='price']"))).getText();
        System.out.println("İkinci Ürün adı: " + ikinciUrunTitle);
        System.out.println("ikinci Ürün Fiyatı: " + ikinciUrunfiyat);

        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        Thread.sleep(2000);


    }

    @Test(priority = 2)
    public void test02() {

        //test 2
        // bilgisayar bölümüne gidelim
        dropBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropBox);
        select.selectByVisibleText("Computers");

        //Notebook aratalım
        WebElement inputbox = driver.findElement(By.xpath("//input[@type='text']"));
        inputbox.clear();
        inputbox.sendKeys("Notebook" + Keys.ENTER);


        //sonucları yazdıralım
        System.out.println("Notebook araması için çıkan sonuc sayısı: " + driver.findElement(By.xpath("(//span[@dir='auto'])[1]")).getText());

        // sonucların icersinde notebook gözüküyormu bakalım
        String actualResult = driver.findElement(By.xpath("(//span[@dir='auto'])[3]")).getText();
        actualResult = actualResult.replaceAll("\"", "");
        String expectedResult = "Notebook";
        Assert.assertEquals(actualResult, expectedResult);


        //ilk ürüne tıklayım
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //ürünün title'ını ve fiyatını yazdıralım

        ucuncuUrunTitle = (driver.findElement(By.xpath("//span[@id='productTitle']"))).getText();
        ucuncuUrunfiyat = (driver.findElement(By.xpath("//span[@data-a-color='price']"))).getText();
        System.out.println("İkinci Ürün adı: " + ucuncuUrunTitle);
        System.out.println("ikinci Ürün Fiyatı: " + ucuncuUrunfiyat);


        //sepete ekleyelim
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();

    }


    @Test(priority = 3)
    public void test03() {

        //test 3
        //sepete tıklayalım
        driver.findElement(By.xpath("//div[@id='nav-cart-count-container']")).click();

        //sepetteki ürünler secilen ürünlermi kontrol edelim
        List<WebElement> urunListesi = driver.findElements(By.xpath("//span[@class='a-truncate-cut']"));
        List<WebElement>urunFiyatliste=driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));


        System.out.println("listedeki ürün sayısı: " + urunListesi.size());

        for (WebElement w : urunListesi) {
            System.out.println(w.getText());
        }

        String actualSepet1UrunTitle = urunListesi.get(2).getText();
        String actualSepet2UrunTitle = urunListesi.get(1).getText();
        String actualSepet3Uruntitle = urunListesi.get(0).getText();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualSepet1UrunTitle, ilkUrunTitle, "ilk urunde hata");
        softAssert.assertEquals(actualSepet2UrunTitle, ikinciUrunTitle, "ikinci urunde hata");
        softAssert.assertEquals(actualSepet3Uruntitle, ucuncuUrunTitle, "3. urunde hata var");

        softAssert.assertAll();

        //sepetteki fiyatlarını bize verilen toplkam fiyatla aynı mı dogrulayalım
        String sepetilkUrunfiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[3]")).getText();
        String sepetikinciUrunfiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();
        String sepetUcuncuurunfiyat = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]")).getText();

        softAssert.assertEquals(sepetilkUrunfiyat, ilkUrunfiyat, "Sepetteki ilk ürün ile alınan ilk ürün fiyatı farkl");
        softAssert.assertEquals(sepetikinciUrunfiyat, ikinciUrunfiyat, "Sepetteki ikinci ürün ile alınan ikinci ürün fiyatı farklı");
        softAssert.assertEquals(sepetUcuncuurunfiyat, ucuncuUrunfiyat, "Sepetteki ucuncu ürün ile alınan ucuncu ürün fiyatı farkl");


    }


    @AfterClass
    public void teardown() {

      //  driver.close();
    }


}
