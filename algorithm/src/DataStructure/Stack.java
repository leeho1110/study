package DataStructure;

import java.util.EmptyStackException;

public class Stack<T> {
	
	/*
	 Stack
	 <top>	
	 node: 	data(4)
	 		next: node : data
                         next 	 				
	 
	 스택은 노드로 구성이 되는데 node는 자신의 값과 다음 노드를 가질 수 있음
	 */

	// 스택의 구성요소가 되는 노드
	
	private Node<T> top;
	
	class Node<T> {
		private T data;
		// 다음 노드가 들어갈 자리
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	public T pop() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;
		
		return item;
	}
	
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		
		return top.data;
	}
	
	// 새로운 노드가 제일 위에 가야한다 따라서 기존에 있던 노드를 새로운 노드의 next에 넣어준 (뒤로 한칸 민다) 뒤에 top에 새로운 노드를 넣기
	public void push(T item){
		Node<T> t = new Node<T>(item);
		t.next = top;
		top = t;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
	}
	
	
}
