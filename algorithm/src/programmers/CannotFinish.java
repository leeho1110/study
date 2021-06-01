package programmers;

import java.util.HashMap;
import java.util.Map;

public class CannotFinish {
	
	static String solution(String[] participant, String[] completion) {
		
		Map<String,Integer> pList = new HashMap<String,Integer>();
		
		for(String p : participant) {
			pList.put(p, pList.getOrDefault(p, 0) + 1);
		}
		
		for(String com : completion) {
			if(pList.get(com) == 1) {
				pList.remove(com);
			} else {
				pList.replace(com, pList.get(com)-1);
			}
		}
		
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
