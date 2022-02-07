package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_SatirSayisi {

    @Test
    public void test01(){
        try {
        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);

        int sayfa1satirSayisi=workbook.getSheet("Sayfa1").getLastRowNum();
        int sayfa1FizikiKullanilanSatir=workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();

      System.out.println("1. Sayfa Satır Sayısı: " + sayfa1satirSayisi);
      System.out.println("1.Syfa Fiziki Kullanılan Satır Sayısı: " + sayfa1FizikiKullanilanSatir);

      // Fiziki kullanılan satır sayısı index ile degil sayma sayıları ile çalışır
      // ilk metod index ile çalışır

            int sayfa2satirSayisi=workbook.getSheet("Sayfa2").getLastRowNum();
            int sayfa2FizikiKullanilanSatir=workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

            System.out.println("2. Sayfa Satır Sayısı: " + sayfa2satirSayisi);
            System.out.println("2.Syfa Fiziki Kullanılan Satır Sayısı: " + sayfa2FizikiKullanilanSatir);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
