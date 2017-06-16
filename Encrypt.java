import java.util.*;
import java.lang.*;

public class encrypt {

  public static String encrypt(final String text, final int n) {

		String ans = "";
		String temp = text;

		if (n <= 0) {
			return text;
		}
    else if (text == "") {
      return text;
    }
    else if (text == null) {
      return null;
    }
		else {

			for (int i = 0; i < n; i++) {
				for (int j = 1; j < text.length(); j += 2) {
					ans += temp.charAt(j);
				}
				for (int k = 0; k < text.length(); k += 2) {
					ans += temp.charAt(k);
				}
				temp = ans;
				if (i != n-1) {
					ans = "";
				}
			}
	    return ans;
		}
  }

  public static String decrypt(final String encryptedText, final int n) {

    String ans = "";
		String temp = encryptedText;
    int count = 0;

		if (n <= 0) {
			return encryptedText;
		}
    else if (encryptedText == "") {
      return encryptedText;
    }
    else if (encryptedText == null) {
      return encryptedText;
    }
		else {
			for (int i = 0; i < n; i++) {
        if (temp.length() % 2 != 0) {
          for (int j = 0; j <= ((temp.length()-1)/2); j++) {
  					ans += temp.charAt((temp.length()-1)/2 + count);
            count++;
            if (j == ((temp.length()-1)/2)) {
              break;
            }
            ans += temp.charAt(j);
  				}
        }
        else {
          for (int j = 0; j < (temp.length()/2); j++) {
  					ans += temp.charAt(temp.length()/2 + count);
            count++;
            if (j == (temp.length()/2)) {
              break;
            }
            ans += temp.charAt(j);
  				}
        }
        temp = ans;
				if (i != n-1) {
					ans = "";
				}
        count = 0;
			}
	    return ans;
		}
  }
  public static void main(String[] args) {
    System.out.println(encrypt("hello world",1));
  }
}
