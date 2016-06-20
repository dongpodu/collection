package com.elisonwell.datastructure;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 有序set
 * 按照放入的顺序排序
 * @author duyisong
 * @createAt 2016年6月17日
 */
public class TestLinkedHashSet {
	private static LinkedHashSet<String> set = new LinkedHashSet<>();
	static{
		String[] array = {"this","is","a","test","linked","hash","set","class"};
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
