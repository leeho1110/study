package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HateSameNumber {

	static int[] solution(int[] arr) {
		
		List<Integer> answerList = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			// 배열의 마지막 수인 경우 다음과 비교 불가, 전 자리의 수와 비교해야함
			if(i == arr.length-1) {
				answerList.add(arr[i]);
			} 
			// 마지막 전까지는 다음 수가 변경된다면 넣는다
			else {
				if(arr[i] != arr[i+1]) {
					answerList.add(arr[i]);
				}
			}
		}
		
		int[] answer = new int[answerList.size()];
		for(int i=0; i<answerList.size(); i++) {
			answer[i] = answerList.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1,1,1,1,5,2,2,2,3,0,7,7,7,8,8};
		for(int num : solution(arr)){
			System.out.print(num + " ");
		};
	}
}
