package algorithm;

public class ProgrammerSkillCheck1 {
	
//	�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. 
//	n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���.
//	������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.
	
	static class Solution {
		String a;
	    public long solution(long n) {
	    	
	    	a = "";
	    		
	        String.valueOf(n)										// String.valueOf(n) : long Ÿ���� �������� String���� ��ȯ
	        	.chars()											// chars() �޼ҵ带 ���� String�� ������ char�� �ɰ���
	        	.sorted().											// sorted() �޼ҵ带 ���� ������������ �����Ѵ�.
	        	forEach(c -> a = Character.valueOf((char) c) + a);	// ����� ���� �ϳ��� �����ʺ��� ���������鼭 ������������ �����Ѵ�.
	        long answer = Long.parseLong(a);
	        return answer;
	        
	        // Stream�� �󸶳� �� ����ϴ���, �ַ� ���ڿ��� ��� �ٷ������ ���� �� �� �־��� �� �ܿ� �߰����� ������ ������ ���� ������� �߰��� ����
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(8457213));
	}
}
