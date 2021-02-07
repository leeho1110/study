package algorithm;

public class QuickSort {
	// https://www.youtube.com/watch?v=7BDzle2n47c
	
	// 최초 quickSort 재귀함수 시작점
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}
	
	// 재귀로 호출되는 부분
	private static void quickSort(int[] arr, int start, int end) {
		
		int part2 = partition(arr, start ,end); // 왼쪽 오른쪽으로 갈랐을 때 오른쪽의 첫번째 방
		
		/*    	   0       1      2        3
		   1 : | start | data | part2 | data | : 이 경우는 start,data / part2, data 각각 quicksort 호출
		   2 : | start | part2 | data | data | : start 하나밖에 없기 때문에 quicksort 호출되면 안됨
		 
		 따라서 1번의 경우 처럼 part2가 1개 이상 start에서 떨어져 있을 때에만 (start < part2-1) quicksort가 호출되여야함
		 */
		
		// 왼쪽 partition이 1개 이상
		if(start < part2 - 1) {
			quickSort(arr, start, part2 -1);
		}
		
		// 오른쪽 partition이 1개 이상
		if(part2 < end) {
			quickSort(arr,part2, end);
		}
	}

	// 리스트를 pivot을 중심으로 왼쪽, 오른쪽을 나누는 함수
	private static int partition(int[] arr, int start, int end) {
		// 가운데 pivot 지정
		int pivot = arr[(start + end) /2];
		// end 포인터가 start 포인터보다 작거나 같을때까지, 즉 엇갈릴 때까지
		while (start <= end) {
			
			// 여기서 start, end 포인터의 역할이 헷갈릴 수 있는데 쉽게 생각하면 오른쪽으로는 큰게 넘어가야하고, 왼쪽으로는 작은게 넘어가야한다. 
			// start 포인터는 오른쪽으로 넘길 자기보다 큰 값이 나올때까지 전진하는 것(작으면 전진)
			// end 포인터는 왼쪽으로 넘길 자기보다 작거나 같은 값이 나올때까지 전진하는 것(크면 전진). 
			
			// start가 먼저 움직임 만약 pivot값보다 값이 작으면 계속 앞으로 전진, 만약 값이 같거나 크면 정지
			while(arr[start] < pivot) start++;
			// start 포인터 정지된 이후 end 포인터는 pivot값이 크면 
			while(arr[end] > pivot) end--;
			
			// end 포인터와 start 포인이터가 지나쳤는지?
			if(start <= end) {
				// 둘의 값을 swap하고 start, end 포인터를 각자의 방향으로 한칸씩 전진
				swap(arr,start,end);
				start++;
				end--;
			}
		}
		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}
	
	private static void printArray(int[] arr) {
		for(int data : arr) {
			System.out.print(data + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		printArray(arr);
		quickSort(arr);
		printArray(arr);
		
	}
}
