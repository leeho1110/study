package programmers;

public class Ternary {

	static int solution(int n) {
		
		// 정답을 넣을 변수
		int answer = 0;
		
		String ternary = "";
		
		while(n/3 > 0 ) {
			// 이건 오른쪽부터 더해준다. 마지막에 어차피 뒤집어야 하므로 애초에 뒤집어서 넣는다.
			ternary += Integer.toString(n%3);
			n = n/3;
		}
		// 마지막에 나눠지지 않는 경우 마지막 남은 값을 붙혀준다
 		ternary+=n;
		
     	for(int i=0; i<ternary.length(); i++) {
     		answer += Integer.parseInt(ternary.substring(i, i+1)) * Math.pow(3,ternary.length()-1-i);
     	}
		
		return answer;
	}
	
	public static void main(String[] args) {
		
  		System.out.println(solution(41));
	}
}
