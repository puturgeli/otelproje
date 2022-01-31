package Kutuphane;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String, String> hm = new HashMap<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        selectOption();

    }

    public static void selectOption() {

            System.out.println("*******Lutfen yapmak istediginiz islemi seciniz*******");
            System.out.println("1-> Kayit islemi \n2-> Bilgi islem \n3-> Silme islemi \n4-> Listeyi goruntulemek \n5-> Cikis");
            String secim = scan.next();
            switch (secim) {
                case "1" :
                    KayitIslemi.saveInfo();
                    break;

                case "2":
                    BilgiIslem.getInfo();
                    break;

                case "3" :
                    SilmeIslemi.removeInfo();
                    break;
                case "4" :
                    Liste.listegoruntuleme();

                case "5" :
                    System.out.println("Cikis isleminiz basariyla gerceklestirilmistir. Iyi gunler dileriz");
                    break;

                default :
                    System.out.println("Yanlis giris yaptiniz. \nTekrar deneyiniz");
                    break;
            }

    }

}
