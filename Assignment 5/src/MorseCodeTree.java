import java.util.ArrayList;
/*
 * Class: CMSC 204
 * Instructor: Huseyin Aygun
 * Description: A class that builds the morse code tree
 * Due: 03/26/2024
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: William Hernandez
 */
/**
 * morse code tree class which implements the interface
 * @author Will H
 *
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	
	private TreeNode<String> root;
	
	/**
	 * class constructor which builds the tree
	 */
	public MorseCodeTree() {
		buildTree();	// builds the morse code tree
	}
	
	
	/**
	 * method which gets the root reference
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;	// returns root
	}
	
	/**
	 * sets root of the morsecode tree
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<String>(newNode);	
		
	}
	
	/**
	 * Adds element to the correct position in the tree based on the addNode method
	 * This method will call the recursive method
	 */
	@Override
	public void insert(String code, String letter) {
		addNode(root, code, letter);
		
	}
	
	/**
	 * This is a recursive method which adds a node to the left or right child of a root, 
	 * this method will continuously call addNode with the string code sent each time removing the first character 
	 * until we reach the last symbol - or . and places it at that location
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		TreeNode<String> node = new TreeNode<>(letter);
		
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {	// reads '.' 
				root.left = node;	// places node at left child
			}else if(code.charAt(0) == '-'){
				root.right = node;	// places node at right child
			}
		} else {
			TreeNode<String> newRoot = root;	// sets new parent root
			String newCode = code.substring(1); // this sends the new code when recalling the recursive method
			
			if(code.charAt(0) == '.') {
				newRoot = root.left;
			}else if(code.charAt(0) == '-') {
				newRoot = root.right;
			}
			
			addNode(newRoot, newCode, letter);	// recursively calls this method until last char in string is placed
			
		}
	}
	/**
	 * Fetch the data in the tree based on the code 
	 * This method will call the recursive method fetchNode
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}
	
	/**
	 * recursive method which takes a code string and root, 
	 * reads through the tree and and returns node string data
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String data = "";
		
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {
				data = root.left.getData();	// gets data at left child
			}else if(code.charAt(0) == '-'){
				data = root.right.getData();	// gets data at right child			
			}
		} 
		else {	// 
			TreeNode<String> newRoot = root;	// sets new root from parameter
			String newCode = code.substring(1); // removes first character of the string into a new string to be recursively reduced until its finished
			
			if(code.charAt(0) == '.') {
				newRoot = root.left;	// sets the left root as new root
			}else if(code.charAt(0) == '-') {
				newRoot = root.right;	// sets the right root as new root
			}
			data = fetchNode(newRoot, newCode);	// adds recursively found node to data string
		}
		return data;	// returns node string data
	}
	
	/**
	 * a method that does not work with the implementation
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("not supported");
	}
		/**
		 * a method that does not work with this implementation
		 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("not supported");
	}
	/**
	 * builds the tree with the nodes at their respective spots
	 */
	@Override
	public void buildTree() {
		// root of the tree
		root = new TreeNode<String>("");	// set root node to an empty string
		
		// level 2 in the tree, children of the root node
		insert(".", "e");
		insert("-","t");
		
		// level 3
		insert("..","i");
		insert(".-","a");
		insert("-.","n");
		insert("--","m");
		
		// level 4
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert(".--","w");
		insert("-..","d");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		
		// level 5
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert(".--.","p");
		insert(".---","j");
		insert("-...","b");
		insert("-..-","x");
		insert("-.-.","c");
		insert("-.--","y");
		insert("--..","z");
		insert("--.-","q");
		
		// these are inserted to the tree based on the tree in the assignment document
		
	}
	/**
	 * method returns an array list of the data in the tree in order
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> arrayOfNodes = new ArrayList<>();	// this empty array list will be filled with the array nodes
		LNRoutputTraversal(root, arrayOfNodes);	// sends root "" and empty ArrayList to be filled
		return arrayOfNodes;	// returns an inorder list of the nodes in the tree
	}
	/**
	 * traverses the tree in order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {	// inorder traversal of the tree
		if(root != null) {
			LNRoutputTraversal(root.left, list);
			list.add(root.getData());
			//System.out.println(root.getData());
			LNRoutputTraversal(root.right, list);
		}
		
	}
	
}
