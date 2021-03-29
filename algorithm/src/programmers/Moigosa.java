package programmers;

public class Moigosa {

	static int solution(int[] answers) {
		
		int[] supo1 = {1,2,3,4,5};
		int[] supo2 = {2,1,2,3,2,4,2,5};
		int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
		
		int cnt=0;
		
		int cnt1 = getAnswerCnt(supo1,answers);
		int cnt2 = getAnswerCnt(supo2,answers);
		int cnt3 = getAnswerCnt(supo3,answers);
		
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
		
		return cnt;
		
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
		
		System.out.println(solution(answers));
	}
}
