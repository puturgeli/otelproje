package tests.day18;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class odevTesti_D18_HotelRoomCreation {
    // 1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
    // 2. Bir metod olusturun: RoomCreateTest()

    @Test
    public void RoomCreationTest(){

        HotelMyCampPage hmycPage=new HotelMyCampPage();
        // 3. https://qa-environment.concorthotel.com/ adresine gidin.

        Driver.getDriver().get("https://qa-environment.concorthotel.com/");
        Driver.getDriver().findElement(By.cssSelector("[id=\"details-button\"]")).click();
        Driver.getDriver().findElement(By.cssSelector("[id=\"proceed-link\"]")).click();

        // 4. Username textbox ve password metin kutularını locate edin ve aşağıdaki verileri girin.

        //          a. Username : manager    b. Password : Manager1!
      hmycPage.girisYap();



        // 5. Login butonuna tıklayın.

        hmycPage.loginButon.click();


        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.
        hmycPage.HotelManagementElement.click();
        hmycPage.addHotelRoomsMetodu.click();



        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.

        Actions actions =new Actions(Driver.getDriver());
        Faker faker=new Faker();
                actions.click(hmycPage.addHotelIdText).sendKeys(faker.number().digit()).
                        sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).
                        sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                        sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                        sendKeys(faker.finance().bic()).sendKeys(Keys.TAB).perform();

        Select select=new Select(hmycPage.IDGRoup);select.selectByIndex(faker.random().nextInt(1,50));


        // 8. Save butonuna basin.
        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        // 10. OK butonuna tıklayın.
        // 11. Hotel rooms linkine tıklayın.
        // 12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..

    }
}
