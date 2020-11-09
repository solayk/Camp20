package reservation.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				+ ",customer_id,site_no,check_in,check_out,requestedterm,manager_id,price) "
				+ "VALUES((to_char(sysdate,'YYMMDD') || to_char(seq_reserve_id.nextval)),"  // 예약 번호
				+ ""       //고객 id
				+ "?,?,?,sysdate,?,?,?,?+?,?,'zxc5507',?"   // 매니저 id 미구현
				+ ") ";
		
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql); 
		
		ps.setInt(1,reserve.getPerson_no());         						//인원수
		ps.setString(2, reserve.getCar_no());  		  						//차번호
		ps.setString(3, reserve.getEst_arr_time());   						//도착예정시간
		
		ps.setString(4, UserVO.getCustomer_id());   						//ID
		
		ps.setString(5, UserVO.getSite_no());         						//사이트넘버
		ps.setDate(6,  new java.sql.Date(UserVO.getCheck_in().getTime()));  //체크인 //sql
		ps.setDate(7,  new java.sql.Date(UserVO.getCheck_in().getTime()));  //체크아웃  (체크인+숙박일)
		ps.setInt(8, (Integer)UserVO.getStayDays());						//숙박일
		ps.setString(9, reserve.getRequestTerm());         					//요청사항 
		ps.setInt(10, reserve.getPrice());									//숙박일
		
		
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
	
	/*
	 * 함수명  : SetName_Tel
	 * 인자 : ?
	 * 반환값 : ?
	 * 역할 : id값으로 Name과 Tel을 셋팅하기위한 용도  
	 * 
	 */
	public ReservationVO SetName_Tel(String Customer_id) throws Exception {
		ResultSet rs;

		String sql = "SELECT name,tel FROM customer WHERE customer_id = ?";
		
		System.out.println(sql);
		
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setString(1, Customer_id);  		  				
		
		rs = ps.executeQuery();
		
		ReservationVO vo = new ReservationVO();
		
		if(rs.next()) {
			vo.setCustomer_name(rs.getString("name"));
			vo.setTel(rs.getString("tel"));
		}
		return vo;
	}
	
	/*
	 * 함수명  : CheckResList
	 * 인자 : ?
	 * 반환값 : ?
	 * 역할 : id값으로 예약내역을 Jtable에 출력하기위한 함수 
	 * 
	 */
	public ArrayList CheckResList(String Customer_id) throws Exception {
		ResultSet rs;

		String sql = "SELECT reserv_no,reserve_date,check_in,check_out,status FROM reservation WHERE customer_id = ?";
		
		System.out.println(sql);
		
		PreparedStatement ps = con.prepareStatement(sql); 
		ps.setString(1, Customer_id);  		  				
		
		rs = ps.executeQuery();
		
		ArrayList list = new ArrayList();
		while(rs.next()) {
			ArrayList aa = new ArrayList();
			aa.add(rs.getString("reserv_no"));
			aa.add(rs.getDate("reserve_date"));
			aa.add(rs.getDate("check_in"));
			aa.add(rs.getDate("check_out"));
			aa.add(rs.getString("status"));
			
			list.add(aa);
		}
		
		return list;
	}
	/*
	 * 역할 : 예약번호로 CheckRes페이지를 세팅 한다. 
	 * 
	 */
	public ReservationVO SettingRes(String resNum) {
		ReservationVO vo = new ReservationVO();
		ResultSet rs;
		
		try {
			String sql = "SELECT * FROM reservation r, customer c ,site s WHERE r.customer_id=c.customer_id and  r.site_no=s.site_no and reserv_no = ?";
			System.out.println(sql);
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, resNum); 	
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setSite_type(rs.getString("site_type"));
				
				//TODO 선생님한테 물어볼것
//				vo.setReserve_date(rs.getString("reserve_date").substring(0,10));
				String resDate = rs.getString("reserve_date");			
				vo.setReserve_date(resDate.substring(0,10));
				String chInDate = rs.getString("check_in");	
				vo.setCheck_in(chInDate.substring(0,10));
				String chOutDate = rs.getString("check_out");
				vo.setCheck_out(chOutDate.substring(0,10));
				
				vo.setPerson_no(rs.getInt("person_no"));
				vo.setPrice(rs.getInt("price"));
				vo.setStatus(rs.getString("status"));
				vo.setReserv_no(rs.getString("reserv_no"));
				vo.setCustomer_name(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setEst_arr_time(rs.getString("est_arr_time"));
				vo.setRequestTerm(rs.getString("requestedterm"));

			}
			
		} catch (SQLException e) {
			System.out.println("무슨예외인지 알고싶지않아 ");
			e.printStackTrace();
		} 
		return vo;
	}
	/*
	 * 함수명 : resCancle()
	 * 역할 : 예약취소했을때 예약번호를 인자로 받아 예약번호로 Reservation테이블의 status 상태를 '본인취소'로바꾸는 함수
	 */
	public void resCancle(String resNum) throws Exception {
		ReservationVO vo = new ReservationVO();
		
		String sql = "UPDATE  reservation  SET  status='본인취소'  WHERE  reserv_no = ?";
		
		System.out.println(sql);
		PreparedStatement ps = con.prepareStatement(sql); 
		
		ps.setString(1, resNum);  
		
		
		ps.executeUpdate(); 

		ps.close(); 
		
	}
	
	
}
