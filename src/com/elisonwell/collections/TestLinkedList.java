package com.elisonwell.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
	
	private static List<Integer> list = new LinkedList<>();
	static{
		for(int i=0;i<10000;i++){
			list.add(i);
		}
	}
	
	/**
	 * 经测试，100w的数据，此方法耗时有32min，而用collections.reverse则耗时17mills
	 * @param list
	 * @return
	 */
	public static List<Integer> reverse(LinkedList<Integer> list){
		List<Integer> reverseList = new LinkedList<>();
		for(int i=list.size()-1;i>=0;i--){
			reverseList.add(list.get(i));
		}
		return reverseList;
	}
	
	public static List<Integer> reverse1(LinkedList<Integer> list){
		LinkedList<Integer> list1 = list;
		List<Integer> reverseList = new LinkedList<>();
		for(int i=list1.size()-1;i>=0;i--){
			reverseList.add(list1.peekLast());
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
	
	
	public static void main(String[] args){
		long t = System.currentTimeMillis();
//		reverse(list);
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
		
		long t5 = System.currentTimeMillis();
		System.out.println(reverse1((LinkedList<Integer>)list));
		System.out.println(list);
		long t6 = System.currentTimeMillis();
		System.out.println("find耗时："+(t6-t5));
	}
	
}
