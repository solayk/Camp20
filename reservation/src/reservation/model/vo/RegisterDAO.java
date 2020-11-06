package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	//
	//
	//
	public int chk_idpw(String id, String pw) throws Exception {
		
		String sql1 = "SELECT * \r\n" + 
				" FROM CUSTOMER\r\n" + 
				" WHERE customer_id = ? \r\n" 
				;
		
		PreparedStatement st1 = con.prepareStatement(sql1);
		ResultSet rs1;
		
		st1.setString(1, id);
		
		rs1 = st1.executeQuery();
		
		String chk_id_only = null;
		
		while(rs1.next()) {
			chk_id_only = rs1.getString("CUSTOMER_ID");
		}
		
		// 아이디 존재여부 확인 => 만일 chk_id_only가 null이면 없는 id 
		if(chk_id_only != null) {
			System.out.println("아이디 존재함");
			
			String sql2 = "SELECT * \r\n" + 
					" FROM CUSTOMER\r\n" + 
					" WHERE customer_id = ? AND customer_pw = ? \r\n" 
					;
			PreparedStatement st2 = con.prepareStatement(sql2);
			ResultSet rs2;
			
			st2.setString(1, id);
			st2.setString(2, pw);
			
			rs2 = st2.executeQuery();
			
			String chk_both = null;
			
			while(rs2.next()) {
				chk_both = rs2.getString("CUSTOMER_ID");
			}
				if(chk_both != null) return 1; // 아이디 비밀번호 일치 = 로그인 성공
				else return 3;	// 에러: 아이디 비밀번호 불일치			
		}
		else return 2; // 에러: 아이디 존재하지 않음
		
	}
}

