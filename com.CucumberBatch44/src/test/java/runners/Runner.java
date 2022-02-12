package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@editor",
        dryRun =false


)


public class Runner {

   //runner clasının body'sine hiç bir kod yazmıyacagız
   // bu class için önemli olan kullanacagımız iki adaet notasyonu yazacagız
   // dryRun = false yazıldıgında belirlenen tag'la etiketlenen tüm senaryoları sırasıyla çalıştırırır
   // dryRun=true dedigimizde ise kodları çalıştırmadan eksik stepler olup olmadıgını
    // kontrol eder ve varsa bize eksik stepleri rapor eder


    //features ve gle olarak bir class veya feature dosyasını degil
    //tüm clasör yada package'i seçtik
    // dolayisiyla stepdefinition package'i içersinden hangi class'da olursa olsun
    // işimize yarayan bir stepdefinition varsa rahatlıkla kullanabiliriz


}
