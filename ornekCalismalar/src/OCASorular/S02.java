package OCASorular;

public class S02 {
    public static void main(String[] args) {
        boolean opt=true;
        if (opt) {
            System.out.println("True");
        } else {
            throw new IllegalStateException("Unexpected value: " + opt);
        }
        System.out.println("Done");
    }
}
