package programmers;

public class Gymsuit {
	
	static int solution(int n, int[] lost, int[] reserve) {
		
		int answer = 0;
		
		int[] all = new int[n];
		
		for(int l : lost) { 
			all[l-1]--;
		}
		
		for(int r : reserve) {
			all[r-1]++;
		}
		
		for(int stu=0; stu<all.length; stu++) {
			if(all[stu] == -1) {
				if(stu != 0 && all[stu-1] > 0) {
					all[stu]++;
					all[stu-1]--;
				} else if(stu != all.length-1 && all[stu+1]>0){
					all[stu]++;
					all[stu+1]--;
				}
				
			}
		}
		
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
