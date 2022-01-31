package Kutuphane;

public class SilmeIslemi extends Main{
    public static void removeInfo() {
        do {
            System.out.println("Lutfen silmek istediginiz kisinin kimlik numarasini giriniz");
            String id=scan.next();
            if(hm.isEmpty()){
                System.out.println("Map'te eleman olmadigi icin herhangi bir islem yapilamamistir");
                break;
            }else if (id.length()!=4) {
                System.out.println("lutfen 4 haneli kimlik numarasi giriniz");
                id=scan.next();
            }else if(!hm.containsKey(id)){
                System.out.println("Girdiginiz kimlik no ile ilgili bilgi bulunamamistir");
                break;
            }else {
                System.out.println(id+" kimlik no'lu silmek istediginiz kisinin bilgileri : "+hm.remove(id));
                break;
            }


        }while(true);
        Main.selectOption();
    }
}
