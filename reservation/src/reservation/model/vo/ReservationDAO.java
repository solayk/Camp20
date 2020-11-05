package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JComboBox;


public class ReservationDAO {

//	String name ; // 예약자
//	String VisitName; // 실사용자(방문자)
//	int tel;  // 전화번호
//	int peopleNumber; //인원수
//	
//	String arriveTime;  // 도착 시간
//	int price; // 금액
// --------------------------------------------
	String url;
	String user;
	String pass;
	Connection con;

	// constructor
	public ReservationDAO() throws Exception {
		connectDB();
	}

	// ###########################################################
	// DB control method

	void connectDB() throws Exception {
		/*
		 * 1. 드라이버를 드라이버메니저에 등록 2. 연결 객체 얻어오기
		 */
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@192.168.0.23:1521:orcl";
		user = "positive";
		pass = "1004";
		con = DriverManager.getConnection(url, user, pass);
	}
	
	
	/*
	 * 함수명 : Payment  //결제하다 
	 * 인자 : RevolveVO rest(미정)
	 * 반환값 : void (미정)
	 * 설명 : 화면에서 '결제완료'버튼을 눌렀을때 예약 DB에 정보가 저장된다. 
	 */
	public void Payment(ReservationVO reserve) throws Exception {
		/* 
		 *  
		 */
		String sql = "INSERT INTO reservation(reserv_no,person_no,car_no,est_arr_time,reserve_date"
				+ ",customer_id,site_no,check_in,check_out,manager_id) "
				+ "VALUES((to_char(sysdate,'YYMMDD') || to_char(seq_reserve_id.nextval)),"  // 예약 번호
				+ ""       //고객 id
				+ "?,?,?,sysdate,'qwe5507','200',sysdate,sysdate,'zxc5507'"   //미구현
				+ ") ";
		
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql); 
		
		ps.setInt(1,reserve.getPerson_no());
		ps.setString(2, reserve.getCar_no());
		ps.setString(3, reserve.getEst_arr_time());

		ps.executeUpdate(); 

		ps.close(); 
		
		return ;
	}
	
	
}
