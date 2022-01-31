package tekrarSorulari.mapDeneme;

import java.util.*;

public class kutupHaneDeneme {

    static Scanner scan = new Scanner(System.in);
  static HashMap<Integer, List<depo>> kayit = new HashMap<>();

    public static void main(String[] args) {
        anaMenu();


    }

    private static void anaMenu() {
        System.out.println("====KUTUPHANEMİZE HOŞ GELDİNİZ====\n" +
                "1.Kitap Ekle\n" +
                "2.Kitap Arama\n" +
                "3.Kitap Silme\n" +
                "4.Kitapları Listeleme\n" +
                "5.Çıkış\n\n" +
                "Seciminizi yapın");
        char secim = scan.next().charAt(0);
        switch (secim) {
            case '1':
                kitapEkle(kayit);
                break;
            case '2':
                kitapArama(kayit);
                break;
            case '3':
             //   kitapSilme(kayit);
                break;
            case '4':
               kitapListele(kayit);
                break;
            case '5':
                cikis();
                break;
            default:
                System.out.println("gecerli bir secim yapmadınız");
                anaMenu();
                break;
        }

    }

    private static void kitapArama(HashMap<Integer, List<depo>> kayit) {
        System.out.println("Aramak istediginiz kitabın numarasını giriniz: ");int no=scan.nextInt();
        for (depo w: kayit.keySet()
             ) {
            w=
        }

anaMenu();
    }

    private static void kitapListele(HashMap<Integer, List<depo>> kayit) {

        int sayac=1;
        System.out.println("===============KİTAP LİSTESİ================");
        Set<Map.Entry<Integer, List<depo>>> entrySet=kayit.entrySet();
        for (Map.Entry<Integer, List<depo>> w:entrySet
             ) {
            System.out.println(sayac+".Kitap "+w);
            sayac++;

        }
        System.out.println("Devam etmek için herhangi bir tuşa basın");
        scan.next();
        anaMenu();
    }

    private static void cikis() {
        System.out.println("Program Kapatılıyor.");

        System.out.println("Gene Bekleriz");
    }

    private static void kitapEkle(HashMap<Integer, List<depo>> kayit) {
        int key=100;
        char devam;
        do {
            List<depo> listem = new ArrayList<>();
            scan.nextLine();

            System.out.print("Kitap Adı: ");
            String kitapAdi = scan.nextLine();
            System.out.print("Yazar Adı: ");
            String yazarAdi = scan.nextLine();
            System.out.print("Yayın Evi: ");
            String yayinEvi = scan.nextLine();
            System.out.print("Yayınlanma Tarihi: ");
            int yayinTarih = scan.nextInt();
            System.out.print("Kitap Fiyatı: ");
            double fiyat = scan.nextDouble();

            depo value = new depo(kitapAdi, yazarAdi, yayinEvi, yayinTarih, fiyat);
            listem.add(0, value);
            kayit.put(key, listem);
            key++;
            System.out.println(kayit.keySet()+" nolu kayıt "+kayit.values()+" yapıldı.");
            System.out.print("Yeni kayıt eklenecek mi? (E/H)");
            devam = scan.next().toLowerCase().charAt(0);

        } while (devam != 'h');
        anaMenu();
    }
}