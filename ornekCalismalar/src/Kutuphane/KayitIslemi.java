package Kutuphane;

public class KayitIslemi extends Main {
    public static void saveInfo() {

            System.out.println("Lutfen kimlik numaranizi giriniz ");
            String kimlikNo=scan.next();
            if (kimlikNo.length()!=4) {
                System.out.println("lutfen 4 haneli kimlik numarasi giriniz");
                kimlikNo=scan.next();
            }else{
                if (hm.containsKey(kimlikNo)) {
                    System.out.println("Daha once girilmis bir kimlik no girdiniz lutfen tekrardan giriniz");
                    kimlikNo=scan.next();
                }
            }
            scan.nextLine();
            System.out.println("Lutfen isminizi ve soyisminizi giriniz");
            String adSoyad= scan.nextLine();

            System.out.println("Lutfen adresinizi giriniz");
            String adres= scan.nextLine();

            System.out.println("Lutfen bosluk birakmadan telefon numaranizi giriniz");
            String no= scan.next();

            String kullanici="Ad Soyad : "+adSoyad+" / Adres : "+adres+" / Telefon No : "+no;

            hm.put(kimlikNo,kullanici);

            System.out.println(hm);

            Main.selectOption();

    }

}
