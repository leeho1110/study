package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class PressKeypad {
	
	static String solution(int[] numbers, String hand) {
		
		int leftIndex = 10;	 // '*' => 10으로 치환
		int rightIndex = 12; // '#' => 12로 치환
		
		String answer = "";
		
		for(int number :  numbers) {
			if(number % 3 == 1) {
				answer += "L";
				// 손가락 위치 갱신
				leftIndex = number; 
			} else if(number % 3 == 0) {
				answer += "R";
				// 손가락 위치 갱신
				rightIndex = number;
			} else {
				// 현재 좌우 손가락의 위치와 누르려는 숫자 사이의 거리 구하기 
				int leftLength = getLength(leftIndex, number);
				int rightLength = getLength(rightIndex, number);
				
				// 오른쪽이 더 짧은 경우
				if(leftLength > rightLength) {
					answer += "R";
					// 오른손으로 키패드 누르고 위치 갱신
					rightIndex = number;
				} 
				// 왼쪽이 더 짧은 경우
				else if(leftLength < rightLength) {
					answer += "L";
					// 왼손으로 키패드 누르고 위치 갱신
					leftIndex = number;
				} else {
					// 둘의 거리가 같다면 손잡이에 따라 갱신
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

		// 좌우측(1,2,4,6,7,9,*(10),#(12) 의 경우 1을 뺀 뒤 3으로 나눈 값이 x, 3으로 나머지 한 값이 y 좌표
		int x = (index - 1) / 3;
		int y = (index - 1) % 3;
		
		// 가운데 부분의 x값은 3으로 나눈 값이 x 좌표, y 좌표는 1로 고정
		int numberX = number / 3;
		int numberY = 1;

		// 두 수직선 사이의 값을 구하는 공식은 |x1-x2| + |y1-y2|
		return Math.abs(x-numberX) + Math.abs(y-numberY);
	}
	
	public static void main(String[] args) {
		
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}
}	
