import java.util.Arrays;

public class DataReverse {
  public static int[] DataReverse(int[] data) {
    int count = 8;
    int ind = 0;
    int[] fin = new int[data.length];
    for (int i = data.length-count; i < (data.length-count)+8; i++) {
      fin[ind] = data[i];
      ind++;
      if (i == (data.length-count)+7 && i != 7) {
        count += 8;
        i = data.length-count-1;
      }
      else if (i == 7) {
        break;
      }
    }
    return fin;
  }
  public static void main (String[] args) {
    int[] arr = {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
    System.out.println(Arrays.toString(DataReverse(arr)));
  }
}
