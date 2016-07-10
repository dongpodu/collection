package com.elisonwell.collections.datastructure;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.elisonwell.collections.model.DifferentHashAndNoComparable;
import com.elisonwell.collections.model.SameHashAndComparable;
import com.elisonwell.collections.model.SameHashAndNoComparable;


/**
 * 
 * @author duyisong
 * @createAt 2016年6月28日
 * hashmap 允许key为null
 */
public class TestHashMap {
	
	/**
	 * key的hashcode一样，存放时会发生碰撞，导致hashmap存放性能低下
	 * 同时又由于该对象未实现comparable接口，导致无法比较对象间的大小，从而无法生成二叉查找树，更加影响存放和查找效率
	 * 数据量    put耗时（mills）    get耗时（mills）
	 * 1w       1086                   1
	 * 10w      356235                 4
	 * @return
	 */
	public static Map<SameHashAndNoComparable,Integer> put(){
		HashMap<SameHashAndNoComparable,Integer> map = new HashMap<>();
		for(int i=0;i<100000;i++){
			map.put(new SameHashAndNoComparable(i), i);
		}
		return map;
	}
	
	/**
	 * key的hashcode不一样，不易发生碰撞，查找和存放效率都很高
	 * 数据量    put耗时（mills）    get耗时（mills）
	 * 100w      191                 1
	 * 1000w     9277                1
	 * @return
	 */
	public static Map<DifferentHashAndNoComparable,Integer> put1(){
		HashMap<DifferentHashAndNoComparable,Integer> map = new HashMap<>();
		for(int i=0;i<10000000;i++){
			map.put(new DifferentHashAndNoComparable(i), i);
		}
		return map;
	}
	
	/**
	 * key的hashcode一样，但可比较，效率同二叉树差不多
	 * 数据量    put耗时（mills）    get耗时（mills）
	 * 100w     1624                0
	 * 1000w    13827               1
	 * @return
	 */
	public static Map<SameHashAndComparable,Integer> put2(){
		HashMap<SameHashAndComparable,Integer> map = new HashMap<>();
		for(int i=0;i<10000000;i++){
			map.put(new SameHashAndComparable(i), i);
		}
		return map;
	}
	
	public static void iterator(Map<?,?> map){
		Iterator<?> it =  map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args){
//		long t = System.currentTimeMillis();
//		Map<SameHashAndNoComparable,Integer> map = put();
//		long t1 = System.currentTimeMillis();
//		System.out.println("put耗时："+(t1-t));
//		int result = map.get(new SameHashAndNoComparable(999));
//		long t2 = System.currentTimeMillis();
//		System.out.println("get返回："+result+"，get耗时："+(t2-t1));
		
		
//		long t = System.currentTimeMillis();
//		Map<DifferentHashAndNoComparable,Integer> map = put1();
//		long t1 = System.currentTimeMillis();
//		System.out.println("put1耗时："+(t1-t));
//		int result = map.get(new DifferentHashAndNoComparable(999));
//		long t2 = System.currentTimeMillis();
//		System.out.println("get返回："+result+"，get耗时："+(t2-t1));
		
//		long t = System.currentTimeMillis();
//		Map<SameHashAndComparable,Integer> map = put2();
//		long t1 = System.currentTimeMillis();
//		System.out.println("put2耗时："+(t1-t));
//		int result = map.get(new SameHashAndComparable(999));
//		long t2 = System.currentTimeMillis();
//		System.out.println("get返回："+result+"，get耗时："+(t2-t1));
		
		Map<String,String> map1 = new HashMap<>();
		map1.put(null, "111");
		map1.put(null, "222");
		System.out.println(map1.get(null));
	}
}
