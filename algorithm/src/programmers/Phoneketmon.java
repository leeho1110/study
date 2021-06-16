package programmers;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/1845
public class Phoneketmon {

	static int solution(int[] nums) {
		
		Map<Integer, Integer> poketMonSpecies = new HashMap<Integer, Integer>(); 
		
		for(int num : nums) {
			poketMonSpecies.put(num, poketMonSpecies.getOrDefault(num, 0) + 1);
		}
		
		int answer = nums.length/2 >= poketMonSpecies.keySet().size() ? poketMonSpecies.keySet().size() : nums.length/2;  
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] nums = {3,1,2,3};
		System.out.println(solution(nums));
 	}
}
