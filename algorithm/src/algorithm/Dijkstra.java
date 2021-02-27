package algorithm;

public class Dijkstra {
	
	static int number = 6;
	static int INF = 100000000;
	
	// 방문 여부 체크
	static boolean[] visited = new boolean[6];
	// 최단거리
	static int[] distance = new int[6];
	
	static int getSmallIndex() {
		int min = INF;
		int index = 0;
		for(int i=0; i<number; i++) {
			if(distance[i] < min && !visited[i]) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		
		
	}
}
