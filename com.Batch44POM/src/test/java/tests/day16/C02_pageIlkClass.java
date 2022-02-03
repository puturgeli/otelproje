package tests.day16;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.security.Key;

public class C02_pageIlkClass {

    // POM'de farklı class'lara farklı şekilllerde ulaşılması benimsenmiştir.
    // Driver class'ı için statik yöntemi kullanıyoruz
    // page class'ları için obje üzerinde kullanılması tercih edilmiştir



    @Test
    public void test01(){

        // amazon'a gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // aramakutusuna nutella yazıp aratalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("nutella"+ Keys.ENTER);


        // arama sonuçlarının sonuçlarının nutella içerdigini test edelim
        String actualSonucStr=amazonPage.sonucYazisiElemnti.getText();
        Assert.assertTrue(actualSonucStr.contains("nutella"));
        Driver.closeDriver();




    }

    @Test
    public void test02(){
        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        // java için arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);

        //sonucun java içerdigini kontrol edelim
        String actual=amazonPage.sonucYazisiElemnti.getText();
        Assert.assertTrue(actual.contains("Java"));
        Driver.closeDriver();



    }

}
