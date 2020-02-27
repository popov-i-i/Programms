public class Main {
    public static int MaxElem(int[] a, int i) {
        int m = 0;
        if (i < a.length) {
            m = a[i];
            for (int k = 0; k < a.length; k++) {
                if (m < a[k]) {
                    m = MaxElem(a, k);
                }
            }
            return m;
        } else {
            System.out.print("Массив пуст ");
            return 0;
        }
    }

    public static void main(String[] args) {
        int [] a = {1,63,12,45,6};
        System.out.println(MaxElem(a,0));
    }
}
