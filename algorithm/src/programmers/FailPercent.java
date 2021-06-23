package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FailPercent {
	
	static int[] solution(int N, int[] stages) {
		
		Map<Integer, Integer> challange = new HashMap<Integer, Integer>();
		Map<Integer, Integer> success = new HashMap<Integer, Integer>();
		
		// 1. 멈춰있는 스테이지를 확인
		for(int stop : stages) {
			if(stop < N+1) {
				setStagePer(stop,challange,success);
			} else {
				// 만약 모두 통과라면 진행자, 성공자 +1
				addAll(stop,challange,success);
			}
		}
		
		Map<Integer,Float> answerList = new TreeMap<Integer,Float>();
		for(int i=1; i<=N; i++) {
			answerList.put(i,1-(success.get(i)/(float)challange.get(i)));
		}
		
		int[] answer = new int[N];
		for(int i=1; i<=N; i++) {
            float max = -1;
            int maxKey = 0;
            for(Integer key : answerList.keySet()) {
                if(max < answerList.get(key)) {
                    max = answerList.get(key);
                    maxKey = key;
                }
            }
            answer[i-1] = maxKey;
            answerList.remove(maxKey);
        }
		
        return answer;
	}

	private static void addAll(int stop, Map<Integer, Integer> challange, Map<Integer, Integer> success) {
		for(int i=1; i<=stop-1; i++) {
			challange.put(i, challange.getOrDefault(i, 0) + 1);
			success.put(i, success.getOrDefault(i, 0) + 1);
		}
	}

	private static void setStagePer(int stop, Map<Integer, Integer> challange, Map<Integer, Integer> success) {
		for(int i=1; i<=stop; i++) {
			// 이와 동시에 진행한 것이기도 하니 이전 스테이지의 도전자 수 +1
			challange.put(i, challange.getOrDefault(i, 0) + 1);
			// 멈춰있는 스테이지 전까지의 스테이지들은 통과한 것이니 이전 스테이지의 클리어 수 +1
			if(i-1 != 0) {
				success.put(i-1, success.getOrDefault(i-1, 0) + 1);
			}
		}
	}
                                                                                                                                                                                                                                            
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int N = 4;
//		int[] stages = {4,4,4,4,4};
		solution(N, stages);
		
		
	}
}
