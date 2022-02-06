package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.demoqaPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_WebTableDemoqa {
    // Bir Class olusturun D19_WebtablesHomework

  @Test
  public void demoqatest() {

    //  1. “https://demoqa.com/webtables” sayfasina gidin
    Driver.getDriver().get(ConfigReader.getProperty("DemoQaUrl"));

    //  2. Headers da bulunan department isimlerini yazdirin
    //normalde //thead//th olurdu ancak bu tablo class isimleri ile organize edilmiş
    demoqaPage demoqaPage=new demoqaPage();
    System.out.println("Başlık Satırı Elementi: "+demoqaPage.headerSatirElementi.getText());

    // 2. yol olarak başlıkları bir listeye koyabiliriz
    // basliklarWebElemntiListesi 'tini yazdırabiliriz
    System.out.println("başlık satırı list elementi ile ");
    for ( WebElement each : demoqaPage.headerDatalari) {
      System.out.println(each.getText());
    }
    System.out.println("===lambda ile===");
    demoqaPage.headerDatalari.stream().forEach(t -> System.out.println(t.getText()));

    //  3. sutunun basligini yazdirin
    System.out.println("3. sutunun başlıgı: "+demoqaPage.basliklarWebElemntiListesi.get(2).getText());

    //  4. Tablodaki tum datalari yazdirin
    System.out.println("=============Tüm Body===========");
    System.out.println(demoqaPage.bodyTekWebElement.getText());

    //  5. Tabloda kac cell (data) oldugunu yazdirin

    System.out.println("Tablodaki data sayısı: " + demoqaPage.tumDataWebelementList.size());

    //  6. Tablodaki satir sayisini yazdirin
    System.out.println("Tablodaki satır sayısı: " + demoqaPage.tumSatirlarWebelemntList.size());

    //  7. Tablodaki sutun sayisini yazdirin

    System.out.println("Tablodaki Sutun Sayısı: " + demoqaPage.basliklarWebElemntiListesi.size());
    //sutun sayısı farklı yollardan hesaplanabilir, mesela hücre saysısı bölü satır sayısıda yapabiliriz
    System.out.println("Tablodaki Sutun Sayısı: " + demoqaPage.tumDataWebelementList.size()/demoqaPage.tumSatirlarWebelemntList.size());


    //  8. Tablodaki 3.kolonu yazdirin

    demoqaPage.sutunYazdir(2);

    //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
    demoqaPage.ismeGoreMaasYazdir("Kierra");

    // 10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    demoqaPage.hucreYazdir(3,2);



    Driver.closeDriver();
  }
}
