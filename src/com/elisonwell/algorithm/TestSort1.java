package com.elisonwell.algorithm;

import java.util.Random;

/**
 * 排序算法比较
 * 此处实现均摘自维基百科
 * @author duyisong
 * @createAt 2016年6月15日
 */
public class TestSort1 {
	
	/**
	 * 冒泡排序，与本人实现的相同
	 * @param arr
	 */
	public static void bubble_sort(int[] arr) {
		long t = System.currentTimeMillis();
		int i, j, temp, len = arr.length;
		for (i = 0; i < len - 1; i++)
			for (j = 0; j < len - 1 - i; j++)
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
		long t1 = System.currentTimeMillis();
		System.out.println("bubble_sort耗时:"+(t1-t));
	}
	/**
	 * 选择排序,与本人实现的相同
	 * @param arr
	 */
	public static void select_sort(int[] arr) {
		long t = System.currentTimeMillis();
		int i, j, min, temp, len = arr.length;
		for (i = 0; i < len - 1; i++) {
			min = i;
			for (j = i + 1; j < len; j++)
				if (arr[min] > arr[j])
					min = j;
			temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		long t1 = System.currentTimeMillis();
		System.out.println("select_sort耗时:"+(t1-t));
	}
	
	/**
	 * 插入排序，与我实现的算法性能差不多
	 * 数据量   耗时（s）
	 * 100w    387
	 * 10w     4
	 * @param arr
	 */
	public static void insert_sort(int[] arr){
		long t = System.currentTimeMillis();
		for (int i = 1; i < arr.length; i++ ) {
			int temp = arr[i];
			for (int j = i - 1; j >= 0 && arr[j] > temp; j-- ) {
				arr[j + 1] = arr[j];
				arr[j] = temp;
			}
		}
		long t1 = System.currentTimeMillis();
		System.out.println("insert_sort耗时:"+(t1-t));
	}
	
	/**
	 * 希尔排序的另一种实现，该方法对于100w的数据耗时仅为226毫秒
	 * @param arrays
	 */
	public static void shell_sort(int[] arr) {
		long t = System.currentTimeMillis();
		int gap = 1, i, j, len = arr.length;
		int temp;
		while (gap < len / 3)
			gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
		for (; gap > 0; gap /= 3)
			for (i = gap; i < len; i++) {
				temp = arr[i];
				for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
					arr[j + gap] = arr[j];
				arr[j + gap] = temp;
		}
		long t1 = System.currentTimeMillis();
		System.out.println("shell_sort耗时:"+(t1-t));
	}
	
	public static void main(String[] args){
		
		int[] arrays = new int[1000000];
		Random rand = new Random();
		for(int i=0;i<arrays.length;i++){
			arrays[i] = rand.nextInt();
		}
		
//		bubble_sort(arrays);
		
//		select_sort(arrays);
		
		insert_sort(arrays);
//		sysout(arrays);
		
//		shell_sort(arrays);
//		sysout(arrays);
	}
	
	
	private static void sysout(int[] arrays){
		for(int i=0;i<arrays.length;i++){
			System.out.println(arrays[i]);
		}
	}
}
