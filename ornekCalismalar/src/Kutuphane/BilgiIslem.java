package Kutuphane;

public class BilgiIslem extends Main{
    public static void getInfo() {
        do {
            System.out.println("Lutfen bilgilerini goruntulemek istediginiz kisinin kimlik numarasini giriniz");
            String id= scan.next();
            if(hm.isEmpty()) {
                System.out.println("Map'te eleman olmadigi icin herhangi bir bilgi getirelemedi");
                break;
            }else if (id.length()!=4) {
                    System.out.println("lutfen 4 haneli kimlik numarasi giriniz");
                    id=scan.next();
            }else if(!hm.containsKey(id)){
                System.out.println("Girdiginiz kimlik no ile ilgili bilgi bulunamamistir");
                break;
            }else {
                System.out.println(id+" kimlik no'lu kisinin bilgileri : "+hm.get(id));
                break;
            }


        }while(true);
        Main.selectOption();

    }
}
