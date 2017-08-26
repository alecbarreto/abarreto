class Persist {

  public static int count = 0;

	public static int persistence(long n) {

    int temp;
    int sum = 1;
    String iter = String.valueOf(n);

    if (String.valueOf(n).length() > 1) {
      count++;
    }
		for (int i = 0; i < iter.length(); i++) {
      temp = (int)n % 10;
      sum *= temp;
      n /= 10;
    }
    if (String.valueOf(sum).length() > 1) {
      persistence((long)sum);
    }
    return count;
    count = 0;
	}

  public static void main(String[] args) {
    System.out.println(persistence(4));
  }
}
