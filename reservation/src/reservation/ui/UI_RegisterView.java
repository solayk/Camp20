package reservation.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class UI_RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField tfID;
	private JTextField tfTel;
	private JTextField tfPw;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfAddr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_RegisterView frame = new UI_RegisterView();
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
	public UI_RegisterView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfID = new JTextField();
		tfID.setBounds(187, 102, 200, 25);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("아이디");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel.setBounds(100, 107, 57, 15);
		contentPane.add(lblNewLabel);
		
		tfTel = new JTextField();
		tfTel.setColumns(10);
		tfTel.setBounds(187, 142, 200, 25);
		contentPane.add(tfTel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(100, 147, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("비밀번호");
		lblNewLabel_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(100, 187, 57, 15);
		contentPane.add(lblNewLabel_1_1);
		
		tfPw = new JTextField();
		tfPw.setColumns(10);
		tfPw.setBounds(187, 182, 200, 25);
		contentPane.add(tfPw);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("이름");
		lblNewLabel_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(100, 227, 57, 15);
		contentPane.add(lblNewLabel_1_1_1);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(187, 222, 200, 25);
		contentPane.add(tfName);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("이메일주소");
		lblNewLabel_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(100, 267, 70, 15);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(187, 262, 200, 25);
		contentPane.add(tfEmail);
		
		tfAddr = new JTextField();
		tfAddr.setColumns(10);
		tfAddr.setBounds(187, 302, 200, 25);
		contentPane.add(tfAddr);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("주소");
		lblNewLabel_1_1_1_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1_1.setBounds(100, 307, 57, 15);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("회원가입");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(233, 34, 100, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton bRegist = new JButton("회원가입");
		bRegist.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		bRegist.setBounds(225, 364, 97, 23);
		contentPane.add(bRegist);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(457, 23, 97, 23);
		contentPane.add(btnNewButton);
	}
}
