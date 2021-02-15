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
  	   
   
   
	 
	
	 
	 
	 */
}
