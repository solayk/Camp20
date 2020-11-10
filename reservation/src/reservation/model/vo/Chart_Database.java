package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Chart_Database {
	
//	String url = "jdbc:oracle:thin:@192.168.0.23:1521:orcl";
//	String user = "positive";
//	String pass = "1004";
	String url;
	String user;
	String pass;
	Connection con;


	public ArrayList<ArrayList> getData() {
		
		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		
		try {
//			con = DBCon.getInstance();
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con = DriverManager.getConnection(url, user, pass);
			con = DBCon.getInstance();
			
			//=======================================================
			/**
			 * SQL문장
			 * 1) 월
			 */
			String sql = "SELECT to_char(check_in, 'YYYY-MM') MON, SUM(PRICE)"
					+ " FROM RESERVATION "
					+ " WHERE (check_in>='20/01/01' AND check_in<='20/12/31') AND STATUS IN('이용완료','예약확정') "
					+ " GROUP BY to_char(check_in, 'YYYY-MM') "
					+ " ORDER BY MON "
					;
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ArrayList temp = new ArrayList();
				temp.add(rs.getString("MON"));
				temp.add(rs.getInt("SUM(PRICE)"));
				data.add(temp);
				
			}
			rs.close();
			ps.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("Chart_Database/ getData/ 에러: " + e.toString());
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	
	
	
	

}







