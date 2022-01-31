package Practise;

import java.util.*;

public class Practise2 {
    public static void main(String[] args) {

        List<String>liste=new ArrayList<>(Arrays.asList("Ahmet","Dügün","Dernek","Ahmet","GüzelX","hastahane","Güzel","Bahane","Hayat","emre"));

        alfabetikTekrarsizSirali(liste);
        System.out.println();
        sonHarfeGoreSirali(liste);
        System.out.println();
        sonHarfeGoreTersSirali(liste);
        System.out.println();
        karakterUzunlugunaGoreTers(liste);
        System.out.println();krktrSayilariTersSirali(liste);
        System.out.println();ciftKrktrKareAlSiraliYaz(liste);
        System.out.println();krkterSayisi7Kontrol(liste);
        System.out.println();xIleBitenVarmi(liste);
        System.out.println();enBuyukKarakterYaz(liste);



    }

    //list elemanlarını alfabetik buyuk harf sırası ile ve tekrarsız yazdıralım
    public static void alfabetikTekrarsizSirali(List<String>liste){
        liste.stream().map(String::toUpperCase).sorted().distinct().forEach(t-> System.out.print(t+" "));
    }

    //list elemanlarını son harflerine göre alfabetik buyuk harf ile ve tekrarsız yazdıralım
        public static void sonHarfeGoreSirali(List<String>liste){
    liste.stream().map(String::toUpperCase).sorted(Comparator.comparing(t->t.charAt(t.length()-1))).distinct().forEach(t-> System.out.print(t+" "));
    }
    //list elemanlarını son harflerine göre alfabetik buyuk harf ile ve tekrarsız ve tersten yazdıralım
    public static void sonHarfeGoreTersSirali(List<String>liste){
        liste.stream().map(String::toUpperCase).sorted(Comparator.comparing(t->t.toString().charAt(t.toString().length()-1)).reversed()).distinct().forEach(t-> System.out.print(t+" "));
    }
//list deki elemanları karakter uzunluguna göre ters yazdıralım
    public static void karakterUzunlugunaGoreTers(List<String>liste){
        liste.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).forEach(t-> System.out.print(t+" "));
    }
    //list elemanalrının karakter sayılarını ters sıralı yazdıralım
    public static void krktrSayilariTersSirali(List<String >liste){
        liste.stream().map(String::length).sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }
    //List elemanlarını çift sayılı elemanların karelerini hesaplayan, tekaralı olanları sadece bir kere
    //büyükden küçüge yazdıran bir program yazınız

    public static void ciftKrktrKareAlSiraliYaz(List<String>liste){
        liste.stream().filter(t->t.length()%2==0).map(t->t.length()*t.length()).sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }
    //List elemanlarının character sayısı 7 ve 7 den az olma durumunu kontrol edin
    public static void krkterSayisi7Kontrol(List<String>liste){
        System.out.println(liste.stream().allMatch(t -> t.length() <= 7)?"listede yediden büyük karaktere sahip eleman yok":"Listeden karakter sayısı yediden büyük eleman var");
    }
    //list elemanlarının "x" le biten en az bir elemanı kontrol ediniz
public static void xIleBitenVarmi(List<String >liste){
    System.out.println(liste.stream().anyMatch(t -> t.endsWith("x")||t.endsWith("X")) ? "Listede x ile biten bir isim var" : "Listeden x ile biten bir isim yok");
}
    //Karakter sayısı en büyük olan eleamnı yazdırın
    public static void enBuyukKarakterYaz(List<String>liste){
        System.out.println(liste.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).findFirst());
    }

}
