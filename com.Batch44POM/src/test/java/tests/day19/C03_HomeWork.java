package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.reShoppingCardPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_HomeWork {

  @Test
  public void homeWorkTesti() throws InterruptedException {
      reShoppingCardPage  reShoppingCardPage=new reShoppingCardPage();

    //// 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
      Driver.getDriver().get(ConfigReader.getProperty("hw1Url"));

    //// 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin    (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

      reShoppingCardPage.urunlerinIsimleriniYazdir();

    //// 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    System.out.println("");
      reShoppingCardPage.stringArrayListYazdir();

    //// 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın (Her ürün 1 defadan fazla eklenemez!)

      reShoppingCardPage.rastgeleUrunSec(5);


    //// 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
     //reShoppingCardPage.secilenUrunFiyatTopla();
       Assert.assertEquals(reShoppingCardPage.sepettekiUrunlerinToplami.getText(),reShoppingCardPage.secilenUrunFiyatTopla());

    //// 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    System.out.println("Fiyat Toplamı Testi: Pass");
    //// 7.Checkout'a tıklayın
      reShoppingCardPage.checkOutButonElementi.click();

      Thread.sleep(3000);

      Driver.getDriver().switchTo().alert().accept();

      Driver.closeDriver();

  }
}
