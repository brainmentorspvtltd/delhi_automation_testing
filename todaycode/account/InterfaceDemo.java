package com.brainmentors.cms.account;

// abstract interface DBOperation{
interface DBOperation{
	int MAX = 100;  // public static int MAX =100;
	int add(); // public abstract int add();
	boolean delete();
	int [] read();
	boolean update();
}
interface Trans{
	int count();
	boolean status();
}
interface DBTrans extends DBOperation, Trans{
	int commit();
}
abstract class CommonDBOperation{
	void auth() {
		
	}
	void close() {
		
	}
}
class PosGres extends CommonDBOperation implements DBTrans{

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean status() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int commit() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class Oracle implements DBOperation, Trans{

	int volume() {
		return 0;
	}
	
	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean status() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
class MySQL implements DBOperation{

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] read() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
class DbCaller{
	void dbCall(DBOperation opr){
		opr.add();
		opr.delete();
		opr.read();
		opr.update();
		
	}
}
public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DbCaller caller = new DbCaller();
		caller.dbCall(new Oracle());
		caller.dbCall(new MySQL());
		

	}

}
