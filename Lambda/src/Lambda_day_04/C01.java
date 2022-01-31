package Lambda_day_04;

import java.util.*;
import java.util.stream.Collectors;

public class C01 {
    public static void main(String[] args) {

        TechPro trGunduz = new TechPro("yaz", "TR Gunduz", 97, 121);
        TechPro enGunduz = new TechPro("kis", "ENG Gunduz", 95, 131);
        TechPro trGece = new TechPro("bahar", "TR Gece", 99, 143);
        TechPro enGece = new TechPro("sonbahar", "Eng Gece", 93, 151);

        List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz, enGunduz, trGece, enGece));
//bu class'da agırlıklı olarak return type çalışıcaz

        System.out.print("Batc'lerin ortalaması 92'den büyük mü? ");
        System.out.println(batchOrt92Byk(list) ? "Büyük" : "Degil" + batchOrt92Byk(list));
        System.out.print("110 ögrenciden az batch varmı? ");
        System.out.println(batchOgrSayisi110kck(list) ? "Yok" : "Var");
        System.out.print("BatchLerde bahar var mı? ");
        System.out.println(herhangiBirBaharKontrol(list) ? "Bahar batch'i var" : "Bahar Batc'i yok");
        System.out.println();
        System.out.println(batchSiralaBykKck(list));
        System.out.print("Batch ortalamsına göre ilk üç batch: ");
        System.out.println(batchOrtSiralaBykKck(list));
        System.out.print("Ögrenci sayısı en az olan 2. batch ");
        System.out.println(ogrnciSayisiEnAz2(list));
        System.out.print("Batch ortlaması 95'den büyük olan batch'lerin toplam ögrenci sayısı ");
        System.out.println(ort95BykOgrncSayisiTplm(list));
        System.out.print("Batch ortlaması 95'den büyük olan batch'lerin toplam ögrenci sayısı ");
        System.out.println(batch95BykOgrncSayisiTplm(list));
        System.out.println();
        System.out.println(ogrncSayisi130BykBatchOrtalamaBul(list));
        System.out.println();
        System.out.println(gunduzBatcSayisi(list));
        System.out.print(" Ögrenci saysısı 130 dan büyük batch'lerin en iyisinin ortalaması: ");
        System.out.println(ogrncSayisi130EnBykBatchOrt(list));
        System.out.print(" Ögrenci saysısı 150 den az batch'lerin en kötü ortalaması: ");
        System.out.println(ogrncSayisi150AzEnKckBatchOrt(list));


    }

    //task 01--> batch ortalamalarının 92 den büyük olup olmadıgını  kontrol eden bir pr create edin
    public static boolean batchOrt92Byk(List<TechPro> list) {
        return list.stream().
                anyMatch(t -> t.getBatchOrt() > 92);//akışdaki her elemanı batchOrt field'ına göre eşleşmesi kontrol edildi.


    }
    //task 02--> ögrenci sayılarının hiç birinin 110 den az olmadıgını kontrol eden pr. yazını

    public static boolean batchOgrSayisi110kck(List<TechPro> list) {
        return (list.stream().
                noneMatch(t -> t.
                        getOgrcSayisi() < 110));
    }

    //task 03--> batch'lerde herhangi birininde "bahar olup olmadıgını kontrol ediniz
    public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
        return list.stream().
                anyMatch(t -> t.getBatch().
                        equals("bahar"));
    }

    //task 04--> batch'leri ögrenci sayılarına göre büyükden kücüge sıralayın
    public static List<TechPro> batchSiralaBykKck(List<TechPro> list) {
        return list.stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).
                        reversed()).collect(Collectors.toList());//Collect():   akışdaki elemanları istenen şarta göre toplar
        //Collectors.tolist()---> collect'te toplanan elemanları List'e cevirerek bize verir
    }
    //task 05-->batch'lri batch ortalamasına göre büyükden kücüge sıralayın ilk 3'ünü yazdırın

    public static List<TechPro> batchOrtSiralaBykKck(List<TechPro> list) {
        return list.stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).//ortalamasına göre sıraladık listini
                        reversed()).//listenin tersini aldık
                        limit(3).//ilk üç eleamla sınırladık
                        collect(Collectors.toList());// liste olarak yazdırdık
    }

    //task 06--> batch'ler ogrenci sayısı en az olan 2. batc'i yazdırın.
    public static List<TechPro> ogrnciSayisiEnAz2(List<TechPro> list) {
        return list.stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//ogrenci sayısına göre sıraladık
                        limit(2).//listeyi 2 elemanla sıraladık
                        skip(1).//2. eleamnı yazdırmak için birinci eleamnı atladık
                        collect(Collectors.toList());
    }

    //task 07--> batch ortalamsı 95'den büyük olan batch'lerin ögrenci sayılarını toplamını yazdırın
    public static int ort95BykOgrncSayisiTplm(List<TechPro> list) {
        return list.stream().
                filter(t -> t.getBatchOrt() > 95).//95 den buyuk şartı saglandı
                        map(t -> t.getOgrcSayisi()).//batch ortalaması ögrenci sayısı olarak update edildi
                        reduce(0, Integer::sum);//ögrenci sayısı toplandı.

    }

    public static int batch95BykOgrncSayisiTplm(List<TechPro> list) {
        return list.stream().
                filter(t -> t.getBatchOrt() > 95).//95 den buyuk şartı saglandı
                        mapToInt(t -> t.getOgrcSayisi()).//mapToInt()-->type göre int return eder
                //sum()--> çalışınca reduse gerek kalmaz daha kısa ve hızlı code imkanı saglar
                        sum();//

    }

    //task 08--> ögrenci sayıları 130 dan büyük olan batch'lerin batch ortalamasını bulunuz
    public static OptionalDouble ogrncSayisi130BykBatchOrtalamaBul(List<TechPro> list) {
        return list.stream().
                filter(t -> t.getOgrcSayisi() > 130).//ögrenci sayısı 130 dan fazla olanları alırız
                        mapToDouble(t -> t.getBatchOrt()).//ögrenci saysısı 130 dan büyük olan batch'lerin ortalamalarını alırız
                        average();//gelen notları toplayıp ortalmasını alırız
        //sum(),averange()... stream()'in kendi komutları bunlara bak

    }

    //task 09-->gunduz batch'lerinin sayisini  yazdiriniz.
    public static long gunduzBatcSayisi(List<TechPro> list) {
       // return list.stream().filter(t -> t.getBatchName().endsWith("Gunduz")).collect(Collectors.toList());

        return list.stream().
                filter(t->t.getBatchName().//batchname me göre sıralıyoruz
                            contains("Gunduz")).//icersinde gündüz olanları ayırıyoruz
                                        count();//eleman sayma komutu

    }

    //task 10-->Ogrenci sayilari 130'dan fazla olan batch'lerin en buyuk batch ort'unu bulunuz
    public static OptionalDouble ogrncSayisi130EnBykBatchOrt(List<TechPro> list) {
        return list.stream().
                filter(t -> t.getOgrcSayisi() > 130).//130 dan fazla olanları ayırıyoruz
                        mapToDouble(t -> t.getBatchOrt()).//batch ortalması degişgenini getiryoruz
                                    max();//max degeri alıyoruz

    }

    //task 11-->Ogrenci sayilari 150'dan az olan batch'lerin en kucuk batch ort'unu bulunuz.
    public static int ogrncSayisi150AzEnKckBatchOrt(List<TechPro> list) {
        return  list.stream().
                filter(t -> t.getOgrcSayisi() < 150).
                        mapToInt(t -> t.getBatchOrt()).
                                        min().//
                                            getAsInt();//
    }


}