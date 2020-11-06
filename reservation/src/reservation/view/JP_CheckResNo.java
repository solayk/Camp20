package reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

import reservation.model.vo.ReservationDAO;
import reservation.model.vo.UserVO;

public class JP_CheckResNo extends JPanel {

	private JTextField tf_resNo;
	private JButton bToLogin, bToReserve; 
	private JFrame_main F; 
	
	JTable tbl;  				//테이블
	MyTableModel tbModel;		//모델 
	
	ReservationDAO reserve_dao;   //  ReservationDAO 변수 생성 . 
	
	/*
	 * 이름: JP_MainMenu 기본생성자
	 * 역할: 메인메뉴 JPanel
	 * 작성: 김영권
	 */
	public JP_CheckResNo(JFrame_main f) { 
		
		try {
			reserve_dao = new ReservationDAO();
			System.out.println("DB 연결 성공 ");
		} catch (Exception e) {
			System.out.println("DB 연결실패 :" + e.toString());
		}
		// 테이블 , 모델 
		tbModel = new MyTableModel();
		tbl = new JTable(tbModel);
		bToLogin = new JButton("홈");
		JLabel lb_title = new JLabel("예약 조회");
		JPanel Center = new JPanel();
		
		// 배경 설정
		setBackground(Color.WHITE); 
//		setBounds(100, 100, 600, 600);
		setVisible(true);
		setLayout(null); 
		
			bToLogin.setBounds(457, 23, 97, 23);
			lb_title.setBounds(211, 30, 211, 30);
			Center.setBounds(50,80,500,450);
			Center.setLayout(new BorderLayout());
			
			bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
			lb_title.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
			
		
		add(bToLogin);
		add(lb_title);
			Center.add(new JScrollPane(tbl)); 					// JTable 은 스크롤을 반드시넣어서 붙여줘야한다
		add(Center);
		F = f; 
	
		// Component 생성
//		tf_resNo = new JTextField();
//		bToReserve = new JButton("예약조회"); //변경예정
 				
		// Component 양식 설정
//		tf_resNo.setBounds(207, 247, 150, 21);
//		tf_resNo.setColumns(10);
//		add(tf_resNo);
		

		
//		bToReserve.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		bToReserve.setBounds(238, 301, 97, 23);
//		add(bToReserve);
		
	

		
//		JLabel lb_notice = new JLabel("예약번호를 입력하세요");
//		lb_notice.setHorizontalAlignment(SwingConstants.CENTER);
//		lb_notice.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
//		lb_notice.setBounds(190, 222, 173, 15);
//		add(lb_notice);

		
		try {
			ArrayList reserveList = new ArrayList();
			
			reserveList = reserve_dao.CheckResList(UserVO.getCustomer_id());
			//reserveList = reserve_dao.CheckResList("qwe5507");
			
			tbModel.list = reserveList;  // 2차원배열을 모델클래스의 list에 저장 
			
			//tbl.setModel(tbModel); // 테이블의 테이블모델 지정 [없어도될수도있음 ] - 없어도되었음. 
			tbModel.fireTableDataChanged(); // 데이타가 화면한테 내용바꼇다는 신호  
			
			System.out.println(tbModel.list.get(0));
		} catch (Exception e) {
			System.out.println("예약리스트 조회 실패 :" + e.toString() );
			e.printStackTrace();
		}
		
		

		
//		JTable에 마우스 이벤트
		tbl.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row =  tbl.getSelectedRow(); // 선택한 행이무엇이냐  // 어떤행을선택해도 0번째열 가져온다 (예약번호)
				String resNum = (String)tbl.getValueAt(row, col); // 내가선택한 애의 예약만 가져온다.
				System.out.println(resNum);
				
				
			}
		});
		
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
			//	change();
			F.toLogin(); 
			}
		});
		
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "예약조회" 버튼 클릭 시 동작 설정
		 */
//		bToReserve.addActionListener(new ActionListener() { 
//			public void actionPerformed(ActionEvent arg0) { 
//					
//					F.toJP_CheckRes(); 							//JP_CheckRes 페이지로 넘어간다. 
//		
//			}
//		});
		
	}
	// 
	void change() {
//		try {
//			ArrayList reserveList = new ArrayList();
//			
//			reserveList = reserve_dao.CheckResList(UserVO.getCustomer_id());
//			
//			
//		} catch (Exception e) {
//			System.out.println("예약리스트 조회 실패 :" + e.toString() );
//			e.printStackTrace();
//		}
//
//		tbModel.list = reserveList;  // 2차원배열을 모델클래스의 list에 저장 
//		//tbl.setModel(tbModel); // 테이블의 테이블모델 지정 [없어도될수도있음 ] - 없어도되었음. 
//		tbModel.fireTableDataChanged(); // 데이타가 화면한테 내용바꼇다는 신호  
		
	} // end of change
	
	
	//이너 클래스  // 테이블 모델 - JTable 의 데이타를 관리하는 클래스  
	class MyTableModel extends AbstractTableModel{ // 디폴트 테이블 모델을 쓰면 더 쉬움 
		ArrayList list = new ArrayList();  //   데이터
		String [] columnNames = {"예약 번호","예약일","체크 인","체크 아웃","예약 상태"};  // 제목
		
		public int getRowCount() { 
			return list.size();  
		}
		public int getColumnCount() {
			return columnNames.length; 
		}
		public Object getValueAt(int row, int col) { // 값가져오는 메소드
			ArrayList temp =  (ArrayList)list.get(row);   //  2차원 배열 arraylist사용 
			Object obj = temp.get(col);
			return obj;
		}
		//jtable 과 데이터모델이 주고받는 함수 , 부모가 가지고있는 함수  // 내가지정한 걸로 리턴한다.
		public String getColumnName(int col) { 
			return columnNames[col];
		}
		
	}
	
}
