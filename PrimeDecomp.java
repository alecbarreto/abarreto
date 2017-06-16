public class PrimeDecomp {

  public static boolean isPrime(int n) {
    if (n % 2 == 0) return false;
    for (int i = 3; i * i <= n; i += 2) {
        if (n % i == 0)
            return false;
    }
    return true;
  }
  public static String factors(int n) {
    String answer = "";
    for (int i = n-1; i >= 2; i--) {
      if (isPrime(i) && n % i == 0) {
        answer += "(" + String.valueOf(i) + "*" + String.valueOf(n/i) + ")";
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    System.out.println(factors(86240));
  }
}
