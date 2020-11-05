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

public class JP_Login extends JPanel {
	
	private JTextField tf_id, tf_pw;
	private JButton bNewRegister, bLogin, bToManager; 
	private JFrame_main F; 
	
	/*
	 * 이름: JP_Login 기본생성자
	 * 역할: 로그인 화면 JPanel
	 * 작성: 김영권
	 */
	public JP_Login(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// Component 생성
		tf_id = new JTextField();
		tf_pw = new JTextField();
		
		bNewRegister = new JButton("회원가입"); 
		bLogin = new JButton("로그인");
		bToManager = new JButton("관리자");
				
		// Component 양식 설정
		tf_id.setColumns(10);
		tf_id.setBounds(257, 219, 150, 21);
		add(tf_id);
		
		tf_pw.setColumns(10);
		tf_pw.setBounds(257, 269, 150, 21);
		add(tf_pw);
		
		bNewRegister.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bNewRegister.setBounds(310, 326, 97, 23);
		add(bNewRegister);
		
		bLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin.setBounds(183, 328, 97, 23);
		add(bLogin);
		
		bToManager.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToManager.setBounds(251, 375, 97, 23);
		add(bToManager);
		
		
		// 라벨설정
		JLabel lb_title = new JLabel("로그인");
		JLabel lb_id = new JLabel("아이디");
		JLabel lb_pw = new JLabel("패스워드");
		
		lb_title.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lb_title.setBounds(222, 126, 211, 30);
		add(lb_title);
		
		lb_id.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_id.setBounds(169, 222, 57, 15);
		add(lb_id);
		
		lb_pw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_pw.setBounds(169, 272, 57, 15);
		add(lb_pw);
		
		setVisible(true);
		
		/*
		 * 이름: bNewRegister 버튼 액션 리스너
		 * 역할: "회원가입" 버튼 클릭 시 동작 설정
		 */
		bNewRegister.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.to_JP_Register(); 
			}
		});
		
		/*
		 * 이름: bLogin 버튼 액션 리스너
		 * 역할: "로그인" 버튼 클릭 시 동작 설정
		 */
		bLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.LoginSuccess(); 
			}
		});
		
		
	} 
}
