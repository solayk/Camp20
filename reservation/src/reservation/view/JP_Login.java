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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import reservation.model.vo.CustomerVO;
import reservation.model.vo.RegisterDAO;
import reservation.model.vo.ReservationVO;
import reservation.model.vo.UserVO;
import reservation.others.HintTextField;
import reservation.others.JPanelWithBackground;
import reservation.others.SendMail;

public class JP_Login extends JPanel {
	
	JTextField tf_id, tf_pw;
	
	JButton bNewRegister, bLogin, bSearchId, bSearchPw, bToManager , bexit;
	
	/*
	 * 테스트
	 */
	JButton bGaebal;
	
	JPanel photo_1, photo_2;
	
	ImageIcon imgBackground;
	
	RegisterDAO dao;
	
	JFrame_main F;
	
	int count=0; // 로그인 반복 실패 처리
	
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
		tf_pw = new JPasswordField();
		
		bNewRegister = new JButton(); 
		bLogin = new JButton();
		bToManager = new JButton();
		bSearchId = new JButton();
		bSearchPw = new JButton();
		bexit = new JButton();
		
		/*
		 * 임시 ****************************************
		 */
		bGaebal = new JButton("개발모드");
		imgBackground = new ImageIcon("src/reservation/imgs/JP_Login_3.png");
		
		try {
			dao = new RegisterDAO();
			System.out.println("JP_Login - Register DB 연결 성공");
		} catch (Exception e) {
			System.out.println("JP_Login - Register DB 연결 ==실패==" + e.toString());
			e.printStackTrace();
		}
		
		// Component 양식 설정
		tf_id.setColumns(10);
		tf_id.setBounds(274, 239, 152, 30);
		add(tf_id);
		
		tf_pw.setColumns(10);
		tf_pw.setBounds(274, 289, 152, 30);
		add(tf_pw);

		bLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bLogin.setBounds(170, 330, 250, 35);
			// JButton 투명하게
			bLogin.setContentAreaFilled(false);
			bLogin.setBorderPainted(false);
		add(bLogin);
		
		bSearchId.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSearchId.setBounds(170, 373, 90, 23);
			// JButton 투명하게
			bSearchId.setContentAreaFilled(false);
			bSearchId.setBorderPainted(false);
		add(bSearchId);
		
		bSearchPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSearchPw.setBounds(170, 398, 110, 23);
			// JButton 투명하게
			bSearchPw.setContentAreaFilled(false);
			bSearchPw.setBorderPainted(false);
		add(bSearchPw);
		
		bexit.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bexit.setBounds(527, 0, 57, 37);		//닫기 버튼 위치 
			// JButton 투명하게
			bexit.setContentAreaFilled(false);
			bexit.setBorderPainted(false);
		add(bexit);
		
		bNewRegister.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bNewRegister.setBounds(340, 372, 80, 24);
			// JButton 투명하게
			bNewRegister.setContentAreaFilled(false);
			bNewRegister.setBorderPainted(false);
		add(bNewRegister);
		
		bToManager.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToManager.setBounds(240, 566, 115, 25);
			// JButton 투명하게
			bToManager.setContentAreaFilled(false);
			bToManager.setBorderPainted(false);
		add(bToManager);
		
		/*
		 * 개발완료 후 삭제 예정
		 */
//		bGaebal.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		bGaebal.setBounds(10, 10, 97, 23);
//		add(bGaebal);
//										
//		setVisible(true);
//		
//		bGaebal.addActionListener(new ActionListener() { 
//			public void actionPerformed(ActionEvent arg0) { 
//				F.LoginSuccess();
//			}
//		});
//		
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
		 * bexit 버튼 액션 리스너
		 * 역할 : "닫기" 버튼 클릭시 동작 설정 
		 */
	        //윈도우 닫기버튼 이벤트 처리
		bexit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
					int reply = JOptionPane.showConfirmDialog(null, "감성캠핑을 종료하시겠습니까 ?" , "종료", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
	                
	            }
	        });

		tf_pw.addActionListener(new ActionListener() {					// 비밀번호 text field 에서 엔터 쳤을때 
			public void actionPerformed(ActionEvent arg0) { 
				
				int i=0; // 로그인 성공 또는 실패 구분
								
				try {
					i = dao.chk_idpw(tf_id.getText(), tf_pw.getText());
				} catch (Exception e) {
					System.out.println("JP_Login chk_idpw 실행 에러: " + e.toString());
				}
				
				if(i==1) { 
					UserVO.setCustomer_id(tf_id.getText());
					F.toMainMenu();
					tf_id.setText("");
					tf_pw.setText("");
				}
				else if(i==2) { // 존재하지 않는 아이디
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
					tf_id.setText("");
				}
				else if(i==3) { // 아이디, 비밀번호 불일치 
					if(count<4) JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다. 틀린횟수 " + ++count + "번");
					/*
					 * 추후 비밀번호 재설정에 대한 로직 추가 필요  
					 */
					else {
						JOptionPane.showMessageDialog(null, "비밀번호를 5번 틀리셨습니다. 비밀번호를 재설정하시기 바랍니다.");
						// 비밀번호 메일로 보내기
						CustomerVO vo = new CustomerVO();
						try {
							vo = dao.toSend_pw(tf_id.getText());
						} catch (Exception e) {
							System.out.println("toSend_pw 에러: " + e.toString());
						}
						SendMail mail = new SendMail();
						mail.send_pw(vo.getMemberName(), vo.getMemberEmail(), vo.getMemberPw());
						tf_id.setText("");
						tf_pw.setText("");
					}
					
				}
				else System.out.println("로그인 bLogin 버튼 액션 리스너 확인");	
			}
		});
		
		/*
		 * 이름: bLogin 버튼 액션 리스너
		 * 역할: "로그인" 버튼 클릭 시 동작 설정
		 */
		bLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				
				int i=0; // 로그인 성공 또는 실패 구분
								
				try {
					i = dao.chk_idpw(tf_id.getText(), tf_pw.getText());
				} catch (Exception e) {
					System.out.println("JP_Login chk_idpw 실행 에러: " + e.toString());
				}
				
				if(i==1) { 
					UserVO.setCustomer_id(tf_id.getText());
					F.toMainMenu();
					tf_id.setText("");
					tf_pw.setText("");
				}
				else if(i==2) { // 존재하지 않는 아이디
					JOptionPane.showMessageDialog(null, "존재하지 않는 아이디 입니다");
					tf_id.setText("");
				}
				else if(i==3) { // 아이디, 비밀번호 불일치 
					if(count<4) JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 일치하지 않습니다. 틀린횟수 " + ++count + "번");
					/*
					 * 추후 비밀번호 재설정에 대한 로직 추가 필요  
					 */
					else {
						JOptionPane.showMessageDialog(null, "비밀번호를 5번 틀리셨습니다. 비밀번호를 재설정하시기 바랍니다.");
						// 비밀번호 메일로 보내기
						CustomerVO vo = new CustomerVO();
						try {
							vo = dao.toSend_pw(tf_id.getText());
						} catch (Exception e) {
							System.out.println("toSend_pw 에러: " + e.toString());
						}
						SendMail mail = new SendMail();
						mail.send_pw(vo.getMemberName(), vo.getMemberEmail(), vo.getMemberPw());
						tf_id.setText("");
						tf_pw.setText("");
					}
					
				}
				else System.out.println("로그인 bLogin 버튼 액션 리스너 확인");	
			}
		}); // END OF bLogin 액션 리스너
		
		/*
		 * 역할 : bSearchPw 버튼 클릭시 비밀번호 찾기 실행
		 * 
		 */
		bSearchPw.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				
				String input = JOptionPane.showInputDialog(null,"아이디를 입력하세요");
				
				CustomerVO vo = new CustomerVO();
				
				if(input != null) {
					try {
						vo = dao.toSend_pw(input);
						if (vo.getMemberName() != null) {
							JOptionPane.showMessageDialog(null, "회원님의 이메일 : "+ vo.getMemberEmail() + " 로 비밀번호를 전송하였습니다.");
							SendMail mail = new SendMail();
							mail.send_pw(vo.getMemberName(), vo.getMemberEmail(), vo.getMemberPw());
						}
						else JOptionPane.showMessageDialog(null, "존재하지 않는 아이디입니다");
					} catch (Exception e) {
						System.out.println("비밀번호 찾기로 이메일 전송 실패: " + e.toString());
					}
				}
				
			}
		});
		/*
		 * 역할 : bSearchId 버튼 클릭시 아이디 찾기 실행
		 * 
		 */
		bSearchId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) { 
				
					String input = JOptionPane.showInputDialog(null,"전화번호를 입력하세요 ('-'없이 입력) ");
					String id = null;
					
					System.out.println(input);
					//System.out.println(input.length());
					CustomerVO vo = new CustomerVO();
					try {
					if(input != null ) {
						System.out.println("제대로 입력 ");
						vo = dao.toSend_Id(input);
					
						id = vo.getMemberName();
						System.out.println(id.length());
						String star = "";
						for(int i =0;i<id.substring(id.length()-3,id.length()).length();i++) { 
							star += "*";
						}
						System.out.println(star);
						JOptionPane.showMessageDialog(null,"회원님의 id는 "+id.substring(0,id.length()-3) + star +" 입니다."); // 아이디최소 8글자
					}

					
					
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null," 없는 전화번호 입니다."); 
						System.out.println("id찾기 실패  " + e.toString());
					}

				
				
			}
		});
		
	} // END OF CONSTRUCTOR
	
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
