package structures;

import java.util.*;


public class InOrderIterator<T> implements Iterator<T>{
	private final Deque<BinaryTreeNode<T>> stack;
	private BinaryTreeNode<T> peeknode,temp;
	private boolean first;
	

	public InOrderIterator(BinaryTreeNode<T> root){
		stack=new LinkedList<BinaryTreeNode<T>>();
		peeknode=null;
		temp=null;
		first=true;
		stack.push(root);
		
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !stack.isEmpty();
	}

	@Override
	public T next() {
		BinaryTreeNode<T> BTN=stack.pop();
		while(BTN.hasLeftChild() && first){
			stack.push(BTN);
			BTN=BTN.getLeftChild();
			
		}
		first=false;
		
		if(BTN.hasRightChild() && BTN.getRightChild()!=peeknode) {
			stack.push(BTN.getRightChild());
			temp=stack.peek();
            while(temp.hasLeftChild()){
				temp=temp.getLeftChild();
				stack.push(temp);
			}
		}

		
		peeknode=BTN;
		return BTN.getData();
	}


	public void remove() {
		throw new UnsupportedOperationException();
	}
}
