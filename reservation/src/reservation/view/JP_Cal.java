package reservation.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import reservation.model.vo.ReservationDAO;
import reservation.model.vo.ReservationVO;
import reservation.model.vo.UserVO;

public class JP_Cal extends JPanel {

	JButton bToLogin, bTestSearch, bSite_1, bSite_2, bSite_3, bSite_4, bSite_5; 
	JLabel lb_check_in, lb_numStay, lb_able_sen, lb_able_Num, lb_able_gae,lb_price;
	
	ImageIcon imgBackground;
	
	ReservationDAO reserve_dao;
	
	private JFrame_main F; 
	
	/*
	 * 이름: JP_MainMenu 기본생성자
	 * 역할: 메인메뉴 JPanel
	 * 작성: 김영권
	 */
	public JP_Cal(JFrame_main f) { 
		
		// 배경 설정
		setBackground(Color.WHITE); 
		setBounds(100, 100, 600, 600);
		setLayout(null); 
		F = f; 
		
		// ReservationDAO 연결
		try {
			reserve_dao = new ReservationDAO();
			System.out.println("JP_Cal ReservationDAO DB 연결 성공");
		} catch (Exception e) {
			System.out.println("JP_Cal ReservationDAO DB 연결 ===실패=== :" + e.toString());
		}
		
		// Component 생성
		bToLogin = new JButton("홈"); 
		bTestSearch = new JButton("예약조회");
		bSite_1 = new JButton("사이트 1");
		bSite_2 = new JButton("사이트 2");
		bSite_3 = new JButton("사이트 3");
		bSite_4 = new JButton("사이트 4");
		bSite_5 = new JButton("사이트 5");
 		
		/*
		 * 임시 ****************************************
		 */
		imgBackground = new ImageIcon("src/reservation/imgs/JP_Cal.png");
		
		// Component 양식 설정
		bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToLogin.setBounds(457, 23, 97, 23);
		add(bToLogin);
		
		bTestSearch.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bTestSearch.setBounds(200, 270, 97, 40);
		add(bTestSearch);
		
		/*
		 * 사이트 선택 버튼: "예약조회" 클릭 시 예약 가능한 사이트만 활성화 >>> 추후 반복 처리 시도 예정
		 */
		bSite_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSite_1.setBounds(50, 400, 100, 100);
		add(bSite_1);
		bSite_1.setVisible(false);
		
		bSite_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSite_2.setBounds(150, 400, 100, 100);
		add(bSite_2);
		bSite_2.setVisible(false);
		
		bSite_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSite_3.setBounds(250, 400, 100, 100);
		add(bSite_3);
		bSite_3.setVisible(false);
		
		bSite_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSite_4.setBounds(350, 400, 100, 100);
		add(bSite_4);
		bSite_4.setVisible(false);
		
		bSite_5.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bSite_5.setBounds(450, 400, 100, 100);
		add(bSite_5);
		bSite_5.setVisible(false);
		
		// 처음 화면에서만 보이는 라벨
		lb_check_in = new JLabel("체크인");
		lb_check_in.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_check_in.setBounds(100, 170, 211, 30);
		add(lb_check_in);

		lb_numStay = new JLabel("숙박일수");
		lb_numStay.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_numStay.setBounds(100, 220, 211, 30);
		add(lb_numStay);
		
		// "예약조회" 클릭 시 보이는 라벨
		lb_able_sen = new JLabel("예약 가능한 사이트 수 ");
		lb_able_sen.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lb_able_sen.setBounds(100, 350, 250, 30);
		add(lb_able_sen);
		lb_able_sen.setVisible(false);
		
		lb_able_Num = new JLabel("");
		lb_able_Num.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		lb_able_Num.setBounds(300, 349, 200, 30);
		add(lb_able_Num);
		lb_able_Num.setVisible(false);
		
		lb_able_gae = new JLabel("개");
		lb_able_gae.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		lb_able_gae.setBounds(350, 350, 250, 30);
		add(lb_able_gae);
		lb_able_gae.setVisible(false);
				
		// 체크IN 날짜 선택 달력 팝업
		UtilDateModel model1 = new UtilDateModel();
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1);
        JDatePickerImpl datepicker1 = new JDatePickerImpl(datePanel1);
        datepicker1.setBounds(200,170,200,30);
        add(datepicker1);
        
        // JComboBox 숙박일수 선택
        String [] numStay = {"1","2"};
        JComboBox cb_Stay = new JComboBox(numStay);
		cb_Stay.setBounds(200, 220, 100, 25);
		cb_Stay.setToolTipText("숙박일수를 선택해주세요");
		add(cb_Stay);
		
		// 성수기때 가격 비싸다고 표시해주는 라벨 
		lb_price = new JLabel("7,8,9월은 추가요금 20000원이 추가 됩니다.");
		lb_price.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lb_price.setBounds(320, 220, 250, 30);
		lb_price.setForeground(Color.RED);
		add(lb_price);
		lb_price.setVisible(false);
		
		setVisible(true);
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				clearSearch();
				F.toLogin();
			}
		});
		
		bTestSearch.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				
				// 선택한 날짜가 오늘 이전이라면 예약조회 버튼 작동하지 않음 
				Date date = new Date();
				Date selectedDate = (Date) datepicker1.getModel().getValue();
				
				//성수기때 추가요금 라벨 표시 
				String temp = String.valueOf(selectedDate);
				if(temp.contains("Jul") || temp.contains("Aug") || temp.contains("Sep"))//     7,8,9월에 예약하면 20000원 추가 
				{
					lb_price.setVisible(true);
				}else {
					lb_price.setVisible(false);
				}
				//
				
				if(selectedDate!=null) {
					int compare = date.compareTo(selectedDate); // 오늘 ~ 어제이하 1, 내일부터 -1
					if(compare==1) {
					
						JLabel error = new JLabel("오늘날짜 이후로 날짜를 다시 선택하세요.");
						error.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
						JOptionPane.showMessageDialog(null,error,"오류메시지",JOptionPane.WARNING_MESSAGE);
						return;
					} else {
						UserVO.setCheck_in(selectedDate);
						UserVO.setStayDays(Integer.parseInt((String)cb_Stay.getSelectedItem())); //  getSelectedItem의 객체가 String이기때문에 String으로 변환후 Int로바꿔야함 
						testSearch();
					}
				}
				else {
					JLabel error = new JLabel("날짜를 선택하세요.");
					error.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
					JOptionPane.showMessageDialog(null,error,"오류메시지",JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
	
		/*
		 * 사이트 선택 버튼 액션리스너 1~5
		 */
		bSite_1.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				UserVO.setSite_no("1");
				clearSearch();
				F.toJP_Reserve(); 
			}
		});
		bSite_2.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				UserVO.setSite_no("2");
				clearSearch();
				F.toJP_Reserve(); 
			}
		});	
		bSite_3.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				UserVO.setSite_no("3");
				clearSearch();
				F.toJP_Reserve(); 
			}
		});	
		bSite_4.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				UserVO.setSite_no("4");
				clearSearch();
				F.toJP_Reserve(); 
			}
		});	
		bSite_5.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
				UserVO.setSite_no("5");
				clearSearch();
				F.toJP_Reserve(); 
			}
		});	
	}
	
	/*
	 * 함수명: testSearch
	 * 역할: "예약조회" 버튼 클릭 시 버튼 보이기
	 */
	void testSearch() {
		
		ArrayList<ReservationVO> list = new ArrayList<ReservationVO>();	
		
		System.out.println(UserVO.getCheck_in());

		bSite_1.setEnabled(true);
		bSite_2.setEnabled(true);
		bSite_3.setEnabled(true);
		bSite_4.setEnabled(true);
		bSite_5.setEnabled(true);
		
		try {
			list = reserve_dao.CheckAvailable(UserVO.getCheck_in());
		} catch (Exception e) {
			System.out.println("JP_Cal list 받아오지 못함: " + e.toString());
		}
		
		// 남은 사이트 수 표시 목적 배열
		String[] chk = new String[]{"1","2","3","4","5"};
		ArrayList<String> chk_Site_no = new ArrayList<String>(Arrays.asList(chk));
		System.out.println(chk_Site_no.size());
		
		for(ReservationVO data: list) {
			
			// 남은 사이트 수 표시를 위해 예약완료 사이트 번호 배열에서 제거
			for(int i=0; i<chk_Site_no.size(); i++) {
				if(data.getSite_no().equals(chk_Site_no.get(i))) chk_Site_no.remove(i);
			}
								
			switch(data.getSite_no()){
				case "1": bSite_1.setEnabled(false); break;
				case "2": bSite_2.setEnabled(false); break;
				case "3": bSite_3.setEnabled(false); break;
				case "4": bSite_4.setEnabled(false); break;
				case "5": bSite_5.setEnabled(false); break;
			}
		}
		
		bSite_1.setVisible(true);
		bSite_2.setVisible(true);
		bSite_3.setVisible(true);
		bSite_4.setVisible(true);
		bSite_5.setVisible(true);
		
		lb_able_sen.setVisible(true);
		
		lb_able_Num.setText(Integer.toString(chk_Site_no.size()));
		lb_able_Num.setVisible(true);
		
		lb_able_gae.setVisible(true);
		
		setVisible(true);
	}
		
	/*
	 * 함수명: clearSearch
	 * 역할: "예약조회" 외 다른 버튼 클릭시 "예약조회"로 보였던 버튼 다시 숨기기
	 */
	void clearSearch() {
		bSite_1.setVisible(false);
		bSite_2.setVisible(false);
		bSite_3.setVisible(false);
		bSite_4.setVisible(false);
		bSite_5.setVisible(false);
		lb_able_sen.setVisible(false);
		lb_able_Num.setText("");
		lb_able_Num.setVisible(false);
		lb_able_gae.setVisible(false);
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
