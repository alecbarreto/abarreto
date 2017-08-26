public class Groups {

	public static boolean groupCheck(String s){

		boolean ans = true;

		for (int i = 0; i < s.length(); i++) {
			if (ans == false) {
				break;
			}
			if (s.charAt(i) == '(') {
				for (int j = s.length()-1; j > i; j--) {
					if (ans == false) {
						break;
					}
					if (s.charAt(j) == ')') {
						if ((j-i) % 2 != 0) {
							s = s.replace('(',' ');
							s = s.replace(')',' ');
							break;
						}
						else {
							ans = false;
							break;
						}
					}
					else if (j == i+1 && s.charAt(j) != ')') {
						ans = false;
						break;
					}
				}
			}
			else if (s.charAt(i) == ')') {
				ans = false;
				break;
			}
			else if (s.charAt(i) == '[') {
				for (int j = s.length()-1; j > i; j--) {
					if (ans == false) {
						break;
					}
					if (s.charAt(j) == ']') {
						if ((j-i) % 2 != 0) {
							s = s.replace('[',' ');
							s = s.replace(']',' ');
							break;
						}
						else {
							ans = false;
							break;
						}
					}
					else if (j == i+1 && s.charAt(j) != ']') {
						ans = false;
						break;
					}
				}
			}
			else if (s.charAt(i) == ']') {
				ans = false;
				break;
			}
			else if (s.charAt(i) == '{') {
				for (int j = s.length()-1; j > i; j--) {
					if (ans == false) {
						break;
					}
					if (s.charAt(j) == '}') {
						if ((j-i) % 2 != 0) {
							s = s.replace('{',' ');
							s = s.replace('}',' ');
							break;
						}
						else {
							ans = false;
							break;
						}
					}
					else if (j == i+1 && s.charAt(j) != '}') {
						ans = false;
						break;
					}
				}
			}
			else if (s.charAt(i) == '}') {
				ans = false;
				break;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(groupCheck("[({}){}]"));
	}
}
