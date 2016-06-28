package com.elisonwell.collections.algorithm;

import java.util.Random;

/**
 * 
 * @author duyisong
 * @createAt 2016年6月22日
 */
public class TestFindMins {
	
	/**
	 * 查找arrays中k个最小的数,利用选择法排序的
	 * 时间复杂度为O(k*n)
	 * @param arrays
	 * @param k
	 */
	public static int[] find(int[] arrays,int k){
		int min;
		int temp;
		int[] newArr = new int[k];
		for(int i = 0;i<arrays.length;i++){
			min = i;
			for(int j=i+1;j<arrays.length;j++){
				if(arrays[j]<arrays[min]){
					min = j;
				}
			}
			temp = arrays[i];
			arrays[i] = arrays[min];
			arrays[min] = temp;
			
			newArr[i] = arrays[i];
			if(i==k-1) break;
		}
		return newArr;
	}
	
	public static int[] find1(int[] arrays,int k){
		int[] newArr = new int[k];
		for(int i = 0;i<k;i++){
			newArr[i] = arrays[i];
		}
		
		TestSort.select(newArr);
		
		for(int i=k-1;i<arrays.length;i++){
			if(arrays[i]<newArr[k-1]){
				newArr[k-1] = arrays[i];
				TestSort.select(newArr);
			}
		}
		return newArr;
	}
	
	public static void main(String[] args){
		int[] arrays = new int[10];
		Random rand = new Random();
		for(int i=0;i<arrays.length;i++){
			arrays[i] = rand.nextInt();
		}
		
//		sysout(arrays);
//		sysout(find(arrays, 3));
		sysout(find1(arrays, 3));
		TestSort.select(arrays);
		sysout(arrays);
	}
	
	
	private static void sysout(int[] arrays){
		for(int i=0;i<arrays.length;i++){
			System.out.println(arrays[i]);
		}
	}
}
