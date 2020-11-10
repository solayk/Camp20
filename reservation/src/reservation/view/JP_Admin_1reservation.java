/**
 * 관리자페이지
 * 1) 예약 확인 페이지
 */

package reservation.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import reservation.model.vo.Admin_1reservation_DAO;

public class JP_Admin_1reservation extends JPanel implements ActionListener{
	
	JTextField reserveChoicetf;
	JButton reserveSearch;
	JTable reserveStatusTbl;
	JComboBox reserveChoiceBox;

	reserveStatusModel rmodel;
	
	Admin_1reservation_DAO rdao;
	
	
	// ======================================================
	// 화면 구성요소
	public JComboBox getReserveChoiceBox() {
		return reserveChoiceBox;
	}
	
	public void setReserveChoiceBox(JComboBox reserveChoiceBox) {
		this.reserveChoiceBox = reserveChoiceBox;
	}
	
	// **************************************
	/**
	 * 역할 : 실행
	 * 201108 원우
	 */
	
	public JP_Admin_1reservation() {
		
		try {
			rdao = new Admin_1reservation_DAO();
			System.out.println("Admin 1 reserve DB연결 O");
			
		} catch (Exception e) {
			System.out.println("Admin 1 reserve DB연결 X" + e.toString());
			e.printStackTrace();
		}
		
		r_AddLayout();
		eventProc();
		rStatus();
	}
	
	
	
	// *****************************************************
	/**
	 * 역할 : 이벤트 핸들러
	 * 201108 원우
	 */
	void eventProc() {
		reserveSearch.addActionListener(this);
		reserveStatusTbl.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = reserveStatusTbl.getSelectedRow();
				int col = columnNames.length-1;
				int col2 = 0;
				Object value = reserveStatusTbl.getValueAt(row, col);
				Object value2 = reserveStatusTbl.getValueAt(row, col2);
				
				
				if(e.getClickCount()>1) {
					System.out.println("더블클릭");
					
					String[] statusList = {"선택", "입금대기", "예약확정", "예약불가", "이용완료"}; 
					Object changeStatus = JOptionPane.showInputDialog(null, "현재 예약 상태 : "+value, "예약상태 고르셈", JOptionPane.QUESTION_MESSAGE, null, statusList, statusList[0]);
					System.out.println(changeStatus);
					if(value.equals(changeStatus)) {
						JOptionPane.showMessageDialog(null, "똑같음");
					}
					
					else if(changeStatus == null || changeStatus.equals("선택")) {
						JOptionPane.showMessageDialog(null, "예약상태 선택 ㄱ");
					}
					
					else {
						int result = JOptionPane.showConfirmDialog(null, changeStatus+"로 바뀜", "정말?", JOptionPane.YES_NO_CANCEL_OPTION);
						if(result==JOptionPane.YES_OPTION) {
							rdao.changeStatus(value2, changeStatus);
							rStatus();
						}
						else if(result==JOptionPane.CANCEL_OPTION) {
							JOptionPane.showMessageDialog(null, "취소됨");
						}
						else {
							JOptionPane.showMessageDialog(null, "안바뀜");
						}
							
					}
					
				}
				
			}
		});
		
	}
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		
		if(evt == reserveSearch) {
			rStatus();
		}
		
	}
	
	
	
	
	
	// *****************************************************
	/**
	 * 역할 : 레이아웃
	 * 201108 원우 
	 */
	public void r_AddLayout() {
		
		// 예약목록 검색 기준 > dropbox
		String[] reserveSearchStandard = {"예약번호", "예약자명", "전화번호", "예약상태"};
		reserveChoiceBox = new JComboBox(reserveSearchStandard);
		
		// 예약목록에서 검색할 내용
		reserveChoicetf = new JTextField(20);
		
		// 확인할 버튼
		reserveSearch = new JButton("확인");
		
		// 예약목록
		rmodel = new reserveStatusModel();
		reserveStatusTbl = new JTable(rmodel);
		
		
		//=============================
		// 화면 구성
		setBounds(100, 100, 600, 600);
		setLayout(new BorderLayout());
		
			// 상단
			JPanel reserveChoice = new JPanel();
			reserveChoice.setLayout(new FlowLayout());
//			reserveChoice.setLayout(new GridLayout(1, 6);
			reserveChoice.setBorder(new TitledBorder("예약확인"));
			reserveChoice.add(reserveChoiceBox);
			reserveChoice.add(reserveChoicetf);
			reserveChoice.add(reserveSearch);
			
//			grid layout 으로 할 경우
//			JPanel blank1 = new JPanel();
//			JPanel blank2 = new JPanel();
//			JPanel blank3 = new JPanel();
//			reserveChoice.add(blank1);
//			reserveChoice.add(blank2);
//			reserveChoice.add(blank3);
			
			// 센터
			JPanel reserveStatus = new JPanel();
			reserveStatus.setBorder(new TitledBorder("예약현황"));
			reserveStatus.setLayout(new BorderLayout());
			
			RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(rmodel);
			reserveStatusTbl.setRowSorter(sorter);
			reserveStatus.add(new JScrollPane(reserveStatusTbl));
			
		// 상단+센터
		add(reserveChoice, BorderLayout.NORTH);
		add(reserveStatus, BorderLayout.CENTER);
		
	}
	
	
	
	/**
	 * 역할 : 데이터 항상 보여지도록
	 * 201108 원우
	 */
	void rStatus() {
		try {
			ArrayList data = rdao.rStatus(reserveChoiceBox.getSelectedItem().toString(), reserveChoicetf.getText());
			rmodel.data = data;
			rmodel.fireTableDataChanged();
			System.out.println("예약목록 ㅇ");
			
		} catch (Exception e) {
			System.out.println("예약목록 ㄴ" + e.toString());
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 역할 : 예약현황 페이지 칼럼 보여지도록
	 * 201108 원우
	 * 
	 * 변경내역
	 * 1109 : 예약상태 변경시 가장 마지막 열이 선택 되도록 컬럼네임 밖으로 뺌 (eventProc())
	 */
	
	String[] columnNames = {"예약번호", "이름", "전화번호", "사이트 번호", "투숙인원수",
			"예약일", "체크인", "체크아웃", "차량번호", "도착예정시간", "상태"};
	class reserveStatusModel extends AbstractTableModel{
		
		ArrayList data = new ArrayList();
		
		@Override
		public int getRowCount() {
			return data.size();
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			ArrayList temp = (ArrayList)data.get(rowIndex);
			Object obj = temp.get(columnIndex); 
			return obj;
			
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
	}












	
	
	
	
	
}
