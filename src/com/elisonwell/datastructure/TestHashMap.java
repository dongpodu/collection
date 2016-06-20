package com.elisonwell.datastructure;

import java.util.HashMap;
import java.util.Iterator;

public class TestHashMap {
	private static HashMap<Integer,Integer> map = new HashMap<>();
	static{
		for(int i=0;i<10;i++){
			map.put(i, i);
		}
	}
	
	public static void iterator(){
		Iterator<Integer> it =  map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public static void main(String[] args){
		iterator();
	}
}
