package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

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
	
	private JTextField tfID, tfTel, tfName, tfEmail, tfAddr;
	private JButton bRegist, bToLogin; 
	
//	비밀번호 표시 필드 _201103 원우
//	비번확인 텍스트필드 생성 (tfPwConfirm) _201105 원우
	private JPasswordField tfPW, tfPwConfirm;
	
//	이메일 드롭박스 _201105 원우
	JComboBox emailBox;
	
	
	/*
	 * 이름: JP_Login 기본생성자
	 * 역할: 로그인 화면 JPanel
	 * 작성: 정원우
	 */
	public JP_Register(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.LIGHT_GRAY); 
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
		
		bRegist = new JButton("회원가입"); 
		bToLogin = new JButton("홈"); 
				
		// Component 양식 설정
		tfID.setBounds(187, 102, 200, 25);
		tfID.setColumns(10);
		add(tfID);

		tfTel.setBounds(187, 142, 200, 25);
		tfTel.setColumns(10);
		add(tfTel);
		
		tfPW.setBounds(187, 182, 200, 25);
		tfPW.setColumns(10);
		add(tfPW);
		
//		여기부터 전체적으로 위치 조정 > 비번확인 tf 들어옴 _201105 원우
//		비번 확인 텍스트 필드 _201105 원우
		tfPwConfirm.setBounds(187, 222, 200, 25);
		tfPwConfirm.setColumns(10);
		add(tfPwConfirm);
		
		tfName.setBounds(187, 262, 200, 25);
		tfName.setColumns(10);
		add(tfName);
		
		tfEmail.setBounds(187, 302, 200, 25);
		tfEmail.setColumns(10);
		add(tfEmail);
		
		tfAddr.setBounds(187, 342, 200, 25);
		tfAddr.setColumns(10);
		add(tfAddr);

		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bRegist.setBounds(225, 404, 97, 23);
		add(bRegist);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(457, 23, 97, 23);
		add(bToLogin);
		
		
		// 라벨 설정
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(100, 107, 57, 15);
		add(lblNewLabel);
		

//		중복검사 _201106 원우
		JLabel lblNewLabel_overlap = new JLabel("사용가능");
		lblNewLabel_overlap.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_overlap.setBounds(400, 107, 57, 15);
		add(lblNewLabel_overlap);
		
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(100, 147, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(100, 187, 57, 15);
		add(lblNewLabel_1_1);
		
		
//		비밀번호 관련 라벨 붙여놓음 _201105 원우
		JLabel lblNewLabel_1_3 = new JLabel("알파벳소문자/숫자 8~20자");
		lblNewLabel_1_3.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		lblNewLabel_1_3.setForeground(Color.red);
		lblNewLabel_1_3.setBounds(400, 187, 200, 20);
		add(lblNewLabel_1_3);
		
		
//		여기부터 전체적으로 위치 조정 > 비번확인 tf 들어옴 _201105 원우
//		비번 확인 텍스트 필드 _201105 원우
		JLabel lblNewLabel_1_2 = new JLabel("비밀번호확인");
		lblNewLabel_1_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(100, 227, 80, 15);
		add(lblNewLabel_1_2);
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(100, 267, 70, 15);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("이메일주소");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(100, 307, 80, 15);
		add(lblNewLabel_1_1_1_1);
		
		
//		이메일 드롭박스 _201105 원우
		String[] mail = {"메일 선택", "@gmail.com", "@naver.com", "@hanmail.net", "@yahoo.co.kr"};
		emailBox = new JComboBox(mail);
		emailBox.setBounds(400, 302, 120, 25);
		add(emailBox);
		
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(100, 347, 57, 15);
		add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(233, 34, 100, 30);
		add(lblNewLabel_2);
		
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
		bRegist.addActionListener(this);
		
	}
	
	
	
//	회원가입 버튼 클릭 _201103 원우
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object evt = e.getSource();
		
		if(evt == bRegist) {
			insertMember();
			emailAdd();
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
			}
			
			System.out.println("입력성공");
			
			
		} catch(Exception e) {
			System.out.println("입력실패: " + e.toString());
			e.printStackTrace();
		}
		
	} // end of insertMember()
	
	
/*	
	// ID 중복 검사 _201106 원우
	public void overlapId() {
		
		
		overlapDeny()
		
	}
	
	
	@Override
	public synchronized void addKeyListener(KeyListener l) {
		// TODO Auto-generated method stub
		super.addKeyListener(l);
	}
	
	public void keyPress(KeyEvent e) {
		dao = 
	}
*/	
	
	
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
		
		
} 

