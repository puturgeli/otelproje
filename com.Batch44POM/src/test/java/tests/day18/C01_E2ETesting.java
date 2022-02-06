package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;

import java.nio.channels.AcceptPendingException;

public class C01_E2ETesting {

  @Test
  public void test01() {

    // 1. Tests packagenin altına class olusturun: CreateHotel
    // 2. Bir metod olusturun: createHotel
    // 3. https://www.hotelmycamp.com adresine git.
    // 4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri    girin.
    //    a. Username : manager
    //    b. Password  : Manager1!
    // 5. Login butonuna tıklayın.
    HotelMyCampPage hmycp=new HotelMyCampPage();
    hmycp.girisYap();

    // 6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
  // hmycp.bekleme(3);
    hmycp.HotelManagementElement.click();
    hmycp.hotelListElement.click();
    hmycp.addHotelMetodu.click();
    // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    actions.click(hmycp.addHotelCodeKutusu).
            sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
            sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
            sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
            sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).
            sendKeys(faker.internet().emailAddress()).perform();
    Select select=new Select(hmycp.IDGRoup);
    select.selectByIndex(1);


    // 8. Save butonuna tıklayın.
   hmycp.AddListSaveButonu.click();

    // 9. “Hotel was inserted successfully” textinin göründüğünü test edin.
    System.out.println(hmycp.addHotelSaveSuccesWord.getText());

   Assert.assertTrue(hmycp.addHotelSaveSuccesWord.getText().contains("successfully"));
    // 10. OK butonuna tıklayın.

    Driver.getDriver().findElement(By.cssSelector("[class=\"btn btn-primary\"]")).click();

    Driver.closeDriver();

  }
}
