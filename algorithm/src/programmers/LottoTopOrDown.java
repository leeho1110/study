package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/77484
public class LottoTopOrDown {

	static int[] solution(int[] lottos, int[] win_nums) {
		
		int match = 0;
		int zero = 0;
		
		 for (int l : lottos) {
	            if (l == 0) zero++;
	            else {
	                for (int w : win_nums) {
	                    if (l == w) {
	                        match++;
	                        break;
	                    }
	                }
	            }
	        }
	        
	        int min = match;
	        int max = match + zero;
	        
	        int[] answer = {Math.min(7 - max, 6), Math.min(7 - min, 6)};
	        return answer;
	}
	
	public static void main(String[] args) {
		// [3, 5]
//		int[] lottos = {44, 1, 0, 0, 31, 25};
//		int[] win_nums = {31, 10, 45, 1, 6, 19};
		
		// [1, 6]
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		// [1, 1]
//		int[] lottos = {45, 4, 35, 20, 3, 9};
//		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		int[] answer = solution(lottos, win_nums);
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
