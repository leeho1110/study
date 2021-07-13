package programmers;

import java.util.ArrayList;
import java.util.List;

public class Moigosa {

	// Test Case 50% 
	static int[] solution(int[] answers) {

		// 총 3명의 수포자가 존재하며 각 수포자는 아래의 배열처럼 정답을 찍는다.
		int[] supo1 = {1,2,3,4,5};
		int[] supo2 = {2,1,2,3,2,4,2,5};
		int[] supo3 = {3,3,1,1,2,2,4,4,5,5};

		// 정답 배열에는 수포 리스트에서  정답을 맞춘 갯수를 추출하는 getAnswerCnt 를 각 수포자마다 돌림
		int[] supoAnswer = {getAnswerCnt(supo1,answers), getAnswerCnt(supo2,answers), getAnswerCnt(supo3,answers)};
		// 정답 값을 정렬 후 반환
		for(int supo : supoAnswer) {
			System.out.print(supo + " ");
		}
		System.out.println();
		int largest = -1;
		List<Integer> idxList = new ArrayList<Integer>();

		for(int i=0; i<supoAnswer.length; i++) {
			int answer = supoAnswer[i];
			if(answer >= largest) {
				largest = answer;
				idxList.add(i+1);
			} 
		}

		int[] answerList = new int[idxList.size()];
		int idx = 0;
		for(int supo : idxList) {
			answerList[idx] = supo;
			idx++;
		}


		return answerList;
	}

	// 들어온 리스트와 answer를 비교
	private static int getAnswerCnt(int[] supoList, int[] answers) {
		int cnt = 0;

		// 들어온 정답의 갯수만큼 탐색하고 수포 배열의 길이를 나머지 연산으로 구해 인덱스를 일치시킴  
		// ex) supoList의 개수가 총 5개라면 0%5=0, 1%5=1, ... 5%5=0, 6%5=1, 7%5=2 이렇게 계속 supoList를 반복
		for(int idx=0; idx<answers.length; idx++) {
			if(answers[idx] == supoList[idx%supoList.length]) {
				cnt++;
			}
		}

		return cnt; 

	}

	// Test Case 100%
	static int[] solution2(int[] answer) {
		
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] score = new int[3];
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == a[i%a.length]) {score[0]++;}
			if(answer[i] == b[i%b.length]) {score[1]++;}
			if(answer[i] == c[i%c.length]) {score[2]++;}
		}
		
		int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
		
		ArrayList<Integer> list = new ArrayList<>();
		
		if(maxScore == score[0]) {list.add(1);}
		if(maxScore == score[1]) {list.add(2);}
		if(maxScore == score[2]) {list.add(3);}
		
		
		return list.stream().mapToInt(i->i).toArray();
	}

	public static void main(String[] args) {

		int[] answers = {4,1,3,2,3,1,4,2,3,1,4,1,5,4,3,4,1,2,3,2,1};
		for(int i : solution(answers)) {
			System.out.println(i);
		};

	}
}
