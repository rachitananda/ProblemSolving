package com.problem.solving;

import java.util.LinkedList;
import java.util.Queue;




public class Demo {
	
	

	public static void main(String[] args) {
	
	BinaryTree tree = new BinaryTree();
	tree.root= new Node(1);
	tree.root.rhs=new Node(3);
	Node n2 = new Node(2);
	n2.rhs= new Node(5);
	n2.lhs= new Node(4);
	tree.root.lhs=n2;
	
	System.out.println("inorder");
	tree.inorderTraversal(tree.root);
	System.out.println("\npreorder");
	tree.preOrderTraversal(tree.root);
	System.out.println("\npostorder");
	tree.postOrderTraversal(tree.root);
	System.out.println("\nBFS- level order");
	tree.levelOrderTraversal();
	}

	
	
	
	
	static class BinaryTree{
		
		Node root;
		
		
		void inorderTraversal(Node node){
			if(node == null){
				return;
			}
			inorderTraversal(node.lhs);
			System.out.print(node.data+" ");
			inorderTraversal(node.rhs);
			
		}
		
		void preOrderTraversal(Node node){
			if(node == null){
				return;
			}
			System.out.print(node.data+" ");
			inorderTraversal(node.lhs);
			inorderTraversal(node.rhs);
			
		}
		void postOrderTraversal(Node node){
			if(node == null){
				return;
			}

			postOrderTraversal(node.lhs);
			postOrderTraversal(node.rhs);
			System.out.print(node.data+" ");
			
		}
		
	
		void levelOrderTraversal(){
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			
			while(!queue.isEmpty()){
				
				Node node = queue.poll();
				System.out.print(" "+node.data+" ");
				if(node.lhs!=null){
					queue.add(node.lhs);
				}
				if(node.rhs!=null){
					queue.add(node.rhs);
				}
				
			}
			
			
		}
		
	}
	
	static class Node{
		int data;
		Node lhs,rhs;
		Node(int key){
			data=key;
		}
	}
	
}


