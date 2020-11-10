package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {     // 세 DAO 가 DBCon에 연결하고 DBCon이 DB에 한번 연결되게 하기위한 용도의 클래스 
						// 싱글톤 패턴 

	static Connection con; // static메소드는 static만 접근할수있기때문에  static
	String url;
	String user;
	String pass;
	private  DBCon() throws Exception {
		url = "jdbc:oracle:thin:@192.168.0.23:1521:orcl";
		user = "positive";
		pass = "1004";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, pass);
	}
	public static Connection getInstance() throws Exception {  // 객체가없어도 접근할수있게끔 static 
		if(con == null) new DBCon(); // con이 null이아닐때만 con을 리턴한다. 
		return con;
	}
}
 