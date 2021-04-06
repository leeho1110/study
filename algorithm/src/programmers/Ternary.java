package programmers;

public class Ternary {

	static int solution(int n) {
		
		int answer = 0;
		
		String ternary = "";
		
		while(n/3 > 0 ) {
			ternary += Integer.toString(n%3);
			n = n/3;
		}
		System.out.println(n);
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		solution(28);
	}
}
