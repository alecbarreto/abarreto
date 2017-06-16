import java.util.*;
import java.lang.*;

public class isTriangleNumber {

	public static Boolean isTriangleNumber(long number) {

    int adder = 1;
    int count = 1;
    boolean ans = true;

    if (number <= 1) {
      return ans;
    }

    while (ans) {
      if (count > number) {
        ans = false;
        break;
      }
      else if (count == number) {
        break;
      }
      adder++;
      count += adder;
    }

    return ans;
  }
  public static void main(String[] args) {
    System.out.println(isTriangleNumber(10));
  }
}
