package reservation.others;

import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/*
 * 텍스트 박스 뒤에 흐리게 글씨 나오도록 
 */

public class HintTextField extends JTextField {
	// 폰트 수정
    Font gainFont = new Font("맑은 고딕", Font.PLAIN, 11);
    Font lostFont = new Font("맑은 고딕", Font.ITALIC, 11);

    public HintTextField(final String hint) {

        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                } else {
                    setText(getText());
                    setFont(gainFont);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint)|| getText().length()==0) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                    setForeground(Color.BLACK);
                }
            }
        });

    }
}