import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriter {
  public static void write(Path path, int[][] data) {
    try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
      for (int[] row : data) {
        for (int value : row) {
          writer.write(String.valueOf(value));
          writer.write(" ");
        }
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
  }
}
