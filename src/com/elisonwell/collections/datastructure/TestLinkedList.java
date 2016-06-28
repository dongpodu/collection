package com.elisonwell.collections.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {
	
	private static LinkedList<Integer> list = new LinkedList<>();
	static{
		for(int i=0;i<1000000;i++){
			list.add(i);
		}
	}
	
	/**
	 * 经测试，100w的数据，此方法耗时有32min，而用collections.reverse则耗时17mills
	 * 原因：linkedList.get方法耗时较长，每次调用都会从头部或尾部开始查找,耗时为O(n^2)
	 * @param list
	 * @return
	 */
	public static List<Integer> reverse(LinkedList<Integer> list){
		LinkedList<Integer> reverseList = new LinkedList<>();
		for(int i=list.size()-1;i>=0;i--){
			reverseList.add(list.get(i));
		}
		return reverseList;
	}
	/**
	 * 经测试，100w的数据耗，此方法耗时16mills
	 * 原因：linkedList.peekLast方法每次弹出尾部元素，耗时是个常量（O(1)）,故整个方法耗时为O(n)
	 * @param list
	 * @return
	 */
	public static List<Integer> reverse1(LinkedList<Integer> list){
		LinkedList<Integer> list1 = list;
		LinkedList<Integer> reverseList = new LinkedList<>();
		for(int i=list1.size()-1;i>=0;i--){
			reverseList.add(list1.peekLast());
		}
		return reverseList;
	}
	
	/**
	 * 经测试，100w的数据耗，此方法耗时22mills
	 * 原因：迭代器会记住当前迭代位置，it.previous或it.next方法耗时是个常量（O(1)）,故整个方法耗时为O(n)
	 * collections.reverse方法更省时间，因为它只需要迭代list.size的一半即可
	 * @param list
	 * @return
	 */
	public static List<Integer> reverse2(LinkedList<Integer> list){
		LinkedList<Integer> reverseList = new LinkedList<>();
		/*listIterator(list.size())传得参数是list.size()而不是list.size()-1
		 * 因为这样可以使得第一次调用previous()时指向的元素为最后一个元素
		 * 			   
		 *                              <--迭代器初始位置
		 * 1    1    1    1     1     1     *
		 */
		ListIterator<Integer> it = list.listIterator(list.size());//注意
		while(it.hasPrevious()){
			reverseList.add(it.previous());
		}
		return reverseList;
	}
	
	/**
	 * 从linkedlist的get方法实现逻辑得出，查找越靠近中间的元素耗时越长
	 * @param index
	 * @return
	 */
	public static Integer find(int index){
		return list.get(index);
	}
	
	public static LinkedList<Integer> listIteratorSet(){
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		ListIterator<Integer> it = list.listIterator();
		while(it.hasNext()){
			it.next();
			it.set(9);//改变上一次next位置对应的值
		}
		return list;
	}
	
	
	public static void main(String[] args){
//		long t = System.currentTimeMillis();
//		reverse1(list);
//		long t1 = System.currentTimeMillis();
//		System.out.println("reverse耗时："+(t1-t));
//		Collections.reverse(list);
//		long t2 = System.currentTimeMillis();
//		System.out.println("Collections.reverse耗时："+(t2-t1));
//		
//		long t3 = System.currentTimeMillis();
//		find(1000000/6);
//		long t4 = System.currentTimeMillis();
//		System.out.println("find耗时："+(t4-t3));
		
//		long t5 = System.currentTimeMillis();
//		reverse2((LinkedList<Integer>)list);
//		long t6 = System.currentTimeMillis();
//		System.out.println("reverse2耗时："+(t6-t5));
		
		System.out.println(listIteratorSet());
	}
	
}
