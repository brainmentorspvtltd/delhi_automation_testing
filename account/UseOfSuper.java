package com.brainmentors.cms.account;

class X{
	int a ;
	X(){
		a = 10;
		System.out.println("X Cons Call "+a);
	}
	X(int a){
		this();
		this.a = a;
		System.out.println("X Param Cons call "+a);
	}
}
class Y extends X{
	int a ;
	Y(){
		super(2000);
		// super();
		a= 20;
		a = super.a + 10;
		System.out.println("Y Cons Call "+a);
	}
	Y(int a){
		this();
		// super();
		this.a = a;
		System.out.println("Y Param XCons call");
	}
}
class Z extends Y{
	int a ;
	Z(){
		super(1000);
		// super();
		a = 30; // this.a = 30;
		//a = a + super.a + ((X)this).a;
		a = a + ((Y)this).a + ((X)this).a;
		//a = super.a + 
		System.out.println("Z Cons call ------- "+a);
	}
	Z(int a){
		this();
		// super();
		this.a = a;
		System.out.println("Z Param Cons Call "+a);
	}
}
public class UseOfSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Z z =new Z(100);

	}

}
