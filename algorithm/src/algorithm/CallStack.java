package algorithm;

public class CallStack {

	// 스택 자료구조는 위에서만 꺼낼 수 있는 기다란 통이 있고 그곳에 공을 넣었다 뺏다하는 구조
	
	/* 
	  
	 CallStach 호출 스택 구조는 아래의 hi 메소드를 통해 설명하겠음
	 
	 1. main에서 hi 메소드를 호출한다. 메모리에 leeho를 변수로 하는 hi가 적재된다
	 2. hi 메소드에서 hello(name)을 호출한다
	 	-> hello 메소드가 실행되어 name을 print하고 메모리에서 반환된다
	 3. print 메소드가 호출되어 메모리에 적재된 후 :-) 를 찍고 반환(메모리에서 제거)된다
	 4. hello2(name) 메소드가 호출된다
	 	-> 메모리에 적재된 후 name을 print한 후 메모리에서 반환된다.
	 5. bye 메소드가 호출된다.
	  	-> 메모리에 적재된 후 bye를 찍고 메모리에서 반환된다.
	 6. hi 메소드가 실행완료되었으므로 hi가 메모리에서 반환된다.
	   
	 */
	
	static void hi(String name) {
		hello(name);
		hello2(name);
		bye();
	}

	private static void bye() {
		System.out.println("bye");
	}

	private static void hello2(String name) {
		System.out.println(name);
	}

	private static void hello(String name) {
		System.out.println(name);
	}
	
	public static void main(String[] args) {
		hi("leeho");
	}
	
	
}
