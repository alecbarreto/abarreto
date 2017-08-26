public class Reverse {

	public static String reverse(String str) {
		if (str == "") {
			return "";
		}
		else if (str.length()-1 == 0) {
			String fin = "";
			fin += str.charAt(0);
			return fin;
		}
		else {
			return str.charAt(str.length()-1) + reverse(str.substring(0,str.length()-1));
		}
  }
	public static void main(String[] args) {
		System.out.println(reverse("abc"));
	}
}
