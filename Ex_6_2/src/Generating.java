import java.io.FileWriter;
import java.io.IOException;

public class Generating {
    public Generating() throws IOException {
        try (FileWriter fileWriter = new FileWriter("Matrix.txt")) {
            for (int i = 1; i < 99; i++) {
                for (int j = 1; j < 100; j++) {
                    fileWriter.write(String.valueOf((int) (Math.random() * 10 + 1)) + ',');
                }
                fileWriter.write("\n");
            }
            fileWriter.write(" \n");

            for (int i = 1; i < 100; i++) {
                for (int j = 1; j < 99; j++) {
                    fileWriter.write(String.valueOf((int) (Math.random() * 10 + 1)) + ',');
                }
                fileWriter.write((int) (Math.random() * 10 + 1) + "\n");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Generating n = new Generating();
    }
}
