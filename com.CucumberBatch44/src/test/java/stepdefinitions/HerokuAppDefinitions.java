package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HerokuappPages;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class HerokuAppDefinitions {


    HerokuappPages herokuappPages=new HerokuappPages();

    @When("add element butonuna basar")
    public void add_element_butonuna_basar() {
        herokuappPages.addButonElement.click();

    }
    @Then("Delete butonu gorununceye kadar bekler")
    public void delete_butonu_gorununceye_kadar_bekler() {
     //   WebDriverWait wait=new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(5));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[onclick=\"deleteElement()\"]")));

        ReusableMethods.waitForVisibility(herokuappPages.deleteButonElement,20);



    }
    @Then("Delete butonunun gorundugunu test eder")
    public void delete_butonunun_gorundugunu_test_eder() {
        Assert.assertTrue(herokuappPages.deleteButonElement.isDisplayed());

    }
    @Then("Delete butonuna basarak butonu siler")
    public void delete_butonuna_basarak_butonu_siler() {
        herokuappPages.deleteButonElement.click();

    }


}
