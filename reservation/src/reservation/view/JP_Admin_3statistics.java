package reservation.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class JP_Admin_3statistics extends JPanel{
	
	// ======================================================
	// 화면 구성요소
	JCheckBox reserveRevenue, reserveCount;
	JButton runGraph;
	JRadioButton revenueMonth, revenueYear, revenueChoice,
				countMonth, countYear, countChoice;
	JTable statTbl;
	
	public JP_Admin_3statistics() {
		s_AddLayout();
	}
	
	
	
	// *****************************************************
	// 레이아웃
	private void s_AddLayout() {
		
		// 매출
		reserveRevenue = new JCheckBox("매출 보기", true);	// 기본 선택 (매출+예약건수)
		revenueMonth = new JRadioButton();
		revenueMonth.setSelected(true);			// 월간 보기를 기본 선택
		revenueYear = new JRadioButton();
		revenueChoice = new JRadioButton();
		
		ButtonGroup revenueGroup = new ButtonGroup();
		revenueGroup.add(revenueMonth);
		revenueGroup.add(revenueYear);
		revenueGroup.add(revenueChoice);
		
		
		// 예약건수
		reserveCount = new JCheckBox("예약건수 보기", true);	// 기본 선택 (매출+예약건수)
		countMonth = new JRadioButton();
		countMonth.setSelected(true);			// 월간 보기를 기본 선택
		countYear = new JRadioButton();
		countChoice = new JRadioButton();
		
		ButtonGroup countGroup = new ButtonGroup();
		countGroup.add(countMonth);
		countGroup.add(countYear);
		countGroup.add(countChoice);
		
		
		// 실행 버튼
		runGraph = new JButton("실행");
		
		
		// 그래프 담을 테이블? 패널?
		// statTbl = new JTable();
		// statPanel = new JPanel();
		
		
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
				revenueStandard.setLayout(new GridLayout(5, 3));
				
				revenueStandard.add(reserveRevenue);
				revenueStandard.add(new JLabel()); 
				revenueStandard.add(new JLabel("월간"));
				revenueStandard.add(countMonth);
				revenueStandard.add(new JLabel("연간"));
				revenueStandard.add(countYear);
				revenueStandard.add(new JLabel("기간 선택"));
				revenueStandard.add(countChoice);
				
				// 상단_가운데_예약건수
				JPanel countStandard = new JPanel();
				countStandard.setBorder(new TitledBorder("예약건수"));
				countStandard.setLayout(new GridLayout(5, 3));
				
				countStandard.add(reserveCount);
				countStandard.add(new JLabel()); 
				countStandard.add(new JLabel("월간"));
				countStandard.add(revenueMonth);
				countStandard.add(new JLabel("연간"));
				countStandard.add(revenueYear);
				countStandard.add(new JLabel("기간 선택"));
				countStandard.add(revenueChoice);
				
				// 상단_우측_실행버튼
				// 버튼 크기가 너무 커서 조절하고 싶은데
				// gridlayout 을 3,3 해서 하자니 new 를 너무 많이쓰고,
					// gridlayout 일 경우 https://flower0.tistory.com/319 이런 방법도 있음
				// borderlayout.center 하자니 너무 큼.
				// 일단 레이아웃보다 기능이 급하니 추후 다시 생각해보기
				
				
			// 상단 좌+중+우
			graphStandard.add(revenueStandard);
			graphStandard.add(countStandard);
			graphStandard.add(runGraph);
			
			
			// 그래프
			JP_Admin_3Chart demo = new JP_Admin_3Chart();
			JFreeChart chart = demo.getChart();
			ChartPanel chartPanel=new ChartPanel(chart);
			
			
			
			
		add(graphStandard, BorderLayout.NORTH);
		add(chartPanel, BorderLayout.CENTER);
			
			
		
	}
	
	
	
	
	
	
}
