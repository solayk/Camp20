package reservation.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import reservation.model.vo.ReservationDAO;
import reservation.model.vo.UserVO;

public class JP_CheckResNo extends JPanel {

	private JTextField tf_resNo;
	private JButton bToLogin, bToReserve; 
	private JFrame_main F; 
	
	JTable tbl;  				//테이블
	MyTableModel tbModel;		//모델 
	
	ReservationDAO reserve_dao;   //  ReservationDAO 변수 생성 . 
	ImageIcon imgBackground;
	
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
		
		imgBackground = new ImageIcon("src/reservation/imgs/JP_ResNo_1.png");
		// 테이블 , 모델 
		tbModel = new MyTableModel();
		tbl = new JTable(tbModel);
		bToLogin = new JButton("");
		//JLabel lb_title = new JLabel("예약 조회");
		JPanel Center = new JPanel();
		
		// 배경 설정
		setBackground(Color.WHITE); 
//		setBounds(100, 100, 600, 600);
		setVisible(true);
		setLayout(null); 
		
			bToLogin.setBounds(510, 23, 50, 50);
			bToLogin.setContentAreaFilled(false);
			bToLogin.setBorderPainted(false);
			Center.setBounds(50,110,500,450);
			Center.setLayout(new BorderLayout());
			bToLogin.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		add(bToLogin);
		
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tbModel);
		tbl.setRowSorter(sorter);

		tbl.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 15));   // 헤더 폰트 
		tbl.setFont(new Font("맑은 고딕", Font.BOLD, 14)); 					//데이터 폰트 
		tbl.setRowHeight(25);
			Center.add(new JScrollPane(tbl)); 					// JTable 은 스크롤을 반드시넣어서 붙여줘야한다
		add(Center);
		F = f; 
		
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
		
		

		
		//JTable에 마우스 이벤트
		tbl.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int col = 0;
				int row =  tbl.getSelectedRow(); // 선택한 행이무엇이냐  // 어떤행을선택해도 0번째열 가져온다 (예약번호)
				
				if(e.getClickCount()>1) {		//더블클릭시 이벤트 발생 
					System.out.println("더블클릭");

					int reply = JOptionPane.showConfirmDialog(null, "해당 예약번호로 조회하시겠습니까? ", "예약 조회", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						String resNum = (String)tbl.getValueAt(row, col); // 내가선택한 애의 예약만 가져온다.
						System.out.println(resNum);
						UserVO.setReserv_no(resNum);
						F.toJP_CheckRes(); 							//JP_CheckRes 페이지로 넘어간다. 
					}
				}
				
				
			}
		});
		
		
		/*
		 * 이름: 버튼 액션 리스너
		 * 역할: "홈" 버튼 클릭 시 동작 설정
		 */
		bToLogin.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) { 
			//	change();
			F.toMainMenu(); 
			}
		});
		
	}
	
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
	/*
	 * 함수명: paintComponent
	 * 역할: 배경이미지 설정
	 */
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);

		  g.drawImage(imgBackground.getImage(), 0, 0, this);
	}
	
}




