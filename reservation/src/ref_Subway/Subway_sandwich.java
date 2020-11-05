package ref_Subway;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class Subway extends JFrame
	{
		JTextArea ta;  // 우측 텍스트 에어리어
		String[][] source = {{"에그마요 (Egg Mayo)","쉬림프 (Shrimp)","미트볼 (Meatball)"},{"허니오트 (Honey Oat)","플랫브래드 (Flat Bread)","하티 (Hearty Italian)"},
			{"에그마요 (Egg Mayo)","아보카도 (Abocado)","미트 추가 (Meat)"},{"양상추 (Lettuce)","토마토 (Tomatoes)","오이 (Cucumbers)"},
			{"샌드위치 단품 (Sandwich only)","콤보 (Combo) (샌드위치+콜라)","세트 (Set) (샌드위치+콜라+쿠키+수프)"}}; // 옵션정보 배열 
		JButton start ;// 주문시작버튼 
		JButton order; //주문
		JButton cancel;	//취소 
		JButton[][] Button = new JButton[5][3];  //사용될 버튼 배열 
		ImageIcon[][] icon = new ImageIcon[5][3]; //사용될 이미지 배열
		JPanel[] p = new JPanel[5];
		JPanel pt = new JPanel();
		JPanel orderOrNot;
		int price, k, r;
		
	Subway()
	{
			ta = new JTextArea(); //
			ta.setSize(128, 10);
			ta.setLineWrap(true);
			k=1;
			for (int i=0 ;i<source.length ;i++)
				for (int j = 0 ; j<source[i].length ; j++) {
					icon[i][j] = new ImageIcon("src/ref_Subway/source/1_"+k+".png");
					k++;
				}
			for (int i=0 ;i<source.length ;i++)
				for (int j = 0 ; j<source[i].length ; j++)
				{					
					Button[i][j] = new JButton(icon[i][j]);
					Button[i][j].setVerticalTextPosition(JButton.BOTTOM);
					Button[i][j].setHorizontalTextPosition(JButton.CENTER);
					Button[i][j].setBorderPainted(false);
					Button[i][j].setContentAreaFilled(false);
				}
			r=1;
			for (int i=0 ;i<source.length;i++)
				for (int j = 0 ; j<source[i].length ; j++) {
					Button[i][j].setRolloverIcon(new ImageIcon("src/ref_Subway/source/0_"+r+".png"));
					r++;
				}
			start = new JButton(new ImageIcon("src/ref_Subway/source/start.png"));
			start.setBorderPainted(false);
			start.setContentAreaFilled(false);
			order = new JButton(new ImageIcon("src/ref_Subway/source/order.png"));
			order.setBounds(250, 150, 128, 128);
			order.setBorderPainted(false);
			order.setContentAreaFilled(false);
			cancel = new JButton(new ImageIcon("src/ref_Subway/source/cancel.png"));
			cancel.setBounds(400, 150, 128, 128);
			cancel.setBorderPainted(false);
			cancel.setContentAreaFilled(false);
	}	
	void Out()
	{ 
		setLayout(new BorderLayout());
		orderOrNot = new JPanel();
		orderOrNot.setLayout(null);
		orderOrNot.add(order);
		orderOrNot.add(cancel);
		
		for (int i =0 ; i<p.length ;i++)
		{			
			p[i] = new JPanel();
			p[i].setLayout(new GridLayout(1,3));
			for (int j = 0 ; j<Button[i].length ; j++)
			{
				p[i].add(Button[i][j]);
			}			
		}
		add(start, BorderLayout.CENTER);
		pt.setLayout(new GridLayout(1, 1));
		pt.add(ta);
		add(pt, BorderLayout.EAST);
		setTitle("서브웨이 주문 시스템 (Subway Order System)");		
		setBounds(100,50,1024,512);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		
		Ahdlr ahd = new Ahdlr();
		start.addActionListener(ahd);
		order.addActionListener(ahd);	
		cancel.addActionListener(ahd);
		for (int i = 0 ; i <Button.length ; i++)
			for (int j = 0 ; j<Button[i].length ; j++)
			{
				Button[i][j].addActionListener(ahd);
			}
	}	 
class Ahdlr implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton a = (JButton)(e.getSource());
			if(a==start)
			{
				start.setVisible(false);
				add(p[0], BorderLayout.CENTER);
				p[0].setVisible(true);
			}
		for (int i = 0 ;i<Button.length-1 ;i++ )
			for (int j = 0 ;j<Button[i].length ;j++) 
				if(a==Button[i][j])
				{
					if(a==Button[0][0])	price=4300; // 추가금액이 발생하는 옵션들 // 여기서 금액을 더하는것이 아니라 초기화를 진행해야 취소후 재선택시 가격정보 초기화 가능 
					if(a==Button[0][1])	price=5700;
					if(a==Button[0][2])	price=5200;
					if(a==Button[2][0])	price+=700;	
					if(a==Button[2][1])	price+=1300;
					if(a==Button[2][2])	price+=1700;
					if(a==Button[4][1])	price+=500;
					if(a==Button[4][2])	price+=1900;
				ta.setText(ta.getText().toString()+source[i][j]+"\n"); // 주문내역에 추가
				p[i].setVisible(false); //화면전환
				p[i+1].setVisible(true); 
				add(p[i+1], BorderLayout.CENTER);
				}
		for (int i = 0 ; i<Button[4].length ; i++)
			if (a==Button[4][i]) // 마지막 옵션 선택후 주문 및 휘소 화면으로 전환
			{
				ta.setText(ta.getText()+source[4][i]+"\n"+price+"원");
				p[4].setVisible(false);
				orderOrNot.setVisible(true);
				add(orderOrNot);
			}
		if (a==order) // 주문시 콘솔창에 주문내역 출력 및 화면 주문내역으로 전환 
			{
			System.out.println(ta.getText());
			add(ta, BorderLayout.CENTER);
			orderOrNot.setVisible(false);
			JOptionPane.showMessageDialog(null, "======= 주문 내역 =======\n" + ta.getText());
			}
		if (a==cancel) // 취소시 다시 처음 주문화면으로 전환 
			{
			orderOrNot.setVisible(false);
			start.setVisible(true);
			ta.setText("");
			}
		}
	}
}
public class Subway_sandwich {

	public static void main(String[] args) {
		Subway n = new Subway();
		n.Out();
	}

}
