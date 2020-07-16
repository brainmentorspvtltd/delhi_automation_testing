package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBC implements DBConstants{
	
	ResourceBundle rb = ResourceBundle.getBundle(CONFIG_FILE);
	ResourceBundle rb2 = ResourceBundle.getBundle(QUERY_FILE);
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;
		String url = rb.getString(DB_URL);
		String driverName = rb.getString(DRIVER);
		String userid = rb.getString(USERID);
		String password = rb.getString(PASSWORD);
		/* URLS
		 * jdbc:mysql://ip:port/database
		 * jdbc:oracle:thin:@ip:port:servicename
		 * jdbc:postgresql://ip:port/database
		 */
		//  Driver Names
		// com.mysql.cj.jdbc.Driver
		// org.postgresql.Driver
		// oracle.jdbc.driver.OracleDriver
		Class.forName(driverName);
		// Creating Connection
		con = DriverManager.getConnection(url,userid,password);
		return con;
		
	}
	
	ArrayList<Emp> read() throws ClassNotFoundException, SQLException{
		Connection con = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Emp> empList =new ArrayList<Emp>();
		Scanner scanner = new Scanner(System.in);
		try {
		
		System.out.println("Enter the Salary");
		String salary = scanner.nextLine();
		//String sql = "select id, name, salary from emp where salary>="+salary;
		String sql = rb2.getString(EMP_SALARY_QUERY);
		con = getConnection();
		//stmt = con.createStatement();
		pstmt = con.prepareStatement(sql);
		pstmt.setDouble(1, Double.parseDouble(salary));
		//rs = stmt.executeQuery(sql);
		rs = pstmt.executeQuery();
		boolean isFound = false;
		while(rs.next()) {
			isFound = true;
			empList.add(new Emp(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary")));
			//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		if(!isFound) {
			System.out.println("No Record Found...");
		}
		}
		finally {
		if(rs!=null) {	
		rs.close();
		}
		if(pstmt!=null) {
			pstmt.close();
		}
//		if(stmt!=null) {
//		stmt.close();
//		}
		if(con!=null) {
		con.close();
		}
		scanner.close();
		}
		return empList;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JDBC jdbc = new JDBC();
		ArrayList<Emp> empList = jdbc.read();
		System.out.println(empList);
	}

}
