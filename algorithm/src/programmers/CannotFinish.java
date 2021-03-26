package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CannotFinish {
	
	static String solution(String[] participant, String[] completion) {
		
		/* 
		 	�Ϲ� �迭�� ������ �ְ� �����ϴ� ���� �ƴ� �ؽ��� �̿��Ͽ� �޸� �Ҹ� �ִ��� ���̴� ���� �ٽ��̴�. 
		 */
		
		Map<String,Integer> pList = new HashMap<String,Integer>();
		
		// �־��� ���ڿ��� Ž���ϸ� Map�� ���� �־��ش�.
		for(String p : participant) {
			
			// #1. Ű�� ���� ������ ���� ������ 1�� �����ְ� �ƴ϶�� Ű������ �־��� 
//			if(pList.containsKey(p)){
//				pList.replace(p, pList.get(p) + 1);
//			} else {
//				pList.put(p, 0);
//			}
			
			// #2. 1�� getOrDefaulut �޼ҵ带 ���� Ű�� ���ٸ� 0�� �־��ְ� �ִٸ� +1�� ���ִ� ���� ����� ���ٷ� ǥ��
			pList.put(p, pList.getOrDefault(p, 0) + 1);
		}
		
		// ������ ����� ���鼭 ���� 0�� ��� (�������� ����) remove, �ƴ϶�� -1�� �����Ѵ�
		for(String com : completion) {
			if(pList.get(com) == 0) {
				pList.remove(com);
			} else {
				pList.replace(com, pList.get(com)-1);
			}
		}
		
		// ��� ���
		String answer = "";
		for(String a : pList.keySet()) {
			answer = a;
		}
		
		return answer;
		
	}
	
	

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		String answer = solution(participant, completion);
		System.out.println(answer);
		
	}
}
