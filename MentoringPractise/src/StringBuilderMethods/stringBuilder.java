package StringBuilderMethods;

import org.w3c.dom.ls.LSOutput;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Ahmet ");
        sb.append("Ali ");


        System.out.println(sb);


        // append(); in iki ozelligi var.
        // Bir tanesi direk birlestirme concat gibi...
        // Digeri de substring de oldugu gibi araligi alarak ekleme yapabiliriz...

        sb.append("Can", 0, 3);
        System.out.println(sb);
        //---------------------------------------------------------------------------------
        // 2.Method --> length(); SB nin uzunlugunu verir...

        System.out.println("Stringin uzunlugu: " + sb.length());


        //---------------------------------------------------------------------------------
        // 3.Method --> capacity ();

        System.out.println(sb.capacity());

        //---------------------------------------------------------------------------------
        // 4.Method --> trimToSize(); capacity de ki bosluklari siler lengt e esitler
        sb.trimToSize();
        System.out.println("listemin fazlalıkları temizlenmiş olarak uzunlugu: " + sb.capacity());

        //---------------------------------------------------------------------------------
        // 5.Method --> charAt(); SB de ki istene karakteri indexine gore almaya yarar.,

        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i, i + 1).equals("a")) {
                sb.deleteCharAt(i);

            }

        }
        System.out.println(sb);

        sb.delete(2,5);
        System.out.println(sb);

        //---------------------------------------------------------------------------------
        // 9.Method --> indexOf(); SB de istenen karakterin indexini verir...


        StringBuilder sb1=new StringBuilder();
        sb1.append("Ne");
        sb1.append("Mutlu");
        sb1.append("Türküm");
        sb1.append("Diyene");
        System.out.println(sb1);
        System.out.println(sb1.indexOf("mutlu"));


    }
}
