package Kutuphane;

import java.util.Map;
import java.util.Set;

public class Liste extends Main {

    public static void listegoruntuleme() {
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();

        int sayac=1;

        for (Map.Entry<String, String> each : entrySet) {

            System.out.println(sayac +". entry : " + each);
            sayac++;
        }
        Main.selectOption();

    }
}
