package tests.Homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class day11_Q7 extends TestBase {


    @Test
    public void test() {
        // 1) "https://www.facebook.com/" SAYFASINA GiDiN
        driver.get("https://www.facebook.com");

        // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
        driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']")).click();

        // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
        WebElement gun = driver.findElement(By.xpath("//select[@id='day']"));
        yazdir(gun);

        // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN

        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        yazdir(ay);


        // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN
        WebElement yil = driver.findElement(By.xpath("//select[@id='year']"));
        yazdir(yil);


    }

    private void yazdir(WebElement gun) {
        Select select = new Select(gun);
        List<WebElement> gunler = select.getOptions();
        System.out.println("");
        if (gunler.size() == 12) {
            System.out.print("Aylar:");
        } else if (gunler.size() > 12 && gunler.size() < 32) {
            System.out.print("Gunler: ");
        } else {
            System.out.print("Yıllar: ");
        }

        for (WebElement each : gunler) {
            System.out.print(each.getText() + " ");
        }

    }

}
