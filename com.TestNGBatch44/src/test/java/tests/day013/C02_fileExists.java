package tests.day013;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_fileExists {


    @Test
    public void test02(){
        System.out.println(System.getProperty("user.home"));

        //masaüstünde projeler klasörünün yolunu istesek
        // C:\Users\Suat\Desktop\projeler\1.gif

        //dinamik olarak msaüstümdeki klasöre gitmek istersem

        String path=System.getProperty("user.home")+"\\Desktop\\projeler\\1.gif ";
        System.out.println(path);


        System.out.println("user.dir"+System.getProperty("user.dir"));


        //masaüstümdeki proje klasörünün içerisinde 1.gif isiminde bir dosya oldugunu test edersek

       // 1- önce bu dosyaya ulaşmak için gerekli dinamik bir path oluşturalım

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\Projeler\\1.GIF ";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        System.out.println(System.getProperty("user.dir"));//projemin yolunu verir

        String pomPath=System.getProperty("user.dir")+"\\pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(pomPath)));

    }



}
