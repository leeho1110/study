package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamPrac {
	
	public static void main(String[] args) {
		List<Integer> numList = new ArrayList<Integer>();
		numList.add(2);
		numList.add(1);
		numList.add(3);
		numList.add(4);
		
		Stream<Integer> stream = numList.stream().sorted();
		Object[] a = stream.toArray();
	}
}
