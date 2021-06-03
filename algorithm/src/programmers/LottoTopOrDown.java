package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTopOrDown {

	static int[] solution(int[] lottos, int[] win_nums) {
		
		int rank = 7;
		int zeroCnt = 0;

		List<Integer> win_nums_list = new ArrayList<Integer>();
		for(int i : win_nums) {
			win_nums_list.add(i);
		}
		
		// 입력받은 번호를 돌며
		for(int i : lottos) {
			if(win_nums_list.contains(i)) {
				rank--;
			} else if (i==0) {
				zeroCnt++;
			} 
		}
		
		if(rank >= 6) {
			rank = 6;
		}
		
		int[] answer = {rank-zeroCnt,rank};
		
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
