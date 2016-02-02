package structures;

import java.util.*;


public class PostOrderIterator<T> implements Iterator<T>{

	private final Stack<BinaryTreeNode<T>> stack;
	private BinaryTreeNode<T> right=null;
	private boolean first=true;

	public PostOrderIterator(BinaryTreeNode<T> root){
		stack = new Stack<BinaryTreeNode<T>>();
		stack.push(root);
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		BinaryTreeNode<T> temp=stack.peek();
		while(temp.hasLeftChild() && first){
			temp=temp.getLeftChild();
			stack.push(temp);
		}
		first=false;
		if(temp.hasRightChild() && temp.getRightChild()!=right) {
			stack.push(temp.getRightChild());
			temp=stack.peek();

			while(temp.hasLeftChild()){
				temp=temp.getLeftChild();
				stack.push(temp);
			}
		}

		temp=stack.pop();
		right=temp;
		return temp.getData();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
