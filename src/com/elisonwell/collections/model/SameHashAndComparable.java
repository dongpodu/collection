package com.elisonwell.collections.model;



/**
 * hashcode相同且可比较
 * @author duyisong
 * @createAt 2016年6月28日
 */
public class SameHashAndComparable 
	implements Comparable<SameHashAndComparable>{
	private int f1;

	public SameHashAndComparable(int f1) {
		super();
		this.f1 = f1;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SameHashAndComparable other = (SameHashAndComparable) obj;
		if (f1 != other.f1)
			return false;
		return true;
	}

	@Override
	public int compareTo(SameHashAndComparable o) {
		if(o==null){
			return -1;
		}
		return o.f1-this.f1;
	}
	
}
