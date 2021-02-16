package DataStructure;

public class Tree {

	/*
	 
	 Tree
 	-> Array, Linked List, Stack, Queue 일직선 구조이지만, Tree는 부모와 자식을 가지는 구조로써 계층과 그룹이 존재한다.
	 ex)
		   O
		  / \
		 O   O
		/ \   \
	   O   O   O -> leaf
   
	- Tree는 노드로 구성되어있다. Node가 하나 이상의 자식 노드를 가지는 경우 Tree가 된다. 
	   그 중 자식 노드가 최대 2개까지만 붙는 Tree를 binary tree, 3개는 ternary tree.
   	
	- Binary Search Tree(이진 탐색  트리): 안의 데이터 중 왼쪽 Node와 그 이하 자식 노드들은 현재 노드보다 커야하고, 오른쪽은 현재 노드보다 커야한다.
   	  	Binary Tree	   	Binary Search Tree
   	      8                    8
   	   6    9                6   10
   	  4 12   10             4 7 11 12
   	
   	- balance가 맞는 트리에는 Red-Black Tree, AVL Tree가 있다.
   	
   	- Complete Binary Tree(완전 이진 트리): 모든 노드들이 레벨 별로 왼쪽부터 채워져 있어야 한다. 
  	   마지막 레벨을 제외한 모든 서브 트리의 레벨이 같고, 마지막 레벨은 왼쪽부터 채워져 있어야 한다
  	   
  	  	O:			 X:
  		    O			O
		  /   \		   / \
		 O     O	  O   O
		/ \   /      / \   \
	   O   O O      O   O   O
  	   
  	- Full Binary Tree: 하나의 Childe Node를 가진 노드가 하나도 없는 트리, 만약 자식 노드를 가지려면 두개를 가지고 아니면 하나도 X
  	
  	- Perfect Binary Tree: 양쪽으로 빈 공간없이 모든 노드가 2개의 자식 노드를 가지고, 레벨도 딱 떨어지는 완벽한 피라미드 구조
	 
	--------------------------------------------------------------------------------------------------------------------- 
	
	-> 이진 트리를 횡단하면서 트리의 모든 데이터를 가져오는 방법
	   Inorder(left,root,right/왼쪽, 오른쪽 안(In)에) 
	   Preorder(root,left,right/왼쪽,오른쪽 이전(pre==before)에 )
	   Postorder(1eft,right,root/왼쪽,오른쪽 후(post==after)에)
	   
		   1
		 2   3
	    4 5
	   
	   In-order : 4 2 5 1 3
	   Pre-order : 1 2 4 5 3
	   Post-order : 4 5 2 3 1 
	 
	 */
	class Node{
		int data;
		Node left;
		Node right;
	}
	
	public Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + "-");
			inorder(node.right);
		}
	}
	
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data + "-");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + "-");
		}
	}
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node n4 = tree.makeNode(null, 4, null);
		Node n5 = tree.makeNode(null, 5, null);
		Node n2 = tree.makeNode(n4, 2, n5);
		Node n3 = tree.makeNode(null, 3, null);
		Node n1 = tree.makeNode(n2, 1, n3);
		
		tree.setRoot(n1);
		System.out.println(">> In-Order");
		tree.inorder(tree.getRoot());
		System.out.println("\n\n>> Pre-Order");
		tree.preorder(tree.getRoot());
		System.out.println("\n\n>> Post-Order");
		tree.postorder(tree.getRoot());
		
		
	}
}
