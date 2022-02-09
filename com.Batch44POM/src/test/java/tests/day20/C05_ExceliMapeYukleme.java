package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class C05_ExceliMapeYukleme {



    @Test
    public void test01(){

        // dosya yolu ve sayfa ismi verilen bir excel Sheet'i map olarak kayıt eden
        // reusable bir metod oluşturalıkm

        String path="src/test/java/resources/ulkeler.xlsx";
        String sayfaAdi="Sayfa1";

   Map<String,String>UlkelerMap= reusableMethodExcel.mapOlustur(path, sayfaAdi);

    // oluşturdugumuz map'i kullanarak Turkey'in bilgilerini yazdıralım
    System.out.println(UlkelerMap.get("Turkey"));

    //listede Netherlands oldugunu test edin

        Assert.assertTrue(UlkelerMap.containsKey("Netherlands"));


    }
}
