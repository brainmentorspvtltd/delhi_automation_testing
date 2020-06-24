class A1{
	 static class B1{
		
	}
}
class User{
	/***
	 * @see A.print
	 */
	@Deprecated
	void show() {
		
	}
	 static int count; // Class Variables Class Loading
	private String userid; // Instance Variables
	private String password;
	User(String userid, String password){
		this.userid = userid;
		this.password = password;
		count++;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
public class StaticDemo {

	//@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		
		if(10>2) {
			User amit = new User("amit","777");
			//int m = 100;
		}
		//amit.getPassword();
		
		System.out.println("Inside Main");
		System.out.println(User.count);
		User amit = new User("amit","777");
		User ram = new User("ram","222");
		System.out.println("Total Users we Have "+User.count);
		Class.forName("").newInstance();

	}

}
