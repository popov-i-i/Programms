public class Multiplication extends Thread {

    private int[][] matrixF;
    private int[][] matrixS;
    private int[][] result;
    private int FLength;
    private int SLength;
    private int SHeight;

    public Multiplication(int[][] matrixF, int[][] matrixS) {
        this.matrixF = matrixF;
        this.matrixS = matrixS;
        this.FLength = matrixF.length;
        this.SLength = matrixS[0].length;
        this.SHeight = matrixS[0].length;
        this.result = new int[FLength][SLength];
    }

    @Override
    public void run() {
        for (int id = 0; id < FLength; id++) {
            for (int idx = 0; idx < SLength; idx++) {
                int element = 0;
                for (int i = 0; i < SHeight; i++) {
                    element += matrixF[id][i] * matrixS[i][idx];
                }
                result[id][idx] = element;
            }
        }
    }

    public int[][] getElement() {
        return result;
    }
}
