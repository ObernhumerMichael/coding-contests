import java.nio.file.Path;

public class Level4 {
  public static void main(String[] args) {
    Path example = Path.of("./in_level-4_0-example.txt");
    Path small = Path.of("./in_level-4_1-small.txt");
    Path large = Path.of("./in_level-4_2-large.txt");

    Path[] paths = {example, small, large};
    // Path[] paths = {example};

    for (Path path : paths) {
      int[][] input = FileReader.read(path);
      Path outputPath = Path.of(path.toString().replace("in_", "result_"));
      FileWriter.write(outputPath, new Algorithm().run(input));
    }
  }
}
