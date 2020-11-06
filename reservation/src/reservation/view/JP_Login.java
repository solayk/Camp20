package reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import reservation.model.vo.RegisterDAO;
import reservation.model.vo.ReservationVO;
import reservation.model.vo.UserVO;
import reservation.others.HintTextField;
import reservation.others.JPanelWithBackground;

public class JP_Login extends JPanel {
	
	JTextField tf_id, tf_pw;
	JButton bNewRegister, bLogin, bToManager; 
	
	/*
	 * 테스트
	 */
	JPanel test;
	
	RegisterDAO dao;
	
	JFrame_main F; 
	
	/*
	 * 이름: JP_Login 기본생성자
	 * 역할: 로그인 화면 JPanel
	 * 작성: 김영권
	 */
	public JP_Login(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.BLACK); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// Component 생성
		// 로그인, 패스워드 입력 TextField 도움말 HintTextField로 추가
		tf_id = new HintTextField("아이디를 입력하세요");
		tf_pw = new HintTextField("비밀번호를 입력하세요");
		
		bNewRegister = new JButton("회원가입"); 
		bLogin = new JButton("로그인");
		bToManager = new JButton("관리자");
		
		try {
			dao = new RegisterDAO();
			System.out.println("JP_Login - Register DB 연결 성공");
		} catch (Exception e) {
			System.out.println("JP_Login - Register DB 연결 ==실패==" + e.toString());
			e.printStackTrace();
		}
		
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
		
		/*
		 * 테스트
		 */
		test = null;
		try {		
			test = new JPanelWithBackground("C:\\Users\\kosmo20\\Desktop\\test_3_cropped.gif");
			} catch (Exception e) {
				System.out.println("이미지 불러오기 실패");
			}
		test.setBounds(370, 360, 226, 226);
		add(test);
		
		/*
		 * 테스트
		 */
		
		
		// 라벨설정
		JLabel lb_title = new JLabel("캄 파 진 현");
		JLabel lb_id = new JLabel("아이디");
		JLabel lb_pw = new JLabel("패스워드");
		
		lb_title.setFont(new Font("완도희망체", Font.BOLD, 50));
		lb_title.setBounds(180, 120, 250, 55);
		lb_title.setForeground(Color.WHITE);
		add(lb_title);
		
		lb_id.setFont(new Font("완도희망체", Font.PLAIN, 20));
		lb_id.setBounds(169, 222, 57, 15);
		lb_id.setForeground(Color.WHITE);
		add(lb_id);
		
		lb_pw.setFont(new Font("완도희망체", Font.PLAIN, 20));
		lb_pw.setBounds(169, 272, 77, 15);
		lb_pw.setForeground(Color.WHITE);
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
				
				int i=0; // 로그인 성공 또는 실패 구분
				int count=0; // 로그인 반복 실패 처리
								
				try {
					i = dao.chk_idpw(tf_id.getText());
				} catch (Exception e) {
					System.out.println("JP_Login chk_idpw 실행 에러: " + e.toString());
				}
				
				if(i==1) {
					UserVO.setCustomer_id(tf_id.getText());
					F.LoginSuccess(); 
				}
				else if(i==2) { // 존재하지 않는 아이디
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
					tf_id.setText("");
				}
				else if(i==3) { // 아이디, 비밀번호 불일치 
					++count;
					if(count<5) JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다./n 틀린횟수 " + count + "번");
					/*
					 * 추후 비밀번호 재설정에 대한 로직 추가 필요  
					 */
					else JOptionPane.showMessageDialog(null, "비밀번호를 5번 틀리셨습니다. 비밀번호를 재설정하시기 바랍니다.");
					tf_id.setText("");
					tf_pw.setText("");
				}
				else System.out.println("로그인 bLogin 버튼 액션 리스너 확인");	
			}
		});
		
	} // END OF CONSTRUCTOR

}
