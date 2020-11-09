/**
 * 관리자페이지
 * 2) 회원 관리 페이지
 */

package reservation.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import reservation.model.vo.Admin_2member_DAO;

public class JP_Admin_2member extends JPanel implements ActionListener{
	
	// ======================================================
	// 화면 구성요소
	JComboBox memberChoiceBox;
	JTextField memberChoicetf;
	JButton membersearch;
	JTable memberListTbl;
	memberListModel mmodel;
	Admin_2member_DAO mdao;
	
	
	public JP_Admin_2member() {
		
		try {
			mdao = new Admin_2member_DAO();
			System.out.println("mdao : " + mdao);
			System.out.println("Admin_2member_DAO 연결 O");
		} catch (Exception e) {
			System.out.println("Admin_2member_DAO 연결 X : " + e.toString());
			e.printStackTrace();
		}
		
		
		m_AddLayout();
		eventProc();
		mStatus();
		
	}
	
	
	
	// *****************************************************
	/**
	 * 역할 : 이벤트
	 * 201109 원우
	 */
	void eventProc() {
		membersearch.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evt = e.getSource();
		
		if(evt == membersearch) {
			mStatus();
		}
		
	}
	
	
	
	
	// *****************************************************
	/**
	 * 역할 : 회원리스트 전체
	 * 201109 원우
	 */
	void mStatus() {
		try {
			ArrayList data = mdao.mStatus(memberChoiceBox.getSelectedItem().toString(), memberChoicetf.getText());
			mmodel.data = data;
			mmodel.fireTableDataChanged();
			System.out.println("회원목록 ㅇ");
			
		} catch (Exception e) {
			System.out.println("회원목록 X : " + e.toString());
			e.printStackTrace();
		}
		
	}
	
	
	
	// *****************************************************
	// 레이아웃
	private void m_AddLayout() {
		
		// 회원목록 검색 기준 > dropbox
		String[] memberSearchStandard = {"ID", "이름", "전화번호", "e-mail"};
		memberChoiceBox = new JComboBox(memberSearchStandard);
		
		// 회원목록에서 검색할 내용
		memberChoicetf = new JTextField(20);
		
		// 확인버튼
		membersearch = new JButton("확인");
		
		// 회원목록
		mmodel = new memberListModel();
		memberListTbl = new JTable(mmodel);
		
		//=============================
		// 화면 구성
		setBounds(100, 100, 600, 600);
		setLayout(new BorderLayout());
		
			// 상단
			JPanel memberChoice = new JPanel();
			memberChoice.setLayout(new FlowLayout());
//			memberChoice.setLayout(new GridLayout(1, 6);
			memberChoice.setBorder(new TitledBorder("회원목록"));
			memberChoice.add(memberChoiceBox);
			memberChoice.add(memberChoicetf);
			memberChoice.add(membersearch);
			
//			grid layout 으로 할 경우
//			JPanel blank1 = new JPanel();
//			JPanel blank2 = new JPanel();
//			JPanel blank3 = new JPanel();
//			reserveChoice.add(blank1);
//			reserveChoice.add(blank2);
//			reserveChoice.add(blank3);
			
			// 센터
			JPanel memberList = new JPanel();
			memberList.setBorder(new TitledBorder("회원현황"));
			memberList.setLayout(new BorderLayout());
			memberList.add(new JScrollPane(memberListTbl));
			
		// 상단+센터
		add(memberChoice, BorderLayout.NORTH);
		add(memberList, BorderLayout.CENTER);
		
	}
	
	
	class memberListModel extends AbstractTableModel{

		ArrayList data = new ArrayList();
		String[] columnNames = {"ID", "이름", "전화번호", "e-mail", "주소"};

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
			return temp.get(columnIndex);
		}
		
		@Override
		public String getColumnName(int col) {
			return columnNames[col];
		}
		
	}



	
	
	
	
}
