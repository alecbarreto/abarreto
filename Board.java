public class Board {

  private int rows;
  private int cols;
  private double difficulty;
  private Cell[][] board;
  private boolean[][] safeCells;
  private boolean[][] markedCells;

  public Board(int r, int c, double d) {
    rows = r;
    cols = c;
    difficulty = d;
    board = new Cell[rows][cols];
    safeCells = new boolean[rows][cols];
    markedCells = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (Math.random() > difficulty) {
          board[i][j] = new Cell(false, 0);
        }
        else {
          board[i][j] = new Cell(true, 0);
        }
      }
    }

    // XXX may God have mercy on your soul
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (!(board[i][j].isMine())) {
          if (i > 0 && i < rows-1) {
            if (j > 0 && j < cols-1) {
              for (int k = -1; k < 2; k++) {
                if (board[i+k][j-1].isMine()) {
                  board[i][j].addSurroundingMine();
                }
              }
              for (int k = -1; k < 2; k++) {
                if (board[i+k][j+1].isMine()) {
                  board[i][j].addSurroundingMine();
                }
              }
              if (board[i-1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
              if (board[i+1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
            }

            else if (j == 0) {
              for (int k = -1; k < 2; k++) {
                if (board[i+k][j+1].isMine()) {
                  board[i][j].addSurroundingMine();
                }
              }
              if (board[i-1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
              if (board[i+1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
            }
            else {
              for (int k = -1; k < 2; k++) {
                if (board[i+k][j-1].isMine()) {
                  board[i][j].addSurroundingMine();
                }
              }
              if (board[i-1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
              if (board[i+1][j].isMine()) {
                board[i][j].addSurroundingMine();
              }
            }
          }

          else if (j == 0 && i == 0) {
            if (board[i+1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i+1][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }
          else if (j == 0 && i == rows-1) {
            if (board[i-1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i-1][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }
          else if (j == cols-1 && i == 0) {
            if (board[i+1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i+1][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }
          else if (j == cols-1 && i == rows-1) {
            if (board[i-1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i-1][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }

          else if (i == 0) {
            if (board[i+1][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i+1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i+1][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }
          else {
            if (board[i-1][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i-1][j].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i-1][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j-1].isMine()) {
              board[i][j].addSurroundingMine();
            }
            if (board[i][j+1].isMine()) {
              board[i][j].addSurroundingMine();
            }
          }
        }
      }
    }
  }

  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

  public void addSafeCell(int x, int y) {
    safeCells[x][y] = true;
  }

  public void addMarkedCell (int x, int y) {
    markedCells[x-1][y-1] = true;
  }

  public Cell[][] getBoard() {
    return board;
  }

  public String toString() {
    String s = "\n";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (j == 0) {
          s += "\n\n\t\t\t\t\t";
        }

        if (safeCells[i][j] || (board[i][j].getSurrounding() == 0 && !board[i][j].isMine())) {
          if (board[i][j].getSurrounding() == 0 && !board[i][j].isMine()) {
            s += "   ";
          }
          else {
            s += board[i][j].getSurrounding() + "  ";
          }
        }

        else if (markedCells[i][j]) {
          s += "X  ";
        }

        else {
          s += "-  ";
        }
      }
    }
    return s;
  }
}
