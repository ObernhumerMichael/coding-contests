import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileReader {

  public static int[][] read(Path path) {
    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

      int rowCount = Integer.parseInt(reader.readLine().trim());
      int[][] rows = new int[rowCount][];

      for (int i = 0; i < rowCount; i++) {
        String line = reader.readLine();
        if (line == null) {
          throw new IOException("Expected " + rowCount + " rows, but file ended at row " + i);
        }
        rows[i] = Arrays.stream(line.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
      }
      return rows;
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
      return new int[0][0]; // Return an empty array in case of an error
    }
  }
}
