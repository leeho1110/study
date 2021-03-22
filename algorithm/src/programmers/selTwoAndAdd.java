package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class selTwoAndAdd {

	public static void main(String[] args) {
		
		int[] test = {2,1,3,4,1};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<test.length; i++) {
			for(int j=i+1; j<test.length; j++) {
				int sum = test[i]+test[j];
				if(!list.contains(sum)) {
					list.add(sum);
				}
			}
		}
		
		int[] numbers = new int[list.size()];
		
		for(int i = 0; i<numbers.length; i++) {
			numbers[i] = list.get(i);
		}
		
		Arrays.sort(numbers);
		
		for(int ans : numbers) {
			System.out.println(ans);
		}
	}
	
}
