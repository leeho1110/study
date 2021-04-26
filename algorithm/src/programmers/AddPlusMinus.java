package programmers;

public class AddPlusMinus {

	static int solution(int[] absolutes, boolean[] signs) {
		
		int answer = 0;
		
		for(int i=0; i<absolutes.length; i++) {
			answer += signs[i] ? absolutes[i] : -absolutes[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] absolutes = {4,1,4,2,3};
		boolean[] signs = {true, false, false, true, false};
		
		System.out.println(solution(absolutes, signs));
	}
}
