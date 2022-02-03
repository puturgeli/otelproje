package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_singletonPattern {


    @Test
    public void test01(){
        // singleton pattern bir class'tan birden fazla obje üretilmesine
        // izin vermeyen bir pattern olarak kabul görmüştür.


        // biz Driver class'ını driver üretmek üzere kullanıyoruz
        // ancak driver class'ında driver isminde bir instance variable da var
        // ve biz obje üreterek bu instance driver'a ulaşabiliriz.


        // Driver driver1=new Driver();


        //singleton pattern kabul görmüşl bişr pattern'dir
        // amaç bir class'da obje üretilmemesini sağlamaktır.
        // bunun için signleton pattern'de koruyacagımız class'da
        // parametresiz bir constructur oluşturur ve bu constructur'ı private yaparız






    }

}
