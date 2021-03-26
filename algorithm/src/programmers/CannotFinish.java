package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CannotFinish {
	
	static String solution(String[] participant, String[] completion) {
		
		/* 
		 	일반 배열에 무작정 넣고 가감하는 것이 아닌 해쉬를 이용하여 메모리 소모를 최대한 줄이는 것이 핵심이다. 
		 */
		
		Map<String,Integer> pList = new HashMap<String,Integer>();
		
		// 주어진 문자열을 탐색하며 Map에 값을 넣어준다.
		for(String p : participant) {
			
			// #1. 키를 갖고 있으면 값을 가져와 1을 더해주고 아니라면 키값으로 넣어줌 
//			if(pList.containsKey(p)){
//				pList.replace(p, pList.get(p) + 1);
//			} else {
//				pList.put(p, 0);
//			}
			
			// #2. 1을 getOrDefaulut 메소드를 통해 키가 없다면 0을 넣어주고 있다면 +1을 해주는 같은 방식을 한줄로 표현
			pList.put(p, pList.getOrDefault(p, 0) + 1);
		}
		
		// 완주자 목록을 돌면서 값이 0인 경우 (동명이인 없음) remove, 아니라면 -1을 진행한다
		for(String com : completion) {
			if(pList.get(com) == 0) {
				pList.remove(com);
			} else {
				pList.replace(com, pList.get(com)-1);
			}
		}
		
		// 결과 출력
		String answer = "";
		for(String a : pList.keySet()) {
			answer = a;
		}
		
		return answer;
		
	}
	
	

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String answer = solution(participant, completion);
		System.out.println(answer);
		
	}
}
