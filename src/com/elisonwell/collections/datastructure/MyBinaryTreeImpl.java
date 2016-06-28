package com.elisonwell.collections.datastructure;


/**
 * 二分查找树实现
 * @author duyisong
 * @createAt 2016年6月19日
 */
public class MyBinaryTreeImpl<T extends Comparable<? super T>> {
	
	private TreeNode<T> root;
	
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
		System.out.println(tree.findMin());
	}
}
