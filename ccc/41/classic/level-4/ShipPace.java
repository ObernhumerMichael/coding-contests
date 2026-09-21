public class ShipPace {
  private static final int[] paces = {0, 5, 4, 3, 2, 1};
  private final boolean backwards;
  private int curPaceIndex = 0;

  public ShipPace(boolean backwards) {
    this.backwards = backwards;
  }

  public int getPace() {
    return paces[curPaceIndex] * (backwards ? -1 : 1);
  }

  public void increase() {
    if (curPaceIndex < paces.length - 1) {
      curPaceIndex++;
    }
  }

  public void decrease() {
    if (curPaceIndex > 0) {
      curPaceIndex--;
    }
  }

  /**
   * Space units till stop.
   *
   * @return will always be positive.
   */
  public int spaceTillStop() {
    return curPaceIndex;
  }
}
