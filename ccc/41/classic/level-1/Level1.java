import java.nio.file.Path;

public class Level1 {
  public static void main(String[] args) {
    Path example = Path.of("./in_level-1_0-example.txt");
    Path small = Path.of("./in_level-1_1-small.txt");
    Path large = Path.of("./in_level-1_2-large.txt");

    Path[] paths = {example, small, large};

    for (Path path : paths) {
      int[][] input = FileReader.read(path);
      int[] output = new Algorithm().run(input);
      Path outputPath = Path.of(path.toString().replace("in_", "result_"));
      FileWriter.write(outputPath, output);
    }
  }
}
