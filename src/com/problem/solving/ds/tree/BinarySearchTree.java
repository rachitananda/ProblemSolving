package com.problem.solving.ds.tree;


/**
 * The worst case time complexity of search and insert operations is O(h) where h is height of Binary Search Tree.
 * In worst case, we may have to travel from root to the deepest leaf node.
 * The height of a skewed tree may become n and the time complexity of search and insert operation may become O(n).
 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 * BST  PROPERTIES
 * - left<root<right
 * - no duplicates
 * -A new key is always inserted at leaf. We start searching a key from root till we hit a leaf node.
 * Once a leaf node is found, the new node is added as a child of the leaf node.
 */
public class BinarySearchTree extends BinaryTree {

	//TODO - https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/ 
    
    public boolean  search(int key){
    	
    	boolean isfound= searchBST(key, root);
    	System.out.println(key +" found "+isfound);
    	return isfound;
    }
    
    /**
     * O(h) - height of tree
     * @param key
     * @param root
     * @return
     */
    public boolean searchBST(int key,Node root){
    	if(root == null){
    		return false;
    	}
    	
    	if(root.data == key){
    		return true;
    	}
    	
    	if(key >root.data){
    		return searchBST(key, root.right);
    	}else{
    		return searchBST(key, root.left);
    	}
    	
    }
    
    void insert(int key) { 
        root = insertBST(key,root); 
     } 
    
    /**
     *  
     * 0(h) - height of tree
     * @param root
     * @param key - item to add
     */
    public Node insertBST(int key, Node root){
    	
		if(root== null){
			root = new Node(key);
			return root;
		}
		
		if(key > root.data){
			root.right=insertBST(key,root.right);
		}else{
			root.left=insertBST(key,root.left);
		}
		
		return root;
    	
    }
}
