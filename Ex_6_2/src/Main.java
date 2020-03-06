import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, IncorrectInputData, InterruptedException {

        FileWorker newFile = new FileWorker("Matrix.txt");
        int[][] matrixF = newFile.getMatrixFirst();
        int[][] matrixS = newFile.getMatrixSecond();
        System.out.println("Считались данные");
        if (matrixF[0].length != matrixS.length) {
            throw new IncorrectInputData("Количество элементов не совпадает");
        }


        long begin = System.currentTimeMillis();
        SimpleMultiplication simpleMultiplication = new SimpleMultiplication(matrixF, matrixS);
        int[][] firstResult = simpleMultiplication.getResult();
        FileWorker.writeToFile("SimpleMultiplication.txt", firstResult);
        long out = System.currentTimeMillis() - begin;
        System.out.println("Результат работы однопоточной программы: затрачено времени: " + out);


        int threadNumber;
        for(int id1 = 1; id1<5; id1++) {
            threadNumber = id1;

            int interval = (int) Math.ceil(matrixF.length / threadNumber);
            Multiplication[] threads = new Multiplication[threadNumber];
            int[][] sResult = new int[matrixF.length][matrixS[0].length];
            int[][] subMatrixFirst;
            long newbegin = System.currentTimeMillis();
            for (int i = 0; i < threadNumber; i++) {
                if (i != threadNumber - 1) {
                    subMatrixFirst = Arrays.copyOfRange(matrixF, i * interval, (i + 1) * interval);

                } else {
                    subMatrixFirst = Arrays.copyOfRange(matrixF, i * interval, matrixF.length);
                }
                Multiplication bob = new Multiplication(subMatrixFirst, matrixS);
                bob.start();
                threads[i] = bob;
            }

            for (int idx = 0; idx < threadNumber; idx++) {
                threads[idx].join();
                int[][] sPartResult = threads[idx].getElement();
                int sPartResultLength = sPartResult.length;
                if (idx < threadNumber - 1) {
                    for (int i = 0; i < sPartResultLength; i++) {
                        sResult[i + idx * interval] = sPartResult[i];
                    }
                } else {
                    int ending = matrixF.length - (threadNumber - 1) * interval;
                    for (int i = 0; i < ending; i++) {
                        sResult[i + idx * interval] = sPartResult[i];
                    }
                }
            }

            long newout = System.currentTimeMillis() - newbegin;

            System.out.println("Результат работы многопоточной программы: затрачено времени: " + newout + "; " + id1 +" потоков");
        }

    }
}
