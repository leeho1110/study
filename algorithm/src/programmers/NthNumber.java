package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NthNumber {

	// commands에 든 원소를 하나씩 돌며 array의 i부터 j를 자르고 정렬, 이 후 k번째 수를 가져옴 
	
	static int[] solution(int[] array, int[][] commands) {
        
		// 정답을 넣을 List를 생성
		List<Integer> answerList = new ArrayList<Integer>();
		
		// 2차원 배열에는 i,j,k값이 들어있다. 이값을 추출하여 array에 연산을 한 모음마다 진행해야하므로 for문 탐색
		for(int[] command : commands) {
			// 각 모음에 있는 값들을 copyOfRange를 통해 int[]로 변환, 들어오는 i값에서 1을 빼줘야 알맞는 인덱스
			int[] temp = Arrays.copyOfRange(array, command[0]-1, command[1]);
			// 오름차순으로 정렬
			Arrays.sort(temp);
			// 이전에 생성한 배열에 j번째 값 넣어주기
			answerList.add(temp[command[2]-1]);
		}

		// 값을 정답 배열에 넣어주기
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
