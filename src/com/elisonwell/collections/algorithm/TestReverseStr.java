package com.elisonwell.collections.algorithm;


/**
 * 旋转字符串
 * @author duyisong
 * @createAt 2016年6月20日
 */
public class TestReverseStr {
	
	
	/**
	 * 反转字符串
	 * 如：he is a good boy
	 * 反转后：boy good a is he
	 * 
	 * 算法实现逻辑：先将每个单词反转，得到eh si a doog yob,再将整个字符串反转，得到 boy good a is he
	 * @param str
	 */
	public static String reverse(String str){
		if(str==null || str.isEmpty()){
			return "";
		}
		char[] chars = str.toCharArray();
		char[] newChars = new char[chars.length];
		int spaceIndex = 0,lowerIndex = -1;
		int j = 0; //用来指定空字符索引
		for(int i = 0;i<chars.length;i++){
			if(i==spaceIndex){
				j = i;
				while(true){
					if((++j<chars.length && chars[j]==' ') 
							|| j ==chars.length){
						lowerIndex = i>0?spaceIndex:lowerIndex; //保留上次spaceIndex的位置
						spaceIndex = j;
						break;
					}
				}
			}
			if(chars[i]==' '){
				newChars[chars.length-i-1] = ' ';
			}else{
				/*
				 * 本来这个是代码newChars[i] = chars[spaceIndex-i+lowerIndex]，
				 * 且在该迭代后还需要再迭代newChars，将newChars整个反转，这里只是将其一并做了，少了一次迭代
				 */
				newChars[chars.length-i-1] = chars[spaceIndex-i+lowerIndex];
			}
		}
		return new String(newChars);
	}
	
	/**
	 * 编写程序，在原字符串中把字符串前面的m个字符移动到字符串的尾部部，
	 * 要求：长度为n的字符串操作时间复杂度为O(n)，空间复杂度为O(1)。 
	 * 例如，原字符串为”Ilovebaofeng”，m=5，输出结果为：”baofengIlove”
	 * 
	 * 实现原理与reverse方法相同
	 * @param str
	 * @param m 
	 * @return
	 */
	public static String reverse1(String str,int m){
		if(str==null || str.isEmpty()){
			return "";
		}
		if(m<=0 || m>=str.length()){
			return str;
		}
		char[] chars = str.toCharArray();
		char[] newChars = new char[chars.length];
		int len = chars.length;
		for(int i=0;i<len;i++){
			if(m>=i+1){
				newChars[len-i-1] = chars[m-i-1];
			}else{
				newChars[len-i-1] = chars[len-i+m-1];
			}
		}
		return new String(newChars);
	}
	
	public static void main(String[] args){
//		String st = "he is a good boy";
//		System.out.println(reverse(st));
		
		String st = "Ilovebaofeng";
		System.out.println(reverse1(st,11));
	}
	
}
