package reservation.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import reservation.model.vo.ReservationDAO;
import reservation.model.vo.ReservationVO;
import reservation.model.vo.UserVO;

public class JP_CheckRes extends JPanel {
	//private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private JFrame_main F;
	
	ReservationVO rvo;
	
	ReservationDAO reserve_dao;
	ImageIcon imgBackground;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
	SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
	Date time = new Date();
	
	public JP_CheckRes(JFrame_main f) {
		
		try {
			reserve_dao = new ReservationDAO();
		} catch (Exception e) {
			System.out.println("DB연동 실패  : "+ e.toString());
			e.printStackTrace();
		}
		imgBackground = new ImageIcon("src/reservation/imgs/JP_Res_1.png");
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		textField = new JTextField("입금계좌 : 카카오뱅크 1112132123131 이진강");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(238, 210, 270, 21);
		textField.setEditable(false); 	
		add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("입금정보");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3.setBounds(124, 210, 102, 20);
		add(lblNewLabel_3);
		
	//	JLabel lblNewLabel_2 = new JLabel("예약확인/취소");
	//	lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
	//	lblNewLabel_2.setBounds(194, 23, 211, 30);
	//	add(lblNewLabel_2);
		
		JButton bLogin = new JButton("");
//		bLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		bLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin.setBounds(510, 23, 50, 50);
		bLogin.setContentAreaFilled(false);
		bLogin.setBorderPainted(false);
		add(bLogin);
		
//		textField_1 = new JTextField();
//		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
//		textField_1.setColumns(10);
//		textField_1.setBounds(238, 201, 222, 21);
//		add(textField_1);
		
//		JLabel lblNewLabel_3_1 = new JLabel("사용자");
//		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
//		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_3_1.setBounds(124, 202, 102, 20);
//		add(lblNewLabel_3_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		textField_2.setBounds(238, 245, 270, 21);
		textField_2.setEditable(false); 	
		add(textField_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("예약상태");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(124, 245, 102, 20);
		add(lblNewLabel_3_2);
		
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(238, 280, 270, 21);
		textField_3.setEditable(false); 
		add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("예약번호");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3.setForeground(Color.WHITE);
		lblNewLabel_3_3.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(124, 280, 102, 20);
		add(lblNewLabel_3_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(238, 315, 270, 21);
		textField_4.setEditable(false);
		add(textField_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("예약자명");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4.setForeground(Color.WHITE);
		lblNewLabel_3_4.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(124, 315, 102, 20);
		add(lblNewLabel_3_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(238, 350, 270, 21);
		textField_5.setEditable(false);
		add(textField_5);
		
		JLabel lblNewLabel_3_5 = new JLabel("핸드폰");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_5.setForeground(Color.WHITE);
		lblNewLabel_3_5.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(124, 350, 102, 20);
		add(lblNewLabel_3_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(10);
		textField_6.setBounds(238, 385, 270, 21);
		textField_6.setEditable(false);
		add(textField_6);
		
		JLabel lblNewLabel_3_6 = new JLabel("도착예정시간");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_6.setForeground(Color.WHITE);
		lblNewLabel_3_6.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(124, 385, 102, 20);
		add(lblNewLabel_3_6);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(238, 420, 270, 21);
		textField_7.setEditable(false);
		add(textField_7);
		
		JLabel lblNewLabel_3_7 = new JLabel("요청사항");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_7.setForeground(Color.WHITE);
		lblNewLabel_3_7.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblNewLabel_3_7.setBounds(124, 420, 102, 20);
		add(lblNewLabel_3_7);
		
		JButton bLogin_1 = new JButton("예약취소");
		bLogin_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin_1.setBounds(238, 501, 97, 23);
		add(bLogin_1);
		
		JLabel lblNewLabel = new JLabel("사이트명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(66, 120, 60, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1.setBounds(66, 145, 60, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("예약일");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_4.setBounds(149, 120, 60, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(130, 145, 100, 15);//57
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("기간");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_5.setBounds(280, 120, 60, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(230, 145, 190, 15);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("인원");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_6.setBounds(410, 120, 60, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(410, 145, 60, 15);    // 337
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_7 = new JLabel("요금");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_7.setBounds(460, 120, 60, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(460, 145, 60, 15);   // 427
		add(lblNewLabel_1_4);
		
		rvo = new ReservationVO();
		
		if(UserVO.getReserv_no() != null) {
		rvo = reserve_dao.SettingRes(UserVO.getReserv_no());
		
		}
		
		
//		System.out.println("날짜 :" +rvo.getReserve_date().substring(0,10));
		lblNewLabel_1.setText(rvo.getSite_type());
		lblNewLabel_1_1.setText(rvo.getReserve_date());
		lblNewLabel_1_2.setText(rvo.getCheck_in() +" ~ "+rvo.getCheck_out());
		lblNewLabel_1_3.setText(Integer.toString(rvo.getPerson_no()));
		lblNewLabel_1_4.setText(Integer.toString(rvo.getPrice()));
		
		//textField.setText();
		textField_2.setText(rvo.getStatus());
		textField_3.setText(rvo.getReserv_no());
		textField_4.setText(rvo.getCustomer_name());
		textField_5.setText(rvo.getTel());
		textField_6.setText(rvo.getEst_arr_time());
		textField_7.setText(rvo.getRequestTerm());
		
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toMainMenu(); 
			}
		});
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "예약취소" 버튼 클릭 시 동작 설정
		 */
		bLogin_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				//F.toLogin(); 
				try {
					System.out.println(rvo.getCheck_in()); // 체크인날짜 
					//Date tempDate = dateFormat1.parse(rvo.getCheck_in());
					String tempCheckTime = rvo.getCheck_in();
					System.out.println(tempCheckTime);
					//현재날짜
					Date nowTime = new Date();				//현재 날짜 
 
					Calendar cal = Calendar.getInstance();
					cal.set(Calendar.YEAR, Integer.parseInt(tempCheckTime.substring(0, 4))); // 년도 지정 
					cal.set(Calendar.MONTH, Integer.parseInt(tempCheckTime.substring(5,7))-1); // 월 지정 
					cal.set(Calendar.DATE, Integer.parseInt(tempCheckTime.substring(8,10))); // 일 지정 
					Date checkTime = new Date(cal.getTimeInMillis());   // 캘린더타입을 date타입으로
					System.out.println("check in time: "+ checkTime);
					System.out.println("Now in time: "+ nowTime);
					cal.add(Calendar.DATE, -3);
					Date checkTime_Minus3 = new Date(cal.getTimeInMillis());   // 체크인기준 3일뺀것 [순서바꾸지마시오절대절대절대 ]
					System.out.println(" check -3 time : "+ checkTime_Minus3);
					cal.add(Calendar.DATE, -4);
					Date checkTime_Minus7 = new Date(cal.getTimeInMillis());   // 체크인기준 7일뺀것 [순서바꾸지마시오절대절대절대 ]
					System.out.println(" check -7 time : "+ checkTime_Minus7);
//					 date1.compare(date2)  -> date1이 date2보다 큰날이면 1리턴  / date1이 date2보다 작은날이면 -1 리턴 / 같으면 0리턴 
					//현재시간과 체크인 7일전 비교
					int compare = nowTime.compareTo(checkTime_Minus7);
					System.out.println(compare);
					//현재시간과 체크일 3일전 비교 
					int compare1 = nowTime.compareTo(checkTime_Minus3);
					System.out.println(compare1);
					int compare2 = nowTime.compareTo(checkTime);
					System.out.println(compare2);
					
					
					if(compare == -1) { 						//현재일이 체크인 7일전보다 적을때
						System.out.println(" 100 % 환불"); 		  
					}else if(compare == 1 && compare1 == -1 ) {
						System.out.println(" 80 % 환불");
					}else if(compare1 == 1 && compare2 == -1 ) {
						System.out.println(" 50 % 환불");
					}else {
						System.out.println("현재일이 체크인날짜과 같거나 체크인날짜가 과거일때 / 취소불가 ");
					}
					
					
				System.out.println(rvo.getStatus());   // 예약 상태 
				
				if(rvo.getStatus().equals("입금대기")) {  // 입금 대기중이라면 
					int reply = JOptionPane.showConfirmDialog(null, "예약을 취소하시겠습니까? ", "예약 취소", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						
						reserve_dao.resCancle(textField_3.getText());
						
						JOptionPane.showMessageDialog(null,"취소되었습니다.","취소완료",JOptionPane.INFORMATION_MESSAGE);
						F.toJP_CheckResNo();    //  JP_CheckResNo페이지로 이동 [뒤로가기]
					}
				}else if(rvo.getStatus().equals("본인취소")) {
					JOptionPane.showMessageDialog(null,"이미 취소상태 입니다.","",JOptionPane.INFORMATION_MESSAGE);
					
				}else if(rvo.getStatus().equals("예약불가")) {
					JOptionPane.showMessageDialog(null,"관리자에 의해 취소된 예약입니다.","",JOptionPane.INFORMATION_MESSAGE);
				}else if(rvo.getStatus().equals("이용완료")) {
					JOptionPane.showMessageDialog(null,"이미 이용하신 예약입니다.","",JOptionPane.INFORMATION_MESSAGE);
				}else if(rvo.getStatus().equals("예약확정")) {
					if(compare == -1) { 				
						//현재일이 체크인 7일전보다 적을때
						int reply1 = JOptionPane.showConfirmDialog(null, "100% 환불 가능 합니다, 취소하시겠습니까? ", "예약 취소", JOptionPane.YES_NO_OPTION);
						if (reply1 == JOptionPane.YES_OPTION) {
							
							reserve_dao.resCancle(textField_3.getText());
							
							JOptionPane.showMessageDialog(null,"취소되었습니다.","취소완료",JOptionPane.INFORMATION_MESSAGE);
							F.toJP_CheckResNo();    //  JP_CheckResNo페이지로 이동 [뒤로가기]
						}
					}else if(compare == 1 && compare1 == -1 ) {
						int reply2 = JOptionPane.showConfirmDialog(null, "80% 환불 가능 합니다, 취소하시겠습니까? ", "예약 취소", JOptionPane.YES_NO_OPTION);
						if (reply2 == JOptionPane.YES_OPTION) {
							
							reserve_dao.resCancle(textField_3.getText());
							
							JOptionPane.showMessageDialog(null,"취소되었습니다.","취소완료",JOptionPane.INFORMATION_MESSAGE);
							F.toJP_CheckResNo();    //  JP_CheckResNo페이지로 이동 [뒤로가기]
						}
					}else if(compare1 == 1 && compare2 == -1 ) {
						int reply3 = JOptionPane.showConfirmDialog(null, "50% 환불 가능 합니다, 취소하시겠습니까? ", "예약 취소", JOptionPane.YES_NO_OPTION);
						if (reply3 == JOptionPane.YES_OPTION) {
							
							reserve_dao.resCancle(textField_3.getText());
							
							JOptionPane.showMessageDialog(null,"취소되었습니다.","취소완료",JOptionPane.INFORMATION_MESSAGE);
							F.toJP_CheckResNo();    //  JP_CheckResNo페이지로 이동 [뒤로가기]
						}
					}else {
						JOptionPane.showMessageDialog(null,"취소가 불가능합니다.","",JOptionPane.INFORMATION_MESSAGE);
						System.out.println("현재일이 체크인날짜과 같거나 체크인날짜가 과거일때 / 취소불가 ");
					}
					
					
					
				}
				} catch (Exception e) {
					System.out.println("취소 실패 : " + e.toString());
					e.printStackTrace();
				}
					
				}
		});
	}
	/*
	 * 함수명: paintComponent
	 * 역할: 배경이미지 설정
	 */
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);

		  g.drawImage(imgBackground.getImage(), 0, 0, this);
	}
//	/*
//	 * 역할 : 들어온 예약번호로 예약내용들을 세팅하는 함수 
//	 */
//	public void resSetting (String resNum) {
//		ReservationDAO vo = new ReservationDAO();
//		
//		
//		
//		
//	}
}
