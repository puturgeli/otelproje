package tests.day18;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMYCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.util.List;

public class C02_WebTables {
HotelMyCampPage hmycp=new HotelMyCampPage();
HMYCWebTablePage hmcWepTable;
  @Test
  public void loginTest() {

    // ● Bir class oluşturun : C02_WebTables
    // ● login( ) metodun oluşturun ve oturum açın.
    // ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    //            ○ Username : manager
    //            ○ Password : Manager1!
      hmycp.girisYap();

}

    @Test
    public void table() {
    // ● table( ) metodu oluşturun
    //            ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    //            ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.

    //header kısmında birinci satır ve alttaki dataları locate edelim
    //thead//tr[1]//th
        hmcWepTable=new HMYCWebTablePage();
        List<WebElement>headerDataList=hmcWepTable.headerBirinciSatirDatalar;
    System.out.println("Tablodaki sutun Sayısı: " + headerDataList.size());



    }
    @Test(dependsOnMethods = "loginTest")
    public void printRows( ) {

    // tablodaki tüm body 2i bir metodda yazdırın
    // ● printRows( ) metodu oluşturun //tr

    //            ○ table body’sinde bulunan toplam satir(row) sayısını bulun.

    // tbody
      hmcWepTable=new HMYCWebTablePage();

    System.out.println(hmcWepTable.tümbodyWebelement.getText());

    //            ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    //            ○ 4.satirdaki(row) elementleri konsolda yazdırın.

        List<WebElement>bodyTumDataliste=hmcWepTable.bodyTumDataList;
        List<WebElement> satirlarWebelementListesi=hmcWepTable.satirlarListesi;


        int satir=1;
       for (WebElement w :satirlarWebelementListesi ) {
      System.out.println(satir+".satır:  "+ w.getText());
      satir++;
        }
    System.out.println("body'deki tüm data sayısı: " + bodyTumDataliste.size());

        // Eger body tek bir webelement olarak locate edersek
        // icindeki tum datalari getText() ile yazdirabiliriz
        // ancak bu durumda bu elementler ayri ayri degil
        // body'nin icindeki tek bir String'in parcalari olurlar
        // dolayisiyla bu elementlere tek tek ulasmamaiz mumkun olmaz
        // sadece contains methodu ile body'de olup olmadiklarini test edebiliriz
        // Eger her bir data'yi ayri ayri almak istersek
        // //tbody//td seklinde locate edip bir list'e atabiliriz








  }
}
