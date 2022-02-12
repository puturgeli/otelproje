package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WebUnivercityPages;
import utilities.Driver;
import utilities.ReusableMethods;

public class WebUnivercityStepDefinitions {
WebUnivercityPages webUnivercityPages=new WebUnivercityPages();


    @Given("login portal'a kadar asagi iner")
    public void login_portal_a_kadar_asagi_iner() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }
    @Then("Login Portal'a tiklar")
    public void login_portal_a_tiklar() {
        webUnivercityPages.webUniversityLoginButton.click();


    }
    @Then("{string} ve {string} kutularina deger yazdirir")
    public void ve_kutularina_deger_yazdirir(String username, String password) {
        webUnivercityPages.usernameBox.sendKeys(username);
        webUnivercityPages.passwordBox.sendKeys(password);

    }
    @Then("login butonuna basar")
    public void login_butonuna_basar() {
        webUnivercityPages.loginbutonElement.click();

    }
    @Then("Popup'ta cikan yazinin {string} oldugunu test edin")
    public void popup_ta_cikan_yazinin_oldugunu_test_edin(String popUpYazi) {

        String alertYazisi= Driver.getDriver().switchTo().alert().getText();
        Assert.assertTrue(alertYazisi.equalsIgnoreCase(popUpYazi));

    }
    @Then("ok diyerek sayfaya geri doner")
    public void ok_diyerek_sayfaya_geri_doner() {
        Driver.getDriver().switchTo().alert().accept();

    }
    @Then("ilk sayfaya doner")
    public void ilk_sayfaya_doner() {
        ReusableMethods.switchToWindow("WebDriverUniversity.com");

    }
    @Then("ilk sayfaya donuldugunu test eder")
    public void ilk_sayfaya_donuldugunu_test_eder() {
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="WebDriverUniversity.com";
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("diger windowa gecer")
    public void digerWindowaGecer() {
        ReusableMethods.switchToWindow("WebDriver | Login Portal");
        System.out.println(Driver.getDriver().getTitle());
    }



}
