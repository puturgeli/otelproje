package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.annotation.processing.Generated;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class reShoppingCardPage {

  public reShoppingCardPage() {
    PageFactory.initElements(Driver.getDriver(), this);
  }

  @FindBy(xpath = "//div[@class=\"shelf-item\"]")
  public List<WebElement> tumDataElementi;

  @FindBy(xpath = "//p[@class=\"shelf-item__title\"]")
  public List<WebElement> tumUrunIsimleriListesi;

  @FindBy(xpath = "//div[@class=\"shelf-item__price\"]")
  public List<WebElement> urunFiyatListesi;

  @FindBy(xpath = "//p[@class=\"sub-price__val\"]")
  public WebElement sepettekiUrunlerinToplami;

  @FindBy(xpath = "//div[text()='Checkout']")
  public WebElement checkOutButonElementi;

  @FindBy(xpath = "//div[@class=\"shelf-item__price\"]//p")
  public List<WebElement> sepettekiUrunFiyatListesi;

  public void urunlerinIsimleriniYazdir() {
    int t = 1;
    System.out.println("listede " + tumUrunIsimleriListesi.size() + " adet ürün vardır.");
    for (WebElement w : tumUrunIsimleriListesi) {
      System.out.print(t + ".urun: " + w.getText() + "  ");
      t++;
    }
  }

  public void stringArrayListYazdir() {
    List<String> urunListesi = new ArrayList<>();
    int t = 0;
    for (WebElement w : tumUrunIsimleriListesi) {
      urunListesi.add(t, (t + 1) + ".Urun: " + w.getText());
      t++;
    }

    System.out.println(urunListesi);
  }

  public void rastgeleUrunSec(int urunadeti) {
    WebElement secilenUrun;
    String xpath;
    List<String> secilenUrunKontrolListesi = new ArrayList<>();
    Random random = new Random();
    for (int i = 1; i <= urunadeti; i++) {
      xpath ="(//div[@class=\"shelf-item\"])[" + random.nextInt(1,tumUrunIsimleriListesi.size()) + "]";
      secilenUrun = Driver.getDriver().findElement(By.xpath(xpath));

      if (!secilenUrunKontrolListesi.contains(secilenUrun.getText())) {
        secilenUrunKontrolListesi.add(secilenUrun.getText());
        Driver.getDriver().findElement(By.xpath(xpath)).click();
        System.out.println("Secilen " + i + ".Urun: " + secilenUrun.getText());
      } else {
        i --;
      }
    }
  }

  public String secilenUrunFiyatTopla() {
    Locale locale  = new Locale("en", "UK");
    String pattern = "####.###";
    DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
    decimalFormat.applyPattern(pattern);
    String fiyat;
    double toplam = 0;
    String Sontoplam;
    for (WebElement w : sepettekiUrunFiyatListesi) {
      fiyat = w.getText().replace("$", "");
      toplam += Double.parseDouble(fiyat);
    }
   return Sontoplam="$ "+ decimalFormat.format(toplam);
  }
}