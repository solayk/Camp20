package reservation.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JP_Admin_0main extends JFrame{
	
	// 각 탭들
	JP_Admin_1reservation reserveList;
	JP_Admin_2member memberList;
	JP_Admin_3statistics statList;
	
	
	public JP_Admin_0main() {
		
		reserveList = new JP_Admin_1reservation();
		memberList = new JP_Admin_2member();
		statList = new JP_Admin_3statistics();
		
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("예약관리", reserveList);
		pane.addTab("회원관리", memberList);
//		pane.addTab("통계", statList);
		
		pane.setSelectedIndex(0);
		
		getContentPane().add("Center", pane);
		pack();
		dispose();
		setVisible(true);

	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String[] args) {
		new JP_Admin_0main();
	}
	

}
