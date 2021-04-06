package programmers;

public class Ternary {

	static int solution(int n) {
		
		int answer = 0;
		
		String ternary = "";
		
		while(n/3 > 0 ) {
			// 이건 오른쪽부터 더해진다, 이걸 왼쪽으로 더할수있도록
			ternary += Integer.toString(n%3);
			n = n/3;
			
			// 마지막 최종의 단계에서 3으로 나눠지지 않는 경우에서는 당시의 몫과 나머지를 연속으로 넣어야하는데 이걸 어떻게 해야하나
			if(n/3 < 3) {
				ternary += 1;
			}
		}
		System.out.println(n);
		
		return answer;
	}
	
	public static void main(String[] args) {
		
		solution(28);
	}
}
