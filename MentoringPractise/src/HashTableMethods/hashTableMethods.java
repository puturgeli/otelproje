package HashTableMethods;

import java.util.Hashtable;

public class hashTableMethods {

    //hashtable da ne key degeri olarak ne de value degeri olarak null kullanılmaz

    public static void main(String[] args) {
        Hashtable<Integer,String> ht=new Hashtable<>();
        //hashtable da sıralama rastgele olur
        ht.put(101,"Hakan");
        ht.put(102,"Yunus");
        ht.put(103,"Ziya");
        ht.put(104,"Süleyman");
        ht.put(105,"Mehmet");
        ht.put(106,"Suat mehmet Ziya");
        System.out.println("listemizin ilk hali " + ht);

// 1-size() ; Bu karma tablodaki anahtar sayısını dondurur.
        System.out.println("listemizde anahtar sayısı: " + ht.size());

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 2-clone() ; Bu karma tablonun rastgele bir kopyasını olusturur.
        Hashtable<Integer,String>ht1=new Hashtable<>();
        ht1.put(107,"Ahmet");
        ht1.put(108,"Mustafa");
        System.out.println("yeni listemiz: "+ht1.clone());


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 3-clear() ; key icermemesi icin map i temizler.
        ht1.clear();
        System.out.println("Yeni listemizi sildik: "+ht1);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 4-contains(Object value) ; Bazi key lerin map te
        // belirtilen degerle eslesip eslesmedigini test eder

        System.out.println("Listemizde Suat varmı: "+ht.contains("Suat"));//true yazar
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 5-containsKey(Object key) ; Belirtilen nesnenin bu karma tabloda bir key olup olmadigini test eder.

        System.out.println("Listemizdeki keylerde 101 no varmı? "+ht.containsKey(101));//true yazar

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // remove(Object key) ; Key (ve buna karsilik gelen degeri) kaldirdigini

        ht.remove(101);
        System.out.println("listenin yeni hali: "+ht);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 7-remove(Object key, Object value) ; Belirtilen key girisi, yalnizca o anda belirtilen degere eslenmisse kaldirir.

        ht.remove(102,"Yunus");
        System.out.println(ht);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // get(Object key) ; Belirtilen anahtarin eselendigi degeri
        // veya null bu eslesme key icin esleme icermiyorsa dondurur...

        System.out.println("106 nolu anahtarın value: "+ht.get(106));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 9-getOrDefault(Object key, V defaultValue) ; Belirtilen key in esitlendigi degeri veya
        // defaultValue bu esleme key için esleme icermiyorsa dondurur...
        ht.getOrDefault(101,"suat");
        System.out.println(ht.getOrDefault(103,"Ahmet"));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 10-hashCode() ; Map arayuzundeki tanima gore map icin kod degerini dondurur..


        System.out.println("Hash Code lara bakalım: "+ht.get(104).hashCode());

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 11-isEmpty() ; Bu hashtable'ın degerlerle key eslemedigini test eder bos ise true dolu ise false dondurur.

        System.out.println("Listemiz Boş mu ? "+ht.isEmpty());
        System.out.println("ikinci listemiz boş mu? "+ht1.isEmpty());
/*
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		ht.put(null,"ali");
		//NullPointerException firlatir

		ht.put(104,null);
		//NullPointerException firlatir
 */


    }
}
