
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that converts morse code to english
 * Due: 03/26/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * tree node class to construct the tree
 * @author Will H
 *
 * @param <T>
 */
public class TreeNode<T> {
		TreeNode<T> left;
		TreeNode<T> right;
		T dataNode;
		
		public TreeNode(T dataNode) {
			this.left = null;
			this.right = null;
			this.dataNode = dataNode;
		}
		
		public TreeNode(TreeNode<T> node) {
			this.dataNode = node.dataNode;
			this.left = node.left;
			this.right = node.right;
		}
		
		public T getData() {
			return this.dataNode;
		}
	}