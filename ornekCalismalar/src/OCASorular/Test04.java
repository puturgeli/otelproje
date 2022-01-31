package OCASorular;

public class Test04 implements I01 {

    int x;

    public void cal(int item){

        x = item + item;

    }

    public static void main(String args[]){

        Test03 obj1 = new Test03();

        Test04 obj2 = new Test04();

        obj1.cal(I01.x);

        System.out.println(obj1.x);

        obj2.cal(I01.x);

        System.out.println(obj2.x);

    }

}