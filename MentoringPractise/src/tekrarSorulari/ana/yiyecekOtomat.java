package tekrarSorulari.ana;

import java.util.Scanner;
import java.util.TreeMap;

public class yiyecekOtomat {



    public static void main(String[] args) throws InterruptedException {

        Scanner scan=new Scanner(System.in);
        System.out.println("\n===YİYECEK OTOMATI===");
        TreeMap<String,Double> otomat=new TreeMap<>();
        otomat.put("A-->TADELLE ",5.2 );
        otomat.put("B-->COKONAT ",4.7 );
        otomat.put("C-->SNİKERS ",6.5 );
        otomat.put("D-->BİSKREM ",4.8 );
        otomat.put("E-->NEGRO ",3.8 );

        char secim=' ';
        boolean flag=false;
        String devamMi = "";

        otomat.forEach((x,y)-> System.out.println(x+y+ "TL"));
        double toplamTutar=0;
        do {
            System.out.println("Seciminizi Yapın: ");
            secim = scan.next().toUpperCase().charAt(0);
            switch (secim){
                case 'A':
                    toplamTutar+=otomat.get("A-->TADELLE ");
                    flag=false;
                    break;
                case 'B':
                    toplamTutar+=otomat.get("B-->COKONAT ");
                    flag=false;
                    break;
                case 'C':
                    toplamTutar+=otomat.get("C-->SNİKERS ");
                    flag=false;
                    break;
                case 'D':
                    toplamTutar+=otomat.get("D-->BİSKREM ");
                    flag=false;
                    break;
                case 'E':
                    toplamTutar+=otomat.get("E-->NEGRO ");
                    flag=false;
                    break;
                default:
                    System.out.println("Hatalı bir secim yaptınız");
                    flag=false;break;

            }
            if (flag==false){
                System.out.println("Seçdiginiz ürün düşüyor.");
                Thread.sleep(1000);
                System.out.println("Loading…\n" + "█▒▒▒▒▒▒▒▒▒");
                Thread.sleep(1000);
                System.out.println("50%\n" + "███████▒▒▒");
                Thread.sleep(1000);
                System.out.println("100%\n" + "██████████");

                System.out.println("-------");
                System.out.println("\ndevam etmek istiyormusun. (E/H)");
               scan.nextLine();
                devamMi=scan.nextLine();


            }


        }while (devamMi.equalsIgnoreCase("E")||flag==true);
        System.out.println("ödemeniz gereken para : " + toplamTutar);
        System.out.println("------------\n");
        double odemeMiktari=0.0;

        do {
            System.out.println("lütfen ödemenizi yapın ");
            double odenenPara=scan.nextDouble();
            if(odenenPara==50||odenenPara==5||odenenPara==10||odenenPara==20){
                if (odemeMiktari<toplamTutar){
                    System.out.println("eksik odemen yaptınız " + (odemeMiktari - odenenPara));
                }
                System.out.println("Paranız Kontrol ediliyor");Thread.sleep(500);
                System.out.println("ödemeniz yapılmıştır. afiyet olsun");

            }else{
                System.out.println("Otomatimiz sadece 5TL,10TL,20TL,50TL 'lik banknot kabul etmektedir. Lutfen odemeyi bu sekilde yapiniz..\n");


            }
        }while (odemeMiktari<toplamTutar);

        if(odemeMiktari>toplamTutar){
            System.out.println("Para Üstünüz gene bekleriz" + (odemeMiktari - toplamTutar)+"TL ");
        }
        System.out.println("gene bekleriz");

    }


    }

