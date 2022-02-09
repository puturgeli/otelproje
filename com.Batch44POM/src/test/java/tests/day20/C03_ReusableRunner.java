package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_ReusableRunner {


    @Test
    public void test02(){

        // 11.index deki satırın 2. index'deki hücresinde azarbaycan yazdıgını test edelim

        String path="src/test/java/resources/ulkeler.xlsx";

        String expectedData="Azerbaycan";

        Assert.assertEquals(reusableMethodExcel.hucreGetir(path,"Sayfa1",11,2).getStringCellValue(),expectedData);
    }
}
