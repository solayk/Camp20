package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JP_MainMenu extends JPanel {

	private JLabel lb_title;
	private JButton bToReserv, bToCheckReserve; 
	private JFrame_main F; 
	
	/*
	 * 이름: JP_MainMenu 기본생성자
	 * 역할: 메인메뉴 JPanel
	 * 작성: 김영권
	 */
	public JP_MainMenu(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// Component 생성
		
		
		bToReserv = new JButton("캠핑사이트 예약"); 
		bToCheckReserve = new JButton("예약내역 확인/취소"); 
				
		// Component 양식 설정
		bToReserv.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToReserv.setBounds(169, 178, 200, 100);
		add(bToReserv);
		
		bToCheckReserve.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToCheckReserve.setBounds(169, 335, 200, 100);
		add(bToCheckReserve);
		
		lb_title = new JLabel("메인메뉴");
		lb_title.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lb_title.setBounds(211, 86, 211, 30);
		add(lb_title);
				
		setVisible(true);
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "사이트 예약" 버튼 클릭 시 동작 설정
		 */
		bToReserv.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toJP_Cal(); 
			}
		});
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "예약 확인/취소" 버튼 클릭 시 동작 설정
		 */
		bToCheckReserve.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				F.toJP_CheckResNo(); 
			}
		});
		
	} 
}
