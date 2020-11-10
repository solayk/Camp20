package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import reservation.model.vo.ReservationDAO;
import reservation.model.vo.ReservationVO;
import reservation.model.vo.UserVO;

public class JP_Reserve extends JPanel {

	JTextField tfName, tfTel, tfCarNo, tfPrice , tfRequest;
	JButton bToLogin, bRegist; 
	
	//static ReservationVO vo;
	ReservationVO vo;
	
	JFrame_main F; 
	
	private JComboBox personNumComboBox;
	private JComboBox estArrComboBox;
	private JComboBox comboBox_2;
	
	ImageIcon imgBackground;
	
	ReservationDAO reserve_dao;   //  ReservationDAO 변수 생성 . 
	
	/*
	 * 이름: JP_MainMenu 기본생성자
	 * 역할: 메인메뉴 JPanel
	 * 작성: 김영권
	 */
	public JP_Reserve(JFrame_main f) { 
		
		// 
		try {
			reserve_dao = new ReservationDAO();
			System.out.println("DB 연결 성공 ");
		} catch (Exception e) {
			System.out.println("DB 연결실패 Reserve :" + e.toString());
		}
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		imgBackground = new ImageIcon("src/reservation/imgs/JP_Reserve_1.png");
		
		// Component 생성
		bToLogin = new JButton("");
		bRegist = new JButton("");
		tfName = new JTextField();
		tfTel = new JTextField();
		tfCarNo = new JTextField();
		tfRequest = new JTextField();
		tfPrice = new JTextField();
		
		vo = new ReservationVO();
 				
		// Component 양식 설정
		tfName.setBounds(290, 155, 200, 25);
		tfName.setColumns(10);
		tfName.setEditable(false); 						//이름 편집 못하게 
		
		add(tfName);
		
		tfTel.setBounds(290, 194, 200, 25);
		tfTel.setColumns(10);
		tfTel.setEditable(false); 						//전화번호 편집 못하게 
		add(tfTel);
		
		tfCarNo.setBounds(290, 314, 200, 25);		
		tfCarNo.setColumns(10);
		add(tfCarNo);
		
		tfRequest.setBounds(290, 354, 200, 25);			//요청사항 텍스트필드 추가 
		tfRequest.setColumns(10);
		add(tfRequest);
		
		tfPrice.setBounds(290, 395, 200, 25);		
		tfPrice.setColumns(10);
		tfPrice.setEditable(false); 					//요금 편집못하게 (인원수,사이트넘버,날짜등등에따라 자동 조정) 
		add(tfPrice);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(530, 15, 53, 53);
		bToLogin.setContentAreaFilled(false);
		bToLogin.setBorderPainted(false);
		add(bToLogin);
		
		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));    			
		bRegist.setBounds(243, 495, 120, 29);	
		bRegist.setContentAreaFilled(false);
		bRegist.setBorderPainted(false);
		add(bRegist);
		
		Integer []cbJanreStr = {1,2,3,4};  										// 인원수 콤보박스 데이터 추가 
		personNumComboBox = new JComboBox(cbJanreStr);
		personNumComboBox.setBounds(290, 237, 96, 21);            
		add(personNumComboBox);
		
		String []cbJanreStr1 = {"12시~2시","2시~4시","4시~6시","6시~8시"}; 			// 도착예정시간 콤보박스 데이터 추가
		estArrComboBox = new JComboBox(cbJanreStr1);
		estArrComboBox.setBounds(290, 277, 96, 21);							
		add(estArrComboBox);
		
//		JComboBox comboBox_2 = new JComboBox();									//숙박기간 콤보박스 [삭제예정]		
//		comboBox_2.setBounds(215, 211, 96, 21);	
//		add(comboBox_2);
		
//		JLabel lblNewLabel_2 = new JLabel("예약정보 입력");
//		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
//		lblNewLabel_2.setBounds(171, 40, 211, 30);
//		add(lblNewLabel_2);
		
//		JLabel lblNewLabel = new JLabel("예약자");
//		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel.setBounds(128, 116, 57, 15);
//		add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("전화번호");
//		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_1.setBounds(128, 160, 57, 15);
//		add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_3 = new JLabel("인원수");
//		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_3.setBounds(128, 211, 57, 15);							
//		add(lblNewLabel_3);
//	
//		JLabel lblNewLabel_3_1 = new JLabel("도착예정시간");
//		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_3_1.setBounds(128, 260, 75, 15);						
//		add(lblNewLabel_3_1);
//		
//		JLabel lblNewLabel_1_1 = new JLabel("차 번호");
//		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
//		lblNewLabel_1_1.setBounds(128, 310, 57, 15);
//		add(lblNewLabel_1_1);
//		
//		JLabel lblNewLabel_3_2 = new JLabel("요청사항");
//		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_3_2.setBounds(128, 350, 57, 15);
//		add(lblNewLabel_3_2);
//		
//		JLabel lblNewLabel_1_1_1 = new JLabel("요금");
//		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_1_1_1.setBounds(128, 390, 57, 15);					
//		add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("이용규칙 동의");
		chckbxNewCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(173, 450, 115, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("환불규정 동의");
		chckbxNewCheckBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(312, 450, 115, 23);
		add(chckbxNewCheckBox_1);
		
		//이름, 전화번호 셋팅을 위한 코드 // start
		
		ReservationVO vo1;	
		try {
			vo1 = reserve_dao.SetName_Tel(UserVO.getCustomer_id());
			tfName.setText(vo1.getCustomer_name());
			tfTel.setText(vo1.getTel());
			//요금 셋팅  //start
			String temp = String.valueOf(UserVO.getCheck_in());
			System.out.println(temp);			
			
			if(temp.contains("Jul") || temp.contains("Aug") || temp.contains("Sep"))//     7,8,9월에 예약하면 20000원 추가 
			{
				tfPrice.setText(Integer.toString((UserVO.getStayDays()*40000)+20000));
			}else {
				tfPrice.setText(Integer.toString((UserVO.getStayDays()*40000)));
			}
			//요금 셋팅  //end
			
		} catch (Exception e1) {
			System.out.println("셋팅실패 :" + e1.toString());
			e1.printStackTrace();
		}
		//이름,전화번호 셋팅을 위한 코드  - end
		setVisible(true);
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toMainMenu(); 
			}
		});
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "결제완료" 버튼 클릭 시 동작 설정
		 */
		bRegist.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				System.out.println(tfCarNo.getText());
				int reply = JOptionPane.showConfirmDialog(null, "예약 하시겠습니까? ", "예약", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
				if(chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected() && !tfCarNo.getText().equals("")) {
				reserveCheck();
				JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.");
				F.toMainMenu(); 
				}else if(tfCarNo.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "차번호를 입력해주세요. ");
				}
				else {
					JOptionPane.showMessageDialog(null, "이용약관에 동의해 주세요 ");
				}
				}
			}
		});
		/*
		 * 체크 박스 이용약관  
		 * 
		 */
		chckbxNewCheckBox.addActionListener(new ActionListener() {  //이용규칙 동의 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox.isSelected()) {
			    String text = "1. 떠들면 쫒아냄 \n"
			    		+ "2. 술먹으면 쫒아냄 \n"
			    		+ "3. 남녀 혼숙 금지 \n"
			    		+ "4. 팁 환영 \n"
			    		+ "5. 쓰레기버리면 즉시 쫒아냄 \n"
			    		+ "6. 담배피면 쫒아냄 \n"
			    		+ "7. 10시 이후 취침 \n"
			    		+ "8. 화재시 모든책임은 본인에게 있음 \n"
			    		+ "9. 귀중품 분실시 모든책임은 본인에게 있음\n"
			    		+ "10. 산짐승에게 해를 당할시 모든 책임은 본인에게 있음\n"
			    		+ "11. 오전 9시 체크아웃 "
			    	;
			    JTextArea textArea = new JTextArea(text,10,50);
			    textArea.setColumns(30);
			 //   textArea.setLineWrap(true);					//행 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
			  //  textArea.setWrapStyleWord(true);			
			    textArea.setEditable(false);				// 편집이 불가능하도록 설정
			    Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);					// 텍스트와 TextArea 경계 사이에 여백을 두기 위해서 emptyBorder를 생성합니다.
			    Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);		   		 	//TextArea에 lineBorder(검정테두리), emptyBorder(여백)로 구성된 복합 경계선을 설정합니다.
			    textArea.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));	// TextArea에 스크롤 기능을 추가한 후 Panel안에 집어 넣습니다.
			    textArea.setSize(textArea.getPreferredSize().width, 1);
			    int result = JOptionPane.showConfirmDialog(null, 
			    		textArea, "이용 약관", 
						JOptionPane.YES_NO_OPTION);
			    System.out.println(result);
			    if(result == 0) { 				// 이용약관 예 늘렀을때 
			    	
			    }else if(result == 1) {			// 이용약관 아니오 늘렀을때 
			    	chckbxNewCheckBox.setSelected(false);
			    }else {							// 그냥 닫았을때 
					chckbxNewCheckBox.setSelected(false);
				}
				}
			}
		});
		
		/*
		 *  체크 박스 환불 규정 동의 
		 */  		
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {  //환불규정 동의 누르면
			@Override
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_1.isSelected()) {
			    String text = 
			    		  "1. 체크인 7일전 이전에  환불 시 100% 환불 \n"
			    		+ "2. 체크인 7일 ~ 3일전 환불 시 80% 환불\n"
			    		+ "3. 체크인 3일 ~ 당일 전 환불 시 50% 환불 \n"
			    		+ "4. 당일 환불 불가능 \n"
			    		+ "5. 팁 환영";
			    JTextArea textArea = new JTextArea(text);
			    textArea.setColumns(30);
			  //textArea.setLineWrap(true);					
			  //textArea.setWrapStyleWord(true);
			    textArea.setEditable(false);				// 편집이 불가능하도록 설정
			    Border lineBorder = BorderFactory.createLineBorder(Color.black, 3);			
			    Border emptyBorder = BorderFactory.createEmptyBorder(7, 7, 7, 7);		   		
			    textArea.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));	
			    textArea.setSize(textArea.getPreferredSize().width, 1);
			    int result = JOptionPane.showConfirmDialog(null, 
			    		textArea, "환불 규정", 
						JOptionPane.YES_NO_OPTION);
			    System.out.println(result);
			    if(result == 0) { 				// 환불규정 예 늘렀을때 
			    	
			    }else if(result == 1) {			// 환불규정 아니오 늘렀을때 
			    	chckbxNewCheckBox_1.setSelected(false);
			    }else {							// 그냥 닫았을때 
			    	chckbxNewCheckBox_1.setSelected(false);
				}
				}
			}
		});
	} 
	/*
	 * 함수명 : reserveCheck
	 * 인자 : 없음
	 * 반환값 : 없음 
	 * 역할 : 결제완료를눌렀을때 실행되며 입력한 데이터를 VO에 담고 DAO의 PAMENT를실행해 DB에 저장한다. 
	 */
	public void reserveCheck() {
		ReservationVO rvo = new ReservationVO(); 
	//	CustomerVO cvo = new CustomerVO;  
	//	cvo.setMemberID(memberID);
		
		rvo.setPerson_no((int)personNumComboBox.getSelectedItem());   			// 창에 입력된 인원수를 가져온다. 
		rvo.setEst_arr_time((String)estArrComboBox.getSelectedItem()); 			// 창에 입력된 도착예정시간을 가져온다.
		rvo.setCar_no(tfCarNo.getText());										// 창에 입력된 차번호를 가져온다. 
		rvo.setRequestTerm(tfRequest.getText());								// 창에 입력된 요청사항을 가져온다. 
		rvo.setPrice(Integer.parseInt(tfPrice.getText()));
		
		
		try {
			
			reserve_dao.Payment(rvo);
			
		} catch (Exception e) {
			System.out.println("결제 실패 : "+ e.toString());
			e.printStackTrace();
		}
	}
	/*
	 * 함수명: paintComponent
	 * 역할: 배경이미지 설정
	 */
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);

		  g.drawImage(imgBackground.getImage(), 0, 0, this);
	}
	

	
	
}
