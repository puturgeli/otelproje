package tekrarSorulari;

import java.util.*;

public class
MentoringSoruları3 {

    public static void main(String[] args) {

        /*
        31----
    Saati saniyeye çeviren java methodunu yazınız.

    Test Data:
    howManySeconds(2);
    Beklenen çıktı:
     7200
    ************************************************************************
         */
        Scanner scan=new Scanner(System.in);

        System.out.print("Saniye olarak görmek için bir saat yazınız.:  ");
        int saat=scan.nextInt();
        System.out.println(saat +" saat :"+saniyeCevir(saat)+ " saniye yapar");

        /*
         32----
    İki integer sayının eşitliğini kontrol eden java methodunu yazınız.

    num1 = num2 => true
    ************************************************************************
         */
        System.out.print("Kontrol edilecek 1. sayıyı girin: ");
        int x=scan.nextInt();
        System.out.print("Kontrol edilcek ikinc sayıyı girin: ");
        int y=scan.nextInt();
        System.out.println(x+" sayısı "+y+" sayınına eşitmi: "+esitMi(x,y));


        /*
        Bir arrayi tersine çeviren  method yazınız.

    Test Data:

    reverse [1, 2, 3, 4]
    return  [4, 3, 2, 1]
    ************************************************************************
         */
        System.out.println("İşlem yapılacak arrayin elemanlarını aralarında boşluk bırakarak giriniz: ");
       scan.nextLine();
        String cumle=scan.nextLine();
        String arr[]=cumle.split(" ");
        String tersarr[]=new String[arr.length];
        int a=0;
        for (int i = arr.length-1; i>=0  ; i--) {
            tersarr[a]=arr[i];
            a++;
        }
        System.out.println(Arrays.toString(arr)+" arrayinin tersi: "+Arrays.toString(tersarr));


        /*
         34-----
    String array dizisindeli 4 harfli kelimeleri return eden methodu yazınız.


    Test Data:
    isFourLetters(["Tomato", "Potato", "Pair"])

     ["Pair"]
    ************************************************************************
         */
        List<String> dortHarf=new ArrayList<>();
        for (String w:arr
             ) {
            if (dortHarfliReturn(w)) {
                dortHarf.add(w);
            }

             }
        System.out.println("Listemdeki dort harfli kelimeler:" +dortHarf);

        /*
        35----   Methoda iki sayı girelim ve  bize bir array dönsün.
     Array elemanları 1.sayının 2. sayı kadar kendisi ile
     toplamından oluşsun.

    Test Data:
    arrayOfMultiples(7, 5)

    sonuç: [7,14,21,28,35]
         */

        System.out.print("Arrayin başlıyacagı sayıyı girin: ");int sayi1=scan.nextInt();
        System.out.print("Arrayin bitecegi katı girin: ");int sayi2=scan.nextInt();
        arrayOlustur(sayi1,sayi2);

        /*
         36-----  Bir sayı asal olduğunda true, aksi halde false çıktısı return eden bir Java Methodu yazınız.

    Test Data:

    isPrime(31)
    true
    isPrime(18)
    false
    ************************************************************************
         */
        System.out.println("Asal kontrolü yapılacak sayıyı giriniz: ");int asl=scan.nextInt();
        System.out.println(asl+" sayısı asalmıdır? "+asalMi(asl));

        /*
          37-----
    Kullanıcının yazdığı metni, 'hacker'ların konuşma diline çevirip return eden bir method(method ismi hackerDili) yazınız.

    Hackerlar bazı harfleri sayılara çevirerek yazışabiliyorlar. Genellikle çevirdikleri harfler şu şekilde:
    s -> 5
    a -> 4
    e -> 3
    i -> 1
    o -> 0

    Test data
    hackerDili("javayı severim")
    j4v4yı 53v3r1m

    İpucu harfleri değiştirin ve ekrana yazdırın.
    ************************************************************************
         */

        System.out.print("Manipüle yapılacak stringi yazın: ");scan.nextLine();String mani= scan.nextLine();

        System.out.println(mani+" stringin manipule hali: "+manipuleEt(mani));

             /*
           38 ----
             Verilen array'deki en büyük ve en küçük sayı arasındaki farkı return eden bir method yazınız.

             Örnek -
             farkBul([10, 15, 20, 2, 10, 6])
          */
        System.out.println("İnteger tipindeki Arrayin elemanlarını aralarında boşluk bırakarak girin:  ");
       String maxmim=scan.nextLine();
        String depo[]=maxmim.split(" ");

        int maxMim[]=integerArrayYap(depo);

        Arrays.sort(maxMim);
        System.out.println(Arrays.toString(maxMim) +" en büyük elemanı: "+maxMim[maxMim.length-1]
                +" en küçük elemanı "+maxMim[0]
                +"\naralarındaki fark: "+(maxMim[maxMim.length-1]-maxMim[0]));


        /*
    39-----    Bir dizi içerisindeki pozitif tam sayı sayısını ve
    negatif tam sayıların toplamını return (array olarak) eden bir method yazınız.

    Örnek:
    countPositivesSumNegative ([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15])
    [10, -65]
    // Toplam 10 pozitif sayı var.
    // Tüm negatif sayıların toplamı -65'tir.

    Notlar :
    Boş bir dizi verilirse, boş bir dizi döndürür: []
    0 pozitif değil.

    ************************************************************************
   */

        System.out.println("İçinde negatif degerlerde olan bir arrayin elamnlarını boşluk bırakarak yaınız");
        String metin1= scan.nextLine();
        String arrm[]=metin1.split(" ");
        int metin2[]=integerArrayYap(arrm);
        int pozitifNegatifarr[]=positifNagatifSay(metin2);
        System.out.println(Arrays.toString(pozitifNegatifarr)+" dizide "+pozitifNegatifarr[0]+" pozitif sayı var ve " +
                "negatif sayıların toplamı: "+pozitifNegatifarr[1]);


    }

    private static int[] positifNagatifSay(int[] metin2) {
        int negatifToplam=0;int pozitifToplam=0;
        int negatifsay=0;int pozitifSay=0;
        for (int i = 0; i <metin2.length ; i++) {
            if (metin2[i]>0){
                pozitifToplam+=metin2[i];
                pozitifSay++;
            }else{
                negatifToplam+=metin2[i];
                negatifsay++;
            }
        }int pozitifNegatifarr[]={pozitifSay,negatifToplam};
        return pozitifNegatifarr;

    }

    private static int[] integerArrayYap(String[] depo) {
        int maxMim[]=new int[depo.length];
        for (int i = 0; i < depo.length ; i++) {
            maxMim[i]= Integer.parseInt(depo[i]);
        }
        return maxMim;
    }

    private static String manipuleEt(String mani) {
        mani=mani.replaceAll("s","5");
        mani=mani.replaceAll("a","4");
        mani=mani.replaceAll("e","3");
        mani=mani.replaceAll("i","1");
        mani=mani.replaceAll("o","0");
    return mani;
    }

    public static boolean asalMi(int a){
        boolean sonuc=false;
        for (int i = 2; i <=a ; i++) {
            if(a%i==0) {
                break;
            }else{sonuc = true;}
        }
                return sonuc;
            }


    private static void arrayOlustur(int sayi1, int sayi2) {
        int arr[]=new int[sayi2];
        for (int i = 0; i < sayi2; i++) {
            arr[i]=sayi1+sayi1*i;
        }
        System.out.println("Oluşan Array: "+Arrays.toString(arr));
    }

    public static boolean dortHarfliReturn(String x){
        return (x.length()==4);
    }
    public static boolean esitMi(int x, int y){
        return(x==y);
    }
    public static int saniyeCevir(int x){
        return (x=x*360);
    }
}

