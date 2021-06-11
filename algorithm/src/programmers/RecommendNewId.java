package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/72410
public class RecommendNewId {
	
	static String solution(String new_id) {
		
//		�ܰ� new_id�� ��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ�մϴ�.
//		2�ܰ� new_id���� ���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� �����մϴ�.
//		3�ܰ� new_id���� ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ�մϴ�.
//		4�ܰ� new_id���� ��ħǥ(.)�� ó���̳� ���� ��ġ�Ѵٸ� �����մϴ�.
//		5�ܰ� new_id�� �� ���ڿ��̶��, new_id�� "a"�� �����մϴ�.
//		6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� �����մϴ�.
//		     ���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� �����մϴ�.
//		7�ܰ� new_id�� ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ��ؼ� ���� ���Դϴ�.

		// 1.
		String answer = new_id.toLowerCase();
		
		// 2.
		answer = answer.replaceAll("[^a-z0-9-_.]", "");
		
		// 3.
		answer = answer.replaceAll("[.]{2,}", ".");
		
		// 4.
		answer = answer.replaceAll("^[.]|[.]$", "");
		
		// 5.
		if(answer.length() == 0){
			answer = "a";
		}
		
		// 6.
		if(answer.length() >= 16){
			answer = answer.substring(0,15);
			answer = answer.replaceAll("[.]$", "");
		}
		
		// 7. 
		if(answer.length() <= 2){
			String plus = answer.substring(answer.length()-1, answer.length()); 
			while(answer.length() < 3){
				answer += plus;
			}
		}
		
		return answer;
    }
	
	public static void main(String[] args) {
		
		String new_id = "...!@BaT#*..y.abcdefghijklm";
		
		System.out.println(solution(new_id));
	}
}
