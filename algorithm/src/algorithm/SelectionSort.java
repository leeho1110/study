package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

	public SelectionSort() {
	}
	
	/*
	 	선택 정렬
	 	
	 	전체 리스트 중 첫번째 요소를 선택, 나머지 요소를 비교하며 최솟값을 찾는다.
	 	최솟값을 찾으면 해당 요소를 배열의 첫번째 위치에 놓는다.
	 	완료되면 두번째 요소를 선택, 나머지 요소와 비교하며 최솟값을 찾고 해당 요소를 두번째 위치에 놓는다.
	 	
	 	이를 마지막 요소 전까지 반복한다.
	  
	 
	 */
	public void searchMin(int[] numList) {
	
		// 최솟값 선언
		int smallest = numList[0];
		
		// 전체 탐색
		for(int i=0; i<numList.length-2; i++) {
			// 최솟값의 인덱스를 저장하기 위한 변수
			int changed = 0;
			// 선택 정렬의 요소를 고민해놓고 나머지 요소들을 탐색
			for(int j=i+1; j<numList.length-1; j++) {
				// 만약 탐색하는 요소가 최솟값보다 작다면 최솟값을 해당 값으로 변경
				if(numList[j] < smallest) {
					// 변경한 인덱스를 저장
					smallest = numList[j];
					changed = j;
				}
			}
			// 기준 요소의 값을 바꿔치기
			int temp = numList[i];
			numList[i] = smallest;
			numList[changed] = temp;
		}
		
		for(int num: numList) {
			System.out.println(num);
		}
	}
	
	 
	public static void main(String[] args) {
		
		int[] numList = {5,2,1,3,4};
		
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.searchMin(numList);
		
	}
}
