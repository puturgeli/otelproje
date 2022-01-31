package tests.day08;

import org.testng.annotations.Test;

public class C01 {


    @Test(priority = 9)
    public void youtubeTesti(){
        System.out.println("youtube testi çalıştı");
    }

    @Test
    public void amazonTesti(){ //eger iki tane priority belirlemedigimiz test varsa bu sefer testng harf sırasına göre çalıştırır

        System.out.println("amazon Testi çalıştı");
    }

    @Test
    public void bestbyTesti(){// eger priority atanmazsa priority=0 kabul eder
        System.out.println("best bay testi çalıştı");

    }


}
