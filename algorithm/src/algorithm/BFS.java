package algorithm;

import java.util.LinkedList;

public class BFS {

	/*
	 	Breadth First Search (넓이 우선 탐색)
	 	
	 	To-do : 나의 이웃 중 망고 장수를 찾기
	 	
	 	나의 이웃 중 망고 장수를 찾고 만약 없다면 이웃의 이웃에서 다시 찾기! 찾을 때까지 반복한다

	 	사용 자료구조는 큐(First-in First-Out)
	 	
	   0
	  /
	 1 - 3     
	 | / | \  
	 2 - 4  5 - 7
	 		 \ 6 - 8
	 							   7
	 |   |  |   |  |   |  | 5 |  | 6 |  | 6 |  | 8 |  |   |  |   |  |   |
	 |   |  |   |  | 3 |  | 4 |  | 4 |  | 4 |  | 4 |  | 4 |  |   |  |   |
	 |_0_|  |_1_|  |_2_|  |_2_|  |_2_|  |_2_|  |_2_|  |_2_|  |_2_|  |_ _|
	 
	   0  ->  1  ->  3  ->  5  ->  7  ->  6  ->  8  ->  4  ->  2
	   
	 */
	public static void search(LinkedList<String> personList) {
		
	}
	
	
}
