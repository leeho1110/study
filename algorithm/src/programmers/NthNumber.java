package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthNumber {

	// commands에 든 원소를 하나씩 돌며 array의 i부터 j를 자르고 정렬, 이 후 k번째 수를 가져옴 
	
	static int[] solution(int[] array, int[][] commands) {
        
		List<Integer> answerList = new ArrayList<Integer>();
		
		for(int[] command : commands) {
			int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
			Arrays.sort(temp);
			answerList.add(temp[command[2]-1]);
		}

		int[] answer = new int[answerList.size()];
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = solution(array, commands);
		
		for(int i: answer) {
			System.out.println(i);
		}
	}
}
