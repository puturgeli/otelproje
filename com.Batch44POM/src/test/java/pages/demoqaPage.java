package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.security.SecureRandom;
import java.util.List;

public class demoqaPage {

    public demoqaPage(){
    PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//div[@class='rt-tr']")
    public WebElement headerSatirElementi;

  @FindBy(xpath = "//div[@class='rt-tr']//div[@class=\"rt-resizable-header-content\"]")
  public List<WebElement>headerDatalari;

  @FindBy(xpath = "//div[@class=\"rt-th rt-resizable-header -cursor-pointer\"]")
  public List<WebElement> basliklarWebElemntiListesi;

    @FindBy(xpath = "//div[@class=\"rt-tbody\"]")
    public WebElement bodyTekWebElement;

    @FindBy(xpath = "//div[@class=\"rt-td\"]")
    public List<WebElement>tumDataWebelementList;

    @FindBy(xpath = "//div[@class=\"rt-tr-group\"]")
    public List<WebElement>tumSatirlarWebelemntList;





  public void sutunYazdir(int sutunNumarasi) {
        //(//div[@class="rt-tr-group"])[3]//div[@class='rt-td'][3]

        int satirSayisi=tumSatirlarWebelemntList.size();
        String dinamikXpath;
        WebElement geciciElement;

    System.out.println("İstenen Sutun Başlığı: " + basliklarWebElemntiListesi.get(sutunNumarasi - 1).getText());
       for(int i = 1; i <= satirSayisi; i++) {
           dinamikXpath="(//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td']["+sutunNumarasi+"]";

           geciciElement=Driver.getDriver().findElement(By.xpath(dinamikXpath));
      System.out.println("Sutunun "+i+".Satırı: "+geciciElement.getText());
       }



    }

    public void ismeGoreMaasYazdir(String isim) {

        int satirSayisi=tumSatirlarWebelemntList.size();
        String dinamikXpath;
        String  satirdakiIsim;
        String  salary;

         for (int i = 1; i <= satirSayisi; i++) {
        dinamikXpath=   "(//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'][1]";

        satirdakiIsim=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();
        dinamikXpath="(//div[@class='rt-tr-group'])["+i+"]//div[@class='rt-td'][5]";
        salary=Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText();

        if (satirdakiIsim.equals(isim)){
        System.out.println(isim+"'in maaşı: "+salary);
        }


    }
    }

    public void hucreYazdir(int satir, int sutun) {
        String dinamikXpath= "(//div[@class='rt-tr-group'])["+satir+"]//div[@class='rt-td']["+sutun+"]";
    System.out.println(satir+".satir'ın "+sutun+" sutun elementi: "+Driver.getDriver().findElement(By.xpath(dinamikXpath)).getText());

    }
}
