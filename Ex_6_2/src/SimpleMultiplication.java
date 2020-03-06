public class SimpleMultiplication {

    private int[][] matrixF;
    private int[][] matrixS;
    private int[][] result;
    private int FHeight;
    private int SHeight;
    private int SLength;

    public SimpleMultiplication(int[][] matrixF, int[][] matrixS) {
        this.matrixF = matrixF;
        this.matrixS = matrixS;
        this.FHeight = matrixF.length;
        this.SLength = matrixS[0].length;
        this.SHeight = matrixS.length;

        this.result = new int[FHeight][SHeight];
    }

    public int[][] getResult() throws IncorrectInputData {
        for (int id = 0; id < FHeight; id++) {
            for (int idx = 0; idx < SLength; idx++) {
                int elem = 0;

                 for (int i = 0; i < SHeight; i++) {
                    elem += matrixF[id][i] * matrixS[i][idx];
                }
                result[id][idx] = elem;
            }
        }
        return result;
    }
}
