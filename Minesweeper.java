import java.util.*;

public class Minesweeper {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int rows = 16;
    int cols = 30;
    double difficulty = 0.2;
    int tempRow;
    int tempCol;
    String bombMark = "no";
    int bombRow;
    int bombCol;
    boolean pastInitialBoard = false;
    boolean play = true;
    boolean notRow = false;
    boolean notCol = false;

    Board board = new Board(rows,cols,difficulty);
    boolean[][] safeCells = new boolean[rows][cols];

    while (play) {

      if (notRow || notCol) {
        pastInitialBoard = false;
      }

      if (pastInitialBoard) {

        while (true) {

          System.out.println(board + "\n\n\n");

          if (notRow) {
            System.out.println(" That row is not on the board");
            bombMark = input.nextLine();
            notRow = false;
          }
          else if (notCol) {
            System.out.println(" That column is not on the board");
            bombMark = input.nextLine();
            notCol = false;
          }

          System.out.print(" Would you like to mark a bomb? (type 'y' or 'n'): ");
          bombMark = input.nextLine();

          if (bombMark.toLowerCase().equals("y")) {

            System.out.print(" Select the row the bomb is in (1-16): ");
            bombRow = input.nextInt();
            if (bombRow > board.getRows() || bombRow < 1) {
              notRow = true;
              continue;
            }

            System.out.print(" Select the column the bomb is in (1-30): ");
            bombCol = input.nextInt();
            if (bombCol > board.getCols() || bombCol < 1) {
              notCol = true;
              continue;
            }

            board.addMarkedCell(bombRow,bombCol);
            bombMark = input.nextLine();
          }
          else {
            break;
          }
        }
      }
      else {
        System.out.println(board);
      }

      notRow = false;
      notCol = false;

      if (bombMark.toLowerCase().equals("yes") || !pastInitialBoard) {
        System.out.print("\n\n\n");
      }

      System.out.print(" Select a row (1-16): ");
      while (!input.hasNextInt()) {
        System.out.print(" That's not a valid row number\nSelect a row (1-16):");
        input.next();
      }
      tempRow = input.nextInt();

      if (tempRow > board.getRows() || tempRow < 1) {
        notRow = true;
        continue;
      }

      System.out.print(" Select a column (1-30): ");
      while (!input.hasNextInt()) {
        System.out.print(" That's not a valid column number\nSelect a row (1-16):");
        input.next();
      }
      tempCol = input.nextInt();
      bombMark = input.nextLine();

      if (tempCol > board.getCols() || tempCol < 1) {
        notCol = true;
        continue;
      }

      if (board.getBoard()[tempRow-1][tempCol-1].isMine()) {
        play = false;

        for (int i = 0; i < board.getRows(); i++) {
          for (int j = 0; j < board.getCols(); j++) {
            if (j == 0) {
              System.out.print("\n\n\t\t\t\t\t");
            }
            if (board.getBoard()[i][j].isMine()) {
              System.out.print("X  ");
            }
            else if (board.getBoard()[i][j].getSurrounding() == 0) {
              System.out.print("   ");
            }
            else {
              System.out.print(board.getBoard()[i][j].getSurrounding() + "  ");
            }
          }
        }

        System.out.print("\n\n\n\n Whoops, looks like that one was a mine!\n That's game over for now, but feel free to type 'again' to play another round!\n If not, you can type 'quit' to quit the program (you can always come back by typing 'java Minesweeper'): ");
        if (input.nextLine().toLowerCase().equals("again")) {
          play = true;
          board = new Board(16,30,0.2);
          pastInitialBoard = false;
        }
        else {
          System.out.println("\n Thanks for playing!");
          break;
        }
      }
      else {
        board.addSafeCell(tempRow-1, tempCol-1);
        pastInitialBoard = true;
        continue;
      }
    }
  }
}
