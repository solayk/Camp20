package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import reservation.model.vo.CustomerVO;
import reservation.model.vo.RegisterDAO;
import reservation.others.HintTextField;

public class JP_Register extends JPanel implements ActionListener {
	
	JTextField tfID, tfTel, tfName, tfEmail, tfAddr;
	JButton bRegist, bToLogin; 
	
	JPasswordField tfPW, tfPwConfirm;
	
	JComboBox emailBox;
	
	ImageIcon imgBackground;
	
	JLabel lblNewLabel_overlap;
	
	// 테스트
	JLabel lbIdCheck;
	
	/*
	 * 이름: JP_Login 기본생성자
	 * 역할: 로그인 화면 JPanel
	 * 작성: 정원우
	 */
	public JP_Register(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		
		// Component 생성
		tfID = new HintTextField("알파벳 소문자/숫자로 8~20자");
		tfTel = new HintTextField("하이픈'-' 없이 입력하세요");
		
//		비밀번호 필드 얘도 바꿔줌 _201103 원우
		tfPW = new JPasswordField();
		tfName = new HintTextField("이름을 입력하세요");
		tfEmail = new JTextField();
		tfAddr = new JTextField();
		
//		비밀번호 확인 텍스트필드 _201105 원우
		tfPwConfirm = new JPasswordField();
		
		bRegist = new JButton(); 
		bToLogin = new JButton(); 
				
		// Component 양식 설정
		tfID.setBounds(211, 182, 200, 25);
		tfID.setColumns(10);
		add(tfID);

		tfTel.setBounds(211, 222, 200, 25);
		tfTel.setColumns(10);
		add(tfTel);
		
		tfPW.setBounds(211, 262, 200, 25);
		tfPW.setColumns(10);
		add(tfPW);
		
//		여기부터 전체적으로 위치 조정 > 비번확인 tf 들어옴 _201105 원우
//		비번 확인 텍스트 필드 _201105 원우
		tfPwConfirm.setBounds(211, 302, 200, 25);
		tfPwConfirm.setColumns(10);
		add(tfPwConfirm);
		
		tfName.setBounds(211, 342, 200, 25);
		tfName.setColumns(10);
		add(tfName);
		
		tfEmail.setBounds(211, 382, 200, 25);
		tfEmail.setColumns(10);
		add(tfEmail);
		
		tfAddr.setBounds(211, 422, 200, 25);
		tfAddr.setColumns(10);
		add(tfAddr);

		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bRegist.setBounds(180, 484, 250, 35);
		// JButton 투명하게
			bRegist.setContentAreaFilled(false);
			bRegist.setBorderPainted(false);
		add(bRegist);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(530, 15, 53, 53);
			// JButton 투명하게
			bToLogin.setContentAreaFilled(false);
			bToLogin.setBorderPainted(false);
		add(bToLogin);
		
		imgBackground = new ImageIcon("src/reservation/imgs/JP_Register.png");
		
		
		// 라벨 설정

		/*
		 * 삭제예정?
		 */
//		중복검사 _201106 원우
		lblNewLabel_overlap = new JLabel();
		lblNewLabel_overlap.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_overlap.setBounds(405, 187, 57, 15);
		add(lblNewLabel_overlap);
		
		String[] mail = {"메일 선택", "@gmail.com", "@naver.com", "@hanmail.net", "@yahoo.co.kr"};
		emailBox = new JComboBox(mail);
		emailBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		emailBox.setBounds(430, 382, 120, 25);
		add(emailBox);
		
		setVisible(true);
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				f.toLogin(); 
			}
		});
		
		
		
		
	// -----------------------------------------------------------------------------		
	// -----------------------------------------------------------------------------		
		
		
//		이벤트 실행 _201103 원우
		eventProc();
		
//		객체연결?_201103 원우
		try {
			dao = new RegisterDAO();
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
		
	}
	
	
	
//	데이터베이스 연결? _201103 원우
	RegisterDAO dao;
	
	
	
//	이벤트 실행 _201103 원우
	void eventProc() {
		
		String id = tfID.getText();

		bRegist.addActionListener(this);
		
		
		tfID.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					dao = new RegisterDAO();
					if(dao.overlapDeny(id)) {
						lblNewLabel_overlap.setForeground(Color.RED);
						lblNewLabel_overlap.setText("사용 불가");
					}
					else {
						lblNewLabel_overlap.setForeground(Color.BLUE);
						lblNewLabel_overlap.setText("사용 가능");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				lblNewLabel_overlap.setText("사용가능");
			}
			
			
		});
			
			
		
	}
	
	
	
//	회원가입 버튼 클릭 _201103 원우
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object evt = e.getSource();
		
		if(evt == bRegist) {
			emailAdd();
			insertMember();
		}
		
		

	}
	
	
	
//	회원가입 _201103 원우
	CustomerVO vo = new CustomerVO();
	public void insertMember() {
//		List<String> list = new ArrayList<String>();
		
//		list.add(vo.setMemberID(tfID.getText()));
//		list.add(tfID.getText());
//		for(int i = 0; i<list.size(); i++) {
//			if(list.get(i).contains(" "){

		vo.setMemberID(tfID.getText());
		vo.setMemberTel(tfTel.getText());
		vo.setMemberPw(tfPW.getText());
		vo.setMemberName(tfName.getText());
		vo.setMemberAddr(tfAddr.getText());
		
		
		
		
		
		
		// 유효성 검사를 위한 변수들임 _201105 원우
		String checkId = tfID.getText();
		String checkTel = tfTel.getText();
		String checkPw = tfPW.getText();
		String checkPwConfirm = tfPwConfirm.getText();
		String checkName = tfName.getText();
		String checkEmail = tfEmail.getText();
		String checkAddr = tfAddr.getText();
		
		
		
		try {
			// 1. id 유효성 검사 _201105 원우
			// 1-1. 공백 > 생각해보니 영어랑 숫자만 받으면 되는 일임
//			if(checkId.contains(" ")) {
//				JOptionPane.showMessageDialog(null, "id 공백확인하셈", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
//				return;
//			}
			// 1-2. 영어숫자
			if(false == Pattern.matches("^[a-zA-Z0-9]*$", checkId)) {
				JOptionPane.showMessageDialog(null, "id 알파벳/숫자만됨", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 1-3. 최소길이
			else if(8 > checkId.length() || 20 < checkId.length()) {
				JOptionPane.showMessageDialog(null, "id 8글자이상", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 1-4. 중복검사 해야하는데............ > 바로 뜨게
			
			
			// 2. 전화번호 유효성 검사 _201105 원우
			// 2-1. 길이제한
			else if(11 != checkTel.length()) {
				JOptionPane.showMessageDialog(null, "전번은 11글자", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 2-2. 숫자만입력
			else if(false == Pattern.matches("^[0-9]*$", checkTel)) {
				JOptionPane.showMessageDialog(null, "전번은 숫자만됨", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			// 2-3. 자동 하이픈 삽입을 해보고 싶고
			// 2-4. 공백 입력조차 안되도록 아예 값을 텍스트필드에 받지 않게 해보고픈데
			
			
			// 3.비밀번호 유효성검사 _201105 원우
			// 3-1. 비번구성 (숫자1, 알파벳소문자1, 8~20글자) 
			else if(false == Pattern.matches( "^(?=.*[0-9])(?=.*[a-z]).{8,20}$", checkPw)) {
				JOptionPane.showMessageDialog(null, "비번은 숫자+소문자,8글자ㅇ", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			// 4. 비밀번호 확인
			else if(!checkPwConfirm.equals(checkPw)) {
				JOptionPane.showMessageDialog(null, "비번재확인ㄱ", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			// 5. 이름 유효성 검사 _201105 원우
			// 5-1. 한글만 입력
			else if(false == Pattern.matches("^[가-힣]*$", checkName)) {
				JOptionPane.showMessageDialog(null, "이름은 한글만됨", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			// 6. 메일 유효성 검사 _201105 원우
			// 6-1. 공백 확인
			else if(false == Pattern.matches("^[a-z0-9]*$", checkEmail)) {
				JOptionPane.showMessageDialog(null, "메일은 소문자랑 숫자만 됨", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			// 
			else {
				
				dao.regist(vo);
				clearTextField();
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				System.out.println("입력성공");
			}
			
			
			
		} catch(Exception e) {
			System.out.println("입력실패: " + e.toString());
			e.printStackTrace();
		}
		
	} // end of insertMember()
	
	
	
	// email = textfield + dropbox _201105 원우
	public void emailAdd() {
		String mailadr =  (String) emailBox.getSelectedItem();
		String writeMail = tfEmail.getText();
		
		vo.setMemberEmail(writeMail+mailadr);
				
	}


	
//	회원가입 버튼 클릭시 textfield 초기화 _201103 원우
	private void clearTextField() {
		
		tfID.setText(null);
		tfTel.setText(null);
		tfPW.setText(null);
		tfPwConfirm.setText(null);
		tfName.setText(null);
		tfEmail.setText(null);
		tfAddr.setText(null);
		
	}
		
	/*
	 * 함수명: paintComponent
	 * 역할: 배경이미지 설정
	 */
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);

		  g.drawImage(imgBackground.getImage(), 0, 0, this);
		 // g.drawRoundRect(120, 10, 50, 50, 30, 20);
	}
} 

