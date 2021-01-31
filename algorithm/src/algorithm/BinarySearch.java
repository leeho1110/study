package algorithm;

import java.util.Arrays;

public class BinarySearch {

	public BinarySearch() {
		/*
		 * 
		 * 이진 탐색
		 * 
		 * x의 크기를 가진 배열이 존재할 때 특정 수의 위치를 찾는 알고리즘. 전체 크기에서 가운데 지점과 찾고자 하는 수를 비교하며 원하는 수의
		 * 위치를 찾아간다.
		 * 
		 * ex) 답은 4이고, 1~10사이에서 4를 찾고 싶을때
		 * 
		 * 1~9의 중간은 5, 5와 4를 비교 5과 4보다 크므로 범위는 1~5로 변경 1~5의 중간은 3, 3과 4를 비교 3은 4보다 작으므로
		 * 범위는 3~5로 변경 3~5의 중간은 4, 답과 일치
		 * 
		 * 
		 */
	}

	public int search(int item, int[] numList) {

		Arrays.sort(numList);

		int guess = 0;
		int low = 0;
		int high = numList.length - 1;
		int mid = 0;

		while (low <= high) {
			
			mid = ((low + high) / 2);
			guess = numList[mid];
			if (guess == item) {
				return mid;
			}
			
			if (numList[mid] > item) {
				high = mid;
			} else {
				low = mid;
			}
		}

		return mid;
	}

	public static void main(String[] args) {

		int[] numList = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int item = 4;

		BinarySearch bs = new BinarySearch();

		int answerIdx = bs.search(item, numList);
		System.out.printf("idx: %d, answer: %d",answerIdx, numList[answerIdx]);
	}
}
