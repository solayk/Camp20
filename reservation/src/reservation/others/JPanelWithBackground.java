package reservation.others;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class JPanelWithBackground extends JPanel {
	private Image backgroundImage;

	 public JPanelWithBackground(String fileName) throws IOException {
	  //backgroundImage = ImageIO.read(new File(fileName));
	  backgroundImage = Toolkit.getDefaultToolkit().createImage(fileName);
	 }

	 public void paintComponent(Graphics g) {
	  super.paintComponent(g);

	  g.drawImage(backgroundImage, 0, 0, this);
	 }
}
