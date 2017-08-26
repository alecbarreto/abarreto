public class AreSame {

	public static boolean comp(int[] a, int[] b) {

		boolean ans = false;

		if (a == null || b == null) {
			ans = false;
		}
    else if (a.length == 0 || b.length == 0) {
      ans = true;
    }
		else {
	    for (int i = 0; i < a.length; i++) {
				if (ans == true) {
					break;
				}
				for (int j = 0; j < b.length; j++) {
					if (Math.pow(a[i],2) == b[j]) {
						if (i == a.length-1) {
							ans = true;
							break;
						}
					}
					else if (j == b.length-1 && Math.pow(a[i],2) != b[j]) {
						ans = false;
						break;
					}
				}
			}
		}
		return ans;
  }

	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = {9,1,4};
		System.out.println(comp(a,b));
	}
}
