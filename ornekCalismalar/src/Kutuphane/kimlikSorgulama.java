package Kutuphane;


import java.util.*;

public class kimlikSorgulama<nextInt> {
    static Scanner scan = new Scanner(System.in);
    static Map<Integer, List<String>> kayit = new HashMap<>();

    public static void main(String[] args) {

        anaMenu();

    }

    private static void anaMenu() {
        System.out.println("***Kayıt Bölümü***");
        System.out.print("1.Kayıt Ekleme\n2.Kayıt Görüntüleme\n3.Kayıt Silme\n4.Kayıt Listeleri\n5.Çıkış\n\nSeciminizi yapın...: ");
        int secim = scan.nextInt();
        switch (secim) {
            case 1:
                kayıtEkle(kayit);
                break;
            case 2:
                getInfo(kayit);
                break;
            case 3:
                getRemove(kayit);
                break;
            case 4:
                listeleme(kayit);
                break;
            case 5:
                System.out.println("Program Sonlandırıldı.");
                break;
            default:
                System.out.println("Hatalı Bir secim yapıldı.");
                anaMenu();
                break;
        }

    }

    private static void getRemove(Map<Integer, List<String>> kayit) {
        char devamMi;
        veritabaniKontrol();

        do {
            System.out.println("***KAYIT SİLME BÖLÜMÜ***");
            System.out.print("Lütfen Silmek İstediginiz Kaydın Numarasını Girin: ");
            int kno = scan.nextInt();

            if (kayit.containsKey(kno)) {
                System.out.println("Aradıgnız Kayıt Bulundu:\n" + kayit.get(kno) + "\nSilmek İstediginize Eminmisiniz?(E/H)");
                char sil = scan.next().toLowerCase().charAt(0);
                if (sil == 'e') {
                    kayit.remove(kno);
                }
                break;
            } else {
                System.out.println("Aradıgınız Kayıt Bulunamadı..");

            }
            System.out.println("Yeni arama Yapılacak mı?(E/H)");
            devamMi = scan.next().toLowerCase().charAt(0);
        } while (devamMi != 'e');
        System.out.println("Ana Menuye Dönmek için Bir Tuşa Basın");
        scan.next();
        anaMenu();

    }

    private static void getInfo(Map<Integer, List<String>> kayit) {
        char devamMi;
        veritabaniKontrol();


        do {
            System.out.println("***KAYIT ARAMA BÖLÜMÜ***");
            System.out.print("Aradıgınız Kayıdın 4 Haneli Kimlik Numarasını Girin: ");
            int kano = scan.nextInt();
            if (!kayit.containsKey(kano)) {
                System.out.println("Aradıgınız Kimlik Numarasında Bir Kayıt Yoktur.");
                break;
            } else {
                System.out.println("Aradıgnız Kayıt Bulunmuştur.");
                System.out.println(kano + " Kimlik Nolu Kişinin Bilgileri: " + kayit.get(kano));

            }

            System.out.print("Yeni arama Yapılacakmı? (E/H)");
            devamMi = scan.next().toLowerCase().charAt(0);
        } while (devamMi != 'h');
        System.out.println("Ana Menuye Dönmek için Bir Tuşa Basın");
        scan.next();
        anaMenu();
    }

    private static void veritabaniKontrol() {
        if (kayit.isEmpty()) {
            System.out.println("Veritabanında henüz yapılmış bir kayıt yoktur.");
            System.out.println("AnaMenuye Dönmek İçin Bir Tuşa basın.");
            scan.next();
            anaMenu();
        }
    }

    private static void listeleme(Map<Integer, List<String>> kayit) {

        System.out.println("***LİSTELEME GÖLÜMÜ***");
        Set<Map.Entry<Integer, List<String>>> entrySet = kayit.entrySet();
        int sira = 1;
        for (Map.Entry<Integer, List<String>> w : entrySet) {
            System.out.println(sira + ". kayit --> " + w);
            sira++;

        }
        System.out.println("Ana Menuye dönmek için bir tuşa basın: ");
        scan.next();
        anaMenu();
    }

    private static void kayıtEkle(Map<Integer, List<String>> kayit) {

        char devamMi;
        do {
            System.out.print("Lütfen 4 Haneli Kimlik Numaranızı Giriniz: ");
            int kno = krkUzunluKontrol(scan.nextInt());
            scan.nextLine();
            System.out.print("Ad ve Soyad Bilgisini Giriniz: ");
            String adSoyad = kelimeKontrol(scan.nextLine());
            System.out.print("Adres Bilgisini Giriniz: ");
            String adres = kelimeKontrol(scan.nextLine());
            System.out.print("Lütfen 11 Haneli Telefon Bilgisini Giriniz: ");

            String tel = duzenle(scan.next());


            List<String> list = new ArrayList<>();
            list.add(0, adSoyad);
            list.add(1, adres);
            list.add(2, tel);

            kayit.put(kno, list);


            System.out.println("Yeni Kayıt Eklenecek mi? (E/H)");
            devamMi = scan.next().toLowerCase().charAt(0);

        } while (devamMi != 'h');
        anaMenu();
    }

    private static String duzenle(String numara) {

        if (numara.length() != 11) {
            System.out.println("Telefon Numarası 11 Haneli olmalıdır. \nTekrar Giriniz:");
            numara = duzenle(scan.next());
        } else {

            numara = "(" + numara.substring(0, 3) + ") " + numara.substring(3, 6) + " " + numara.substring(6, 8) + " " + numara.substring(8, 10);

        }
        return numara;
    }

    private static String kelimeKontrol(String str) {
        str = str.trim();
        String arr[] = str.split("");
        String depo = str.substring(0, 1).toUpperCase();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                depo += str.substring(i, i + 2).toUpperCase();
                i++;
            } else {
                depo += str.substring(i, i + 1);
            }
        }
        return depo;

    }

    private static int krkUzunluKontrol(int krkUzun) {
        String krkuzunlugukontrol = krkUzun + "";
        if (krkuzunlugukontrol.length() != 4) {
            System.out.println("Kimlik Numarası 4 Haneli Olmalıdır.\nTekrar Deneyiniz..:");
            krkUzun = krkUzunluKontrol(scan.nextInt());

        } else {
            if (kayit.containsKey(krkUzun)) {
                System.out.println("Yazılan Kimlik numarası Sisteme Kayıtlıdır.\nBaşka Bir Kimlik Numarası Giriniz: ");
                krkUzun = scan.nextInt();
            }

        }
        return krkUzun;
    }


}