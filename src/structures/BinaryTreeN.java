package structures;

public class BinaryTreeN<T> implements BinaryTreeNode<T>{
     private T data;
     private BinaryTreeNode<T> left;
     private BinaryTreeNode<T> right;
	
	public BinaryTreeN(BinaryTreeNode<T> left,T elem,BinaryTreeNode<T> right){
				data=elem;
				this.left=left;
				this.right=right;
	}
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(T data) {
		if(data==null) throw new NullPointerException();
			
		this.data=data;
		
	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return left!=null;
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return right!=null;
	}

	@Override
	public BinaryTreeNode<T> getLeftChild() {
		if(!hasLeftChild()) throw new IllegalStateException();  //TODO Auto-generated method stub
		return left;
	}

	@Override
	public BinaryTreeNode<T> getRightChild() {
		if(!hasRightChild()) throw new IllegalStateException();// TODO Auto-generated method stub
		return right;
	}

	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		this.left=left;// TODO Auto-generated method stub
		
	}

	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		this.right=right;// TODO Auto-generated method stub
		
	}

}
