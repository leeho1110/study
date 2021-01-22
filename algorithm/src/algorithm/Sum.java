package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sum {

	static class Solution {
		// https://programmers.co.kr/learn/courses/30/lessons/68644
		public int[] solution(int[] numbers) {

			// 더한 값을 넣어줄 List를 생성
			List<Integer> numList = new ArrayList<Integer>();
			
			// for문을 돌며 하나씩 더해나감
			for (int i = 0; i < numbers.length; i++) {
				for (int j = numbers.length - 1; j >= i + 1; j--) {
					
					// 기존에 있는지 확인
					if (!numList.contains(numbers[i] + numbers[j])) {
						numList.add(numbers[i] + numbers[j]);
					}
				}
			}

			// 여기가 핵심! stream 객체를 통해서 오름차순 정렬 후 mapToInt 메소드를 통해서 값을 그대로 뱉어냄
			int[] answer = numList.stream().sorted().mapToInt(num -> num).toArray(); 
			Stream<Integer> stream = numList.stream();

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] numbers = { 2, 1, 3, 4, 1 };

		int[] answer = s.solution(numbers);
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
