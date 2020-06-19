package com.brainmentors.cms.account;

class A1{
	int x,y,z;
	A1(){
		x = 10;
		y = 20;
		z = 30;
	}
}
class B1 extends A1{
	int m ;
	B1(){
		m = 1000;
	}
}

class X1{
	protected A1 show() {
		System.out.println("X Show");
		return new A1();
	}
}
class Y1 extends X1{
	@Override
	 public B1 show() {
		System.out.println("Y Show");
		return new B1();
	}
	
}
public class OverridingRules {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		X1 obj = new Y1();
		obj.show();

	}

}
