package tests.day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class reusableMethod {

  // bir metod oluşturalım
  // dosya yolu, sayfa ismi  ve satır, hücre index'ini verince hücre bilgisini döndürsün

  public static Cell hucreGetir(String path, String sayfaIsmi, int satir_index, int hucre_index) {

    Cell cell = null;

    try {
      FileInputStream fileInputStream = new FileInputStream(path);
      Workbook workbook = WorkbookFactory.create(fileInputStream);
      cell = workbook.getSheet(sayfaIsmi).getRow(satir_index).getCell(hucre_index);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return cell;
  }

  public static Map<String,String> mapOlustur(String path, String sayfaAdi) {

    Map<String,String>excelMap=new HashMap<>();
    Workbook workbook = null;
    
    //ilk olarak excel'e ulaşalım
    try {
      FileInputStream fis=new FileInputStream(path);
      workbook=WorkbookFactory.create(fis);
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    String key="";
    String value="";

    int satirSayisi=workbook.getSheet(sayfaAdi).getLastRowNum();
    for (int i = 0; i <=satirSayisi ; i++) {

      // 2. adım tablodaki hücreleri map'e uygun hale dönüştürmek
      key=workbook.getSheet(sayfaAdi).getRow(i).getCell(0).toString();
      value=workbook.getSheet(sayfaAdi).getRow(i).getCell(1).toString()+
              ", "+workbook.getSheet(sayfaAdi).getRow(i).getCell(2).toString()+
              ", "+workbook.getSheet(sayfaAdi).getRow(i).getCell(3).toString();

      //ucuncu adım key, value haline getirdigimiz satırları mape ekledik
      excelMap.put(key,value);

    }

    return excelMap;
  }
}
