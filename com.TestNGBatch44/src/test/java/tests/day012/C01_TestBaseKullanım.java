package tests.day012;

import org.testng.annotations.Test;
import tests.day010.C01_allerts;

public class C01_TestBaseKullanım {


@Test
    public void test01(){

    // projeniz içersindeki  herhangi bir class'dan obje oluşturabilir ve
    //o obje sayesinde ait oldugu class'daki tüm variable ve method'lara
    //(acces modifer izin verdigi sürece) ulaşabilirim

    C01_allerts obj=new C01_allerts();

//eğer proje kapsamında bir class'dan obje oluşturulmasını engellemek isterseniz
//1- o class'ın constructor 'ının private yapabiliriz
//2- clasıın kendisi abstract yapabiliriz
//1. method çok tercih edilmez cünkü OO conset'e uymaz(çok sınırlı sayıda kullanımı vardır)
// 2. method'u kullanabilirz. böylece o class'daki abstract olmayan (concrete)
//method'ları ovverride etmek mecburiyeti olmadan kullanabiliriz
//ama obje oluşturamayız

//örnegin biz testbase'deki class'ını abstract yaptıgımızdan obje oluşturamayız
//ama child class'lradan TestBase'deki setep ve teardown metodlarının kullanabiliriz.

//TesBase obj1=new TestBase(); olmaz





}


}
