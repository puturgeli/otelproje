package tests.day19;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HMYCWebTablePage;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C01_WebTableDinamikLocate {
    // 3 test metodu oluşturalım




    @Test
    public void satirYazdirTesti(){
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        // 1.metod satır numarası verdigimde bana o satırdaki dataları yazdırsın

        // 2. satırı yazdırırsak locate //tbody//tr[2] olur
        // 7. satırı yazdır desek locate //tbody//tr[7] olur bir metod yazdıp istedigimiz satırı cagırabiliriz

        HMYCWebTablePage hmycWebTablePage=new HMYCWebTablePage();
        WebElement dorduncusatirElementi=hmycWebTablePage.satirGetir(4);
         System.out.println(dorduncusatirElementi.getText());



         Driver.closeDriver();


    }
    @Test
    public void hucreGetirTesti(){
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        // 2. method satırno ve data numarası girdigimde verdigim datayı yazdırsın
        HMYCWebTablePage hmycWebTablePage=new HMYCWebTablePage();
    // 2 satırın dördüncü datası istense istenenin locate //tbody//tr[2]//td[4] olur
    // 4.satırın 5. datası desek locate //tbody//tr[4]//td[5] olur

    System.out.println("istenen hücre elemanı: "+hmycWebTablePage.hucreWebelementGetir(5, 3));

        Driver.closeDriver();



    }
    @Test
    public void sutunYazdirTesti(){

        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        HMYCWebTablePage hmycWebTablePage=new HMYCWebTablePage();
        // 3. sutun numarası verdigimde bana tüm sutunu yazdırsın
       hmycWebTablePage.sutunYazdir(6);

       Driver.closeDriver();





    }

}
