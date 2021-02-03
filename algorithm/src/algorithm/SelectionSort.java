package algorithm;

import java.awt.image.SampleModel;
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
	
	
	public int[] selectionSort(int[] numList) {
		
		// 전체 탐색  
		for(int i=0; i<numList.length-1; i++) {
			// 내부 탐색
			for(int j=i+1; j<numList.length; j++) {
				// 최솟값은 i번째 요소 -> 계속헤서 비교해야할 대상
				int smallest = numList[i];
				// 값 비교
				if(smallest > numList[j]) {
					// 교체
					int temp = numList[j];
					numList[j] = smallest;
					numList[i] = temp;
				}
			}
		}
		
		return numList;
	
	 
	}
	
	public List<Integer> selectionSortByLinkedList(List<Integer> numList) {
		
		// 전체 탐색  
		for(int i=0; i<numList.size()-1; i++) {
			// 내부 탐색
			for(int j=i+1; j<numList.size(); j++) {
				// 최솟값은 i번째 요소 -> 계속헤서 비교해야할 대상
				int smallest = numList.get(i);
				// 값 비교
				if(smallest > numList.get(j)) {
					// 교체
					int temp = numList.get(j);
				}
			}
		}
		
		return numList;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		int[] numList = {5,7,1,3,2,4,8,6,9};
		SelectionSort selectionSort = new SelectionSort();
		int[] sortedList = selectionSort.selectionSort(numList);
		
		for(int num : sortedList) {
			System.out.println(num);
		}
		
	}
}
