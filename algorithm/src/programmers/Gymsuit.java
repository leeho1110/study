package programmers;

public class Gymsuit {
	
	static int solution(int n, int[] lost, int[] reserve) {
		
		/*
		 도난당하여 체육복이 없는 학생 : -1
		 자신의 체육복만 가지는 학생 : 0
		 여벌의 체육복을 가지는 학생 : 1 
		 */
		
		// 정답의 갯수를 담을 변수 선언
		int answer = 0;
		
		// 들어온 학생의 수의 길이를 가지는 배열 선언
		int[] all = new int[n];
		
		// 여벌이 있는 학생은 +1
		for(int r : reserve) {
			all[r-1]++;
		}
		
		// 도난당한 학생은 -1, 위에서 더해준 여벌이 있는 학생중 도난을 당하면 0이 되어 자신의 것만 있는 상태가 됨. 순서 중요.
		for(int l : lost) { 
			all[l-1]--;
		}
		
		
		for(int stu=0; stu<all.length; stu++) {
			// 만약 체육복이 없는 학생인 경우
			if(all[stu] == -1) {
				// 첫번째 학생(앞번호 없음) 외에는 자신의 앞번호 학생에게 여벌의 옷을 빌림
				if(stu != 0 && all[stu-1] > 0) {
					all[stu]++;
					all[stu-1]--;
				} 
				// 마지막 학생(뒷번호 없음) 외에는 자신의 뒷번호에게 여벌의 옷 빌림.
				else if(stu != all.length-1 && all[stu+1]>0){
					all[stu]++;
					all[stu+1]--;
				}
				
				// 위의  조건문으로 첫번째와 마지막이 아닌 경우 자신의 앞뒤로 여벌이 있는지 확인할 수 있음
			}
		}
		
		// 체육복을 입을 수 있는(0) 혹은 여벌이 있는(1) 학생을 확인
		for(int i=0; i<all.length; i++) {
			if(all[i] > -1) {
				answer++;
			}
		}
		
		return answer; 
	}

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		
		int answer = solution(n, lost, reserve);
		System.out.println(answer);
	}
}
