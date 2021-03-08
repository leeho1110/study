package algorithm;

import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.LinkedList;
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
			int smallest = numList[i];
			int idx = i;
			
			for(int j=i+1; j<numList.length; j++) {
				if( smallest > numList[j] ) {
					smallest = numList[j];
					idx = j;
				}
			}
			
			int temp = numList[i];
			numList[i] = smallest;
			numList[idx] = temp;
		}

		
		return numList;
	
	 
	}
	
	public List<Integer> selectionSortByLinkedList(List<Integer> numList) {
		
		// 전체 탐색  
		for(int i=0; i<numList.size()-1; i++) {
			for(int j=i+1; j<numList.size(); j++) {
				int smallest = numList.get(i);
				if(smallest > numList.get(j)) {
					int temp = smallest;
					numList.set(i, numList.get(j));
					numList.set(j,temp);
				}
			}
		}
		
		
		return numList;
	}
	
	
	
	public static void main(String[] args) {
		
		// int[] 리스트의 경우
		int[] numList = {5,7,1,3,2,4,8,6,9};
		SelectionSort selectionSort = new SelectionSort();
		int[] sortedList = selectionSort.selectionSort(numList);
		
		for(int num : sortedList) {
			System.out.println(num);
		}
		
		// 데이터의 삽입 및 삭제에서 장점이 있는 LinkedList
//		List<Integer> numLinkedList = new LinkedList<Integer>();
//		numLinkedList.add(5);
//		numLinkedList.add(7);
//		numLinkedList.add(1);
//		numLinkedList.add(3);
//		numLinkedList.add(2);
//		numLinkedList.add(4);
//		numLinkedList.add(8);
//		numLinkedList.add(6);
//		numLinkedList.add(9);
//		
//		List<Integer> sortedLinkedList = selectionSort.selectionSortByLinkedList(numLinkedList);
//		for(int num : sortedLinkedList) {
//			System.out.println(num);
//		}
		
	}
}
