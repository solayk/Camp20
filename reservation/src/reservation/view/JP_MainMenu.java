package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class JP_MainMenu extends JPanel {

	JLabel lb_title;
	JButton bToReserv, bToCheckReserve; 
	JFrame_main F; 
	
	ImageIcon imgBackground;
	
	ImageIcon iconTitle, iconToReserv, iconToCheckReserve;
	
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
		bToReserv = new JButton(""); 
		bToCheckReserve = new JButton(""); 
		
		/*
		 * 임시 ****************************************
		 */
		imgBackground = new ImageIcon("src/reservation/imgs/mainmemu_test5.png");
		
		// 아이콘 설정
		iconTitle = new ImageIcon("src/reservation/imgs/JP_MainMenu_title.png");
		iconToReserv = new ImageIcon("src/reservation/imgs/JP_MainMenu_bToReserv.png");
		iconToCheckReserve = new ImageIcon("src/reservation/imgs/JP_MainMenu_bToCheckReserve.png");
		
		// Component 양식 설정
		bToReserv.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToReserv.setBounds(150, 140, 300, 150);
		bToReserv.setIcon(iconToReserv);
		bToReserv.setIcon(resizeIcon(iconToReserv, bToReserv.getWidth(), bToReserv.getHeight()));
		add(bToReserv);
		
		bToCheckReserve.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToCheckReserve.setBounds(150, 335, 300, 150);
		bToCheckReserve.setIcon(iconToCheckReserve);
		bToCheckReserve.setIcon(resizeIcon(iconToCheckReserve, bToReserv.getWidth(), bToReserv.getHeight()));
		add(bToCheckReserve);
				
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
	
	/*
	 * 함수명: resizeIcon
	 * 역할: 버튼 사진 크기 조절
	 */
	public Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
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
