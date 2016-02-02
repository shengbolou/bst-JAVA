package structures;

import static org.junit.Assert.assertEquals;


public class TestDriver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BST<Integer>();
		tree.add(4).add(2).add(1).add(3).add(5).add(6).add(7);
		
		
		
		
		
		TreeViewer viewer = new TreeViewer();
		
		BinaryTreeNode<Integer> node = tree.toBinaryTreeNode();
		//System.out.println(TreeViewer.toDotFormat(node));
		
		for(Integer i : tree){
			System.out.println(i);
		}
	    
	   
        		
	}
}