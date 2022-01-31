import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ders {
  static Scanner scan = new Scanner(System.in);
 static List<Integer> list = new ArrayList<>();

  /*
  kullanıcııdan alınan listedeki elemanların
  1.tüm elemanların toplamını yazdıralım
  2.karelerini aldıralım
  3. tek eleman varsa küpünü alıp 3 fazlasının listesini yazdıralım
  4.cift elemanların kareköklerini ve aynı eleman tekrar etmiyecek şekilde kücükden büyüge yazdıralım
  5. tek olan eleamnları kücükden büyüge tekrarsız yazdıralım


   */

  public static void main(String[] args) {

    System.out.println("Listedemizdeki elemanları aralarında boşluk bırakarak giriniz : ");
    String listeEl = scan.nextLine();
    String[] liste = listeEl.split(" ");

    for (String w : liste) {
      list.add(Integer.valueOf(w));
    }

    System.out.println(list);
    menu();
  }

  public static boolean ciftEl(int x) {
    return (x % 2 == 0);
  }

  public static boolean tekEl(int x) {

    return (x % 2 != 0);
  }

  public static void menu() {
    System.out.println(
        "Seciminizi yapın : \n1.Tüm elemanları topla: \n2.Karelerini al\n3.Tek elemanların küpünü alma\n4.Cift elemanların karekökünü al\n5.tek olan elemanları sırala");
    int secim = scan.nextInt();
    switch (secim) {
      case 1:
        //   list.stream().reduce(Integer::sum);
        int toplam = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(list + " Listedeki elemanların toplamı: " + toplam);
        System.out.println("devam etmek için herhangi bir tuşa basın");
        scan.nextLine();
        menu();
        break;
      case 2:
        list.stream().filter(ders::ciftEl).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        System.out.println("devam etmek için herhangi bir tuşa basın");
        scan.nextLine();
        menu();
        break;
      case 3:
        list.stream()
            .filter(ders::tekEl)
            .map(t -> t * t * t)
            .forEach(t -> System.out.print(t + " "));
        System.out.println("devam etmek için herhangi bir tuşa basın");
        scan.nextLine();
        menu();
        break;
      case 4:
        list.stream()
            .filter(ders::ciftEl)
            .map(Math::sqrt)
            .forEach(t -> System.out.println(t + " "));
        System.out.println("devam etmek için herhangi bir tuşa basın");
        scan.nextLine();
        menu();
        break;
      case 5:
        list.stream().filter(ders::tekEl).sorted().forEach(t -> System.out.print(t + " "));
        System.out.println("devam etmek için herhangi bir tuşa basın");
        scan.nextLine();
        menu();
        break;
    }
  }
}
