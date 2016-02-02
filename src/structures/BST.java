package structures;

import java.util.Iterator;

public class BST<T extends Comparable<T>> implements BinarySearchTree<T>{
	private BinaryTreeNode<T> root;
	private boolean found;

	public BST(){
		root=null;
	}

	private BinaryTreeNode<T> recAdd(T elem, BinaryTreeNode<T> tree){
		if(tree==null) tree=new BinaryTreeN<T>(null,elem,null);



		else if(elem.compareTo(tree.getData())<=0 && !tree.hasLeftChild())
			tree.setLeftChild(new BinaryTreeN<T>(null,elem,null));



		else if(elem.compareTo(tree.getData())>=0 && !tree.hasRightChild())

			tree.setRightChild(new BinaryTreeN<T>(null,elem,null));


		else if(elem.compareTo(tree.getData())<=0) 
			tree.setLeftChild(recAdd(elem,tree.getLeftChild()));

		else
			tree.setRightChild( recAdd(elem,tree.getRightChild()));

		return tree;

	} 
	@Override
	public BinarySearchTree<T> add(T toAdd) {
		// TODO Auto-generated method stub
		if(toAdd==null) throw new NullPointerException();
		root=recAdd(toAdd,root);
		return this;
	}

	private boolean recContains(T elem, BinaryTreeNode<T> tree){
		if(tree==null) return false;


		else if(elem.compareTo(tree.getData())<0 && !tree.hasLeftChild()) return false;
		else if(elem.compareTo(tree.getData())>0 && !tree.hasRightChild()) return false;

		else if(elem.compareTo(tree.getData())<0)
			return recContains(elem,tree.getLeftChild());

		else if(elem.compareTo(tree.getData())>0)
			return recContains(elem,tree.getRightChild());

		else return true;


	}
	@Override
	public boolean contains(T toFind) {
		// TODO Auto-generated method stub
		if(toFind==null) throw new NullPointerException();
		return recContains(toFind,root);
	}


	private BinaryTreeNode<T> recRemove(T elem, BinaryTreeNode<T> tree){
		if(tree==null) found=false;

		else{
			if(!tree.hasLeftChild() && elem.compareTo(tree.getData())<0) found=false;
			else if(!tree.hasRightChild() && elem.compareTo(tree.getData())>0) found=false;

			else if(elem.compareTo(tree.getData())<0 && tree.hasLeftChild())
				tree.setLeftChild(recRemove(elem,tree.getLeftChild()));
			else if(elem.compareTo(tree.getData())>0 && tree.hasRightChild())
				tree.setRightChild(recRemove(elem,tree.getRightChild()));
			else{
				tree=removeNode(tree);
				found=true;
			}
		}
		return tree;

	}
	private BinaryTreeNode<T> removeNode(BinaryTreeNode<T> tree){
		T data;

		if(!tree.hasLeftChild() && !tree.hasRightChild()) return null;
		if(!tree.hasLeftChild() && tree.hasRightChild())
			return tree.getRightChild();

		if(!tree.hasRightChild() && tree.hasLeftChild())
			return tree.getLeftChild();

		else{
			data=getPredecessor(tree.getLeftChild());
			tree.setData(data);
			tree.setLeftChild(recRemove(data,tree.getLeftChild()));
			return tree;
		}


	}
	private T getPredecessor(BinaryTreeNode<T> tree){
		while(tree.hasRightChild())
			tree=tree.getRightChild();
		return tree.getData();
	}
	@Override
	public boolean remove(T toRemove) {
		// TODO Auto-generated method stub
		root=recRemove(toRemove,root);
		return found;

	}
	private int recSize(BinaryTreeNode<T> tree){
		if(tree==null) return 0;
		else if(!tree.hasLeftChild() && !tree.hasRightChild()) return 1;
		else if(!tree.hasLeftChild()) return recSize(tree.getRightChild())+1;
		else if(!tree.hasRightChild()) return recSize(tree.getLeftChild())+1;
		else return recSize(tree.getLeftChild()) + recSize(tree.getRightChild()) + 1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return recSize(root);

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root==null;
	}

	@Override
	public T getMinimum() {
		BinaryTreeNode<T> temp=root;
		if(isEmpty()) throw new IllegalStateException();
		while(temp.hasLeftChild()){
			temp=temp.getLeftChild();
		}
		return temp.getData();
	}

	@Override
	public T getMaximum() {
		BinaryTreeNode<T> temp=root;
		if(isEmpty()) throw new IllegalStateException();
		while(temp.hasRightChild()){
			temp=temp.getRightChild();
		}
		return temp.getData();
	}

	@Override
	public BinaryTreeNode<T> toBinaryTreeNode() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new IllegalStateException();
		return root;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new InOrderIterator(root);
	}

}
