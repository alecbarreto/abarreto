import java.util.*;
import java.lang.*;

class Main {

  public static String game(long n) {
    double sum = 0;
    String ans = "[";
    int count = 1;
    if (n == 0) {
      return "[0]";
    }
    else {
      for (double row = 1; row <= n; row++) {
        for (double col = 1; col <= n; col++) {
          sum += col/(col+row);
        }
      }
    }
    if (sum - (int)sum > 0.9) {
      ans += Integer.toString((int)Math.round(sum));
      ans += "]";
      return ans;
    }
    while (sum != (int)sum) {
      sum *= 10;
      count *= 10;
    }
    for (int i = 2; i <= sum; i++) {
      if (sum % i == 0 && count % i == 0) {
        sum /= i;
        count /= i;
      }
    }
    if (sum / count == sum) {
      return ans + Integer.toString((int)sum) + "]";
    }
    ans += Integer.toString((int)sum);
    ans += ", ";
    ans += Integer.toString(count);
    ans += "]";
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(game(4));
  }
}
