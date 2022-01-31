package tests.Practice;

import org.testng.annotations.Test;

public class Q1 {

@Test(priority = 3000)
    public void b(){

    System.out.println("b Methodu Çalışıtı");

}

    @Test(priority = -2001, enabled = false)
    public void a(){

        System.out.println("a Methodu Çalışıtı");

    }
    @Test(priority = 2000)
    public void c(){

        System.out.println("c Methodu Çalışıtı");

    }


    @Test
    public void test01(){
        System.out.println("TEST1....");
    }
    @Test
    public void test012(){
        System.out.println("TEST2....");
    }
    @Test
    public void test03(){
        System.out.println("TEST3....");
    }
    @Test (enabled = false)
    public void test04(){
        System.out.println("TEST4....");
    }
    @Test
    public void test05(){
        System.out.println("TEST5....");
    }
    @Test (enabled = false)
    public void test06(){
        System.out.println("TEST6....");
    }




}
