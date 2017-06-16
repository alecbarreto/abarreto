public class Cell {

  private boolean mine;
  private int surroundingMines;

  public Cell() {
    mine = false;
  }

  public Cell(boolean isMine, int surrounding) {
    mine = isMine;
    surroundingMines = surrounding;
  }

  public boolean isMine() {
    return mine;
  }

  public void addSurroundingMine() {
    surroundingMines++;
  }

  public int getSurrounding() {
    return surroundingMines;
  }

  public String toString() {
    if (this.isMine()) {
      return "This cell is a mine.";
    }
    return "This cell is not a mine.";
  }
}
