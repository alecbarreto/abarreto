import java.util.ArrayList;

public class Flap_Display {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789";

  public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
    String[] ans = new String[lines.length];

    for (int i = 0; i < lines.length; i++) {
      int length = lines[i].length();
      String temp1 = lines[i];
      String temp2;
      int location;
      ans[i] = "";

      for (int j = 0; j < length; j++) {
        temp2 = temp1;
        temp1 = "";

        for (int k = 0; k < temp2.length(); k++) {
          location = ALPHABET.indexOf(temp2.charAt(k));
          temp1 += ALPHABET.charAt( (location + rotors[i][j]) % ALPHABET.length());
        }
        ans[i] += temp1.charAt(j);
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] cat = new String[1];
    cat[0] = "CAT";

    int[][] rot = new int[1][3];
    rot[0][0] = 1;
    rot[0][1] = 13;
    rot[0][2] = 27;

    System.out.println(flapDisplay(cat,rot)[0]);
  }
}
