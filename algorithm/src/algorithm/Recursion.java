package algorithm;

public class Recursion {

	public int factorial(int i) {
		if (i == 1) {
			System.out.println();
			return 1;
		} else {
			return i * factorial(i - 1);
		}
	}

	public static void main(String[] args) {
		Recursion recursion = new Recursion();
		int total = recursion.factorial(3);
		System.out.println(total);
	}
}
