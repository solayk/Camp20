package reservation.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class UI_ReservationView extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JLabel lblNewLabel_1;
	private JTextField tfTel;
	private JLabel lblNewLabel_3;
	private JTextField tfCarNo;
	private JTextField tfPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_ReservationView frame = new UI_ReservationView();
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
	public UI_ReservationView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(215, 111, 200, 25);
		contentPane.add(tfName);
		
		JLabel lblNewLabel = new JLabel("예약자");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(128, 116, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("예약정보 입력");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(171, 40, 211, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(128, 160, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(215, 155, 200, 25);
		contentPane.add(tfTel);
		
		lblNewLabel_3 = new JLabel("인원수");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(128, 265, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("인원수를 선택해주세요");
		comboBox.setBounds(215, 264, 96, 21);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3_1 = new JLabel("도착예정시간");
		lblNewLabel_3_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(128, 318, 75, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(215, 317, 96, 21);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("차 번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(128, 373, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		tfCarNo = new JTextField();
		tfCarNo.setColumns(10);
		tfCarNo.setBounds(215, 368, 200, 25);
		contentPane.add(tfCarNo);
		
		JLabel lblNewLabel_3_2 = new JLabel("숙박기간");
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3_2.setBounds(128, 212, 57, 15);
		contentPane.add(lblNewLabel_3_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(215, 211, 96, 21);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("요금");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(128, 431, 57, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		tfPrice = new JTextField();
		tfPrice.setColumns(10);
		tfPrice.setBounds(215, 426, 200, 25);
		contentPane.add(tfPrice);
		
		JButton bRegist = new JButton("결제완료");
		bRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bRegist.setBounds(215, 514, 97, 23);
		contentPane.add(bRegist);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("이용규칙 동의");
		chckbxNewCheckBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(128, 474, 115, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("환불규정 동의");
		chckbxNewCheckBox_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		chckbxNewCheckBox_1.setBounds(267, 474, 115, 23);
		contentPane.add(chckbxNewCheckBox_1);
	}
}
