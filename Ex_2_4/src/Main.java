public class Main {
    static int maxline(int a[][]) {
        int maxline = 0;
        for (int i = 0; i < a.length; i++) {
            int mlen = 0;
            int len = 0;
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == 0) {
                    len += 1;
                } else {
                    if (len >= mlen) {
                        mlen = len;
                        len = 0;
                    }
                }
                if (len > mlen) {
                    mlen = len;
                }
            }
            if (mlen > maxline) {
                maxline = mlen;
            }
        } return maxline;
    }

    public static void main(String[] args) {
        int [][] a = {{5,7,3,17}, {8,7,0,12}, {1,0,0,1}, {1,0,0,0}};
        System.out.println(maxline(a));
    }
}
