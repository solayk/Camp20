package reservation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class JP_Admin_3statistics extends JPanel {
	
	// ======================================================
	// 화면 구성요소
	JCheckBox cbRevenue, cbCount;
	JButton jbRunGraph;
	JRadioButton rbRevenueMonth, rbRevenueYear,	rbCountMonth, rbCountYear;
	JTable statTbl;
	JFreeChart chart;
	ChartPanel chartPanel;
	JP_Admin_3Chart demo;
	
	public JP_Admin_3statistics() {
		s_AddLayout();
		eventProc();
	}
	
	/*
	 * 이벤트
	 */
	public void eventProc() {
		
		ButtonEventHandler hdlr = new ButtonEventHandler();
		jbRunGraph.addActionListener(hdlr);
		
	}
	
	class ButtonEventHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			
			if(o==jbRunGraph) {
				showChart();
			}
		}
	}
	
	
	
	// *****************************************************
	// 레이아웃
	private void s_AddLayout() {
		
		// 매출
		cbRevenue = new JCheckBox("매출 보기", false);	// 기본 선택 (매출+예약건수)
		rbRevenueMonth = new JRadioButton();
		rbRevenueMonth.setSelected(true);			// 월간 보기를 기본 선택
		rbRevenueYear = new JRadioButton();
		
		ButtonGroup revenueGroup = new ButtonGroup();
		revenueGroup.add(rbRevenueMonth);
		revenueGroup.add(rbRevenueYear);
		
		
		// 예약건수
		cbCount = new JCheckBox("예약건수 보기", false);	// 기본 선택 (매출+예약건수)
		rbCountMonth = new JRadioButton();
		rbCountMonth.setSelected(true);			// 월간 보기를 기본 선택
		rbCountYear = new JRadioButton();
		
		ButtonGroup countGroup = new ButtonGroup();
		countGroup.add(rbCountMonth);
		countGroup.add(rbCountYear);
		
		
		// 실행 버튼
		jbRunGraph = new JButton("실행");
		
		
		//=============================
		// 화면 구성
		setBounds(100, 100, 600, 600);
		setLayout(new BorderLayout());
		
		
			// 상단
			JPanel graphStandard = new JPanel();
			graphStandard.setLayout(new GridLayout(1, 3));
			
				// 상단_좌측_매출
				JPanel revenueStandard = new JPanel();
				revenueStandard.setBorder(new TitledBorder("매출"));
				revenueStandard.setLayout(new GridLayout(4, 3));
				
				revenueStandard.add(cbRevenue);
				revenueStandard.add(new JLabel()); 
				revenueStandard.add(new JLabel("월간"));
				revenueStandard.add(rbCountMonth);
				revenueStandard.add(new JLabel("연간"));
				revenueStandard.add(rbCountYear);
				
				// 상단_가운데_예약건수
				JPanel countStandard = new JPanel();
				countStandard.setBorder(new TitledBorder("예약건수"));
				countStandard.setLayout(new GridLayout(4, 3));
				
				countStandard.add(cbCount);
				countStandard.add(new JLabel()); 
				countStandard.add(new JLabel("월간"));
				countStandard.add(rbRevenueMonth);
				countStandard.add(new JLabel("연간"));
				countStandard.add(rbRevenueYear);
				
			// 상단 좌+중+우
			graphStandard.add(revenueStandard);
			graphStandard.add(countStandard);
			graphStandard.add(jbRunGraph);
			
			
			// 그래프
			demo = new JP_Admin_3Chart();
			chart = demo.getMonthRevenueChart();
			chartPanel = new ChartPanel(chart);
			chartPanel.setVisible(false);
			
		add(graphStandard, BorderLayout.NORTH);
		add(chartPanel, BorderLayout.CENTER);
		setSize(800, 400);
		setVisible(true);
		
	}
	
	
	// 그래프를 보이게
	void showChart() {
		
		// 매출체크박스
		// 매출월 
		if(cbRevenue.isSelected() && rbRevenueMonth.isSelected()) {
			chart = demo.getMonthRevenueChart();
			chartPanel.setVisible(false);
			chartPanel = new ChartPanel(chart);
			chartPanel.setVisible(true);
			JLabel ticker = new JLabel(".");
			add(chartPanel, BorderLayout.CENTER);
			add(ticker, BorderLayout.SOUTH);
			
		}
		
		// 매출연도
		else if(cbCount.isSelected() && rbCountMonth.isSelected()) {
			chart = demo.getMonthReservCountChart();
			chartPanel.setVisible(false);
			chartPanel = new ChartPanel(chart);
			chartPanel.setVisible(true);
			add(chartPanel, BorderLayout.CENTER);
		}
		
		//JCheckBox cbRevenue, cbCount;
		//JRadioButton rbRevenueMonth, rbRevenueYear,	rbCountMonth, rbCountYear;
		
		// 예약체크박스
		// 예약월
		else if(cbRevenue.isSelected() && rbRevenueYear.isSelected()) {
			//chart = demo.getMonthReservCountChart();
			chartPanel.setVisible(false);
			//chartPanel = new ChartPanel(chart);
			//chartPanel.setVisible(true);
			//add(chartPanel, BorderLayout.CENTER);
		}
		
		// 예약연도
		else if(cbCount.isSelected() && rbCountYear.isSelected()) {
			//chart = demo.getMonthReservCountChart();
			chartPanel.setVisible(false);
			//chartPanel = new ChartPanel(chart);
			//chartPanel.setVisible(true);
			//add(chartPanel, BorderLayout.CENTER);
		}
		
			
	}

	
	
}
	
	









