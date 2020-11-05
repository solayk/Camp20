package reservation.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI_MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_MainMenu frame = new UI_MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI_MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("메인메뉴");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(211, 86, 211, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton bToReserv = new JButton("캠핑사이트 예약");
		bToReserv.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToReserv.setBounds(169, 178, 200, 100);
		contentPane.add(bToReserv);
		
		JButton bToCheckReserve = new JButton("예약내역 확인/취소");
		bToCheckReserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bToCheckReserve.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bToCheckReserve.setBounds(169, 335, 200, 100);
		contentPane.add(bToCheckReserve);
	}
}
