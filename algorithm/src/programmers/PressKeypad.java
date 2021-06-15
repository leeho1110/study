package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class PressKeypad {
	
	// 수직선 위의 두 점 사이의 거리를 구하는 법 : |x1-x2| + |y1-y2|
	// ex (1,2) , (2,2) -> |1-2| + |2-2| -> 1 + 0 = 1
	
	static String solution(int[] numbers, String hand) {
		
		int leftIndex = 10;	 // '*' => 10으로 치환
		int rightIndex = 12; // '#' => 12로 치환
		
		String answer = "";
		for(int number :  numbers) {
			if(number % 3 == 1) {
				answer += "L";
			} else if(number % 3 == 0) {
				answer += "R";
			} else {
				// 현재 키패드의 위치
				int leftLength = getLength(leftIndex, number);
				int rightLength = getLength(rightIndex, number);
				
				if(leftLength > rightLength) {
					answer += "R";
					rightIndex = number;
				} else if(leftLength < rightLength) {
					answer += "L";
					leftIndex = number;
				} else {
					if(hand.equals("right")) {
						answer += "R";
						rightIndex = number;
					} else {
						answer += "L";
						leftIndex = number;
					}
				}
			}
		}
		
        
        return answer;
    }
	
	public static int getLength(int index, int number) {

		// 숫자 0의 경우 11로 치환
		index = (index == 0) ? 11 : index;	
		number = (number == 0) ? 11 : number;

		int x = (index - 1) / 3;
		int y = (index - 1) % 3;
		int numberX = number / 3;
		int numberY = 1;

		return Math.abs(x-numberX) + Math.abs(y-numberY);
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}
}	
