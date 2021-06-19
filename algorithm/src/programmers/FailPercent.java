package programmers;

import java.util.HashMap;
import java.util.Map;

public class FailPercent {
	
	static int[] solution(int N, int[] stages) {
		int[] answer = {};
		
		Map<Integer, Integer> numOfChallenger = new HashMap<Integer, Integer>();
		
		// 1. 스테이지별 도전한 사람의 수 
		for(int stage : stages) {
			for(int i=1; i<=stage; i++) {
				numOfChallenger.put(i, numOfChallenger.getOrDefault(i, 0) + 1);
			}
			
		}
		
		System.out.println("chall");
		System.out.println(numOfChallenger);
		
        return answer;
	}

	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		solution(N, stages);
	}
}
