package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JP_CheckResNo extends JPanel {

	private JTextField tf_resNo;
	private JButton bToLogin, bToReserve; 
	private JFrame_main F; 
	
	/*
	 * 이름: JP_MainMenu 기본생성자
	 * 역할: 메인메뉴 JPanel
	 * 작성: 김영권
	 */
	public JP_CheckResNo(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// Component 생성
		tf_resNo = new JTextField();
		bToLogin = new JButton("홈");
		bToReserve = new JButton("예약조회"); //변경예정
 				
		// Component 양식 설정
		tf_resNo.setBounds(207, 247, 150, 21);
		tf_resNo.setColumns(10);
		add(tf_resNo);
		
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(457, 23, 97, 23);
		add(bToLogin);
		
		bToReserve.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToReserve.setBounds(238, 301, 97, 23);
		add(bToReserve);
		
		JLabel lb_title = new JLabel("예약번호 조회");
		lb_title.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lb_title.setBounds(211, 86, 211, 30);
		add(lb_title);
		
		JLabel lb_notice = new JLabel("예약번호를 입력하세요");
		lb_notice.setHorizontalAlignment(SwingConstants.CENTER);
		lb_notice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_notice.setBounds(207, 222, 173, 15);
		add(lb_notice);
				
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
		 * 역할: "" 버튼 클릭 시 동작 설정
		 */
		bToReserve.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toLogin(); 
			}
		});
		
	} 
}
