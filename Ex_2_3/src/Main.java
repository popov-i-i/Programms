public class Main {
    public static float degree(int a, int b) {
        if (b == 0){
            return 1;
        }
        if (b < 0) {
            b = b * (-1);
            b -=  1;
            float m = a * degree(a,b);
            float result = 1/m;
            return result;
        } else {
            b -= 1;
            float m = a * degree(a,b);
            return m;
        }
    }

    public static void main(String[] args) {
        int a = -6;
        int b = 2;
        System.out.println(degree(a,b));
    }
}
