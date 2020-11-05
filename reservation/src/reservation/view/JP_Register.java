package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JP_Register extends JPanel {
	
	private JTextField tfID, tfTel, tfPW, tfName, tfEmail, tfAddr;
	private JButton bRegist, bToLogin; 
	
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
		tfID = new JTextField();
		tfTel = new JTextField();
		tfPW = new JTextField();
		tfName = new JTextField();
		tfEmail = new JTextField();
		tfAddr = new JTextField();
		
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
		
		tfName.setBounds(187, 222, 200, 25);
		tfName.setColumns(10);
		add(tfName);
		
		tfEmail.setBounds(187, 262, 200, 25);
		tfEmail.setColumns(10);
		add(tfEmail);
		
		tfAddr.setBounds(187, 302, 200, 25);
		tfAddr.setColumns(10);
		add(tfAddr);

		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bRegist.setBounds(225, 364, 97, 23);
		add(bRegist);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(457, 23, 97, 23);
		add(bToLogin);
		
		// 라벨 설정
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(100, 107, 57, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(100, 147, 57, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(100, 187, 57, 15);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(100, 227, 57, 15);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("이메일주소");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(100, 267, 70, 15);
		add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(100, 307, 57, 15);
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
	} 
}
