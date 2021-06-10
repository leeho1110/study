package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/72410
public class RecommendNewId {
	
	static String solution(String new_id) {

		// 1.
		String answer = new_id.toLowerCase();
		
		// 2. 
		answer = answer.replaceAll("^a-z0-9-_.", "");
		
		// 3.
		answer = answer.replaceAll("[.]{2,}", ".");
		
		// 4.
		answer = answer.replaceAll("^[.]|[.]$","");
	
		// 5.
		if(answer.length() == 0) {
			answer = "a";
		}
		
		// 6.
		if(answer.length() >= 16) {
			answer = answer.substring(0, 16);
			answer = answer.replaceAll("[.]$", "");
		}
		
		// 7.
		if(answer.length() <= 2)  
            while(answer.length() < 3)
                answer += answer.charAt(answer.length() - 1);
		
        return answer;
    }
	
	public static void main(String[] args) {
		
	}
}
