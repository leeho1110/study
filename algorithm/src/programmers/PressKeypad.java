package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/67256
public class PressKeypad {
	
	// 수직선 위의 두 점 사이의 거리를 구하는 법 : |x1-x2| + |y1-y2|
	// ex (1,2) , (2,2) -> |1-2| + |2-2| -> 1 + 0 = 1
	
	static String solution(int[] numbers, String hand) {
		
		String answer = "";
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i] % 3 == 1) {
				answer += "L";
			} else if(numbers[i] % 3 == 0) {
				answer += "R";
			} else {
				// 현재 키패드의 위치
			}
		}
		
        
        return answer;
    }
	
	public static void main(String[] args) {
		
//		System.out.println(solution(numbers, hand));
	}
}	
