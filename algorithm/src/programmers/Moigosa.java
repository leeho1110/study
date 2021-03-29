package programmers;

import java.util.Arrays;

public class Moigosa {

	static int[] solution(int[] answers) {
		
		int[] supo1 = {1,2,3,4,5};
		int[] supo2 = {2,1,2,3,2,4,2,5};
		int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
		
		int cnt=0;
		
		
		int[] answer = {getAnswerCnt(supo1,answers), getAnswerCnt(supo2,answers), getAnswerCnt(supo3,answers)};
		Arrays.sort(answer);
		
		return answer;
		
	}
	
	private static int getAnswerCnt(int[] supoList, int[] answers) {
		int cnt = 0;
		for(int idx=0; idx<answers.length; idx++) {
			if(answers[idx] == supoList[idx%supoList.length]) {
				cnt++;
			}
		}
		
		return cnt;
		
	}

	public static void main(String[] args) {
		
		int[] answers = {1,1,2,3,1,4,1,2,3,4,5};
		
		for(int a : solution(answers)) {
			System.out.print(a + " ");
		}
	}
}
