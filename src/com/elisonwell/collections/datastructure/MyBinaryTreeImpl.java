package com.elisonwell.collections.datastructure;


/**
 * 二分查找树实现
 * @author duyisong
 * @createAt 2016年6月19日
 */
public class MyBinaryTreeImpl<T extends Comparable<? super T>> {
	
	private TreeNode<T> root;
	
	/**
	 * 添加
	 * @param t
	 */
	public void add(T t){
		if(t==null){
			return;
		}
		if(root==null){
			root = new TreeNode<>(t, null, null);
		}else{
			insert(t, root);
		}
	}
	
	/**
	 * 查找最小
	 * @return
	 */
	public T findMin(){
		if(root==null){
			return null;
		}
		
		TreeNode<T> min = root;
		while(min.left!=null){
			min = min.left;
		}
		return min.getValue();
	}
	
	/**
	 * 中序遍历：左-中-右
	 * 遍历出来的数据是有序的
	 */
	public void iterate(){
		if(root==null){
			System.out.println("tree is empty");
		}else{
			middleIterate(root);
		}
	}
	
	/**
	 * 计算树的高度
	 * @param node
	 * @return
	 */
	public int height(){
		if(root==null) return 0;
		return height(root);
	}
	
	private int height(TreeNode<T> node){
		if(node==null) return -1;
		int leftHeight = height(node.left)+1;
		int rightHeight = height(node.right)+1;
		if(leftHeight>rightHeight){
			return leftHeight;
		}
		return rightHeight;
	}
	
	private void middleIterate(TreeNode<T> node){
		if(node!=null){
			middleIterate(node.left);
			System.out.println(node.getValue());
			middleIterate(node.right);
		}
	}
	
	private TreeNode<T> insert(T t,TreeNode<T> node){
		if(node==null){
			return new TreeNode<>(t, null, null);
		}
		if(node.getValue().compareTo(t)<0){
			node.right = insert(t, node.right);
		}else if(node.getValue().compareTo(t)>0){
			node.left = insert(t, node.left);
		}else{
			//do nothing
		}
		return node;
	}
	
	
	private static class TreeNode<T>{
		private T t;
		private TreeNode<T> left;
		private TreeNode<T> right;
		
		public TreeNode(T t, TreeNode<T> left, TreeNode<T> right) {
			super();
			this.t = t;
			this.left = left;
			this.right = right;
		}

		public T getValue(){
			return t;
		}
	}
	
	
	
	public static void main(String[] args){
		MyBinaryTreeImpl<Integer> tree = new MyBinaryTreeImpl<>();
		tree.add(10);
		tree.add(6);
		tree.add(8);
		tree.add(2);
		tree.add(1);
		tree.add(12);
		tree.add(11);
		tree.add(13);
//		System.out.println(tree.findMin());
		tree.iterate();
		
		System.out.println(tree.height());
	}
}
