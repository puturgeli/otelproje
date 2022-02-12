package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class AmazonStepDefinitions {

    AmazonPages amazonPages=new AmazonPages();



    @Given("kullanici amazon sayfasina gider")
    public void kullanici_amazon_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));

    }

    @Given("iPhone icin arama yapar")
    public void i_phone_icin_arama_yapar() {
        amazonPages.aramacubuguElement.sendKeys("iphone"+ Keys.ENTER);

    }

    @Then("sonuclarin Iphone icerdigini test eder")
    public void sonuclarin_ıphone_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElement.getText();
        Assert.assertTrue(sonucYazisiStr.contains("iphone"));

    }

    @Given("tea pot icin arama yapar")
    public void tea_pot_icin_arama_yapar() {
        amazonPages.aramacubuguElement.sendKeys("tea pot"+ Keys.ENTER);


    }

    @Then("sonuclarin tea pot icerdigini test eder")
    public void sonuclarin_tea_pot_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElement.getText();
        Assert.assertTrue(sonucYazisiStr.contains("tea pot"));

    }

    @Given("flower icin arama yapar")
    public void flower_icin_arama_yapar() {
        amazonPages.aramacubuguElement.sendKeys("flower"+ Keys.ENTER);


    }

    @Then("sonuclarin flower icerdigini test eder")
    public void sonuclarin_flower_icerdigini_test_eder() {
        String sonucYazisiStr=amazonPages.sonucYazisiElement.getText();
        Assert.assertTrue(sonucYazisiStr.contains("flower"));

    }


    @Then("kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.closeDriver();
    }
    @Given("{string} icin arama yapar")
    public void icin_arama_yapar(String arananKelime) {
      amazonPages.aramacubuguElement.sendKeys(arananKelime+ Keys.ENTER);

    }
    @Then("sonuclarin {string} icerdigini test eder")
    public void sonuclarin_icerdigini_test_eder(String arananKelime) {
        String sonucYazisiStr=amazonPages.sonucYazisiElement.getText();
        Assert.assertTrue(sonucYazisiStr.contains(arananKelime));

    }


    @Given("kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String istenenUrl) {

        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));

    }


}

