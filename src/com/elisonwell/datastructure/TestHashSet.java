package com.elisonwell.datastructure;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 无序set
 * 1、不光不按存储元素的顺序排序
 * 2、也不按照放入的顺序排序
 * @author duyisong
 * @createAt 2016年6月17日
 */
public class TestHashSet {
	private static HashSet<String> set = new HashSet<>();
	static{
		String[] array = {"this","is","a","test","hash","set","class"};
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
