package tests.day16;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest {


    //Driver clas'i sayesinde bizim eski driver died
    //artık driver'a ihtiyaç varsa Driver.getDriver() yazacagız


  @Test
  public void test01() {
    // amazona gidelim
    Driver.getDriver().get("https://www.amazon.com");

    // amazona gittigimizi test edelim

    boolean titleTest = Driver.getDriver().getTitle().contains("Amazon.com");
    Assert.assertTrue(titleTest);

    Driver.closeDriver();

    // Driver.getDriver her çalıştıgında
    // driver=new ChromeDriver komutundan sonra yeni bir driver oluşturuyor
    // biz şunu istiyoruz Driver class'onda getDriver'ı ilk çalıştırdıgımızda
    // atama olsun sonraki çalışmalarda atama olmasın
    // bunun için driver=new ChromeDriver() satırı bir if blogu içine alıcaz

  }

  @Test
  public void test02() {
    // bestbuy ana sayfaya gidelim
    Driver.getDriver().get("https://www.bestbuy.com");
    // bestbuy'a gittigimizi test edelim
    String url = Driver.getDriver().getCurrentUrl();
    Assert.assertTrue(url.contains("best"));

    Driver.closeDriver();
  }
}
