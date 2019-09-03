package validateBinarySearchTree;

import java.util.Stack;

/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example:
 * 		Input:
			    2
			   / \
			  1   3
 * 		Output: true
 * 
 * Example:
 * 		Input: 
			  	5
			   / \
			  1   4
			     / \
			    3   6
 * 		Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. 
 * 				The root node's value is 5 but its right child's value is 4.
 * 
 */

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode current = root;

		current.left = new TreeNode(5);
		current.right = new TreeNode(15);
		current.right.left = new TreeNode(6);
		current.right.right = new TreeNode(20);

		System.out.println(isValidBST(root));
	}
	

	public static boolean isValidBST(TreeNode root) {
		if (root == null) 
			return true; 

		Stack<TreeNode> s = new Stack<TreeNode>(); 
		TreeNode curr = root; 

		int sequenceValue = 0;
		boolean valid = true;
		int count = 0;

		while (curr != null || s.size() > 0) 
		{ 
			while (curr !=  null) 
			{ 
				s.push(curr); 
				curr = curr.left; 
			} 

			curr = s.pop();
			
			if (count == 0)
				sequenceValue = curr.val;
			else {
				if (curr.val <= sequenceValue)
					valid &= false;
				else
					sequenceValue = curr.val;
			}
			count++;

			curr = curr.right; 
		} 
		
		return valid;
	} 
}


//}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
