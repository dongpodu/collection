package com.elisonwell.collections.datastructure;

import java.util.List;
import java.util.Vector;

/**
 * vector向量，与arraylist的唯一区别就是vector是线程安全的
 * @author duyisong
 * @createAt 2016年7月5日
 */
public class TestVector {
	private List<Integer> list = new Vector<>();
	
	public void add(Integer i){
		list.add(i);
	}
	
	
	
	public static void main(String[] args){
		
		
	}
}
