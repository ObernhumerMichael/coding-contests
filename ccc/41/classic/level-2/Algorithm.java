public class Algorithm {
  public int[][] run(int[][] input) {
    int[][] result = new int[input.length][2];

    for (int i = 0; i < input.length; i++) {
      int[] row = input[i];
      for (int pace : row) {
        // space
        if (pace > 0) {
          result[i][0] += 1;
        } else if (pace < 0) {
          result[i][0] -= 1;
        }

        // time
        result[i][1] += Math.abs(pace);
        if (pace == 0) {
          result[i][1] += 1;
        }
      }
    }

    return result;
  }
}
