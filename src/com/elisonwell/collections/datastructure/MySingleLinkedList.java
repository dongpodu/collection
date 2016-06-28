package com.elisonwell.collections.datastructure;



/**
 * 单向链表
 * @author duyisong
 * @createAt 2016年6月20日
 */
public class MySingleLinkedList<T>{
	private Node<T> head;
	
	public void add(T t){
		if(t==null){
			return;
		}
		if(head==null){
			head = new Node<>(t, null);
		}else{
			Node<T> current = head;;
			while(current!=null && current.next!=null){
				current = current.next;
			}
			current.next =  new Node<>(t, null);
		}
	}
	
	static class Node<T>{
		private T value;
		private Node<T> next;
		public Node(T value, Node<T> next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	/**
	 * 反向
	 */
	public void reverse(){
	    Node<T> current = head;  
	    Node<T> previousNode = null;  
	    Node<T> nextNode = null;  
	    
	    while (current != null) {  
	        //save the next node  
	        nextNode = current.next;  
	        //update the value of "next"  
	        current.next = previousNode;  
	        //shift the pointers  
	        previousNode = current;  
	        current = nextNode;           
	    }  
	    head = previousNode;
	}
	
	public void iterator(){
		Node<T> current = head;;
		while(current!=null){
			System.out.println(current.value);
			current = current.next;
		}
	}

	public static void main(String[] args){
		MySingleLinkedList<Integer> linkedList = new MySingleLinkedList<>();
		linkedList.add(10);
		linkedList.add(6);
		linkedList.add(8);
		linkedList.add(2);
//		linkedList.iterator();
		
		linkedList.reverse();
		linkedList.iterator();
		
	}
	
}
