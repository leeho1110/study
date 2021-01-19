package algorithm;

public class ProgrammerSkillCheck1 {
	
//	함수 solution은 정수 n을 매개변수로 입력받습니다. 
//	n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
//	예를들어 n이 118372면 873211을 리턴하면 됩니다.
	
	static class Solution {
		String a;
	    public long solution(long n) {
	    	
	    	a = "";
	    		
	        String.valueOf(n)										// String.valueOf(n) : long 타입의 정수값을 String으로 변환
	        	.chars()											// chars() 메소드를 통해 String을 각각의 char로 쪼개고
	        	.sorted().											// sorted() 메소드를 통해 오름차순으로 변경한다.
	        	forEach(c -> a = Character.valueOf((char) c) + a);	// 변경된 값을 하나씩 오른쪽부터 붙혀넣으면서 내림차순으로 변경한다.
	        long answer = Long.parseLong(a);
	        return answer;
	        
	        // Stream을 얼마나 잘 사용하는지, 주로 문자열을 어떻게 다루는지에 대해 알 수 있었고 이 외에 추가적인 내용이 있으면 따로 노션으로 추가할 예정
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(8457213));
	}
}
