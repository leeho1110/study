package programmers;

public class DotProduct {

	static int solution(int[] a, int[] b) {
		
		int answer = 0;
		for(int i=0; i<a.length; i++) {
			answer += a[i] * b[i];
		}
		
		return answer;
	} 
	
	public static void main(String[] args) {
		
		// test1 
		int[] t1_1 = {1,2,3,4};
		int[] t1_2 = {-3,-1,0,2};
		
		// test2
		int[] t2_1 = {-1,0,1};
		int[] t2_2 = {1,0,-1};		
		
		int answer1 = solution(t1_1, t1_2);
		System.out.println(answer1);
		
		int answer2 = solution(t2_1, t2_2);
		System.out.println(answer2);
	}
}
