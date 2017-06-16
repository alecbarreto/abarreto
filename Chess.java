import java.util.*;
import java.lang.*;

class Chess {

  public static String game(long n) {

    double numerator = 0;
    String ans = "[";
    int denominator = 1;

    if (n == 0) {
      return "[0]";
    }

    else {
      for (double row = 1; row <= n; row++) {
        for (double col = 1; col <= n; col++) {
          numerator += col/(col+row);
        }
      }
    }
    if (numerator - (int)numerator > 0.9 || numerator - (int)numerator < 0.1) {
      ans += Integer.toString((int)Math.round(numerator));
      ans += "]";
      return ans;
    }

    while (numerator != (int)numerator) {
      numerator *= 10;
      denominator *= 10;
      if (numerator - (int)numerator > 0.9 || numerator - (int)numerator < 0.1) {
        break;
      }
    }

    for (int i = 2; i <= numerator; i++) {
      if (numerator % i == 0 && denominator % i == 0) {
        numerator /= i;
        denominator /= i;
      }
    }

    if (denominator == 1) {
      return ans + Integer.toString((int)numerator) + "]";
    }

    ans += Integer.toString((int)numerator);
    ans += ", ";
    ans += Integer.toString(denominator);
    ans += "]";
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(game(5));
  }
}
