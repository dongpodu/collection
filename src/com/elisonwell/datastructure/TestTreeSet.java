package com.elisonwell.datastructure;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 有序set
 * 排序按照存放元素的升序排列，故存放的元素需要实现comparable接口，
 * 如没有，则需要在构建TreeSet时传comparator参数
 * @author duyisong
 * @createAt 2016年6月17日
 */
public class TestTreeSet {
	private static TreeSet<String> set = new TreeSet<>();
	static{
		String[] array = {"this","is","a","test","tree","set","class"};
		for(int i=0;i<array.length;i++){
			set.add(array[i]);
		}
	}
	
	public static void iterator(){
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	
	public static void main(String[] args){
		iterator();
	}
}
