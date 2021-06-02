package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoTopOrDown {

	static int[] solution(int[] lottos, int[] win_nums) {
		
		int rank = 6;
		int[] answer = {};

		List<Integer> win_nums_list = new ArrayList<Integer>();
		for(int i : win_nums) {
			win_nums_list.add(i);
		}
		
		for(int i : lottos) {
			if(win_nums_list.contains(i) && i != 0) {
				rank--;
			} else {
				
			}
		}
		
        return answer;
	}
	
	public static void main(String[] args) {
		
	}
}
