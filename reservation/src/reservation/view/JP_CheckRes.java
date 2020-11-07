package reservation.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	ReservationDAO reserve_dao;
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
	
	public JP_CheckRes(JFrame_main f) {
		
		try {
			reserve_dao = new ReservationDAO();
		} catch (Exception e) {
			System.out.println("DB연동 실패  : "+ e.toString());
			e.printStackTrace();
		}
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		textField = new JTextField("입금계좌 : 카카오뱅크 1112132123131 이진강");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(238, 180, 270, 21);
		textField.setEditable(false); 	
		add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("입금정보");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(124, 180, 102, 20);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("예약확인/취소");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(194, 23, 211, 30);
		add(lblNewLabel_2);
		
		JButton bLogin = new JButton("홈");
//		bLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
		bLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin.setBounds(457, 23, 97, 23);
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
		textField_2.setBounds(238, 215, 270, 21);
		textField_2.setEditable(false); 	
		add(textField_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("예약상태");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(124, 215, 102, 20);
		add(lblNewLabel_3_2);
		
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setColumns(10);
		textField_3.setBounds(238, 250, 270, 21);
		textField_3.setEditable(false); 
		add(textField_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("예약번호");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_3.setBounds(124, 250, 102, 20);
		add(lblNewLabel_3_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.LEFT);
		textField_4.setColumns(10);
		textField_4.setBounds(238, 285, 270, 21);
		textField_4.setEditable(false);
		add(textField_4);
		
		JLabel lblNewLabel_3_4 = new JLabel("예약자명");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_4.setBounds(124, 285, 102, 20);
		add(lblNewLabel_3_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setColumns(10);
		textField_5.setBounds(238, 320, 270, 21);
		textField_5.setEditable(false);
		add(textField_5);
		
		JLabel lblNewLabel_3_5 = new JLabel("핸드폰");
		lblNewLabel_3_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_5.setBounds(124, 320, 102, 20);
		add(lblNewLabel_3_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.LEFT);
		textField_6.setColumns(10);
		textField_6.setBounds(238, 355, 270, 21);
		textField_6.setEditable(false);
		add(textField_6);
		
		JLabel lblNewLabel_3_6 = new JLabel("도착예정시간");
		lblNewLabel_3_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_6.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_6.setBounds(124, 355, 102, 20);
		add(lblNewLabel_3_6);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.LEFT);
		textField_7.setColumns(10);
		textField_7.setBounds(238, 390, 270, 21);
		textField_7.setEditable(false);
		add(textField_7);
		
		JLabel lblNewLabel_3_7 = new JLabel("요청사항");
		lblNewLabel_3_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_7.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_7.setBounds(124, 390, 102, 20);
		add(lblNewLabel_3_7);
		
		JButton bLogin_1 = new JButton("예약취소");
		bLogin_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin_1.setBounds(238, 471, 97, 23);
		add(bLogin_1);
		
		JLabel lblNewLabel = new JLabel("사이트명");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 100, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(66, 125, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("예약일");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(149, 100, 57, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(130, 125, 100, 15);//57
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("기간");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(280, 100, 57, 15);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("New label");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(230, 125, 150, 15);
		add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("인원");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(390, 100, 57, 15);
		add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_3 = new JLabel("New label");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(390, 125, 57, 15);    // 337
		add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_7 = new JLabel("요금");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(440, 100, 57, 15);
		add(lblNewLabel_7);
		
		JLabel lblNewLabel_1_4 = new JLabel("New label");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setBounds(440, 125, 57, 15);   // 427
		add(lblNewLabel_1_4);
		
		ReservationVO rvo = new ReservationVO();
		
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
				F.toLogin(); 
			}
		});
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "예약취소" 버튼 클릭 시 동작 설정
		 */
		bLogin_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toLogin(); 
			}
		});
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
