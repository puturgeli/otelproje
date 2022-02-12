package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;
import java.util.Random;

public class HotelMyCampStepDefinations {

    HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
    Random random=new Random();
    Select select;
    Actions actions;

    @Then("login linkine Tiklanir")
    public void login_linkine_tiklanir() {
        hotelMyCampPage.anaSatfaLoginButonu.click();

    }



    @Then("kullanici {string} butonuna basar")
    public void kullanici_butonuna_basar(String string) {
        hotelMyCampPage.loginSayfaiLoginButonu.click();

    }

    @And("kullanici username girer")
    public void kullaniciUsernameGirer() {
        hotelMyCampPage.userNameTextBox.sendKeys(ConfigReader.getProperty("HMYCValidUserid"));
    }

    @Then("kullanici pasword girer")
    public void kullaniciPaswordGirer() {
        hotelMyCampPage.passwordTextBox.sendKeys(ConfigReader.getProperty("HMYCValidUserPas"));
    }

    @And("kullanici kullaniciadini girer")
    public void kullanicikullaniciadiniGirer() {
        hotelMyCampPage.userNameTextBox.sendKeys(ConfigReader.getProperty("HMYCValidKullaniciid"));

    }

    @Then("kullanici kullanicipasword girer")
    public void kullanicipasword() {
        hotelMyCampPage.passwordTextBox.sendKeys(ConfigReader.getProperty("HMYCValidKullanicipas"));
    }

    @Given("kullanici sigleRoom butonuna tiklar")
    public void kullaniciSigleRoomButonunaTiklar() {
        hotelMyCampPage.kullaniciPageSigleRoomButonElement.click();
    }



    @And("kullanici checkin tarihini girer")
    public void kullaniciCheckinTarihiniGirer() {
        actions=new Actions(Driver.getDriver());
        actions.click(hotelMyCampPage.checkInDateelement).
                sendKeys(Keys.CONTROL+"a").sendKeys(Keys.DELETE).
                sendKeys("2/20/2022").
                sendKeys(Keys.TAB).sendKeys("3/10/2022").
                perform();
    }

 /*   @Then("kullanici checkOut tarihini girer")
    public void kullaniciCheckOutTarihiniGirer() {
        actions=new Actions(Driver.getDriver());
        actions.click(hotelMyCampPage.checkInDateelement).
                sendKeys("2/20/2022").
                sendKeys(Keys.TAB).sendKeys("3/10/2022").
                perform();

      //  hotelMyCampPage.checkOutDateElement.sendKeys("2/20/2022");
        }*/

    @And("kullanici yetiskin sayisini secer")
    public void kullaniciYetiskinSayisiniSecer() {
        select=new Select(hotelMyCampPage.selectAdultCountElement);select.selectByIndex(random.nextInt(1,select.getOptions().size()));
    }

    @Then("kullanici cocuk sayisini secer")
    public void kullaniciCocukSayisiniSecer() {
        select=new Select(hotelMyCampPage.selectChildCountElement);select.selectByIndex(random.nextInt(1,select.getOptions().size()));
    }

    @And("kullanici kredikart adini girer")
    public void kullaniciKredikartAdiniGirer() {
        hotelMyCampPage.nameonCrediCartElement.sendKeys(ConfigReader.getProperty("kard"));
    }

    @Then("kullanici kredikart numarasini girer")
    public void kullaniciKredikartNumarasiniGirer() {
        hotelMyCampPage.numberOnCreditCard.sendKeys(ConfigReader.getProperty("kardid"));
    }

    @And("kullanici kartin gecerlilik tarihini secer")
    public void kullaniciKartinGecerlilikTarihiniSecer() {
        select=new Select(hotelMyCampPage.crediCardExpirationyearElement);
        select.selectByIndex(random.nextInt(1,select.getOptions().size()));
    }

    @Then("kullanici kartin gecerlilik ayini secer")
    public void kullaniciKartinGecerlilikAyiniSecer() {
        select=new Select(hotelMyCampPage.crediCartExpiratinMonthElement);select.selectByIndex(random.nextInt(1,select.getOptions().size()));
    }

    @And("kullanici krediKart CVV numarasını yazar")
    public void kullaniciKrediKartCVVNumarasınıYazar() {
        hotelMyCampPage.crediCartCVVElement.sendKeys(ConfigReader.getProperty("CVV"));
    }

    @Then("kullanici mesaj formuna mesaj yazar")
    public void kullaniciMesajFormunaMesajYazar() {
        hotelMyCampPage.mesageFormElement.sendKeys("Yeni Single Room Kayıt Denemesi");
    }

    @And("Kullanici Book this room butonuna basar.")
    public void kullaniciBookThisRoomButonunaBasar() {
        hotelMyCampPage.bookThisRoomButonElement.click();
    }

    @Then("kullanici basariliKayit yapildi yazasini görür")
    public void kullaniciBasariliKayitYapildiYazasiniGörür() {
        Assert.assertTrue(hotelMyCampPage.BasariliRezervasyonYapildiYaziElement.isDisplayed());
    }

    @And("kullanici popupda ok butonuna basar")
    public void kullaniciPopupdaOkButonunaBasar() {
        hotelMyCampPage.basariliKayitPenceresiOkButonElementi.click();
    }

    @Then("kullanici {string} siradaki otele tiklar")
    public void kullaniciSiradakiOteleTiklar(String sira) {
    hotelMyCampPage.kullanisiPageSinngleRoomOdaListesi.get(Integer.valueOf(sira)-1).click();
    }

    @Then("basarili girisyapildi yazisi gorulur")
    public void basariliGirisyapildiYazisiGorulur() {
        Assert.assertTrue(hotelMyCampPage.basariliGirisYaziElementi.isDisplayed());
    }

      @And("kullanici username olarak {string} girer")
    public void kullaniciUsernameOlarakGirer(String username) {
        hotelMyCampPage.userNameTextBox.sendKeys(ConfigReader.getProperty(username));

    }

    @Then("kullanici password olarak {string} girer")
    public void kullaniciPasswordOlarakGirer(String password) {
        hotelMyCampPage.passwordTextBox.sendKeys(ConfigReader.getProperty(password));

    }

    @Then("giris yapilmadigi test eder")
    public void girisYapilmadigiTestEder() {
        Assert.assertTrue(hotelMyCampPage.girisYapilamadiYaziElemendi.isDisplayed());
    }

    @And("scenario outline'dan username olarak {string} yazar")
    public void scenarioOutlineDanUsernameOlarakYazar(String username) {
        hotelMyCampPage.userNameTextBox.sendKeys(username);
    }

    @Then("scenario outline'dan password olarak {string} yazar")
    public void scenarioOutlineDanPasswordOlarakYazar(String password) {
    hotelMyCampPage.passwordTextBox.sendKeys(password);
    }
}
