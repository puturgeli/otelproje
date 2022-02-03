package tests.day16;

import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

public class C04_HotelMyCampPositiveLogin {
    // 1 ) Bir Class olustur : PositiveTest
    // 2) Bir test method olustur positiveLoginTest()

    @Test
    public void positiveLoginTest(){


        //        https://www. hotelmycamp.com/ adresine git
        Driver.getDriver().get(" https://www.hotelmycamp.com/ ");


        //        login butonuna bas
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.LoginButonu.click();

        //    test data username: manager ,
        hotelMyCampPage.userNameKutusu.sendKeys("manager");
        //    test data password : Manager1!
        hotelMyCampPage.passWordKutusu.sendKeys("Manager1!");

        //    Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelMyCampPage.LoginButonu.click();


        hotelMyCampPage.bekleme(3000);


    }


}
