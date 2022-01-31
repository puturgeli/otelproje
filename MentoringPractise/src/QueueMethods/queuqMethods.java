package QueueMethods;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class queuqMethods {
    public static void main(String[] args) {

        /*
         * Fifo : First in first out --> Elemanlar ilk eklenen ilk silinir eczane
         * yemekhane vs sektorlerde zaman kaydı olam elemanlarin tutulmasinda kullanilir.

         * Queue intreface'nin iki subClass constructoru ile obj creat edileblir. LinkedList ve PriorityQueue....

         * LinkedList constructoru ile obj creat edilirse
         * elemanlar Queue icinde insertion order'e gore yani ekleme sirasina goresiralanir

         * PriorityQueue constructoru ile obj creat edilirse elemanlar Queue icinde
         * java'nin kendine ozel algoritmasina gore siralanir.
         */

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        Queue<String>q1=new LinkedList<>(Arrays.asList("Mehmet","Ziya","Güneş","Haluk","Murat","Ahmet"));

        System.out.println("ilk listem: " + q1);

        // Not --> java LinkedList geregi insertion order'e gore yani eklenilen siraya sira olusturdu..
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        Queue<String>q2=new LinkedList<>(Arrays.asList("Dogu","Batı","Güney","Kuzey"));
        System.out.println("ikinci listem: " + q2);

        // --> java kendi PriorityQueue(oncelik sirasi)algoritmasini calistirdi. Kendine gore dizilim yapar...
        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //1-peek() methodu ; ilk elemani silmeden bize return eder.
        System.out.println("ilk listemin ilk elemanı: "+q1.peek());//Mehmet
        System.out.println("ikinci listemin ilk elemanı: " + q2.peek());//Dogu

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
       // 2-poll(); ilk elemani queue'dan siler ve bize return eder
        System.out.println("Listemin ilk elemanı silindi: "+q1.poll());
        System.out.println("ilk listemin yeni hali: " + q1);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // 3-offer(); eleman eklemek icin kullanilir. Add gibidir ama queue ya hastir...
        // Ancak eleman siniri konulduysa add() metodu IllegalStateException firlatir.
        // Ancak offer() method'unda bu durum olmadan kod calismaya devam eder...

        System.out.println(q1.offer("Ahmet"));//true verir
        System.out.println("birinci listeye ekleme yapalım: "+q1);


        System.out.println("ilk listem boş mu? "+q1.isEmpty());

        System.out.println(q1.element());//ilk elemanı verir boş sa wxception atar
        System.out.println(q1);





    }
}
