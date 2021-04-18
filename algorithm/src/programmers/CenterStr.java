package programmers;

public class CenterStr {

	static String solution(String str) {
		
		String answer = "";
        
        //짝수와 홀수인 경우로 나누어서 정리한다! 짝수면 2글자가 나오고 홀수면 1글자가 나올 것이다.
        if(str.length()%2==0) {
            answer = str.substring(str.length()/2-1, str.length()/2+1);
        } else {
            answer = str.substring(str.length()/2,str.length()/2+1);
        }
        
        return answer;
	}
	
static String solution2(String str) {
		
        // 3항 연산자를 사용하여 짝수인 경우와 홀수인 경우를 조금 더 쉽게. 물론 가독성은 떨어진다.
        return str.length()%2==0 ? str.substring(str.length()/2-1, str.length()/2+1) : str.substring(str.length()/2,str.length()/2+1);
	}
	
	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution2("abcde"));
	}
}
