package OCOSorulari;

public class soru1 {
    public static void main(String[] args) {
        int arr1[]={1,2,3};
        int arr2[]=new int[5];
        arr2=arr1;
        for (int i:arr2
             ) {
            System.out.print(i+" ");

        }
        System.out.println();
        int arr3[]=new int[3];
        arr3=arr2;
        for (int i:arr3) {
            System.out.print(i+" ");

        }
    }
}
