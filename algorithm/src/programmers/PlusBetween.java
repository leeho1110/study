package programmers;

public class PlusBetween {

	static int solution(int n1, int n2) {
		
		int big = 0;
		int small = 0;
		int answer = 0;
		
		if(n1 >= n2) {
			big = n1;
			small = n2; 
		} else {
			big = n2;
			small = n1;
		}
		
		for(int i=small; i<=big; i++) {
			answer += i;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(3, 5));
		System.out.println(solution(5, 3));
		System.out.println(solution(3, 3));
		System.out.println(solution(1, 7));
		System.out.println(solution(7, 1));
	}
}
