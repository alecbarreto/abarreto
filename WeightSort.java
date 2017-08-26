public class WeightSort {

	public static String orderWeight(String strng) {
		String[] iter = strng.split("\\s+");
    int[][] weights = new int[iter.length][2];
    int temp = 0;
    int count = 0;
    int[] fin = new int[iter.length];
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < iter.length; i++) {
      for (int j = 0; j < iter[i].length(); j++) {
        temp += Character.getNumericValue(iter[i].charAt(j));
      }
      weights[count][0] = Integer.valueOf(iter[i]);
      weights[count][1] = temp;
      count++;
      temp = 0;
    }
    for (int i = 0; i < weights.length; i++) {
      for (int j = 0; j < weights.length; j++) {
        if (i == j) {
          continue;
        }
        else if (weights[i][1] > weights[j][1]) {
          temp++;
        }
        else if (weights[i][1] == weights[j][1] && Integer.toString(weights[i][0]).charAt(0) > (Integer.toString(weights[j][0]).charAt(0))) {
          temp++;
        }
      }
      fin[temp] = weights[i][0];
      temp = 0;
    }
    for (int i = 0; i < fin.length; i++) {
      builder.append(Integer.toString(fin[i]));
      if (i != fin.length - 1) {
        builder.append(" ");
      }
    }
    return builder.toString();
	}

  public static void main(String[] args) {
    System.out.println(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
  }
}
