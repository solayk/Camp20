package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin_2member_DAO {
	
	String url;
	String user;
	String pass;
	Connection con;
	
	public Admin_2member_DAO() throws Exception {
		con = DBCon.getInstance();
	}


	public ArrayList mStatus(String cb, String tf) throws Exception {
		
		PreparedStatement st = null;
		
		if(tf.length()==0) {
			String sqlNull =
					"SELECT customer_id, name, tel, email, addr "
					+ " FROM customer "
					;
			
			st = con.prepareStatement(sqlNull);
					
		}
		
		else if(cb.equals("ID")) {
			
			String sqlId =
					"SELECT customer_id, name, tel, email, addr "
					+ " FROM customer "
					+ " WHERE customer_id = ?"
					;
			
			st = con.prepareStatement(sqlId);
			st.setString(1, tf);
		}
		
		else if(cb.equals("이름")) {
			String sqlName =
					"SELECT customer_id, name, tel, email, addr "
					+ " FROM customer "
					+ " WHERE name = ?"
					;
			
			st = con.prepareStatement(sqlName);
			st.setString(1, tf);
			
		}
		
		
		else if(cb.equals("전화번호")) {
			String sqlTel =
					"SELECT customer_id, name, tel, email, addr "
					+ " FROM customer "
					+ " WHERE tel = ?"
					;
			
			st = con.prepareStatement(sqlTel);
			st.setString(1, tf);
			
		}
		
		else if(cb.equals("e-mail")) {
			String sqlMail =
					"SELECT customer_id, name, tel, email, addr "
					+ " FROM customer "
					+ " WHERE email = ?"
					;
			
			st = con.prepareStatement(sqlMail);
			st.setString(1, tf);
			
		}
		
		ResultSet rs = st.executeQuery();
		
		ArrayList data = new ArrayList();
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("customer_id"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("email"));
			temp.add(rs.getString("addr"));
			
			data.add(temp);
		}
		
		rs.close();
		st.close();
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
}
