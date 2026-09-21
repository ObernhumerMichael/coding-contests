import java.util.LinkedList;
import java.util.List;

public class Algorithm {
  public int[][] run(int[][] input) {
    int[][] result = new int[input.length * 3][];

    for (int i = 0, j = 0; i < input.length; i += 1, j += 3) {
      int xTarget = input[i][0];
      int yTarget = input[i][1];

      result[j] = getPacesFor(xTarget);
      result[j + 1] = getPacesFor(yTarget);
      result[j + 2] = null;
    }

    return result;
  }

  public int[] getPacesFor(int targetSpace) {
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

    return paces.stream().mapToInt(Integer::intValue).toArray();
  }
}
