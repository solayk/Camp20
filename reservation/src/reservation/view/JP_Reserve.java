package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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

	JTextField tfName, tfTel, tfCarNo, tfPrice;
	JButton bToLogin, bRegist; 
	
	static ReservationVO vo;
	
	JFrame_main F; 
	
	private JComboBox personNumComboBox;
	private JComboBox estArrComboBox;
	private JComboBox comboBox_2;
	
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
			System.out.println("DB 연결실패 :" + e.toString());
		}
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// Component 생성
		bToLogin = new JButton("홈");
		bRegist = new JButton("결제완료");
		tfName = new JTextField();
		tfTel = new JTextField();
		tfCarNo = new JTextField();
		tfPrice = new JTextField();
		
		vo = new ReservationVO();
 				
		// Component 양식 설정
		tfName.setBounds(215, 111, 200, 25);
		tfName.setColumns(10);
		tfName.setEditable(false); 						//이름 편집 못하게 
		
		add(tfName);
		
		tfTel.setBounds(215, 155, 200, 25);
		tfTel.setColumns(10);
		tfTel.setEditable(false); 						//전화번호 편집 못하게 
		add(tfTel);
		
		tfCarNo.setBounds(215, 318, 200, 25);			//373 -> 318
		tfCarNo.setColumns(10);
		add(tfCarNo);
		
		tfPrice.setBounds(215, 373, 200, 25);			//426 -> 373
		tfPrice.setColumns(10);
		tfPrice.setEditable(false); 					//요금 편집못하게 (인원수,사이트넘버,날짜등등에따라 자동 조정) 
		add(tfPrice);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(457, 23, 97, 23);
		add(bToLogin);
		
		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));    			
		bRegist.setBounds(215, 480, 97, 23);								//514 -> 480
		add(bRegist);
		
		Integer []cbJanreStr = {1,2,3,4};  										// 인원수 콤보박스 데이터 추가 
		personNumComboBox = new JComboBox(cbJanreStr);
		personNumComboBox.setBounds(215, 211, 96, 21);               // 264 -> 211변경
		add(personNumComboBox);
		
		String []cbJanreStr1 = {"12시~2시","2시~4시","4시~6시","6시~8시"}; 			// 도착예정시간 콤보박스 데이터 추가
		estArrComboBox = new JComboBox(cbJanreStr1);
		estArrComboBox.setBounds(215, 264, 96, 21);								//318->264
		add(estArrComboBox);
		
//		JComboBox comboBox_2 = new JComboBox();									//숙박기간 콤보박스 [삭제예정]		
//		comboBox_2.setBounds(215, 211, 96, 21);	
//		add(comboBox_2);
		
		JLabel lblNewLabel_2 = new JLabel("예약정보 입력");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(171, 40, 211, 30);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("예약자");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(128, 116, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(128, 160, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("인원수");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(128, 211, 57, 15);							// 264 -> 211변경
		add(lblNewLabel_3);
	
		JLabel lblNewLabel_3_1 = new JLabel("도착예정시간");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(128, 264, 75, 15);						//318 -> 264
		add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("차 번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));		//373 -> 318
		lblNewLabel_1_1.setBounds(128, 318, 57, 15);
		add(lblNewLabel_1_1);
		
//		JLabel lblNewLabel_3_2 = new JLabel("숙박기간");
//		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lblNewLabel_3_2.setBounds(128, 212, 57, 15);
//		add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("요금");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(128, 373, 57, 15);						//426 -> 373
		add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("이용규칙 동의");
		chckbxNewCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(128, 440, 115, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("환불규정 동의");
		chckbxNewCheckBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(267, 440, 115, 23);
		add(chckbxNewCheckBox_1);
		
		setVisible(true);
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toLogin(); 
			}
		});
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "결제완료" 버튼 클릭 시 동작 설정
		 */
		bRegist.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				if(chckbxNewCheckBox.isSelected() && chckbxNewCheckBox_1.isSelected()) {
				reserve();
				F.toLogin(); 
				}else {
					JOptionPane.showMessageDialog(null, "이용약관에 동의해 주세요 ");
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
			    String text = "1. 떠들면 죽는다 2. 술먹으면안되 3. 남녀 혼숙 금지 \n "
			    		+ "1. 떠들면 죽는다 2. 술먹으면안되 3. 남녀 혼숙 금지 \n"
			    		+ "1. 떠들면 죽는다 2. 술먹으면안되 3. 남녀 혼숙 금지 \n"
			    		+ "1. 떠들면 죽는다 2. 술먹으면안되 3. 남녀 혼숙 금지 \n"
			    		+ "1. 떠들면 죽는다 2. 술먹으면안되 3. 남녀 혼숙 금지 \n";
			    JTextArea textArea = new JTextArea(text);
			    textArea.setColumns(30);
			    textArea.setLineWrap(true);					//행 넘길 때 행의 마지막 단어가 두행에 걸쳐 나뉘지 않도록 하기
			    textArea.setWrapStyleWord(true);			// 편집이 불가능하도록 설정
			    textArea.append(text);
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
			    String text = "절대 환불 불가능\n"
			    		+ "절대 환불 불가능\n"
			    		+ "절대 환불 불가능\n"
			    		+ "절대 환불 불가능";
			    JTextArea textArea = new JTextArea(text);
			    textArea.setColumns(40);
			    textArea.setLineWrap(true);					
			    textArea.setWrapStyleWord(true);		
			    textArea.append(text);
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
	 * 함수명 : reserve
	 * 인자 : 없음
	 * 반환값 : 없음 
	 * 역할 : 결제완료를눌렀을때 실행되며 입력한 데이터를 VO에 담고 DAO의 PAMENT를실행해 DB에 저장한다. 
	 */
	public void reserve() {
		ReservationVO rvo = new ReservationVO();
	//	CustomerVO cvo = new CustomerVO;  
	//	cvo.setMemberID(memberID);
		
		rvo.setPerson_no((int)personNumComboBox.getSelectedItem());   			// 창에 입력된 인원수를 가져온다. 
		rvo.setEst_arr_time((String)estArrComboBox.getSelectedItem()); 			// 창에 입력된 도착예정시간을 가져온다.
		rvo.setCar_no(tfCarNo.getText());										// 창에 입력된 차번호를 가져온다. 
		
		try {
			
			reserve_dao.Payment(rvo);
			
		} catch (Exception e) {
			System.out.println("결제 실패 : "+ e.toString());
			e.printStackTrace();
		}
	}

	
	
}
