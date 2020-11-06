package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.*;

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
				+ ",customer_id,site_no,check_in,check_out,requestedterm,manager_id) "
				+ "VALUES((to_char(sysdate,'YYMMDD') || to_char(seq_reserve_id.nextval)),"  // 예약 번호
				+ ""       //고객 id
				+ "?,?,?,sysdate,'qwe5507',?,?,?+?,?,'zxc5507'"   //id / 매니저 id 미구현
				+ ") ";
		
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql); 
		
		ps.setInt(1,reserve.getPerson_no());         						//인원수
		ps.setString(2, reserve.getCar_no());  		  						//차번호
		ps.setString(3, reserve.getEst_arr_time());   						//도착예정시간
		ps.setString(4, UserVO.getSite_no());         						//사이트넘버
		ps.setDate(5,  new java.sql.Date(UserVO.getCheck_in().getTime()));  //체크인 //sql
		ps.setDate(6,  new java.sql.Date(UserVO.getCheck_in().getTime()));  //체크아웃  (체크인+숙박일)
		ps.setInt(7, (Integer)UserVO.getStayDays());						//숙박일
		ps.setString(8, reserve.getRequestTerm());         					//요청사항 
		
		ps.executeUpdate(); 

		ps.close(); 
		

	}
	
	/*
	 * 함수명: CheckAvailable
	 * 역할: JP_Cal에서 "예약조회"버튼 클릭시 사이트 남은 자리 확인 목적 
	 * 작성자: 김영권
	 */
	public ArrayList CheckAvailable (Date selectedDate) throws Exception{
		
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();
		
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		
		String sql = null;
		int StayDays = UserVO.getStayDays();
		
		switch(StayDays) {
			case 1:
				sql = "SELECT site_no, check_in, check_out\r\n" + 
						" FROM reservation\r\n" + 
						" WHERE ((check_in = ? OR check_out-1 = ?)\r\n" + 
						" 		OR (check_in = ? OR check_out-1 = ?))\r\n" +
						" 		AND status IN ('입금대기','예약확정')"
						;
				break;
			case 2:
				sql = "SELECT site_no, check_in, check_out\r\n" + 
						" FROM reservation\r\n" + 
						" WHERE ((check_in = ? OR check_out-1 = ?) \r\n" + 
						" 		OR (check_in = ?+1 OR check_out-1 = ?+1))\r\n" + 
						"    	AND status IN ('입금대기','예약확정')"
						;
		}
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs;
		
		st.setDate(1, sqlDate);
		st.setDate(2, sqlDate);
		st.setDate(3, sqlDate);
		st.setDate(4, sqlDate);
		
		rs = st.executeQuery();
		
		while(rs.next()) {
			ReservationVO vo = new ReservationVO();
			vo.setSite_no(rs.getString("site_no"));			
			vo.setCheck_in(rs.getString("check_in"));			
			vo.setCheck_out(rs.getString("check_out"));			
			list.add(vo);
		}
		
		st.close();
		
		return list;
	}

	
}
