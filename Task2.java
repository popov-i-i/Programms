public class Main {
    public static void sort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
    }
        public static void main(String[] args) {
        int [] a = {5, 4, 3, 2, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
