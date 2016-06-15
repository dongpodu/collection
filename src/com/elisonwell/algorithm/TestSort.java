package com.elisonwell.algorithm;

import java.util.Random;

/**
 * 排序算法比较
 * @author duyisong
 * @createAt 2016年6月15日
 */
public class TestSort {
	/**
	 * 冒泡
	 * 数据量   耗时（s）
	 * 100w    5376（一个半小时）
	 * 10w     14
	 * @param arrays
	 */
	public static void bubble(int[] arrays){
		long t = System.currentTimeMillis();
		int tmp=0;
		for(int i=0;i<arrays.length;i++){
			for(int j=0;j<arrays.length-i-1;j++){
				if(arrays[j]>arrays[j+1]){
					tmp = arrays[j];
					arrays[j] = arrays[j+1];
					arrays[j+1] = tmp;
				}
			}
		}
		long t1 = System.currentTimeMillis();
		System.out.println("bubble耗时:"+(t1-t));
	}
	
	/**
	 * 选择排序
	 * 数据量   耗时（s）
	 * 100w    160
	 * 10w     1
	 * @param arrays
	 */
	public static void select(int[] arrays){
		long t = System.currentTimeMillis();
		int min;
		for(int i=0;i<arrays.length;i++){
			min=arrays[i];
			for(int j=i+1;j<arrays.length;j++){
				if(min>arrays[j]){
					min = arrays[j];
				}
			}
			arrays[i] = min;
		}
		long t1 = System.currentTimeMillis();
		System.out.println("select耗时:"+(t1-t));
	}
	
	public static void main(String[] args){
		
		int[] arrays = new int[1000000];
		Random rand = new Random();
		for(int i=0;i<arrays.length;i++){
			arrays[i] = rand.nextInt();
		}
		
		bubble(arrays);
//		for(int i=0;i<arrays.length;i++){
//			System.out.println(arrays[i]);
//		}
		
		
//		select(arrays);
//		for(int i=0;i<arrays.length;i++){
//			System.out.println(arrays[i]);
//		}
	}
}
