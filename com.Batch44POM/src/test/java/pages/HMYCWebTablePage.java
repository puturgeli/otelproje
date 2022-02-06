package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HMYCWebTablePage {

   public HMYCWebTablePage(){
    PageFactory.initElements(Driver.getDriver(),this);
    }


@FindBy(xpath = "//thead//tr[1]//th")
public List<WebElement> headerBirinciSatirDatalar;

   @FindBy(xpath = "//tbody")
    public WebElement tümbodyWebelement;

   @FindBy(xpath = "//tbody//td")
    public List<WebElement> bodyTumDataList;
   @FindBy(xpath = "//tbody//tr")
   public List<WebElement> satirlarListesi;

   public WebElement satirGetir(int satirNo){
       // 2. satırı yazdırırsak locate //tbody//tr[2] olur
       // 7. satırı yazdır desek locate //tbody//tr[7] olur bir metod yazdıp istedigimiz satırı cagırabiliriz

       String satirDinamikxpath="//tbody//tr["+satirNo+"]";
       WebElement satirElementi=Driver.getDriver().findElement(By.xpath(satirDinamikxpath));

       return satirElementi;
   }


    public String hucreWebelementGetir(int satir, int sutun) {

       String hucreWebElemnti="//tbody//tr["+satir+"]//td["+sutun+"]";
       WebElement istenenHucreElementi=Driver.getDriver().findElement(By.xpath(hucreWebElemnti));
       String hucreDatasi=istenenHucreElementi.getText();

       return  hucreDatasi;

    }

    public void sutunYazdir(int sutun) {
       //table da satır diye bir ifade yok o yüzden her bir satıra gidip istedigimiz sutundaki elemanı alıcaz
       // her bir satırdaki istenen sutun elemantini yazdırabilmek için
       // önce satır sayısını bilmeye ihtiyacım var
       int satirSayisi=satirlarListesi.size();
    System.out.println(sutun + " sutun elemanları");
    System.out.println("================");
    for (int i = 1; i <= satirSayisi;i++) {
      System.out.println(i+".satır :"+hucreWebelementGetir(i, sutun));
    }
    }
}
