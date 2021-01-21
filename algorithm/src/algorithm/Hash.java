package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Hash {
	
	static class Solution {
	    public String solution(String[] participant, String[] completion) {
	    	
	        Map<String, Integer> map = new HashMap<>();
	        
	        // Map에 하나씩 넣어준다
	        for(String eachParticipant : participant){	
	        	if(map.getOrDefault(eachParticipant, 0) > 0) {
	        		map.replace(eachParticipant, map.get(eachParticipant)+1);
	        	} else {
	        		map.put(eachParticipant, 1);
	        	}
	        }
	        
	        // Map에 있는지를 비교하며 제거해준다
	        for(String eachString : completion) {
	        	if(map.containsKey(eachString)) {
	        		if(map.get(eachString) > 1) {
	        			map.replace(eachString, map.get(eachString)-1);
	        		} else {
	        			map.remove(eachString);
	        		}
	        	}
	        }
	        
	        String answer = "";
	        for(String key : map.keySet()) {
	        	answer = key;
	        }
	        
	        return answer;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] participant = {"marina","josipa","nikola","vinko","filipa"};
		String[] completion = {"marina","nikola","vinko","filipa"};
		
		String answer = s.solution(participant, completion);
		System.out.println(answer);
		
	}
}
