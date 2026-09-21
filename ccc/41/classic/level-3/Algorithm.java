import java.util.LinkedList;
import java.util.List;

public class Algorithm {
  public int[][] run(int[][] input) {
    int[][] result = new int[input.length][2];

    for (int i = 0; i < input.length; i++) {
      int[] station = input[i];
      int targetSpace = station[0];
      int curSpace = 0;
      boolean backwards = targetSpace < 0;
      ShipPace ship = new ShipPace(backwards);
      List<Integer> paces = new LinkedList<>();

      while (Math.abs(targetSpace) > Math.abs(curSpace)) {
        int curPace = ship.getPace();
        paces.add(curPace);

        if (curPace != 0) {
          curSpace += backwards ? -1 : 1;
        }

        int remainingSpace = Math.abs(targetSpace) - Math.abs(curSpace);
        if (remainingSpace < ship.spaceTillStop()) {
          ship.decrease();
        } else if (remainingSpace > ship.spaceTillStop()) {
          ship.increase();
        }
      }

      paces.add(0);

      int[] shipInstructions = paces.stream().mapToInt(Integer::intValue).toArray();
      result[i] = shipInstructions;
    }

    return result;
  }
}
