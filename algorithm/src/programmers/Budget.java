package programmers;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12982
public class Budget {

	static int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        
        for(int depart : d) {
        	budget -= depart;
        	if(budget<0) {
        		break;
        	}
        	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] d = {2,2,3,3};
		int budget = 10;
		solution(d, budget);
	}
}
