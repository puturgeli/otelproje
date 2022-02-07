package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_writeExcel {


    @Test
    public void test01() throws IOException {

        // ülkeler exceline 5. sutun olarak nufus sutunu ekleyelim
        // 3. satırdaki ülkenin nufusunu 1000000 yapalım


        // 1. dosyaya ulaşalım
        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);

        // 2.class da çalışmak için dosyanın bir kopyası olan workbook oluşturalım

        Workbook workbook= WorkbookFactory.create(fis);

        // 3. dosyada yapmak istedigimiz degişiklikleri
        // kopya workbook da yapalım

        // ilk önce ilk satırın 5.hücresine nufus başlıgını yazdıralım

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");

        // 3 satırdaki ülke nufusunu 100000 yapalım

        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        //4. olarak kopya da yaptıgımız degişiklikleri ana dosyaya kayıt edelim

        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);




    }
}
