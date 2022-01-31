package Lambda_day_03;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class C01 {
    public static void main(String[] args) {

        List<String > list=new ArrayList<>(Arrays.asList("wmehmet","emrecelenx","nilgün","islam","yıldız","kader","emine","islam","emre"));

        bykHrfTekrarsizSira(list);
        System.out.println();
        crcktrTekrarsizSira(list);
        System.out.println();
        chrctrSayisiKcktnByg(list);
        System.out.println();
        sonHarfineGoreSirala(list);
        System.out.println();
        ciftKareTekrarsizTersSira(list);
        System.out.println();
        harfSayisi7Kontrol(list);
        System.out.println();
        wileBaslayanIsimKontrol(list);
        System.out.println();
        xileBitenIsimKontrol(list);
        chrctrEnBuyuk(list);
        System.out.println();Limit(list);
        System.out.println();ilkElemanHaricSonHarfSirali(list);



    }

//list elemanlarını alfabetik buyuk harf sırası ile ve tekrarsız yazdıralım
    public static void bykHrfTekrarsizSira( List<String > list){
        list.stream().//elemanlar akışa girdi
                //map(t->t.toUpperCase()).//elemanlar büyük harf oldu
                  map(String::toUpperCase).//String clasından uppercase metodunu çagırdık
                    sorted().//alfabetik oldu
                        distinct().//listemiz tekrarsız oldu
                            forEach(t-> System.out.print(t+" "));//yazdırdık

    }
    //list elemanlarının character sayısını ters sıralı olarak tekrasız yazdırın
    public static void crcktrTekrarsizSira( List<String > list){
        list.stream().
                map(String::length).//String classında cracter sayısını update ettik
                    sorted(Comparator.reverseOrder()).//ters sırasını yazdık
                            distinct().//tekrarsız yaptık
                                forEach(t-> System.out.print(t+" "));//yazdırdık
    }
//list elemanlarını chracter sayısına göre kücükten büyüge yazdıralım

    public static void chrctrSayisiKcktnByg(List<String > list){
        list.stream().
                sorted(Comparator.comparing(t->t.length())).//elemanların boyutuna göre karşılaştırıyoruz
                        forEach(t-> System.out.print(t+" "));//büyükten kücüge deseydik .reverse derdik lenght ten sonra
    }

//list elemanlarını son harfine göre ters sıralayalım
    public static void sonHarfineGoreSirala(List<String > list){
        list.stream().
                sorted(Comparator.comparing(t->t.toString().//comparator karşılaştıram clası
                              // karşılaştıram metodu
                         charAt(t.toString().length()-1)).//elemanın son index'inin karakterini alır
                               reversed()).              //elemanın son index'deki elemanlarını alarak tersine sıralar
                                    forEach(t-> System.out.print(t+" "));

    }
    //List elemanlarını çift sayılı elemanların karelerini hesaplayan, tekaralı olanları sadece bir kere
    //büyükden küçüge yazdıran bir program yazınız

public static void ciftKareTekrarsizTersSira(List<String > list){
        list.stream().
           filter(t->t.length()%2==0).//chracter uzunlugu cift olanları alırız
                 map(t->t.length()*t.length()).// cift sayılı karakterlerin karelerini aldık
                     sorted(Comparator.reverseOrder()).//ters sıraladık
                         distinct().//tekrarsız hale getirdik
                                 forEach(t-> System.out.print(t+" "));

}
//List elemanlarının character sayısı 7 ve 7 den az olma durumunu kontrol edin
 public static void harfSayisi7Kontrol(List<String > list){
   /*  //System.out.println(list.stream().allMatch(t->t.length()<=7));
     boolean kontrol=list.stream().
                             allMatch(t->t.length()<=7);//her bir elemanı <=7 ye eşleşmesine baktık true/false döner
 if (kontrol){
     System.out.println("Listin elemanlarının karakter uzunlugu 7 harden büyük degil");
 }else{
     System.out.println("List de elemanlarının karakter uzunlugu 7 harden büyük ");
 }*/

     System.out.println(list.stream().allMatch(t->t.length()<=7)?
             "Listin elemanlarının karakter uzunlugu 7 harden büyük degil"
             :"List de elemanlarının karakter uzunlugu 7 harden büyük");
 }
//List elemanlarının "W" ile başlamasının kontrol ediniz
    public static void wileBaslayanIsimKontrol(List<String > list){
        System.out.println(list.stream().
                        noneMatch(t -> t.startsWith("w")) ?
                                "W ile başlayan bir isim yok"
                                        : "W ile başlayan bir isim var");

    }

    //list elemanlarının "x" le biten en az bir elemanı kontrol ediniz
    public static void xileBitenIsimKontrol(List<String > list){
        System.out.println(list.stream().
                anyMatch(t -> t.endsWith("x")) ?
                    " x ile biten isim kimse ayaga kalsın"
                        : "agam x ile biten isim olumu?");
   //anyMatch()    : en az bir eleman şartı saglarsa true aksi durumda false return eder.
   //allMatch      :tüm elemanlar şartı sağlarsa true en az bir eleman şartı saglamazsa false döner
   //noneMatch     :hiç bir eleman şartı SAĞLAMAZSA true en az bir eleman şartı saglarsa false döner.



    }
    //Karakter sayısı en büyük olan eleamnı yazdırın
    public static void chrctrEnBuyuk(List<String > list){
        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//karakter uzunluguna göre sıraladı
                        reversed()).//tersine aldı
                               findFirst());//ilk elemanını alıp yazdırdık
                               
    }
    public static void Limit(List<String > list){
        Stream<String> sonIsim = list.stream().
                sorted(Comparator.comparing(t -> t.toString().length()).//karakter uzunluguna göre sıraladı
                        reversed()).//tersine aldı

                        limit(3);//limt(a) akıştan çıkan elemanları a parametresine göre ilk a elemanını alır.

        System.out.println(Arrays.toString(sonIsim.toArray()));
    }

    //list elemanlarını son harfine göre sıralayıp ilk eleman hariç kalan elemanları yazdırın

    public static void ilkElemanHaricSonHarfSirali(List<String>list){
        list.stream().
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).
                    distinct().
                            skip(1).//akıştan çıkan elamanların 1. parametresini atlar
                                forEach(System.out::print);

    }
}
