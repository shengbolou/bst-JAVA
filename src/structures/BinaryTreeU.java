package structures;

import java.util.*;

public class BinaryTreeU implements BinaryTreeUtility{

	public BinaryTreeU(){

	}
	@Override
	public <T> Iterator<T> getPreOrderIterator(BinaryTreeNode<T> root) {
		if(root==null) throw new NullPointerException();
		return new PreOrderIterator(root);
	}

	@Override
	public <T> Iterator<T> getInOrderIterator(BinaryTreeNode<T> root) {
		if(root==null) throw new NullPointerException();
		return new InOrderIterator(root);
	}

	@Override
	public <T> Iterator<T> getPostOrderIterator(BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null) throw new NullPointerException();
		return new PostOrderIterator(root);
	}

	@Override
	public <T> int getDepth(BinaryTreeNode<T> root) {
		if(root==null) throw new NullPointerException();

		Deque<BinaryTreeNode<T>> stack=new LinkedList<BinaryTreeNode<T>>();
		int result=0;
		if (root.hasLeftChild()) stack.addLast(root.getLeftChild());  
		if (root.hasRightChild()) stack.addLast(root.getRightChild());
		stack.addLast(null);
		while(!stack.isEmpty()){
			BinaryTreeNode<T> temp=stack.pop();
			if(temp==null){ 
				result++;
				if(!stack.isEmpty())
					stack.addLast(null);
			}
			if(temp!=null){
				if(temp.hasLeftChild())  stack.addLast(temp.getLeftChild());  
				if(temp.hasRightChild()) stack.addLast(temp.getRightChild());
			}
		}
		if(!root.hasLeftChild() && !root.hasRightChild()) result=0;
		return result;
	}

	@Override
	public <T> boolean isBalanced(BinaryTreeNode<T> root, int tolerance) {
		// TODO Auto-generated method stub
		
		if(root==null) throw new NullPointerException();
		if(tolerance<0) throw new IllegalArgumentException();
        int max=getDepth(root);
		int min=getMinDepth(root);
		if(Math.abs(max-min)<= tolerance) return true;
		else return false;
	}
	
	public <T> int getMinDepth(BinaryTreeNode<T> root) {
		if(root==null) throw new NullPointerException();

		Deque<BinaryTreeNode<T>> stack=new LinkedList<BinaryTreeNode<T>>();
		int result=0;
		if (root.hasLeftChild()) stack.addLast(root.getLeftChild());  
		if (root.hasRightChild()) stack.addLast(root.getRightChild());
		stack.addLast(null);
		while(!stack.isEmpty()){
			BinaryTreeNode<T> temp=stack.pop();
			if(temp==null){ 
				result++;
				if(!stack.isEmpty())
					stack.addLast(null);
			}
			if(temp!=null){
				if(temp.hasLeftChild())  stack.addLast(temp.getLeftChild());  
				if(temp.hasRightChild()) stack.addLast(temp.getRightChild());
				else break;
			}
		}
		if(!root.hasLeftChild() || !root.hasRightChild()) result=0;
		else result++;
		return result;
	} 

	@Override
	public <T extends Comparable<? super T>> boolean isBST(
			BinaryTreeNode<T> root) {
		// TODO Auto-generated method stub
		if(root==null) throw new NullPointerException();

		Deque<BinaryTreeNode<T>> stack=new LinkedList<BinaryTreeNode<T>>();
        stack.push(root);
		boolean isbst=true;

		while(!stack.isEmpty()){
			BinaryTreeNode<T> temp=stack.pop();
			if (temp.hasLeftChild()) {
				stack.addLast(temp.getLeftChild());
				if(temp.getLeftChild().getData().compareTo(temp.getData())>0) isbst=false;

			}
			if(temp.hasRightChild()) {
				stack.addLast(temp.getRightChild());
				if(temp.getRightChild().getData().compareTo(temp.getData())<0) isbst=false;

			}

		}
		return isbst;
	}

}
