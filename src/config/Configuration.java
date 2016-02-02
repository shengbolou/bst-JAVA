package config;

import structures.BST;
import structures.BinarySearchTree;
import structures.BinaryTreeN;
import structures.BinaryTreeNode;
import structures.BinaryTreeU;
import structures.BinaryTreeUtility;


/**
 * This class acts as a configuration file which tells the testing framework
 * which implementation you want us to use when we grade your assignment.
 * 
 * @author miklau
 * 
 */
public class Configuration {

	
	/**
	 * Your 8 digit University of Massachusetts Identification Number. This
	 * is the value on your UMass ID Card. We need this to associate your submission
	 * with your moodle account when we submit grades
	 */
	public static final String STUDENT_ID_NUMBER = "28530995";
	

	public static <T> BinaryTreeNode<T> createBinaryTreeNode(BinaryTreeNode<T> left, T elem, BinaryTreeNode<T> right){
		return new BinaryTreeN(left, elem, right);
	}
	
	public static BinaryTreeUtility createBinaryTreeUtility(){
		return new BinaryTreeU();
	}
	
	public static <T extends Comparable<? super T>> BinarySearchTree<T> createBinarySearchTree(){
		return new BST();
	}
	

}
