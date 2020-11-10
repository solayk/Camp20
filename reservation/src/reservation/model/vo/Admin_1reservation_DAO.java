package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import reservation.view.JP_Admin_1reservation;

public class Admin_1reservation_DAO {
	
	
	String url;
	String user;
	String pass;
	Connection con;
	
	public Admin_1reservation_DAO() throws Exception {
		con = DBCon.getInstance();
	}
	
	public void changeStatus(Object cc, Object cs){
		
		String sql = "UPDATE reservation "
				+ " SET status = ? "
				+ " WHERE reserv_no = ?"
				;
		
		try {
			PreparedStatement st;
			st = con.prepareStatement(sql);

			st.setString(1, cs.toString());
			st.setString(2, cc.toString());
			
			st.executeUpdate();
			st.close();
			System.out.println("변경ㅇ");
		
		} catch (SQLException e) {
			System.out.println("변경X : " + e.toString());
			e.printStackTrace();
		}
	}
	
	public ArrayList rStatus(String cb, String tf) throws Exception {
		
		PreparedStatement st = null;
		
		if(tf.length()==0) {
			String nullSql =
					"SELECT r.reserv_no reserve_no, c.customer_id customer_id, c.name name, c.tel tel, r.site_no site_no, "
							+ " r.person_no person_no, r.reserve_date reserve_date, r.check_in check_in, r.check_out check_out, "
							+ " r.car_no car_no, r.est_arr_time arr_time, r.status status "
							+ " FROM customer c INNER JOIN reservation r "
							+ " ON c.customer_id = r.customer_id "
							;
			
			st = con.prepareStatement(nullSql);
		}
		
		
//		만약 콤보박스가 예약번호일 경우
//		if(reserveChoiceBox().getSelectedItem().toString().equals("예약번호")) {	> 아주생쑈를함
		else if(cb.equals("예약번호")) {
			String rNumSql = 
//				"SELECT r.reserv_no \"예약번호\", c.name \"이름\", c.tel \"전화번호\", r.site_no \"사이트 번호\", "
//						+ " r.person_no \"투숙인원수\", r.reserve_date \"예약일\", r.check_in \"체크인\", r.check_out \"체크아웃\", "
//						+ " r.car_no \"차량번호\", r.est_arr_time \"도착예정시간\", r.status \"예약상태\" "
				"SELECT r.reserv_no reserve_no, c.customer_id customer_id, c.name name, c.tel tel, r.site_no site_no, "
						+ " r.person_no person_no, r.reserve_date reserve_date, r.check_in check_in, r.check_out check_out, "
						+ " r.car_no car_no, r.est_arr_time arr_time, r.status status "
				+ " FROM customer c INNER JOIN reservation r "
				+ " ON c.customer_id = r.customer_id "
				+ " WHERE r.reserv_no = ? "
				;
			
			st = con.prepareStatement(rNumSql);
			st.setString(1, tf);
			
		}
		
//		만약 콤보박스가 예약자명일 경우
		else if(cb.equals("예약자명")) {
			String nameSql = 
				"SELECT r.reserv_no reserve_no, c.customer_id customer_id, c.name name, c.tel tel, r.site_no site_no, "
						+ " r.person_no person_no, r.reserve_date reserve_date, r.check_in check_in, r.check_out check_out, "
						+ " r.car_no car_no, r.est_arr_time arr_time, r.status status "
				+ " FROM customer c INNER JOIN reservation r "
				+ " ON c.customer_id = r.customer_id "
				+ " WHERE c.name = ? "
				;
		
			st = con.prepareStatement(nameSql);
			st.setString(1, tf);
			
		}
		
//		만약 콤보박스가 전화번호일 경우
		else if(cb.equals("전화번호")) {
		String telSql = 
				"SELECT r.reserv_no reserve_no, c.customer_id customer_id, c.name name, c.tel tel, r.site_no site_no, "
						+ " r.person_no person_no, r.reserve_date reserve_date, r.check_in check_in, r.check_out check_out, "
						+ " r.car_no car_no, r.est_arr_time arr_time, r.status status "
				+ " FROM customer c INNER JOIN reservation r "
				+ " ON c.customer_id = r.customer_id "
				+ " WHERE c.tel = ? "
				;
			
			st = con.prepareStatement(telSql);
			st.setString(1, tf);
		
		}
		
//		만약 콤보박스가 예약상태일 경우
		else if(cb.equals("예약상태")) {
		String rStatusSql = 
				"SELECT r.reserv_no reserve_no, c.customer_id customer_id, c.name name, c.tel tel, r.site_no site_no, "
						+ " r.person_no person_no, r.reserve_date reserve_date, r.check_in check_in, r.check_out check_out, "
						+ " r.car_no car_no, r.est_arr_time arr_time, r.status status "
				+ " FROM customer c INNER JOIN reservation r "
				+ " ON c.customer_id = r.customer_id "
				+ " WHERE r.status = ? "
				;
		
			st = con.prepareStatement(rStatusSql);
			st.setString(1, tf);
			
		}

		
		ResultSet rs = st.executeQuery();
		
		ArrayList data = new ArrayList();
		
		while(rs.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rs.getString("reserve_no"));
			temp.add(rs.getString("customer_id"));
			temp.add(rs.getString("name"));
			temp.add(rs.getString("tel"));
			temp.add(rs.getString("site_no"));
			temp.add(rs.getString("person_no"));
			temp.add(rs.getString("reserve_date"));
			temp.add(rs.getString("check_in"));
			temp.add(rs.getString("check_out"));
			temp.add(rs.getString("car_no"));
			temp.add(rs.getString("arr_time"));
			temp.add(rs.getString("status"));
			
			data.add(temp);
		}
		
		rs.close();
		st.close();
		
		return data;		
	}
	
	
	
	
	
	
	
	
	
}
