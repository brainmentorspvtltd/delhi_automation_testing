package com.brainmentors.cms.account;

class Demo1{
	public int add(int x, int y) {
		return x + y;
	}
	protected int add(int x, int y,int z) {
		return x + y + z;
	}
	long add(long x, long y) {
		return x + y;
	}
	double add(int x, double y) {
		return x + y;
	}
}
public class OverloadingRules {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo1 obj = new Demo1();
		int z =obj.add(100, 200, 300);
		System.out.println(z);

	}

}
