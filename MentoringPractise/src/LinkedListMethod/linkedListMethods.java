package LinkedListMethod;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class linkedListMethods {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        LinkedList<String > ll1=new LinkedList<>(Arrays.asList("Ahmet","Mehmet" , "ziya","Haluk","Güneş"));

        System.out.println("listem: "+ll1);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 2-add(1,”A”); istenen index’e istenen elemani ekler


        ll1.add("Suat");
        ll1.add(0,"Mahmut");
        System.out.println("yeni Hali ile listem: " + ll1);


        // 3-addAll(coll); istenen collection’in tum elemanlarini ekler
        LinkedList<String>ll2=new LinkedList<>(Arrays.asList("Kulak","Burun","Bogaz"));
        ll1.addAll(ll2);
        System.out.println("listemin son hali " + ll1);

        ll1.addAll(0,ll2);
        System.out.println("listemi ilk başa güncelledim: " + ll1);

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 5-addFirst(); istenen elemani, ilk eleman olarak ekler

        ll1.addFirst("Can");ll1.addLast("Canan");
        System.out.println("yeni liste: " + ll1);

        // 7-remove(); ilk elemani siler

        ll1.remove(1);//1. index deki elemanı silelim
        System.out.println(ll1);
        ll1.remove("Burun");
        System.out.println(ll1);//ilk gördügü yerde siliyor digerlerine gitmiyor

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // 11-removeFirstOccurrence("aaa"); istenen elemanin, ilkini siler.

        ll1.removeFirstOccurrence("Bogaz");//ilk gördügü yerde siler normal remove ile aynı çalışır
        System.out.println(ll1);
        ll1.removeLastOccurrence("Bogaz");//son gördügü degeri sile digerlerini bırakır
        System.out.println(ll1);

        LinkedList<Integer>ll3=new LinkedList<>(Arrays.asList(12,22,33,42,13,66,22,12,-6,-9,10));
        System.out.println(ll3);
        // 13-removeLast(); son nodu siler
        ll3.removeLast();ll1.removeAll(ll2);
        System.out.println(ll1);
        System.out.println(ll3);
        System.out.println("Listemin ilk elemanı: "+ll1.getFirst()+" Son elemanı: "+ll1.getLast());

        System.out.println("Listemde suat ismi varmı? "+ll1.contains("Suat"));

        System.out.println("ikinci listem birinci listede kaldı mı? " + ll1.containsAll(ll2));


    }
}
