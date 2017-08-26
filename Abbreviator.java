import java.lang.*;
import java.io.*;
import java.util.*;

public class test {

  public static String abbreviate(String string) {

    StringBuilder fin = new StringBuilder("");
    String[] words = string.split("\\s+");
    int count = 0;

    for (int i = 0; i < words.length; i++) {
      count = 0;
      if (words[i].length() > 4) {
        for (int j = 0; j < words[i].length(); j++) {
          if (j == 0) {
            fin.append(words[i].charAt(j));
          }
          else if (j < words[i].length()-1) {
            if (words[i].charAt(j) != '!' && words[i].charAt(j) != '-') {
              count++;
            }
            else {
              count--;
              fin.append(count);
              fin.append(words[i].charAt(j-1));
              fin.append(words[i].charAt(j));
              j += 1;
              fin.append(words[i].charAt(j));
              count = 0;
              continue;
            }
          }
          else {
            fin.append(count);
            fin.append(words[i].charAt(j));
            if (words[i].charAt(j) != string.Charat(string.length()-1)) {
              fin.append(" ");
            }
          }
        }
      }
      else {
        fin.append(words[i]);
        if (i != words.length-1) {
          fin.append(" ");
        }
      }
    }
    return fin.toString();
  }

  public static void main(String[] args) {

    System.out.println(abbreviate("elephant-rides are really fun!"));
  }
}
