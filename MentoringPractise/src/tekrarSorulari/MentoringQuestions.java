package tekrarSorulari;

import java.util.Scanner;

public class MentoringQuestions {

    /* 1---Sayının Sayı değerlerinin toplamasını yapan Java kodu yazınız.
    Test Data
    34
    Beklenen Çıktı
    7
    *********************************************************************
*/
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Rakamları Toplanacak sayıyı giriniz.: ");
        int say = scan.nextInt();
        int sayi = say;
        int toplam = 0;
        while (sayi > 0) {
            toplam += sayi % 10;
            sayi = sayi / 10;

        }
        System.out.printf(say + " sayısının basamaklarının toplamı " + toplam);
/* 2---1 den 20 ye kadar tam sayıları alt alta yazan Java kodu yazınız.
    Hint: For döngüsü kullanınız.
    Beklenen Çıktı:
    1
    2
    3
    4
    .
    .
    .
    19
    20
    ************************************************************************

 */
        System.out.println();
        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
        }

        /*

    3----belirlenen sayının 1 den 10 a kadar çarpım sonuçlarını yapan Java programını yazınız.
    Örnek Sonuç:
    5 x 1 = 5
    5 x 2 = 10
    5 x 3 = 15
    5 x 4 = 20
    5 x 5 = 25
    5 x 6 = 30
    5 x 7 = 35
    5 x 8 = 40
    5 x 9 = 45
    5 x 10 = 50
    ************************************************************************
         */
        System.out.println("Hangi Sayının çarpım tablosu yapılacak: ");
        int carp = scan.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(carp + " x " + i + " = " + (carp * i));
        }
        /*

    4----1 den 10 a kadar her satırda bir artırarak aşağıdaki şekli oluşturan Java kodunu yazınız.
     Beklenen çıltı:

    1
    12
    123
    1234
    12345
    123456
    1234567
    12345678
    123456789
    12345678910

    ************************************************************************
         */
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }

        /*
         5-----Aşağıdaki elmas deseni görüntüsünü çizen java kodunu yazınız.
    Test Data:
    Yarım elmas uzunluğu : 7
    Beklenen Çıktı:
          *
         ***
        *****
       *******
      *********
     ***********
    *************
     ***********
      *********
       *******
        *****
         ***
          *
      ************************************************************************
         */
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7 - i; j++) {
                System.out.print(" ");

            }
            for (int j = 0; j < 2 * i + 1; j++) {


                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 6; i >=0 ; i--) {
            for (int j = 6-i; j >=0 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <2*i+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        /*

     6----     Kullanıcıdan bir harf girmesini isteyiniz. Girilen harf sesli ise Sesli harf olduğunu,
           değilse sessiz harf olduğunu ekrana yazdırsın. Girdiği değer harf değilse yada
            1 karakterden fazla ise hata mesajı göstersin. (Test girilen harfi büyük yada küçüklüğüne duyarlıdır.)

    Sesli harfler: a,e,i,o,u

    Test Data:
    a

    Beklenen Çıktı:
    a harfi sesli harfdir.

    Test Data:
    d

    Beklenen Çıktı:
    d harfi sesiz harftir.

    Test Data:
    we  yada %

    Beklenen Çıktı:
    Yanlis karakter girdiniz!
      ************************************************************************
         */
        char arr[]={'a','e','i','o','u','A','E','I','O','U'};

        System.out.println(" Kontrol etmek istedigniz harfi girin: ");
       String sorgu=scan.next();
       if (sorgu.length()>1){
           System.out.println(sorgu+ " bu ne, Harf Sorduk aga kelime yazdın sen: ");
       }else {

           boolean son=false;
           char harf=sorgu.charAt(0);
            for (int i = 0; i <arr.length ; i++) {

            if (arr[i]!=harf ) {

            }else {
                son=true;
            }
           } if (son==true)
           {System.out.println(sorgu + " Sesli Harfdir.");

           }else System.out.println(sorgu + " Sessiz harfdir.");
       }

       /*

    7-----
       Ugly Number:

    Girilen bir sayının  ugly number olup olmadığını kontrol etmek için bir Java programı yazın.


    Sayı sisteminde,  ugly number  sadece asal faktörleri 2, 3 veya 5 olan pozitif sayılardır.

    İlk 10  ugly number 1, 2, 3, 4, 5, 6, 8, 9, 10, 12'dir.

     Kural olarak, 1 dahil.

    Test Data:
    13

    Beklenen çıktı:
    ugly number  degildir

    Test Data:
    25
    Beklenen Çıktı:

    ugly number
     ************************************************************************
        */
        System.out.println("Kontrol edilecek sayıyı giriniz: ");
        int uglynum=scan.nextInt();
        if (uglynum%5==0||uglynum%3==0||uglynum%2==0){
            System.out.println(uglynum+" sayısı Ugly Number'dır");
        }else {
            System.out.println(uglynum+" sayısı Ugly Number degildir.");
        }
        /*

    8----
     Girilen String değerde tersten yazan Java kodunu yazınız.

    Test Data:
    java
    avaj
    ************************************************************************
         */


        System.out.println("Tersten yazmak için bir metin giriniz: ");
       scan.nextLine();
        String metin=scan.nextLine();
        System.out.print(metin+" kelimesinin terseten yazımı: ");
        for (int i = metin.length()-1; i >=0 ; i--) {
            System.out.print(metin.charAt(i));
        }
        /*

    9----2 farklı String'i  ucuca ekleyen Java Kodunu yazınız.

    Test Data:
    str1: Java is
    str2: fun

    Beklenen Çıktı:
    java is fun
    ************************************************************************
         */
     String   str1="Java is";
       String str2= "fun";

        System.out.println(str1+" "+str2);


        /*
       10-----Kullanıcıdan alınan String kümesi içerisinde aranan  String i bulan Java Kodunu yazınız.

    Test Data:
    Java is easy

    Aranan String: is

    Bektenen Çıktı:
    True

    Aranan String: and

    Beklenen Çıktı:False
    ************************************************************************
         */
        System.out.println("Arama yapılacak metni girin: ");
        String metin1=scan.nextLine();
        String[] arama=metin1.split(" ");
        System.out.println("Aranacak kelimeyi girin: ");
        String bul=scan.nextLine();
        boolean sonuc=false;
        for (int i = 0; i <arama.length ; i++) {
            if (arama[i].equalsIgnoreCase(bul)){
                sonuc=true;
            }
        }
        System.out.println(sonuc);

    }
}

