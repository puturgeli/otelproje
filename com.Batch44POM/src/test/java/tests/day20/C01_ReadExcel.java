package tests.day20;


import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        String path="src/test/java/resources/ulkeler.xlsx";
                FileInputStream fis=new FileInputStream(path);
        // biz fileinputstream ile okudugumuz excel dosyasını projemiz içersinde kullanabilmek için
        // Apachi POI depenceny yardımı ile bir Workbook oluşturduk

        // bu workbook bizim projemizin içerinde ülkeler excelinin bir kopyasını kullanmamızı sağlıyor


        //Excelin yapısı geregi bir hucreye (Cell) ulaşabilmek için woorkBookdan başlayarak
        // sirasıyla sheet, row ve cell objeleri oluşturmamız gereklidir.

                Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(4);
        Cell cell=row.getCell(2);
        System.out.println(cell);//andora yazar

    // index'i 4 olan satırdaki index'i 2 olan hücrenin Andora oldugunu test ediniz

    String expectedData ="Andorra";
            Assert.assertEquals(cell.getStringCellValue(),expectedData);

            // 5. indezdeki satırın 3. index'ini hüçre bilgisini yazdıralım
        row=sheet.getRow(5);
        cell=row.getCell(3);
    System.out.println(cell);
    }
}
