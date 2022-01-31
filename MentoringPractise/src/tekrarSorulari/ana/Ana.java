package tekrarSorulari.ana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ana {

	/*
	 * Merhaba arkadaşlar, javadan proje yapmak isteyen arkadaşlar vardı...
projemizin adı YIYECEK OTOMATI

--15 adet ürün ve bu ürünlerin fiyatlarını belirleyiniz.
Bu ürünler ekranda listelensin

--ürün seçip, para miktarı giriniz
--girdiginiz para fazla ise üstünü versin,
eksik ise ekleme yapmanızı istesin
--Ek ürün seçme seçenegi olsun, siz devam ettiginiz sürece,
para kontrolünü de yaparak işlem yapmaya devam etsin...
NOT: Otomat sadece 1 tl , 5 tl, 10 tl, 20 tl miktarlarını kabul etsin
oop concepte ait ögrendiklerimizi kullanmaya çalışalım...

iyi çalışmalar
Kolay gelsin...
1 ne istedigini sor
2 fiyatini hesabla
3 parasini al

	 */
	public static List<String> yiyecek = new ArrayList<>();
	public static List<Double> fiyat = new ArrayList<>();
	public static List<String> sepet= new ArrayList<>();
	public static List<Double> sepettekiFiyat=new ArrayList<>();
	
	static Scanner scan=new Scanner(System.in);
	static String secim="";
	
	public static void main(String[]args) {
		
		yiyecek.addAll(Arrays.asList("biskrem","albeni","hosbes","link","pepsi","su","tadelle","magnum",""));
		fiyat.addAll(Arrays.asList(4.0,3.5,5.0,4.5,7.0,1.5,6.0,12.0));
		
		System.out.println("*******************otomatimiza hosgeldiniz**********************");
		
		do {
			System.out.println("lutfen yapmakistediginiz islmi seciniz\n1-urun secmek\n2-odeme yapmak\n3-cikis");
			System.out.println("URUN NO\t\tURUN\t\t\tFIYATI");
			System.out.println(yiyecek);
			System.out.println();
			System.out.println(fiyat);
			String secim=scan.nextLine();
			if (secim=="1") {
				urunleriListele();
				
				
			}
		} while (secim=="3");
		cikis();
		
	}

	private static void urunleriListele() {
		System.out.println("urunlerimiz gosterilecektir\n"+yiyecek);
		
	}

	private static void cikis() {
		
		System.out.println("bizi tercih ettiginiz icin tesekkurler");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
