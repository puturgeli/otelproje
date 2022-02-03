package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_YanlisKeyKullanimi {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("HMYCUrl"));

        // eğer key olarak girdigimiz string configuration.properties dosyasında yoksa
        // configReader.getProperty()  o key'e bulamaz
        // örnegin HMYCUrl yerine HMYCurl yazarsak;
        // ve nullpointerException fırlatır.



    }
}
