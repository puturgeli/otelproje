package tekrarSorulari;

import java.util.*;

public class mentoringSoruları2 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


     /*    11---- Kullanıcıdan alınan Stringin son karakteirini silep ekrana yazan Java kodunu yazınız.

    Test Data:
    good

    Beklenen Çıktı:
    goo
    ************************************************************************

        Scanner scan = new Scanner(System.in);
        System.out.println("Bir metin giriniz: ");
        String metin = scan.nextLine();
        String yeniMetin = metin.substring(0, metin.length() - 1);
        System.out.println(metin + " metnin son hali: " + yeniMetin);


         12----
    Kullanıcının girdiği String değerlerini büyük harfe çeviren Java kodunu yazınız.

    Test Data:
    Java is fun

    Beklenen Sonuç:
    JAVA IS FUN

    ************************************************************************


        System.out.println("Bir metin girin: ");
        String cevir = scan.nextLine().toUpperCase();
        System.out.println(cevir);



    13----
    Bir palindrom, madam veya racecar veya 10801 sayısı gibi ileriye doğru geriye doğru okuyan bir kelime, sayı, kelime öbeği veya diğer karakter dizisidir.

    Girilecek kelimenin palindrom olup olmadığını doğrulayacak bir Java Kodu yazın.

    Test Data:
    madam

    Beklenen Çıktı:
    True
    ************************************************************************

        System.out.println("Konrol edilecek metni girin: ");
        String polidron = scan.nextLine();
        String tersi = "";
        boolean cevap = false;
        for (int i = polidron.length() - 1; i >= 0; i--) {
            tersi += polidron.charAt(i);
        }
        if (tersi.equals(polidron)) {
            System.out.println(polidron + " girdisinin tersi: " + tersi + " dir. Girdi polidrondur.");
        } else {
            System.out.println(polidron + " girdisinin tersi: " + tersi + " dir. Girdi polidron degildir.");

        }



    14----
    Girilen iki String veriyi karşılaştıran Java kodu yazınız.


    Test data:
    1. String : techproed.com
    2. String : Techproed.com

    Beklenen Çıktı:
    False

    Test data:
    1. String : techproed.com
    2. String : techproed.com

    Beklenen Çıktı:
    true
    ************************************************************************

        System.out.println("Birinci String ifadeyi girin: ");
        String str1 = scan.nextLine();
        System.out.println("İkinci String ifadeyi girin: ");
        String str2 = scan.nextLine();
        if (str1.equals(str2)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }


         15-Grilen String değer içinde istenen sıradaki karakteri bulan Java kodunu yazınız.

    Test Data:
    Java is fun


    Beklenen Çıktı
    0. pozisyondaki karakter : J

    5. pozisyondaki karakter : i

    ************************************************************************

        String ifade = "";
        int krk = 0;
        try {
            System.out.print("Bir string ifade girin: ");
            ifade = scan.nextLine();
            System.out.print("Hangi Sıradaki karakteri istiyorsun.: ");
            krk = scan.nextInt();
            System.out.println(ifade + " Girinlen ifadenin " + krk + " pozisyonundaki harfi: " + ifade.charAt(krk - 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("girilen ifade de harf sayısı " + (ifade.length() + 1) + " senin istedigin " + krk + " sırada olmayan harf istiyorsun insaf kardeş.");
        }


         16----Girilen stringdeki tüm karakterleri büyük harfe dönüştürmek için bir Java programı yazın.

    Test Data:
    java is fun

    Beklenen Çıktı:
    JAVA IS FUN
    ************************************************************************

        System.out.println("Bir string girin: ");
        scan.nextLine();
        String strBuyuk = scan.nextLine().toUpperCase();
        System.out.println(strBuyuk);



    17--- Üç sayı arasındaki en küçük sayıyı bulmak için bir Java METHOD yazın.

    Test data:
    12,24,34

    Beklenen Çıktı:
    12
    ************************************************************************

        int max = 0;
        int mim = 0;
        System.out.println("1. Sayıyı Grin: ");
        int sayi1 = scan.nextInt();

        System.out.println("2. Sayıyı Grin: ");
        int sayi2 = scan.nextInt();

        System.out.println("3. Sayıyı Grin: ");
        int sayi3 = scan.nextInt();
        if (sayi1 > sayi2) {
            max = sayi1;
            mim = sayi2;
        } else {
            max = sayi2;
            mim = sayi1;
        }
        if (sayi3 < mim) {
            System.out.println("En küçük sayı: " + sayi3);
        } else {
            System.out.println("En küçük sayı: " + mim);
        }



    18----Girilen Stringdeki  tüm sesli harfleri saymak için bir Java Methodu yazınız.

    Test Data:
    java is fun

    Beklenen Çıktı:

    Stringdeki sesli harf sayısı: 4

    ************************************************************************

        String sesliHarf[] = {"a", "e", "i", "o", "u"};
        System.out.println("Sesli harf sayılacak metni girin: ");
        scan.nextLine();
        String sesli = scan.nextLine();
        String sesl[] = sesli.split("");
        int sayac = 0;
        for (int i = 0; i < sesl.length; i++) {

            for (int j = 0; j < sesliHarf.length; j++) {

                if (sesliHarf[j].contains(sesl[i])) {
                    sayac++;

                }
            }
        }
        System.out.println("String deki sesli harf sayısı: " + sayac);



    19----    Kullanıcı tarafından girilen bir yılın  artık yıl olup olmadığını kontrol etmek için bir Java Methodu yazınız.

    Test Data:
    2017

    Beklenen Çıktı:
    false
    ************************************************************************

        System.out.println("Kontrol etmek istediginiz yılı girin: ");
        int yil = scan.nextInt();
        yilkontrol(yil);





    20----Karışık verilen sayıları  ve kelimeleri  sıralayan   Java kodunun yazınız.
    not: Test datadaki değerleri kullanınız.

    Test Data:
    [1232, 1134,2345,1022]
    [Java, Python, PHP, C#, C Programming, C++]

    Beklenen Çıktı:
    [1022,1134,1232,2345]
    [C Programming, C#, C++, Java, PHP, Python]
    ************************************************************************

        System.out.println("Sıralanacak girdileri aralarında boşluk bırakarak yazınız: ");
       scan.nextLine();
        String sirala = scan.nextLine();
        String arr[]=sirala.split(" ");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void yilkontrol(int yil) {
        if (yil % 4 == 0) {
            System.out.println(yil + " yılı artık yıldır.");
        } else {
            System.out.println(yil + " yılı artık yıl degildir.");
        }
    }

 21----
    Array deki sayıları tolpayan Java kodunu yazınız.

    array  [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    Beklenen Çıktı:
    Array toplamı: 55
    ************************************************************************

*/

        int arr[] = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int toplam = 0;
        for (Integer w : arr) {
            toplam += w;
        }
        System.out.println(toplam);
/*
22----
    Arraydeki sayıların ortalamasını hesaplayan Java Kodunu yazınız.
 */
        System.out.println(Arrays.toString(arr) + " arrayimdeki elamnaların ortalaması: " + (toplam / arr.length));

/*
23----
    Aşağıdaki grid şeklini yazan Java Kodunu yazınız.

    Beklenen Çıktı:
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
     0  0  0  0  0  0  0  0  0  0
    ************************************************************************
 */
        int satir = 1;
        int sutun = 1;

        for (int i = 0; i < 10; i++) {

            System.out.print(satir + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(sutun + "0 ");
                sutun++;

            }
            satir++;
            sutun = 1;
            System.out.println();


        }
        // 24----
        //    yazılan değerin array içerisinde arayan Java Kodu yazınız.
        //Aranan Değer:2010
        // Beklenen Çıktı :False

        int arr1[] = new int[6];
        arr1[0] = 200;
        arr1[1] = 400;
        arr1[2] = 250;
        arr1[3] = 1000;
        arr1[4] = 300;
        arr1[5] = 7500;
        System.out.println(Arrays.toString(arr1));
        System.out.println("aradıgınız degeri girin: ");
        int deger = scan.nextInt();
        boolean sonuc = false;
        for (Integer w : arr1) {
            if (w.equals(deger)) {
                sonuc = true;
            }
        }
        System.out.println(sonuc);

/*
25----
    Aranan değerin Array içerisinde kaçıncı eleman olduğunu bulan Java Kodu yazınız.
 */
        System.out.println("aradıgınız eleman array'in " + Arrays.binarySearch(arr1, deger) + " indexinde");


        /*
        25----
    Aranan değerin Array içerisinde kaçıncı eleman olduğunu bulan Java Kodu yazınız.
         */

        int arr2[] = {1, 2, 3, 4, 5, 78, 12, 22, 98, 11};
        List<Integer> listem = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            listem.add(arr2[i]);
        }
        System.out.println("Listem " + listem);

/*
27----
    Array listesindeki 2. en büyük sayıyı bulan Java Kodunu yazınız.
 */

        Collections.sort(listem);
        System.out.println("Listenin en büyük ikinci elemanı: " + listem.get(listem.size() - 2));
/*
 28----
    Array içerisindeki tek ve çift sayıların kaçar tane olduğunu bulan Java Kodu yazınız.

 */
        int tek = 0;
        int cift = 0;
        for (Integer w : listem) {
            if (w % 2 == 0) {
                cift++;
            } else {
                tek++;
            }

        }
        System.out.println(listem + " listemde tek sayı adeti: " + tek + " çift sayı adeti: " + cift);

     /*   29----
        Bir String değişkeni cümlesi verildiğinde, her sözcüğü almak için kod yazın ve tersine ters çevrilmiş String'e atayın.
        Test Data:
             sentence -> "Java is fun"
             reversed -> "fun is Java"

      */
        System.out.println("Tersine yazmak istediginiz cümleyi giriniz: ");
        scan.nextLine();
        String cumle = scan.nextLine();
        String[] ters = cumle.split(" ");
        String tersi = "";
        for (int i = ters.length - 1; i >= 0; i--) {
            tersi += ters[i] + " ";
        }
        System.out.println(cumle + " cumlesinin tersi " + tersi);

        /*
        ************************************************************************
    30---
    Kullanıcının gireceği iki binary sayıyı toplayan  Java kodunu yazınız.
    Test Data:
    birinci binary number: 100010
    ikinci  binary number: 110010
         */

        System.out.println("toplanacak ilk binary sayıyı girin: ");
        int binary1 = scan.nextInt();
        System.out.println("toplanacak ikinci binary sayıyı girin: ");
        int binary2 = scan.nextInt();

        int topla=getDecimal(binary1)+getDecimal(binary2);

        System.out.println("Saylarının binary olarak toplamı: "+Integer.toBinaryString(topla));




    }







    public static int getDecimal(int binary){
        int onlukdeger=0;
        int n=0;
        while(true){
            if (binary==0){
                break;
            }else{
                int temp=binary%10;
                onlukdeger+=temp*Math.pow(2,n);
                binary=binary/10;
                n++;
            }
        }return onlukdeger;
    }


}