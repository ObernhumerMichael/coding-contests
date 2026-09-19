import java.util.Arrays;

public class Algorithm {
  public int[] run(int[][] input) {
    int[] result = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      result[i] = Arrays.stream(input[i]).sum();
    }

    return result;
  }
}
