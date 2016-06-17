package com.elisonwell.algorithm;

import java.util.Random;

/**
 * 排序算法比较
 * 此处实现均是我自己实现的
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
	
	/**
	 * 插入排序
	 * 数据量   耗时（s）
	 * 100w    453
	 * 10w     4
	 * @param arrays
	 */
	public static void insert(int[] arrays){
		long t = System.currentTimeMillis();
		int tmp;
		for(int i=1;i<arrays.length;i++){
			for(int j=i;j>0;j--){
				if(arrays[j]<arrays[j-1]){
					tmp = arrays[j];
					arrays[j] = arrays[j-1];
					arrays[j-1] = tmp;
				}else{
					break; //a[j]前面的数据是从小到大的，因此当a[j]>=arrays[j-1]时，则无需再向下比较
				}
			}
		}
		long t1 = System.currentTimeMillis();
		System.out.println("insert耗时:"+(t1-t));
	}
	
	/**
	 * 希尔排序
	 * 希尔排序通过将比较的全部元素分为几个区域来提升插入排序的性能。这样可以让一个元素可以一次性地朝最终位置前进一大步。
	 * 然后算法再取越来越小的步长进行排序，算法的最后一步就是普通的插入排序，但是到了这步，需排序的数据几乎是已排好的了（此时插入排序较快）。
	 * 数据量   耗时（s）
	 * 100w    466
	 * 10w     4
	 * @param arrays
	 */
	public static void shell(int[] arr) {
		long t = System.currentTimeMillis();
		int gap = 1, i, j, len = arr.length;
		while (gap < len / 3){
			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		}
		int tmp=0;
		while(gap > 0){
			for (i = gap; i < len; i++) {
				for (j = i; j > 0; j -= gap){
					if(j-gap>=00 && arr[j-gap] > arr[j]){
						tmp = arr[j];
						arr[j] = arr[j-1];
						arr[j-1] = tmp;
					}else{
						break;
					}
				}
			}
			gap /= 3;
		}
		long t1 = System.currentTimeMillis();
		System.out.println("shell耗时:"+(t1-t));
	}
	
	public static void main(String[] args){
		
		int[] arrays = new int[1000000];
		Random rand = new Random();
		for(int i=0;i<arrays.length;i++){
			arrays[i] = rand.nextInt();
		}
		
//		bubble(arrays);
		
//		select(arrays);
		
//		insert(arrays);
//		sysout(arrays);
		
		shell(arrays);
//		sysout(arrays);
	}
	
	
	private static void sysout(int[] arrays){
		for(int i=0;i<arrays.length;i++){
			System.out.println(arrays[i]);
		}
	}
}
