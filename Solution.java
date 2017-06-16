import java.util.Arrays;
public class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
      int[] que = new int[n];
      int ans = 0;
      int customerIndex = n;
      int queIndex = 0;
      if (customers.length == 0) {
        return 0;
      }
      int adder = customers[customers.length-n];

      for (int i = 0; i < n; i++) {
        que[i] = customers[i];
      }

      while (customerIndex < customers.length) {
        que[queIndex] -= 1;
        if (que[queIndex] == 0) {
          que[queIndex] = customers[customerIndex];
          customerIndex++;
        }
        if (queIndex == n-1) {
          ans++;
          queIndex = 0;
          continue;
        }
        queIndex++;
      }
      for (int i = customers.length-n+1; i < customers.length; i++) {
        if (customers[i] > adder) {
          adder = customers[i];
        }
      }
      return ans+adder;
    }
    public static void main(String[] args) {
      System.out.println(solveSuperMarketQueue(new int[] {8}, 2));
    }
}
