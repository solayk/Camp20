package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import reservation.model.vo.CustomerVO;

public class RegisterDAO {
	
	public RegisterDAO() throws Exception{
		connectDB();
	}
	
	
	Connection con;

	String url = "jdbc:oracle:thin:@192.168.0.23:1521:orcl";
	String user = "positive";
	String pass = "1004";

	
	void connectDB() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, pass);
	}



//	회원가입 _201103 원우
	public void regist(CustomerVO customer) throws SQLException {
		
		String sql = "INSERT INTO customer(customer_id, tel, customer_pw, name, email, addr) VALUES(?, ?, ?, ?, ?, ?)";
		System.out.println(sql);
		
		PreparedStatement gaib = con.prepareStatement(sql);
		
		gaib.setString(1, customer.getMemberID());
		gaib.setString(2, customer.getMemberTel());
		gaib.setString(3, customer.getMemberPw());
		gaib.setString(4, customer.getMemberName());
		gaib.setString(5, customer.getMemberEmail());
		gaib.setString(6, customer.getMemberAddr());
		
		
		gaib.executeUpdate();
		
		gaib.close();
		
	}
	
	
	
//	ID중복 확인 _201103 원우
	public int overlapDeny(CustomerVO customer) throws Exception {
		
		int a = 0;
		
		String sql = "INSERT INTO customer(customer_id, tel, customer_pw, name, email, addr) VALUES(?, ?, ?, ?, ?, ?)";
		
		PreparedStatement gaib = con.prepareStatement(sql);
		
		int result = gaib.executeUpdate();
		if(result>0) {
			
		}
		
		return a;
		
		
	}
	
	
}

