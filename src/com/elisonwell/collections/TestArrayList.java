package com.elisonwell.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {
	
	private static List<Integer> list = new ArrayList<>();
	static{
		for(int i=0;i<10000000;i++){
			list.add(i);
		}
	}
	
	/**
	 * 经测试：
	 * 100w的数据，此方法耗时有51mills，而用collections.reverse则耗时12mills
	 * 100w的数据，此方法耗时有143mills，而用collections.reverse则耗时27mills
	 * @param list
	 * @return
	 */
	public static List<Integer> reverse(List<Integer> list){
		List<Integer> reverseList = new ArrayList<>();
		for(int i=list.size()-1;i>=0;i--){
			reverseList.add(list.get(i));
		}
		return reverseList;
	}
	
	/**
	 * 几乎不耗时，即时100w的数据，耗时也是0
	 * @param index
	 * @return
	 */
	public static Integer find(int index){
		return list.get(index);
	}
	
	
	public static void main(String[] args){
//		long t = System.currentTimeMillis();
//		reverse(list);
//		long t1 = System.currentTimeMillis();
//		System.out.println("reverse耗时："+(t1-t));
//		Collections.reverse(list);
//		long t2 = System.currentTimeMillis();
//		System.out.println("Collections.reverse耗时："+(t2-t1));
		
		long t3 = System.currentTimeMillis();
		find(1000000-1);
		long t4 = System.currentTimeMillis();
		System.out.println("find耗时："+(t4-t3));
	}
	
}
