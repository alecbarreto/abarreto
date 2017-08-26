import java.lang.*;
import java.io.*;
import java.util.*;

public class Tower {

	public static long findNb(long m) {
		int n = 1;
		int sum = 0;

		while (sum < m) {
			sum += Math.pow(n,3);

			if (sum == m) {
				break;
			}
			else if (sum > m) {
				n = -1;
				break;
			}
			n++;
		}
		return n;
	}
	public static void main(String[] args) {

		System.out.println(findNb(984390625L));

	}
}
