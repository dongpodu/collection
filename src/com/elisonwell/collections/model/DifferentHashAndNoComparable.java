package com.elisonwell.collections.model;



/**
 * hashcode不同且不可比较
 * @author duyisong
 * @createAt 2016年6月28日
 */
public class DifferentHashAndNoComparable {
	private int f1;

	public DifferentHashAndNoComparable(int f1) {
		super();
		this.f1 = f1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + f1;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DifferentHashAndNoComparable other = (DifferentHashAndNoComparable) obj;
		if (f1 != other.f1)
			return false;
		return true;
	}

}
