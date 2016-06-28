package com.elisonwell.collections.algorithm;

/**
 * 字符串包含
 * 问题描述：给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
 * 为了简单起见，我们规定输入的字符串只包含大写英文字母，请实现函数bool StringContains(string &A, string &B)
 * 比如，如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BAD
 * 答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
 * 如果是下面两个字符串：
 * String 1：ABCD
 * String 2：BCE
 * 答案是false，因为字符串String2里的E字母不在字符串String1里。
 * 同时，如果string1：ABCD，string 2：AA，同样返回true。
 * @author duyisong
 * @createAt 2016年6月21日
 */
public class TestContainStr {
	
	/**
	 * 算法逻辑：
	 * 将不同的字符对应到不同的素数，不要求字符的顺序与素数顺序一样，只要是一一对应就行。
	 * 然后将长字符串的字符对应的素数累计相乘得到数f，迭代短字符串的字符，用f与各个字符对应的素数取余
	 * 若能整除则长字符串包含该字符，若不能，则不包含。
	 * 
	 * 数学理论：任何大于1的整数均可被表示成一串唯一素数之乘积
	 * 
	 * 
	 * 这里只考虑了字符全为大写的字母
	 * @param lo
	 * @param sh
	 * @return
	 */
	public static boolean contains(String lo,String sh){
		if(lo==null || sh==null){
			return false;
		}
		long[] prime = new long[]{2, 3, 5, 7, 11, 13, 17, 19, 
				23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 
				71, 73, 79, 83, 89, 97, 101};
		//计算lo所有字符对应的素数的乘积
		long f = 1;
		for(int i=0;i<lo.length();i++){
			long x = prime[lo.charAt(i)-'A']; //字母对应的素数
			if(f%x!=0){ //x未被f所乘，说明这个字符是个新的字符
				f *= x;
			}
		}
		
		for(int i=0;i<sh.length();i++){
			long x = prime[sh.charAt(i)-'A'];
			if(f%x!=0){
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * 算法逻辑：可以先把长字符串a中的所有字符都放入一个Hashtable里，然后轮询短字符串b，
	 * 看短字符串b的每个字符是否都在Hashtable里，如果都存在，说明长字符串a包含短字符串b，否则，说明不包含。
	 * 再进一步，我们可以对字符串A，用位运算（26bit整数表示)计算出一个“签名”，再用B中的字符到A里面进行查找
	 * @param lo
	 * @param sh
	 * @return
	 */
	public static boolean contains1(String lo,String sh){
		if(lo==null || sh==null){
			return false;
		}
		
		int hash=0;
		for(int i=0;i<lo.length();i++){
			hash |= (1<<(lo.charAt(i)-'A'));
		}
		for (int i = 0; i < sh.length(); ++i){
	        if ((hash & (1 << (sh.charAt(i) - 'A'))) == 0){
	            return false;
	        }
	    }
		return true;
	}
	
	public static boolean isBrother(String lo,String sh){
		//TODO
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(contains1("DDFFSA", "AD"));
	}
	
}
