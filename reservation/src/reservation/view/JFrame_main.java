package reservation.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

public class JFrame_main extends JFrame {
	
	// CardLayout 선언
	private CardLayout cards = new CardLayout(); 
	
	//FrameDragListener frameDragListener;
	
	/*
	 * 이름: Frame_main 기본생성자
	 * 역할: JFrame 생성, JPanel CardLayout 연결
	 * 작성: 김영권
	 */
	public JFrame_main() { 
	//	frameDragListener = new FrameDragListener(this); 		// 드래그 이벤트 
		
		setBounds(100,100,600,600); 
		setUndecorated(true);					//테두리 없애기 setvisivle보다 먼저 호출되야한다 .. 
		setShape(new RoundRectangle2D.Double(0, 0, 600, 600, 50, 40));      // JFrame 을 둥글게하는 코드 // /setUndecorated(true)가 있어야 사용할수있다. 
		getContentPane().setLayout(cards); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setResizable(false);
		getContentPane().add("JP_Login", new JP_Login(this));
		getContentPane().add("JP_Register", new JP_Register(this));
		getContentPane().add("JP_MainMenu", new JP_MainMenu(this));
		
		
		
		getContentPane().add("JP_Cal", new JP_Cal(this));

		getContentPane().add("JP_CheckRes", new JP_CheckRes(this));
		getContentPane().add("JP_Reserve", new JP_Reserve(this));
		
	  //      addMouseListener(frameDragListener);			// 드래그 이벤트 
	   //     addMouseMotionListener(frameDragListener);	    // 드래그 이벤트 
		setVisible(true); 
	} 
	/*
    public static class FrameDragListener extends MouseAdapter { // 드래그 이벤트 
    	 
        private final JFrame frame;
        private Point mouseDownCompCoords = null;

        public FrameDragListener(JFrame frame) {
            this.frame = frame; 
        }

        public void mouseReleased(MouseEvent e) {
            mouseDownCompCoords = null;
        }

        public void mousePressed(MouseEvent e) {
            mouseDownCompCoords = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            Point currCoords = e.getLocationOnScreen();
            frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
        }
    }
	*/
	/*
	 * 함수명: to_JP_Register
	 * 역할: "회원가입" 버튼 클릭 시 JP_Register로 화면 전환
	 * 작성: 김영권
	 */
	public void to_JP_Register() {
		cards.show(getContentPane(),"JP_Register");
	}
	
	/*
	 * 함수명: toLogin
	 * 역할: "홈" "Login" 버튼 클릭 시 JP_Login으로 화면 전환
	 * 작성: 김영권
	 */
	public void toLogin() { 
		cards.show(getContentPane(),"JP_Login");
	}
	
	/*
	 * 함수명: LoginSuccess
	 * 역할: "로그인" 버튼 클릭 시 아이디와 비밀번호 일치하면 JP_MainMenu로 화면 전환
	 * 작성: 김영권
	 */
	public void LoginSuccess() { 
		cards.show(getContentPane(),"JP_MainMenu");
	}
	
	/*
	 * 함수명: toJP_Cal
	 * 역할: "캠핑사이트 예약" 버튼 클릭 시 JP_Cal로 화면 전환
	 * 작성: 김영권
	 */
	public void toJP_Cal() { 
		cards.show(getContentPane(),"JP_Cal");
	}
	
	/*
	 * 함수명: toJP_CheckResNo
	 * 역할: "예약내역 확인/취소" 버튼 클릭 시 JP_CheckResNo로 화면 전환
	 * 작성: 김영권
	 */
	public void toJP_CheckResNo() { 
		getContentPane().add("JP_CheckResNo", new JP_CheckResNo(this));
		cards.show(getContentPane(),"JP_CheckResNo");
	}
	
	/*
	 * 함수명: toJP_Reserve
	 * 역할: "예약조회" 버튼 클릭 시 JP_Reserve로 화면 전환 ***테스트 버튼 바이패스
	 * 작성: 김영권
	 */
	public void toJP_Reserve() { 
		getContentPane().add("JP_Reserve", new JP_Reserve(this));
		cards.show(getContentPane(),"JP_Reserve");
	}
	/*
	 * 함수명: toJP_Reserve
	 * 역할: "예약조회" 버튼 클릭 시 JP_Reserve로 화면 전환 ***테스트 버튼 바이패스
	 * 작성: 김영권
	 */
	public void toJP_CheckRes() { 
		getContentPane().add("JP_CheckRes", new JP_CheckRes(this));
		cards.show(getContentPane(),"JP_CheckRes");
	}
	
	/*
	 * 함수명: main
	 * 역할: JFrame 생성, 기본생성자 실행으로 JPanel 및 CardLayout 생성
	 * 작성: 김영권
	 */
	public static void main(String[] args) {
		JFrame_main fr = new JFrame_main();
	}
	
}
